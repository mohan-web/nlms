package org.nlms.commons.model;

import java.io.Serializable;

import org.nlms.commons.util.OpenLibUtils;

public class BaseModel implements Serializable
{

    @Override
    public String toString()
    {
        return OpenLibUtils.toString(this);
    }

}
