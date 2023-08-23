Feature: Creating New Contract records

   @TC_Contract
  Scenario: Creating New Order record in Salesforce
    Given the user navigates to the "<URL>"
    When the user enters "<username>" and "<password>"
    And clicks Login button
    When User navigates to order object
  
    Examples: 
      | URL                                             | username              | password     |
      | https://mastek-dev-ed.develop.my.salesforce.com | qateam@automation.com | Automation06 |  