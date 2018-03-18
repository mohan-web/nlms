package org.nlms.security.model;

import java.sql.Timestamp;

import org.nlms.commons.model.BaseModel;


public class LoginLog extends BaseModel
{
    private String userName;

    private Timestamp loginTime;

    private String context;

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public Timestamp getLoginTime()
    {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime)
    {
        this.loginTime = loginTime;
    }

    public String getContext()
    {
        return context;
    }

    public void setContext(String context)
    {
        this.context = context;
    }
}
