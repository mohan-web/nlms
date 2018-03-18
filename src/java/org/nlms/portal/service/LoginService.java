package org.nlms.portal.service;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

import org.nlms.commons.model.Response;
import org.nlms.commons.util.IDGenerator;
import org.nlms.commons.util.OpenLibUtils;
import org.nlms.portal.dao.LoginDAO;
import org.nlms.portal.dao.UserDAO;
import org.nlms.security.model.Login;
import org.nlms.security.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;




@Service
public class LoginService {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginService.class);

    private static final long SESSION_TIMEOUT = TimeUnit.MINUTES.toMillis(30);

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private LoginDAO loginDAO;

    public boolean isUserLoggedIn(Login login)
    {
        boolean status = false;

        if ((!StringUtils.isEmpty(login.getUserName()))
                && (!StringUtils.isEmpty(login.getContext())))
        {
            Login result = loginDAO.getLoginByUserContext(login);
            if (result != null)
            {
                status = true;
            }
        }

        logger.info("isUserLoggedIn userName={}, context={}, status={}", login.getUserName(),
                login.getContext(), status);
        return status;
    }

    public Response login(User user)
    {
        Timestamp logTime = new Timestamp(System.currentTimeMillis());

        Response response = new Response();
        response.setSuccessful(false);
        response.setRequestObject(OpenLibUtils.clone(user));

        if ((user != null) && (!StringUtils.isEmpty(user.getUserName()))
                && (!StringUtils.isEmpty(user.getPassword())))
        {
            String passwordHash = OpenLibUtils.getPasswordHash(user.getPassword());
            User result = userDAO.getUserByCredentials(user.getUserName(), passwordHash);
            System.out.println("=====>User: " + user);
            if ((result != null) && (result.getUserName().equals(user.getUserName())))
            {
                Login login = new Login(user.getUserName(), IDGenerator.getUniqueID(), logTime);
                loginDAO.add(login);
                response.setSuccessful(true);
                //response.setResponseObject(login);
                response.setResponseObject(result);
            }
            else
            {
                response.setErrorMessage("Invalid credentials");
            }
        }
        else
        {
            response.setErrorMessage("User does not exist");
        }

        return response;
    }

    public void logout(String userName)
    {
        loginDAO.delete(userName);
    }

}
