package com.bcomapany.discount;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bcomapany.discount.controller.ProductController;
import com.bcomapany.discount.controller.UserController;
import com.bcomapany.discount.controller.UserTypeController;
import com.bcomapany.discount.entity.Product;
import com.bcomapany.discount.entity.User;
import com.bcomapany.discount.entity.UserType;

/*
 * Spring boot application started, on run it will generate the data and put in H2 which is temporary
 * DI has been done with constructor
 *  
 * */
@SpringBootApplication
public class SpringBootDiscountAppApplication implements CommandLineRunner{
	
	private final UserController userController;
	
	private final UserTypeController userTypeController;
	
	private final ProductController productController;
	

	public SpringBootDiscountAppApplication(UserController userController, UserTypeController userTypeController, ProductController productController) {
		super();
		this.userController = userController;
		this.userTypeController = userTypeController;
		this.productController = productController;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDiscountAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		// This section is temporary just to put some data in H2
		UserType userType1 = new UserType("Employee");
		UserType userType2 = new UserType("Affiliate");
		UserType userType3 = new UserType("Regular Customer");
		
		userTypeController.addUserType(userType1);
		userTypeController.addUserType(userType2);
		userTypeController.addUserType(userType3);
		
		System.out.println("==========User Types======");
		System.out.println(userTypeController.getAllUserType().toString());
		System.out.println("==========================");
		
		 List<UserType> userTypes = userTypeController.getAllUserType().getBody();
		 userType1 = userTypes.get(0);
		 userType2 = userTypes.get(1);
		 userType3 = userTypes.get(2);
		 
		 List<User> users = new ArrayList<User>();
		 users.add(new User("Jack", "Sparrow", "9632154789", "dummu@abc.com", userType1));
		 users.add(new User("Dom", "Torreto", "9586154789", "dummu1@abc.com", userType2));
		 users.add(new User("John", "Wick", "9532154789", "dummu2@abc.com", userType3));
		 users.add(new User("Charli", "Hopper", "8632154789", "dummu3@abc.com", userType1));
		 users.add(new User("Jake", "Hopper", "8032154789", "dummu4@abc.com", userType2));
		 users.add(new User("Tony", "Jha", "9132154789", "dummu5@abc.com", userType3));
		 users.add(new User("Abd", "Dab", "7032154789", "dummu6@abc.com", userType1));
		 users.add(new User("Adam", "Liven", "3232154789", "dummu7@abc.com", userType2));
		 users.add(new User("Mathive", "Stark", "1032154789", "dummu8@abc.com", userType3));
		 users.add(new User("James", "Bond", "8232154789", "dummu9@abc.com", userType1));
		 users.add(new User("Michel", "Jordan", "6832154789", "dummu10@abc.com", userType2));
		 
		 System.out.println("========= Users ===========");
		 System.out.println(userController.saveAllUsers(users).toString());
		 System.out.println("===========================");
		 
		 List<Product> products = new ArrayList<Product>();
         
		 products.add(new Product("TV", "Other", 10000.20));
         products.add(new Product("Phone", "Other", 8000.55));
         products.add(new Product("Laptop", "Other", 28000.52));
         products.add(new Product("Tea Powder", "groceries", 8000.00));
         products.add(new Product("Milk", "groceries", 8000.10));
         products.add(new Product("Sugar", "groceries", 8000.03));
         
         System.out.println("========= Products ===========");
		 System.out.println(productController.saveAll(products).toString());
		 System.out.println("===========================");
	}

}
