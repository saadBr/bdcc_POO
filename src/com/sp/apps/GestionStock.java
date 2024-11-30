package com.sp.apps;

import com.sp.programs.Produit;
import java.util.Scanner;

public class GestionStock {
    // Tableau pour stocker les produits (maximum de 100 produits)
    private static Produit[] produits = new Produit[3];
    private static Scanner sc = new Scanner(System.in);
    private static int nombreProduit = 0; // Compteur pour le nombre actuel de produits

    // Méthode pour afficher le menu principal
    public static void printMenu() {
        System.out.println("------Gestion du stock------");
        System.out.println("1 - Ajouter un produit");
        System.out.println("2 - Modifier un produit");
        System.out.println("3 - Supprimer un produit");
        System.out.println("4 - Afficher la liste des produits");
        System.out.println("5 - Rechercher un produit");
        System.out.println("6 - Calculer la valeur totale du stock");
        System.out.println("0 - Quitter");
        System.out.println();
        System.out.print("Choisissez une option:");
    }

    // Méthode pour ajouter un produit au tableau
    public static void ajouterProduit(Produit produit) {
        // Vérifier si un produit avec le même code existe déjà
        for (int i = 0; i < nombreProduit; i++) {
            if (produit.getCode() == produits[i].getCode()) {
                System.out.println("Erreur, code doit être unique");
                return;
            }
        }
        // Ajouter le produit et incrémenter le compteur
        produits[nombreProduit] = produit;
        nombreProduit++;
        System.out.println("Produit ajouté avec succès !");
    }

    // Méthode pour modifier un produit existant
    public static void modifierProduit(int codeProduit, String nouveauNom, int nouvelleQuantite, double nouveauPrix) {
        for (int i = 0; i < nombreProduit; i++) {
            if (produits[i].getCode() == codeProduit) {
                // Mise à jour des informations du produit
                produits[i].setNom(nouveauNom);
                produits[i].setQuantite(nouvelleQuantite);
                produits[i].setPrix(nouveauPrix);
                System.out.println("Produit modifié avec succès !");
                return;
            }
        }
        System.out.println("Produit introuvable.");
    }

    // Méthode pour supprimer un produit du tableau
    public static void supprimerProduit(int codeProduit) {
        // Parcourir la liste des produits pour trouver le produit à supprimer
        for (int i = 0; i < nombreProduit; i++) {
            if (produits[i].getCode() == codeProduit) {
                // Décaler les éléments après le produit à supprimer
                for (int j = i; j < nombreProduit - 1; j++) {
                    produits[j] = produits[j + 1]; // Copier l'élément suivant dans la position actuelle
                }
                produits[nombreProduit - 1] = null; // Effacer le dernier élément (désormais inutilisé)
                nombreProduit--; // Réduire le nombre total de produits
                System.out.println("Produit supprimé avec succès !");
                return; // Terminer la méthode
            }
        }
        // Si aucun produit avec le code donné n'est trouvé
        System.out.println("Produit introuvable.");
    }

    // Méthode pour afficher la liste complète des produits
    public static void afficherProduits() {
        for (int i = 0; i < nombreProduit; i++) {
            if (produits[i] != null) { // Vérifier que l'élément n'est pas null
                System.out.println(produits[i].toString());
            }
        }
    }

    // Méthode pour rechercher un produit par son nom
    public static void rechercherProduit(String nomProduit) {
        boolean trouve = false;
        for (int i = 0; i < nombreProduit; i++) {
            if (produits[i].getNom().toLowerCase().contains(nomProduit.toLowerCase())) {
                System.out.println(produits[i].toString());
                trouve = true;
            }
        }
        if (!trouve) {
            System.out.println("Produit inexistant.");
        }
    }

    // Méthode pour calculer la valeur totale du stock
    public static void calculerValeurStock() {
        double total = 0;
        for (int i = 0; i < nombreProduit; i++) {
            if (produits[i] != null) { // Vérifier que l'élément n'est pas null
                total += produits[i].stock(); // Ajouter la valeur en stock du produit
            }
        }
        System.out.println("Valeur totale du stock : " + total);
    }

    // Méthode principale (main) pour exécuter l'application
    public static void main(String[] args) {
        int choix;
        do {
            printMenu(); // Afficher le menu principal
            choix = sc.nextInt();
            sc.nextLine(); // Consommer la nouvelle ligne

            switch (choix) {
                case 1:
                    // Ajouter un nouveau produit
                    if (nombreProduit >= produits.length) {
                        System.out.println("Tableau plein, impossible d'ajouter un produit");
                        break;
                    }
                    System.out.println("Code produit :");
                    int codeProduit = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nom produit :");
                    String nomProduit = sc.nextLine();
                    int quantiteProduit;
                    while (true) {
                        System.out.println("Quantité produit :");
                        quantiteProduit = sc.nextInt();
                        if (quantiteProduit >= 0)
                            break;
                        else
                            System.out.println("Veuillez saisir une valeur valide");
                    }
                    double prixProduit;
                    while (true) {
                        System.out.println("Prix produit :");
                        prixProduit = sc.nextDouble();
                        if (prixProduit >= 0)
                            break;
                        else
                            System.out.println("Veuillez saisir une valeur valide");
                    }
                    Produit produit = new Produit(codeProduit, nomProduit, quantiteProduit, prixProduit);
                    ajouterProduit(produit);
                    break;

                case 2:
                    // Modifier un produit existant
                    afficherProduits();
                    System.out.println("Entrez le code du produit à modifier :");
                    int codeProduitModif = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nouveau nom :");
                    String nouveauNom = sc.nextLine();
                    int nouvelleQuantite;
                    while (true) {
                        System.out.println("Nouvelle quantité :");
                        nouvelleQuantite = sc.nextInt();
                        if (nouvelleQuantite >= 0)
                            break;
                        else
                            System.out.println("Veuillez saisir une valeur valide");
                    }
                    double nouveauPrix;
                    while (true) {
                        System.out.println("Nouveau prix :");
                        nouveauPrix = sc.nextDouble();
                        if (nouveauPrix >= 0)
                            break;
                        else
                            System.out.println("Veuillez saisir une valeur valide");
                    }
                    modifierProduit(codeProduitModif, nouveauNom, nouvelleQuantite, nouveauPrix);
                    break;

                case 3:
                    // Supprimer un produit
                    afficherProduits();
                    System.out.println("Entrez le code du produit à supprimer :");
                    int codeProduitSupprimer = sc.nextInt();
                    supprimerProduit(codeProduitSupprimer);
                    break;

                case 4:
                    // Afficher tous les produits
                    afficherProduits();
                    break;

                case 5:
                    // Rechercher un produit par nom
                    System.out.println("Entrez le nom du produit à rechercher :");
                    String nomProduitRecherche = sc.nextLine();
                    rechercherProduit(nomProduitRecherche);
                    break;

                case 6:
                    // Calculer la valeur totale du stock
                    calculerValeurStock();
                    break;

                case 0:
                    System.out.println("Session terminée.");
                    break;

                default:
                    System.out.println("Option invalide !");
            }
        } while (choix != 0);
    }
}
