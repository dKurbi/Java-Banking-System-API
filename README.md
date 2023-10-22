The following project functionalities have been developed:

EndPoints
1) (Get) /api/init_data -> Initializes the database when it's empty, creates an AdminUser with the name Admin and password admin, and populates the roles tables. Once this method is called, the application is ready for use.

2) (ROLE_ADMIN) (Post) /api/auth/signin -> This endpoint allows logging into the application. You should send a body request with the following attributes: name (string) and password (string).

3) (ROLE_ADMIN) (Post) /account_holders/ -> This endpoint is responsible for creating an AccountHolderUser. You should send a body request with the following attributes: name (String), password (String), dateOfBirth (LocalDate), primaryAddressStreet (String), primaryAddressCity (String), primaryAddressPostalCode (String), primaryAddressCountry (String), hasMailAddress (Boolean), mailAddressStreet (String), mailAddressCity (String), mailAddressPostalCode (String), mailAddressCountry (String).

4) (ROLE_ADMIN) (Get) /account_holders/ -> This endpoint provides a list of all AccountHolderUsers.

5) (ROLE_ADMIN) (Post) /checking_accounts/ -> This endpoint creates a CheckingAccount. You should send a body request with the following attributes: ownerId (Long), secondaryOwnerId (Optional<Long>), currency (Optional<String>), secretKey (String). If the owner is under 24 years old, it will create a StudentCheckingAccount.

6) (ROLE_ADMIN) (Get) /checking_accounts/ -> This endpoint provides a list of all CheckingAccounts.

7) (ROLE_ADMIN) (Post) /student_checking_accounts/ -> This endpoint creates a StudentCheckingAccount. You should send a body request with the following attributes: ownerId (Long), secondaryOwnerId (Optional<Long>), currency (Optional<String>), secretKey (String). In case the owner is older than 24, an exception will be raised.

8) (ROLE_ADMIN) (Get) /student_checking_accounts/ -> This endpoint provides a list of all StudentCheckingAccounts.

9) (ROLE_ADMIN) (Get) /basic_accounts/ -> Depending on the parameter sent to this endpoint, it will return:
   - Without parameters: a complete list of BasicAccounts.
   - Sending the key "id": It will return the BasicAccount corresponding to the ID (long) sent as a parameter.
   - Sending the key "OwnerId": It will return a list of BasicAccounts belonging to the owner (long) sent as a parameter.
   - In case both parameters are sent with their respective values, the search for BasicAccount will prioritize the ID.

10) (ROLE_ACCOUNT_HOLDER) (Get) /accounts/balance -> This endpoint returns the balance of an Account, specifying the class type. You should send a body request with the following attributes: secretKey (String), accountId (Long).

The "BankSystem EndPoints.postman_collection.json" file is included, containing all the endpoints for use in Postman.
	
Class Diagram
![MidtermBankSystem drawio](https://user-images.githubusercontent.com/110189061/200124831-860d4e69-0752-4f26-9da1-2a148fc2eaf5.png)
