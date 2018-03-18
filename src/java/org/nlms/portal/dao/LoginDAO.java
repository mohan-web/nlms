package org.nlms.portal.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.nlms.security.model.Login;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;



@Repository
public class LoginDAO
{
    private static final Logger logger = LoggerFactory.getLogger(LoginDAO.class);

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public void add(Login login)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("p", login);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("Login.Delete", login.getUserName());
        sqlSession.insert("Login.Add", params);
        sqlSession.close();
    }

    public Login getLoginByUserContext(Login login)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("p", login);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Login> logins = sqlSession.selectList("Login.GetLoginByUserContext", params);
        sqlSession.close();

        Login result = null;
        if (!CollectionUtils.isEmpty(logins))
        {
            result = logins.get(0);
        }

        return result;
    }

    public void delete(String userName)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        sqlSession.delete("Login.Delete", userName);
        sqlSession.close();
    }

 
}
