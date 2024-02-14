Feature: Scenarios for Opportunity object 
Scenario: Creating New Opportunity record
Given Click App launcher and search Opportunity and Choose Opportunity
And Click New button
When enter Opportunity details
And click opportunity save button
Then Scroll down to Quotes and click dropdown and click new Quote
And Enter Quote details
Then Click Quote Save
