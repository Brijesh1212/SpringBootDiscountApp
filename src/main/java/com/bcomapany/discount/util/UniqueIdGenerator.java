package com.bcomapany.discount.util;

import java.io.Serializable;
import java.util.UUID;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;


/*
 * Generates unique ID 
 * 
 * */

public class UniqueIdGenerator implements IdentifierGenerator {

    public static final String generatorName = "myGenerator";

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object object) throws HibernateException {
//    	System.out.println("UUID : " + UUID.randomUUID().toString().replace("-", ""));
    	return UUID.randomUUID().toString().replace("-", "");
    }

}
