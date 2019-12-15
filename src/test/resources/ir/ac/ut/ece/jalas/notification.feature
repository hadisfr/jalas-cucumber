Feature: Notifying people after voting

  Background: A poll exists
    Given a poll exists with options like:
      | Aleph |
      | Bet   |
      | Gimel |
      | Dalet |

  Scenario: New voters should be notified about their votes
    Given mail server is up
    When MollaNasroAlDin votes to Aleph
    Then a mail notification should be sent to MollaNasroAlDin
