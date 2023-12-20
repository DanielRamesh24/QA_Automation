Feature: Creating New Order records 

     
 
@OrderTestcases    
Scenario: Creating New Order record in Salesforce
 
 	   
    When User009 navigates to order object
    And User009 clicks on new button
    And User009 enters valid data "Order" & "TC_001" 
    And User009 clicks on save button
    # And Verifies009 the New record created "Order" & "TC_001"
    
   
    
   #TC_001 for valid data & TC_002 for invalid data
    