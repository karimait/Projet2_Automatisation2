Feature: Test logo sur la page

  Background:
    Given connexion à la page "https://practice.automationtesting.in"
    @logo
    Scenario: Test presence du logo
      Given la page a tester "https://practice.automationtesting.in"
      And j'enleve la pop up
      Then je dois voir le logo

