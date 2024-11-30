package com.sp.programs;

public class Produit {
    // Attributs privés pour les informations du produit
    private int code;
    private String nom;
    private int quantite;
    private double prix;

    // Constructeur avec paramètres
    public Produit(int code, String nom, int quantite, double prix) {
        this.code = code;
        this.nom = nom;
        this.quantite = quantite;
        this.prix = prix;
    }

    // Constructeur par défaut (nécessaire si on veut créer des objets vides)
    public Produit() {
    }

    // Getters et setters pour les attributs
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    // Redéfinition de la méthode toString() pour afficher les informations du produit
    @Override
    public String toString() {
        return "Produit [code=" + code + ", nom=" + nom + ", quantité=" + quantite + ", prix=" + prix + "]";
    }

    // Calcul de la valeur totale du produit en stock (quantité * prix unitaire)
    public double stock() {
        return quantite * prix;
    }
}
