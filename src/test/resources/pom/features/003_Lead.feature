
Feature: Scenarios for Lead object 
Scenario: Creating New Lead record 
Given User is logged in and searches for lead object
Then Create a new Lead with DataTable
      | First Name | Last Name | Company | Title |
      | Test1      |     Lead  | Meta Soft Tech  | SEIII |
      | Test2      |     Lead  | Mastek  | SEII  |
And User Delete the Record
    
    