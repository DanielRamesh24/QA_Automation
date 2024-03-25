
Feature: Scenarios for Lead object 
Scenario: Creating New Lead record 
Given User is logged in and searches for lead object
Then Create a new Lead with DataTable
      | First Name | Last Name | Company | Title |
      | Test1      |     Test1 | XYZ  | SEIII |
      | AKila   |   VJ   | ABC | SEII  |
Then Updating the existing record  
| Last Name | Company |
| update | ABC |
| update | XYZ |
| update | MNC |  
And User Delete the Record
    
    