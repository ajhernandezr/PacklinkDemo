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
@Search
Feature: Search

  @First
  Scenario Outline: Complete onboarding
    Given a registered client "<username>" and "<password>"
    When accessing for the first time
    Then it will complete the onboarding process with the following Parameters and perform the "<Scenario>"
      | Direction | Name   | Surname | Company      | Postal | Address | Packet | Weight | Width | Height | Length |  |
      | Envio1    | Felipe | Garcia  | EnviosGarcia |  28932 | Madrid  | Madrid |      1 |    10 |     10 |     10 |  |

    Examples: 
      | Scenario | username                   | password |
      |        0 | l4lip22662130@mailbox52.ga | Test@153 |

  @Second
  Scenario Outline: Perform Search
    Given a registered client "<username>" and "<password>"
    When performing a search with the following information:Madrid -> "Madrid". One parcel, 1 kg, 10 cm x 10 cm x 10 cm.
    Then it will select the first service 0 of the list

    Examples: 
      | username                   | password |
      | l4lip22662130@mailbox52.ga | Test@153 |
