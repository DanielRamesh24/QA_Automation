
Feature: Scenario for Contact object
Scenario: Create New Contact record
Given user is logged in and clicks the contact tab
When The user able to hit New button
Then The user should able to fill the required fields and save the contact

Scenario: Update the Contact record
Given The record is properly created with the given user inputs
When The user clicks the Edit button
Then The user should enter the values for the fields to be updated

Scenario: Delete the Contact record
Given The record is updated properly
When The user clicks the Delete button
Then Confirm the delete operation