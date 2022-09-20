@healtests
  Feature: Healenium Demo Feature

    Scenario Outline: Enter Credit Card Details
      Given user in on Credit-Card application page
      When user enters his details - <Name>, <Surname>, <Phone> and <Email>
      Examples:
        | Name          | Surname         | Phone         | Email                       |
        | Healenium     | G               | 9999999999    | test@mail.cc                |