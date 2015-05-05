package com.user.services;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class MyApplication extends Application{

	@Override
	public Set<Class<?>> getClasses(){
		Set<Class<?>> s= new HashSet<Class<?>>();
		s.add(userservices.class);
		return s;
	}
}
