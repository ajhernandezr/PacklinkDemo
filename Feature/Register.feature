#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@Register
Feature: Register

  @First
  Scenario Outline: Get to registration form
    Given an internet user "<username>"
    When going to https://pro.packlink.es/registro
    Then it will see the registration form WITH 5 required fields
  Examples: 
      | username | 
      | Test |
      
  @Second
  Scenario Outline: Get to the onboarding process
    Given an internet user "<username>"
    When registered in https://pro.packlink.es WITH credentials "<username>" and random "<password>"
    Then it will land into the onboarding process

    Examples: 
      | username   | password |
      | l4lip22662130@mailbox52.ga | Test@153 |
