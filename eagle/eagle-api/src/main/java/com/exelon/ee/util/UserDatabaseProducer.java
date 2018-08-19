package com.exelon.ee.util;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.exelon.ee.qualifier.UserDatabase;

public class UserDatabaseProducer {

	@Produces @UserDatabase @PersistenceContext
	static EntityManager userDatabase;

}
