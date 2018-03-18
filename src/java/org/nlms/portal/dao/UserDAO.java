package org.nlms.portal.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.nlms.security.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;



@Repository
public class UserDAO
{
    private static final Logger logger = LoggerFactory.getLogger(UserDAO.class);

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    public User get(String userName)
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("User.GetUsers");
        System.out.println("=====>Users: " + users);

        User user = null;
        if (!CollectionUtils.isEmpty(users))
        {
            user = users.get(0);
        }
        sqlSession.close();
        
        return user;
    }

    public User getUserByCredentials(String name, String password)
    {
        User result = null;

        User user = new User();
        user.setName(name);
        user.setPassword(password);

        Map<String, Object> params = new HashMap<>();
        params.put("p", user);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> users = sqlSession.selectList("User.GetUserByCredentials", params);
        sqlSession.close();

        if (!CollectionUtils.isEmpty(users))
        {
            result = users.get(0);
        }

        return result;
    }

}
