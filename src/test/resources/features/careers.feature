@careers
  Feature: Careers scenarios

    @careers1
    Scenario: Recruiter removes position
      Given I open "careers" page
      And I login as "recruiter"
      Then I verify "recruiter" login
      When I remove "Principal Automation Engineer" position
      And I verify "Principal Automation Engineer" position is removed

    @careers2
    Scenario: Verify that Username is required to login
      Given I open "careers" page
      And I provide only password when login as "recruiter"
      Then I verify "Authentication error. Missing: Username" is displayed

