package com.bcomapany.discount.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.GenericGenerator;

import com.bcomapany.discount.util.UniqueIdGenerator;


//This is class is extended and used by other entity to get id

@MappedSuperclass
public class IdEntity implements Serializable {
	
	    private static final long serialVersionUID = 1L;
	
	    @Id
		@GeneratedValue(generator = UniqueIdGenerator.generatorName) // UniqueIdGenerator class will generate unique ID
		@GenericGenerator(name = UniqueIdGenerator.generatorName, strategy = "com.bcomapany.discount.util.UniqueIdGenerator" )
	    private String id;

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }


}
