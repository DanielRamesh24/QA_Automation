  Feature: Scenarios for Account object 
  Scenario: Creating New Account record
  Given Click App launcher and search Accounts and Choose accounts
  And Click Account New button
  When enter Account details
  When click create save button  
  When Click dropdown and click edit
  Scenario: Update Account record
  When Update the Account name
  Then User Click edit Save button
  Scenario: Delete Account record
  Then User Click Delete button
  Then User Click Delete to Confirm
