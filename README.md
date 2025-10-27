# Application de Gestion de Stock

Une application Java complète de gestion de stock développée avec une architecture MVC et Hibernate pour la persistance des données.

## 📋 Description

Cette application permet de gérer efficacement :
- **Produits** et leurs catégories
- **Commandes** et lignes de commande
- **Stock** et inventaire

## 🏗️ Architecture du Projet
Application de gestion des stock/
├── src/
│ └── main/
│ └── java/
│ └── com/
│ └── example/
│ ├── classes/ # Entités métier
│ │ ├── Categorie.java
│ │ ├── Commande.java
│ │ ├── LigneCommande.java
│ │ └── Produit.java
│ ├── dao/ # Couche d'accès aux données
│ │ └── iDao.java
│ ├── services/ # Couche métier
│ │ ├── CategorieService.java
│ │ ├── CommandeService.java
│ │ ├── LigneCommandeService.java
│ │ └── ProduitService.java
│ └── util/
│ └── HibernateUtil.java
├── resources/
│ └── application.properties # Configuration Hibernate
├── test/ # Tests unitaires
│ └── TestProduitService.java
├── target/
├── .gitignore
└── pom.xml # Configuration Maven

## 🛠️ Technologies Utilisées

- **Java** - Langage de programmation
- **Hibernate** - ORM (Object-Relational Mapping)
- **Maven** - Gestion des dépendances
- **JUnit** - Tests unitaires
- **MySQL/PostgreSQL** - Base de données (configurable)

## 📦 Fonctionnalités

### Gestion des Produits
- Ajout, modification, suppression de produits
- Gestion des catégories
- Consultation du stock

### Gestion des Commandes
- Création de commandes
- Gestion des lignes de commande
- Suivi des commandes

### Services Métier
- `ProduitService` : Gestion des opérations sur les produits
- `CategorieService` : Gestion des catégories
- `CommandeService` : Gestion des commandes
- `LigneCommandeService` : Gestion des lignes de commande

## 🚀 Installation

### Prérequis
- Java JDK 8 ou supérieur
- Maven 3.6+
- Base de données MySQL/PostgreSQL

### Configuration

1. **Cloner le repository**
   ```bash
   git clone https://github.com/votre-username/gestion-stock.git
   cd gestion-stock
   Configurer la base de données

2. Modifier le fichier src/main/resources/application.properties

Configurer l'URL, username et password de votre base de données

3. Compiler le projet
mvn clean compile

4.Exécuter les tests
mvn test
📊 Structure de la Base de Données
L'application utilise les entités suivantes :

Produit : Informations sur les produits

Categorie : Catégories de produits

Commande : Commandes passées

LigneCommande : Détails des commandes

🧪 Tests
Les tests unitaires sont disponibles dans le dossier test/ :

TestProduitService.java : Tests pour le service des produits

Exécuter les tests avec :
mvn test

📝 Utilisation
Exemple d'utilisation des services :

// Création d'un service produit
ProduitService produitService = new ProduitService();

// Ajout d'un nouveau produit
Produit produit = new Produit("Nom du produit", 19.99, 100);
produitService.create(produit);

🧪 Exemple d’affichage attendu
<img width="2559" height="1388" alt="Screenshot 2025-10-26 210533" src="https://github.com/user-attachments/assets/505f2611-7319-45b8-ac2e-eaa550447bf0" />





🧩 Gestion de Projets — Application Java Hibernate
📘 Description du projet

Ce projet a pour objectif de développer une application Java permettant de gérer les employés, les projets et les tâches associées.
L’application repose sur Hibernate ORM pour la couche de persistance (connexion et gestion de la base de données MySQL).

Elle permet de :

Gérer les employés (ajout, suppression, modification, recherche)

Gérer les projets et les tâches associées

Associer des employés à des tâches via une relation EmployeTache

Exécuter différentes opérations CRUD à travers des services Hibernate

src/
└── main/
    ├── java/
    │   └── ma/projet/
    │       ├── classes/        # Contient les entités JPA (Employe, Projet, Tache, EmployeTache)
    │       ├── dao/            # Interface générique IDao<T>
    │       ├── service/        # Implémentations des services (EmployeService, ProjetService, etc.)
    │       ├── test/           # Classe(s) de test de la logique métier
    │       └── util/           # Configuration Hibernate (HibernateUtil)
    └── resources/
        └── application.properties  # Fichier de configuration Hibernate/MySQL

pom.xml                            # Dépendances Maven

| Composant          | Technologie             |
| ------------------ | ----------------------- |
| Langage principal  | Java 17                 |
| ORM                | Hibernate 5.6.15        |
| Base de données    | MySQL                   |
| Build tool         | Maven                   |
| IDE recommandé     | IntelliJ IDEA / Eclipse |
| API de persistance | JPA (javax.persistence) |

🧩 Structure des packages
ma.projet.classes

Contient les entités JPA :

Employe : informations sur un employé

Projet : informations sur un projet

Tache : tâche rattachée à un projet

EmployeTache : association entre employé et tâche

ma.projet.dao

IDao<T> : interface générique définissant les opérations CRUD :

void create(T o);
void update(T o);
void delete(T o);
T findById(int id);
List<T> findAll();

ma.projet.service

Implémentations concrètes des services :

EmployeService

ProjetService

TacheService

EmployeTacheService

Chaque service hérite de IDao et utilise Hibernate pour les opérations CRUD.

ma.projet.util

HibernateUtil : classe responsable de la création du SessionFactory à partir du fichier application.properties.

ma.projet.test

GestionEmployeTest : classe de test principale du projet, utilisée pour insérer des données et tester les opérations CRUD.

🛠️ Fichier application.properties
hibernate.connection.driver_class=com.mysql.cj.jdbc.Driver
hibernate.connection.url=jdbc:mysql://localhost:3306/gestion_projets?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
hibernate.connection.username=root
hibernate.connection.password=

hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
hibernate.hbm2ddl.auto=update
hibernate.show_sql=true
hibernate.format_sql=true

🚀 Exécution du projet

Configurer la base de données MySQL

CREATE DATABASE gestion_projets;


Vérifier la configuration du fichier application.properties

Adapter le username et password selon ta configuration locale.

Compiler le projet

mvn clean compile


Exécuter le programme de test
Dans IntelliJ ou en ligne de commande :

mvn exec:java -Dexec.mainClass="ma.projet.test.GestionEmployeTest"

🧪 Exemple d’utilisation

Exemple simple dans GestionEmployeTest :

EmployeService employeService = new EmployeService();
Employe e1 = new Employe("Said", "Safi", "Développeur");
employeService.create(e1);

List<Employe> list = employeService.findAll();
list.forEach(System.out::println);

🧠 Objectif pédagogique

Ce projet a pour but de :

Mettre en pratique la programmation orientée objet (POO)

Manipuler Hibernate et JPA

Concevoir une architecture à couches (DAO / Service / Test)

Apprendre à gérer les relations entre entités (OneToMany, ManyToMany, etc.)

🧪 Exemple d’affichage attendu
<img width="2511" height="1185" alt="Screenshot 2025-10-27 120313" src="https://github.com/user-attachments/assets/15039308-a14e-4077-9e80-9e1f721e8d11" />





🏛️ Système de Gestion d’État Civil — Application Java Hibernate
📘 Description du projet

Ce projet implémente un système de gestion d’état civil permettant de suivre les informations des personnes (hommes, femmes) et de leurs mariages.
L’objectif est de modéliser et automatiser la gestion des mariages, enfants et relations familiales à l’aide de Hibernate (JPA) et MySQL.

L’application permet notamment de :

Gérer les personnes (hommes et femmes)

Enregistrer et suivre les mariages (date de début, fin, nombre d’enfants)

Lister les épouses d’un homme donné

Calculer le nombre d’enfants d’une femme sur une période

Identifier les femmes mariées plusieurs fois

Compter les hommes mariés à plusieurs femmes entre deux dates

src/
└── main/
    ├── java/
    │   └── ma/projet/
    │       ├── beans/           # Entités JPA (Personne, Homme, Femme, Mariage)
    │       ├── dao/             # Interface générique IDao<T>
    │       ├── service/         # Services Hibernate (HommeService, FemmeService, MariageService)
    │       ├── test/            # Classe de test principale (EtatCivil)
    │       └── util/            # Classe HibernateUtil
    └── resources/
        └── application.properties

pom.xml                           # Dépendances Maven

| Composant          | Technologie             |
| ------------------ | ----------------------- |
| Langage principal  | Java 17                 |
| ORM                | Hibernate 5.6.15        |
| Base de données    | MySQL                   |
| Build tool         | Maven                   |
| API de persistance | JPA (javax.persistence) |
| IDE recommandé     | IntelliJ IDEA / Eclipse |

🧩 Structure des packages
ma.projet.beans

Contient les entités et relations du modèle conceptuel :

Personne : classe abstraite contenant les attributs communs (id, nom, prenom, telephone, adresse, dateNaissance)

Homme : hérite de Personne

Femme : hérite de Personne

Mariage : relie un Homme et une Femme, avec :

dateDebut

dateFin

nbrEnfant

Relations :

Homme 1 ────< Mariage >──── 1 Femme

ma.projet.dao

IDao<T> : interface générique définissant les opérations CRUD :

void create(T o);
void update(T o);
void delete(T o);
T findById(int id);
List<T> findAll();

ma.projet.service

Services dédiés à chaque entité :

HommeService

CRUD complet

afficherEpousesEntreDeuxDates(int idHomme, Date debut, Date fin)
→ Affiche les épouses d’un homme entre deux dates.

FemmeService

getNombreEnfantsEntreDates(int idFemme, Date debut, Date fin)
→ Requête native : total d’enfants d’une femme sur une période.

getFemmesMarieesDeuxFois()
→ Requête nommée : femmes mariées au moins deux fois.

getNombreHommesAvecQuatreFemmes(Date debut, Date fin)
→ API Criteria : nombre d’hommes ayant eu 4 femmes entre deux dates.

MariageService

Gestion des mariages

Méthode afficherMariages(Homme homme) → affiche tous les mariages d’un homme avec leurs détails.

ma.projet.util

HibernateUtil : gère la création du SessionFactory à partir du fichier application.properties.

ma.projet.test

EtatCivil : programme principal de test, permettant de :

Créer des instances d’hommes et de femmes

Simuler plusieurs mariages

Tester toutes les méthodes de la couche service :

Afficher les épouses d’un homme

Compter les enfants d’une femme

Lister les femmes mariées deux fois

Compter les hommes mariés à quatre femmes

Afficher les détails des mariages d’un homme

⚙️ Fichier application.properties
hibernate.connection.driver_class=com.mysql.cj.jdbc.Driver
hibernate.connection.url=jdbc:mysql://localhost:3306/etat_civil?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC
hibernate.connection.username=root
hibernate.connection.password=

hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
hibernate.hbm2ddl.auto=update
hibernate.show_sql=true
hibernate.format_sql=true

🚀 Exécution du projet
🧩 Étapes

Créer la base de données :

CREATE DATABASE etat_civil;


Vérifier le fichier application.properties (adapter ton username et password).

Compiler le projet :

mvn clean compile


Lancer la classe principale :

mvn exec:java -Dexec.mainClass="ma.projet.test.EtatCivil"

🧪 Exemple d’affichage attendu
<img width="1659" height="846" alt="image" src="https://github.com/user-attachments/assets/75bc8b28-2740-46c7-8908-47b89964ca2a" />






🤝 Contribution
Les contributions sont les bienvenues ! N'hésitez pas à :

Fork le projet

Créer une branche feature (git checkout -b feature/AmazingFeature)

Commit vos changements (git commit -m 'Add some AmazingFeature')

Push vers la branche (git push origin feature/AmazingFeature)

Ouvrir une Pull Request

📄 Licence
Ce projet est sous licence MIT. Voir le fichier LICENSE pour plus de détails.

👥 Auteurs
Ghali ELASRI- ghaliel

📞 Support
Pour toute question ou problème, veuillez ouvrir une issue sur GitHub.

