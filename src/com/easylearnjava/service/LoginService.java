package com.easylearnjava.service;

import com.easylearnjava.dao.LoginDao;
import com.easylearnjava.exception.DaoException;
import com.easylearnjava.exception.ServiceException;

/**
 * 
 * @author rnr
 *
 *This class accepts input data from the LoginAction class, and sends username to the LoginDao class.
 *Based on the password returned from the LoginDao class, a password match is done and the result is 
 *sent to LoginAction class.
 */
public class LoginService {

	public boolean isValidPassword(String userName, String password) {
		try {
			LoginDao ds = new LoginDao();
			String pwdFromDB = ds.getUserPassword(userName);

			if (null != pwdFromDB) {
				if (pwdFromDB.equals(password)) {
					return true;
				}
			}
		} catch (Exception ex) {
			if (!(ex instanceof DaoException)) {
				ex.printStackTrace();
			}
			throw new ServiceException("global.exception.message");
		}
		return false;
	}

}



