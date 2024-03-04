Feature: Scenarios for Order object 


     
 
@OrderTestcases    
Scenario: Creating New Order record 
 
 	   
    When User009 navigates to order object
    And User009 clicks on new button
    And User009 enters valid data "Order" & "TC_001" 
    And User009 clicks on save button
    
    
    Scenario: Update Order Record  
  	And user009 update status field
  
  	
  Scenario: Delete the Record	
    And  user009 Delete the Order Record
    

    