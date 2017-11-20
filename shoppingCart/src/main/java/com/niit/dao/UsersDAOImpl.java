package com.niit.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Users;
@Repository
@Transactional
public class UsersDAOImpl implements UsersDAO{

	@Autowired
	SessionFactory sessionfactory;
	@Override
	public Users getUserByName(String username) {
		
		return (Users)sessionfactory.getCurrentSession().get(Users.class, username);
	}

}
