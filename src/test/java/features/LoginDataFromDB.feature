@DBLogin
Feature: Techfios Other login functionality validation driving the data from mySQL database

  Background: 
    Given User is on techfios login page

  @DbScenario1
  Scenario: User should be able to login with valid credentials and open a new account
    When User enters "username" from mysql database
    When User enters "password" from mysql database
    And User clicks on Signin button
    Then User should land on Dashboard page
