package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.MyUser;
import com.demo.dao.LoginDao;

@Service
public class LoginServiceImpl implements LoginService{
@Autowired
private LoginDao loginDao;

@Override
public MyUser verifyUser(String uname, String pass) {
	
	return loginDao.verifyUser(uname,pass);
}


}
