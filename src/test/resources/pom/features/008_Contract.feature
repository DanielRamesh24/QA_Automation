Feature: Scenarios for Contract object 


   @TC_ContractObject
  Scenario: Create a New Contract Record 
   
    Given User navigates to Contract object
    And clicks on new button
    And enters valid date
    And Verifies the New record created
    
  Scenario: Update Contract Record  
  	And update ContractTerm field
  
  	
  Scenario: Delete the Record	
    And Delete the Record
    

  