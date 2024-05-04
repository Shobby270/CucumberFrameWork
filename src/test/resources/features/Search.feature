Feature: Search functionality

Scenario: User search for valid product
Given User opens the Application
When User enteres valid product "HP" into search box field
And User clicks on search button
Then User should get valid product

Scenario: User search for invalid product
Given User opens the Application
When User enteres invalid product "Honda" into search box field
And User clicks on search button
Then User should get a message about no product matching

Scenario: User searches without any product
Given User opens the Application
When User dont enter any product name into search box field
And User clicks on search button
Then User should get a message about no product matching 