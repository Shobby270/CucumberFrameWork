Feature: Registration functionality

Scenario: User creates an account only with mandatory fields
Given User navigates to register Account page
When User enters the details into below fields
|firstName			|	Shoaib								|
|lastname 			|	Shaikh								|
|telephone 			| 8888888								|
|password 			| Hameed@270 						|	

And User selects Privacy Policy
And User clicks on Continue button 
Then User account should get created successfully


Scenario: User creates an account only with mandatory fields
Given User navigates to register Account page
When User enters the details into below fields
|firstName			|	Hameed								|
|lastname 			|	Sayed								|
|telephone 			| 8888888								|
|password 			| Hameed@270 						|	
And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button 
Then User account should get created successfully

Scenario: User try to creates an dupliacte account only with mandatory fields
Given User navigates to register Account page
When User enters the details into below fields with duplicate email
|firstName			|	Hameed								|
|lastname 			|	Sayed								|
|email 				 	| shohibshaikh369@gmail.com	|
|telephone 			| 8888888								|
|password 			| Hameed@270 						|	
And User selects Yes for Newsletter
And User selects Privacy Policy
And User clicks on Continue button 
Then User should get propper wrning about duplicate email


Scenario: User creates an account without filling any details
Given User navigates to register Account page
When User dont enter any details into fields
And User clicks on Continue button 
Then User should get propper wrning messages for mandatory fields