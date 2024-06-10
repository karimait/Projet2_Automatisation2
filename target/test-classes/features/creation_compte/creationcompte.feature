Feature: Creation de compte

  @creationcompteInvalide
  Scenario: Test creation de compte invalide
    Given Je suis sur la page "https://practice.automationtesting.in"
    When je clique sur My account
    And  je rentre un email "john.doe@gmail.com"
    And je rentre un password "toto"
    And je clique sur le bouton register
    Then je reste sur la page

