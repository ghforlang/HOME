package com.edu.nbu.collection.trans;

import java.util.Date;

public class GuestLoggingInfo implements java.io.Serializable   
{   
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date loggingDate = new Date();   
    private String uid;   
    private transient String pwd;   
      
    GuestLoggingInfo()   
    {   
        uid = "guest";   
        pwd = "guest";   
    }   
    public String toString()   
    {   
		String password = null;
		if (pwd == null) {
			password = "NOT SET";
		} else {
			password = pwd;
		}
		return "logon info: \n   " + "user: " + uid + "\n   logging date : "
				+ loggingDate.toString() + "\n   password: " + password;   
     }   
} 
