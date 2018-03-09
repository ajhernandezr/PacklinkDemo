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
@DraftShipments
Feature: DraftShipments

  Scenario Outline: Complete onboarding
    Given a registered client "<username>" and "<password>"
    When a service has been selected "<packet>" and 0
    Then it will save the shipment as a draft
    And it will appear in the shipment list "<packet>"

    Examples: 
      | username                   | password | packet |
      | l4lip22662130@mailbox52.ga | Test@153 | Madrid |
