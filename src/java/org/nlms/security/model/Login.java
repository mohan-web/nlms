package org.nlms.security.model;

import java.sql.Timestamp;

import org.nlms.commons.model.BaseModel;


public class Login extends BaseModel
{
    private String userName;

    private String context;

    private Timestamp logTime;

    public Login()
    {
    }

    public Login(String userName, String context, Timestamp logTime)
    {
        this.userName = userName;
        this.context = context;
        this.logTime = logTime;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getContext()
    {
        return context;
    }

    public void setContext(String context)
    {
        this.context = context;
    }

    public Timestamp getLogTime()
    {
        return logTime;
    }

    public void setLogTime(Timestamp logTime)
    {
        this.logTime = logTime;
    }
}
