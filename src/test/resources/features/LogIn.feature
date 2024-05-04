Feature: Login Functionality


Scenario Outline: Login with valid cred
Given User has navigate to login page
When User has enteres valid email address <username> into email field
And User has enteres valid password <password> into password field
And User clicks on login button
Then User should get successfully logged in
Examples:
|username									 |					password  |
|shohibshaikh369@gmail.com |					Shobby@270|
|shohibshaikh3691@gmail.com|				  12345	  	|
|shohibshaikh3692@gmail.com|				  12345			|

Scenario: Login with invalid cred
Given User has navigate to login page
When User has enteres invalid email address into email field
And User has enteres invalid password "Shobby12@270" into password field
And User clicks on login button
Then User should get propper warning message

Scenario: Login with valid email and invalid pass
Given User has navigate to login page
When User has enteres valid email address "shohibshaikh369@gmail.com" into email field
And User has enteres invalid password "123456" into password field
And User clicks on login button
Then User should get propper warning message

Scenario: Login with invalid email and valid pass
Given User has navigate to login page
When User has enteres invalid email address into email field
And User has enteres valid password "Shobby@270" into password field
And User clicks on login button
Then User should get propper warning message

Scenario: Login without providing any cred
Given User has navigate to login page
When User dont enter email address into email field
And User dont enter password into password field
And User clicks on login button
Then User should get propper warning message