package com.example.test;

import com.example.classes.*;
import com.example.services.*;
import com.example.util.HibernateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TestProduitService {

    public static void main(String[] args) {
        try {

            CategorieService catService = new CategorieService();

            Categorie cat1 = new Categorie("Ordinateurs");
            Categorie cat2 = new Categorie("Imprimantes");
            Categorie cat3 = new Categorie("Périphériques");

            catService.create(cat1);
            catService.create(cat2);
            catService.create(cat3);

            System.out.println("Catégories créées avec succès!\n");


            ProduitService prodService = new ProduitService();

            Produit p1 = new Produit("ES12", "Ecran Samsung 19 pouces", 120, 50, cat1);
            Produit p2 = new Produit("ZR85", "Imprimante HP Laser", 100, 30, cat2);
            Produit p3 = new Produit("EE85", "PC Dell Core i5", 200, 20, cat1);
            Produit p4 = new Produit("CS90", "Souris Logitech", 150, 100, cat3);

            prodService.create(p1);
            prodService.create(p2);
            prodService.create(p3);
            prodService.create(p4);

            System.out.println("Produits créés avec succès!\n");

            List<Produit> produits = prodService.findAll();
            for (Produit p : produits) {
                System.out.println(p);
            }
            System.out.println();


            List<Produit> produitsOrdinateurs = prodService.getProduitsByCategorie(cat1);
            for (Produit p : produitsOrdinateurs) {
                System.out.println(p.getReference() + " - " + p.getDesignation() + " - " + p.getPrix() + " DH");
            }
            System.out.println();


            CommandeService cmdService = new CommandeService();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date date1 = sdf.parse("2013-03-14");
            Date date2 = sdf.parse("2013-04-15");

            Commande cmd1 = new Commande(date1);
            Commande cmd2 = new Commande(date2);

            cmdService.create(cmd1);
            cmdService.create(cmd2);

            System.out.println("Commandes créées avec succès!\n");


            LigneCommandeService lcService = new LigneCommandeService();

            LigneCommande lc1 = new LigneCommande(7, p1, cmd1);
            LigneCommande lc2 = new LigneCommande(14, p2, cmd1);
            LigneCommande lc3 = new LigneCommande(5, p3, cmd1);

            lcService.create(lc1);
            lcService.create(lc2);
            lcService.create(lc3);

            // Ajout d'une ligne pour la commande 2
            LigneCommande lc4 = new LigneCommande(3, p1, cmd2);
            LigneCommande lc5 = new LigneCommande(10, p4, cmd2);

            lcService.create(lc4);
            lcService.create(lc5);

            System.out.println("Lignes de commande créées avec succès!\n");

            // Test 7: Affichage des produits d'une commande
            System.out.println("=== Test 7: Produits de la commande 1 ===");
            prodService.afficherProduitsParCommande(1);
            System.out.println();

            // Test 8: Produits commandés entre deux dates
            System.out.println("=== Test 8: Produits commandés entre le 01/03/2013 et le 31/03/2013 ===");
            Date dateDebut = sdf.parse("2013-03-01");
            Date dateFin = sdf.parse("2013-03-31");

            List<Produit> produitsCommande = prodService.getProduitsCommandeBetweenDates(dateDebut, dateFin);
            for (Produit p : produitsCommande) {
                System.out.println(p.getReference() + " - " + p.getDesignation());
            }
            System.out.println();

            // Test 9: Produits avec prix > 100 DH (requête nommée)
            System.out.println("=== Test 9: Produits avec prix > 100 DH ===");
            List<Produit> produitsPrixEleve = prodService.getProduitsPrixSuperieur(100);
            for (Produit p : produitsPrixEleve) {
                System.out.println(p.getReference() + " - " + p.getDesignation() + " - " + p.getPrix() + " DH");
            }
            System.out.println();

            // Test 10: Affichage de toutes les commandes
            System.out.println("=== Test 10: Liste de toutes les commandes ===");
            List<Commande> commandes = cmdService.findAll();
            for (Commande c : commandes) {
                System.out.println(c);
            }

            System.out.println("\n=== Tous les tests terminés avec succès! ===");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.shutdown();
        }
    }
}