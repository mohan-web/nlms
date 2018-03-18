package org.nlms.portal.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



import org.nlms.commons.model.Response;
import org.nlms.portal.service.LoginService;
import org.nlms.security.model.Login;
import org.nlms.security.model.User;

@RestController
@RequestMapping("/auth")
public class LoginController {
	
	@Autowired
	private LoginService loginService;
	 
	@ResponseBody
    @RequestMapping(value = "loggedin", method = { RequestMethod.POST })
    public Boolean isUserLoggedIn(@RequestBody Login login)
    {
        System.out.println("=====>login: " + login);
        Boolean status = loginService.isUserLoggedIn(login);
        return status;
    }
	
	@ResponseBody
    @RequestMapping(value = "login", method = { RequestMethod.POST})
    public Response login(@RequestBody User user){
		return loginService.login(user);
	}
	
	@ResponseBody
    @RequestMapping(value = "logout", method = { RequestMethod.POST })
    public void logout(@RequestBody String userName)
    {
        loginService.logout(userName);
    }
}
