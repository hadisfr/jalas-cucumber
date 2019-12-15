Feature: Voting to a poll

  Background: A poll exists
    Given a poll exists with options like:
      | Aleph |
      | Bet   |
      | Gimel |
      | Dalet |

  Scenario: New votes to a poll should be recorded
    Given previous votes are like:
      | Option | Votes |
      | Aleph  | 0     |
      | Bet    | 1     |
      | Gimel  | 2     |
      | Dalet  | 0     |
    When MollaNasroAlDin votes to Aleph
    Then votes should be like:
      | Option | Votes |
      | Aleph  | 1     |
      | Bet    | 1     |
      | Gimel  | 2     |
      | Dalet  | 0     |
