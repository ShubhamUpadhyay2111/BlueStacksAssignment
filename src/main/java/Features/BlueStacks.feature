Feature: Find all the games and their tournament size

Scenario: Find all the games and their tournament size
    Given We go to the "https://game.tv"
    When We scroll to the bottom of the page
    Then We get the list of the games
    Then We close all chrome instances
