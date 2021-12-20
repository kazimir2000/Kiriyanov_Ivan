Feature:
  Background:
    Given user is on login page
    When enters the username and password
    And clicks Login button
    Then user is navigated to the homepage

  Scenario: Adding new pay grades
#    1. Add new record
    Given user is on Pay Grades page
    When clicks Add button
    And enters <payGradeName>
    And clicks Save button to save Pay Grade name
#    2. Record details
    And clicks Add button in Assigned Currencies
    And enters  <currencyName>, <minimumSalary>, <maximumSalary>
    And clicks Save button to save currency
#    3. Check changes on the Pay Grades page
    And user goes to Pay Grades page
    Then user is observing his entered record with Pay Grade equal to <payGradeName>
#    4. Remove record and check changes
    When user clicks in checkbox on the left of <payGradeName>
    And clicks Delete button
    And click Ok button in dialog box
    Then user is observing Pay Grade table without his record