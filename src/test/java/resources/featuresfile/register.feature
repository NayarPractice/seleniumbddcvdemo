Feature: Register
#  @register
  Scenario: User should create account successfully
    Given I am on Login Page
    When I click on register link
    And  I on Register page and verify a text "Register"
    And  I fill up all field in register form.
      | FName | LName | UName       | Password |
      | Test1 | Demo1 | Testing1236 | Test@123 |
    And  I verify user is "Registration successful" text


