@REQ_POEC24P2G3-61
Feature: Obtenir des informations sur les articles en vente

	@POEC24P2G3-67 @TNR_GR_3
	#Scenario: Affichage des détails d'un article
	Scenario: Vérifier pour obtenir des informations sur les articles en vente
		        Given Je suis sur la page d'accueil du site web "https://practice.automationtesting.in/"
		        When je clique sur le bouton Consent
		        And Je clique sur le lien My Account
		        And Je saisis mon adresse email valide "aitkarima.info@gmail.com"
		        And Je saisis mon mot de passe correct "Aitkarimafatima3*"
		        And Je clique sur le bouton LOGIN
		        Then Je suis redirigé vers la page Dashboard
		        And Je clique sur le bouton Shop
		        And je clique sur l'article de mon choix
		        Then l'utilisateur voit la photographie, un détail descriptif, le prix et le nombre d'exemplaires encore disponibles du produit
		
