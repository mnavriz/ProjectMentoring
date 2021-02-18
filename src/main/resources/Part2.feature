Feature: Login Functionality tests for Campus website

  Background:
    Given Open the webpage https://test.campus.techno.study/

    Scenario: User can login with valid credentials
      When I enter my username and password
      Then I click on LOGIN button
      And  I should be logged in and see the Dashboard

      Scenario Outline: User cannot login with invalid or missing credentials
        Given  I enter invalid <username> and <password>
        When   I click on LOGIN button
        Then   I should see the Error Message

        Examples:
          | username            |password        |
          |dau2030@gmail.com    |TechnoStudy123@ |
          |daulet2030@gmail.com |TechnoStudy     |
          |dau2030@gmail.com    |TechnoStudy     |
          |dau2030@gmail.com    |                |
          |                     |TechnoStudy123@ |
          |                     |                |


