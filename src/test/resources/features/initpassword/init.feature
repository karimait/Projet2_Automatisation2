@init
Feature: Réinitialisation de mot de passe
  # faker@hotmail.it
  # A@J8PLA-9Q
  Background:
    Given connexion à la page "https://practice.automationtesting.in"

  @initok
  Scenario: Test de réinitialisation de mot de passe réussi
    Given je suis sur la page de connexion "https://practice.automationtesting.in"
    When je clique sur le lien My account
    And je clique sur le lien <Lost your password?>
    And j'injecte mon e-mail "faker@hotmail.it"
    And je clique sur le bouton <Reset Password>
    Then je reçois un message de confirmation

  @initNok
  Scenario: Test de réinitialisation de compte inexistant
    Given je suis sur la page de connexion "https://practice.automationtesting.in"
    When je clique sur le lien My account
    And je clique sur le lien <Lost your password?>
    And j'injecte mon e-mail "MY WRONG EMAIL :)"
    And je clique sur le bouton <Reset Password>
    Then je dois voir un message d'erreur