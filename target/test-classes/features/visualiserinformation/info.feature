@visualiser
Feature: Visualiser mes informations de compte

  # john.doe@yahoo.com
  # initiale : Aq90@jhgeT|
  # finale   : |Teghj@09qA
  Background:
    Given connexion à la page "https://practice.automationtesting.in"
    When je clique sur le lien my Account
    And je saisie mon email "john.doe@yahoo.com"
    And je saisie mon password "Aq90@jhgeT|"

  @changementOk
  Scenario: Changement de mot de passe réussi
    Given je suis sur mon compte
    When je clique sur le lien Account Details
    And je clique sur <Password Change>
    And je saisie mon password actuel "Aq90@jhgeT|"
    And je clique sur <New Password>
    And j'injecte mon nouveau password "|Teghj@09qA"
    And je clique <Confirm New Password>
    And je confirme mon nouveau password "|Teghj@09qA"
    And je clique sur le bouton <SAVE CHANGES>
    Then je reçois un message de confirmation

  @changementNOk1
  Scenario: Changement de mot de passe réussi 1
    Given je suis sur mon compte
    When je clique sur le lien Account Details
    And je clique sur <Password Change>
    And je saisie mon password actuel "|Teghj@09qA"
    And je clique sur <New Password>
    And j'injecte mon nouveau password "[PASSWORD]"
    And je clique <Confirm New Password>
    And je confirme mon nouveau password ""
    And je clique sur le bouton <SAVE CHANGES>
    Then je reçois un message d'erreur

  @changementNOk2
  Scenario: Changement de mot de passe réussi 2
    Given je suis sur mon compte
    When je clique sur le lien Account Details
    And je clique sur <Password Change>
    And je saisie mon password actuel "|Teghj@09qA"
    And je clique sur le bouton <SAVE CHANGES>
    Then je reçois un message d'erreur

