Se han desarrollado los siguientes funcionalidades del proyecto:

EndPoints
1) (Get) /api/init_data -> Inicializa la base de datos cuando se encuentra vacia, crea un AdminUser con nombre Admin y password admin, y completa las tablas de roles.
		una vez llamado a este metodo, la aplicacion esta lista para empezar a utilizarse.

2) (ROLE_ADMIN) (Post) /api/auth/signin -> Este endpoint permite hacer un Login en la aplicacion. Se debe enviar como parametro un bodyrequest que contenga los siguientes atributos, name(string) y password (string)
		

3) (ROLE_ADMIN) (Post) /account_holders/ -> este endpoint se encarga de crear un AccountHolderUser. Se debe enviar como parametro un bodyrequest con los siguientes atributos:
		name (String), password (String ), dateOfBirth (LocalDate), primaryAddressStreet (String),primaryAddressCity (String),primaryAddressPostalCode (String), primaryAddressCountry (String),
		hasMailAddress (Boolean), mailAddressStreet (String), mailAddressCity (String),mailAddressPostalCode (String), mailAddressCountry (String).
		
4) (ROLE_ADMIN) (Get) /account_holders/ -> Este enpoint entrega un listado de todos los AccountHoldersUser.


5) (ROLE_ADMIN) (Post) /checking_accounts/ -> Este enpoint crea una ChekingAccount. Se debe enviar como parametro un bodyrequest con los siguientes atributos:   ownerId (Long), secondaryOwnerId (Optional<Long>),
		currency(Optional<String>), secretKey (String). En caso de que el dueño es menor de 24 años, creara una StudentCheckingAccount.

6) (ROLE_ADMIN) (Get) /checking_accounts/ -> Este enpoint entrega un listado de todos las ChekingAccounts

7) (ROLE_ADMIN) (Post) /student_checking_accounts/ -> Este enpoint crea una StudentChekingAccount. Se debe enviar como parametro un bodyrequest con los siguientes atributos:   ownerId (Long), secondaryOwnerId (Optional<Long>),
		currency(Optional<String>), secretKey (String). En caso de que el dueño sea mayor de 24, se reportara una excepcion.

8) (ROLE_ADMIN) (Get) /student_checking_accounts/  > Este enpoint entrega un listado de todos las StudentChekingAccounts

9) (ROLE_ADMIN) (Get) /basic_accounts/ -> Segun el parametro que se le envie este endpoint, entregara :
			Sin parametros: una lista completa de las BasicAccount
			Enviando la Key "id": Devolvera la BasicAccount correspondiete al id (long) que se envie como parametro.
			Enviando la Key "OwnerId": Devolvera una lista de BasicAccounts, que pertenezcan al ownerId (long) que se envie como parametro.
			En caso de que se envien ambos parametros con su respectivos values, primara la busqueda de  BasicAccount segun el id.

10) (ROLE_ACCOUNT_HOLDER) (Get) /accounts/balance -> Este endpoint devuelve el Balance de una Account, especificando el tipo de clase.
			Se debe enviar un bodyrequest con los siguientes atributos: secretKey (String), accountId (Long). 


Se incluye el fichero "BankSystem EndPoints.postman_collection.json" donde se incluyen todos los endpoints para ser utilizados en Postman
Diagrama de clases
![MidtermBankSystem drawio](https://user-images.githubusercontent.com/110189061/200124831-860d4e69-0752-4f26-9da1-2a148fc2eaf5.png)
