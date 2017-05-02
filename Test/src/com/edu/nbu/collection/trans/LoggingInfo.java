package com.edu.nbu.collection.trans;

import java.util.Date;

public class LoggingInfo implements java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Date loggingDate = new Date();
	private String uid;
	private transient String pwd;
	static String name = "zhangsan ";

	LoggingInfo(String user, String password) {
		uid = user;
		pwd = password;
	}

	public String toString() {
		String password = null;
		if (pwd == null) {
			password = "NOT SET";
		} else {
			password = pwd;
		}
		if(name == null) {
			name = "NOT SET";
		}
		return "logon info: \n   " + "user: " + uid + "\n   logging date : "
				+ loggingDate.toString() + "\n   password: " + password + "\n	name: " + name;
	}
}
