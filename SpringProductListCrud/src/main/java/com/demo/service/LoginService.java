package com.demo.service;

import com.demo.beans.MyUser;

public interface LoginService {

	MyUser verifyUser(String uname, String pass);

}
