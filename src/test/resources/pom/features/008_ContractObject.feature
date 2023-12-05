Feature: Creating New Contract records

   @TC_ContractObject
  Scenario Outline: Creating New Contract record in Salesforce
   
    Given User navigates to Contract object
    And clicks on new button
    And enters valid date
    And Verifies the New record created
  	#And update ContractTerm field
    #And Delete the Record
    

  