# SpringBootDiscountApp
# Steps to run application
* Clone repository
* Run as spring boot aplication
* On console User, Products, User Type will be printed as they are created at application runtime
* Use ID's from printed information on console to test below API or you can get ID's from SpringBootDiscountAppApplication.class
* To test discount use localhost:8081/discount/getDiscount/user/{userId}/product/{productId},{productId},...

# API's to check

# Discount API's
* GET : /getDiscount/user/{userId}/product/{productId},{productId},{productId},...             // to get best discount 

# User API's
* POST : localhost:8081/user/add                     // to add new user
* PUT : localhost:8081/user/update                  // to update user
* GET : localhost:8081/user/getAll                 // to get all users
* DELETE : localhost:8081/user/delete/{id}        // to delete user with id
* GET : localhost:8081/user/getById/{id}          // to get user with id
* GET : localhost:8081/user/getByFirstName        // to get user wiht first name

# User Type API's
* POST : localhost:8081/userType/add                     // to add new userType
* PUT : localhost:8081/userType/update                  // to update userType
* GET : localhost:8081/userType/getAll                 // to get all userType
* DELETE : localhost:8081/userType/delete/{id}        // to delete userType with id
* GET : localhost:8081/userType/getById/{id}          // to get userType with id

# Product API's
* POST : localhost:8081/product/add                     // to add new product or to update
* DELETE : localhost:8081/product/delete/{id}        // to delete product with id
* GET : localhost:8081/product/getById/{id}          // to get product with id
