@REQ_POEC24P2G3-61
Feature: Obtenir des informations sur les articles en vente

	@POEC24P2G3-97 @TNR_GR_3
	Scenario: Ajout panier
		        Given Je suis sur la page d'accueil du site web "https://practice.automationtesting.in/"
		        When je clique sur le bouton Consent panier
		        And Je clique sur le lien My Account ajout panier
		        And Je saisis mon adresse email valide panier "aitkarima.info@gmail.com"
		        And Je saisis mon mot de passe correct ajout panier "Aitkarimafatima3*"
		        And Je clique sur le bouton LOGIN panier
		        And Je clique sur le bouton Shop
		        And je clique sur l'article de mon choix ADDBASKET
		        And je clique pour visualiser le panier VIEWBASKET
		        Then l'utilisateur voit la photographie, un détail descriptif, le prix et le nombre d'exemplaires encore disponibles du produit
		
