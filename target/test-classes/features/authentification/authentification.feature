@authentification
Feature: Authentification

  @authentificationValide
    Scenario: Test compte valide
      Given connexion à la page "https://practice.automationtesting.in"
      When je clique sur le lien my Account
      And je saisie mon email "john.doe@yahoo.com"
      And je saisie mon password "Aq90@jhgeT|"
      And je clique sur le bouton de login
      Then je visualise les elements suivant Dashboard , Orders, Download, Adresses, Account Details, Logout


  @authentificationNonValide
    Scenario: Test compte non valide
    Given connexion à la page "https://practice.automationtesting.in"
    When je clique sur le lien my Account
    And je saisie mon email "john.doe@yahoo.com"
    And je saisie mon password "test"
    And je clique sur le bouton de login
    Then un message d'erreur apparait à l'ecran

  @authentifiationValideRemeberMe
  Scenario: Test compte valide et se souvenir de moi
    Given connexion à la page "https://practice.automationtesting.in"
    When je clique sur le lien my Account
    And je saisie mon email "john.doe@yahoo.com"
    And je saisie mon password "Aq90@jhgeT|"
    And je clique pas sur remeber me
    And je clique sur le bouton de login
    Then je visualise les elements suivant Dashboard , Orders, Download, Adresses, Account Details, Logout
    And je clique sur le lien <Logout>
    Then L'email et le meme et le mot de passe est rempli