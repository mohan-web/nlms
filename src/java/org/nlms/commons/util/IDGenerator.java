/*
 * Created on May 29, 2006
 */
package org.nlms.commons.util;

import java.rmi.server.UID;

public class IDGenerator
{
    public static String getUniqueID()
    {
        UID uid = new UID();
        StringBuffer buf = new StringBuffer();
        buf.append(uid.toString());
        return (buf.toString());
    }
}
