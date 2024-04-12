@VendoLite
Feature: To Check the Positive and negative cases for vendolite application

  @VendoLite001
  Scenario Outline: To verify the application is navigate to login page
    Given Launch the url
    When Select the module as "Company"
    And Enter the "<username>" and "<password>"
    And Click on "login" button
    Then check the page is navigate to homepage

    Examples: 
      | username           | password |
      | loginuser@riota.in | 12345678 |

  @VendoLite002
  Scenario Outline: To validate the error message for invalid credentials
    Given Launch the url
    When Select the module as "<module>"
    And Enter the "<username>" and "<password>"
    And Click on "login" button
    Then check the error message as "<errorMsg>"

    Examples: 
      | username           | password      | module  | errorMsg                                      |
      | loginusr@riota.in  |      12345678 | Company | Error Logging in : COMPANY_LOGGIN_FAILED']    |
      | loginusr@riOta.in  |      12345678 | Company | Error Logging in : COMPANY_LOGGIN_FAILED']    |
      |           12345567 |      12345678 | Company | Error Logging in : COMPANY_LOGGIN_FAILED']    |
      | login12345567      | login12345678 | Company | Error Logging in : COMPANY_LOGGIN_FAILED']    |
      | loginuser@riota.in |      12345678 | Client  | Error Logging in : CLIENT_ADMIN_LOGGIN_FAILED |

  @VendoLite003
  Scenario Outline: To check whether we are able to check the request reset button
    Given Launch the url
    When Select the module as "<module>"
    And Enter the "<username>" and "<password>"
    And Click on "Forgot Password" button
    And Click on "Request Reset" button
    Then check the error message as "<errorMsg>"

    Examples: 
      | username           | password | module  | errorMsg                                                                          |
      | loginuser@riota.in |          | Company | Error creating request for username, please verify that username entered is valid |

  @VendoLite004
  Scenario Outline: To check whether we are able to click the menu button
    Given Launch the url
    When Select the module as "<module>"
    And Enter the "<username>" and "<password>"
    And Click on "login" button
    And Click on "menu" button
    Then Check the help and Support label is invisible

    Examples: 
      | username           | password | module  | errorMsg                                                                          |
      | loginuser@riota.in | 12345678 | Company | Error creating request for username, please verify that username entered is valid |

  @VendoLite005
  Scenario Outline: To check whether we are able to select the time span dropdown
    Given Launch the url
    When Select the module as "<module>"
    And Enter the "<username>" and "<password>"
    And Click on "login" button
    Then Check the time span dropdown

    Examples: 
      | username           | password | module  |
      | loginuser@riota.in | 12345678 | Company |

  @VendoLite006
  Scenario Outline: To check whether we are able to select the search type dropdown
    Given Launch the url
    When Select the module as "<module>"
    And Enter the "<username>" and "<password>"
    And Click on "login" button
    Then Check the search Type dropdown

    Examples: 
      | username           | password | module  |
      | loginuser@riota.in | 12345678 | Company |

  @VendoLite007
  Scenario Outline: To check whether we are able to select the type dropdown
    Given Launch the url
    When Select the module as "<module>"
    And Enter the "<username>" and "<password>"
    And Click on "login" button
    Then Check the Type dropdown

    Examples: 
      | username           | password | module  |
      | loginuser@riota.in | 12345678 | Company |

  @VendoLite008
  Scenario Outline: To check whether we are able to change the mobile number
    Given Launch the url
    When Select the module as "<module>"
    And Enter the "<username>" and "<password>"
    And Click on "login" button
    And Click on "profile" button
    And Click on "edit" button
    And Enter the mobile number as "9898989898"
    And Click on "save" button
    Then check the error message as "<Validation>"

    Examples: 
      | username           | password | module  | Validation     |
      | loginuser@riota.in | 12345678 | Company | Changes saved! |

  @VendoLite009
  Scenario Outline: To check whether we are able to change the Username
    Given Launch the url
    When Select the module as "<module>"
    And Enter the "<username>" and "<password>"
    And Click on "login" button
    And Click on "profile" button
    And Click on "edit" button
    And Change the user name as "Riota User"
    And Click on "save" button
    Then check the error message as "<Validation>"

    Examples: 
      | username           | password | module  | Validation     |
      | loginuser@riota.in | 12345678 | Company | Changes saved! |

  @VendoLite010
  Scenario Outline: To check whether we are able to find the frequently asked question list
    Given Launch the url
    When Select the module as "<module>"
    And Enter the "<username>" and "<password>"
    And Click on "login" button
    And Click on "Help and support" button
    Then Check the Frequently asked question listed

    Examples: 
      | username           | password | module  | Validation     |
      | loginuser@riota.in | 12345678 | Company | Changes saved! |

  @VendoLite011
  Scenario Outline: To check whether we are able to change the Email ID
    Given Launch the url
    When Select the module as "<module>"
    And Enter the "<username>" and "<password>"
    And Click on "login" button
    And Click on "profile" button
    And Click on "edit" button
    Then Change the email as "usermail@riota.com"

    Examples: 
      | username           | password | module  |
      | loginuser@riota.in | 12345678 | Company |

  @VendoLite012
  Scenario Outline: To check whether we are able to change the Date Range
    Given Launch the url
    When Select the module as "<module>"
    And Enter the "<username>" and "<password>"
    And Click on "login" button
    Then Change the date range

    Examples: 
      | username           | password | module  |
      | loginuser@riota.in | 12345678 | Company |

  @VendoLite013
  Scenario Outline: To check whether we are able to Upgrade the plan
    Given Launch the url
    When Select the module as "<module>"
    And Enter the "<username>" and "<password>"
    And Click on "login" button
    And Click on "profile" button
    Then Check the upgrade plan page shows message as "No upgradable plans available. Please contact your system admin."

    Examples: 
      | username           | password | module  |
      | loginuser@riota.in | 12345678 | Company |

  @VendoLite014
  Scenario Outline: To check whether we are able to logout the application
    Given Launch the url
    When Select the module as "<module>"
    And Enter the "<username>" and "<password>"
    And Click on "login" button
    And Click on "logout" button
    Then Verify the application is logout

    Examples: 
      | username           | password | module  |
      | loginuser@riota.in | 12345678 | Company |
