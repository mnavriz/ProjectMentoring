Feature: Adding a user and logging in by using the user we have created

  Background:
  Given Open the webpage

    Scenario Outline: User cannot be created with short credentials AND
                      User can be created with a username and a password
                      whose lengths are more than 3 characters

      Given navigate to adduser page by clicking 3.Add a User link
      When Enter "<username>" and "<password>" and click on save button
      And    click ok on alert AND check the "<result>".



      Examples:
        |username | password | result|
        |Mus      |  Mustafa |Username too short.  The username must be at least 4 characters in length.|
        |Navriz   |  Nav     |Password too short.  The password must be at least 4 characters in length.|
        |Mus      |  Nav     |Username too short.  The username must be at least 4 characters in length.|
        |Mustafa |  Navriz  |                                                                           |


    Scenario Outline: User cannot login with invalid credentials AND
                      User can login by using the credentials that have
                      just been created

      Given  navigate to adduser page
      When When Enter "<username>" and "<password>" and click on Test Login button
      Then Get the status "<message>"


      Examples:
          | username | password |   message  |
          |Mufatsa   |  Navriz  |Failed Login|
          |Mustafa   |  Zirvan  |Failed Login|
          |Afatsum   |  Zirvan  |Failed Login|
          |Mustafa   |  Navriz  |Successful Login|


    Scenario Outline: User cannot login if at least one of the credentials is less than 4 characters

      When When Enter "<username>" and "<password>" and click on Test Login button
      Then Get the status "<message>"

      Examples:
        | username | password | message |
        |Mustfa    |  Nav     | Password too short.  The password must be at least 4 characters in length. |
        |Mus       |  Navriz  | Username too short.  The username must be at least 4 characters in length. |
        |Mus       |  Nav     |  Username too short.  The username must be at least 4 characters in length.|


