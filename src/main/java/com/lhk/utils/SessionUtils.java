package com.lhk.utils;

import javax.servlet.http.HttpServletRequest;

public class SessionUtils {
	private static SessionUtils sessionUtils = null;
	
	public static SessionUtils getInstance() {
		if(sessionUtils == null) {
			sessionUtils = new SessionUtils();
		}
		return sessionUtils;
	}
	
	public void putValue(HttpServletRequest req, String key, Object value) {
		req.getSession().setAttribute(key, value);
	}
	
	public Object getValue(HttpServletRequest req, String key) {
		return req.getSession().getAttribute(key);
	}
	
	public void removeValue(HttpServletRequest req, String key) {
		req.getSession().removeAttribute(key);
	}
}
