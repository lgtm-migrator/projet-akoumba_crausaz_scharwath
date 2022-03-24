# Projet DIL

> Akoumba Ludivine, Crausaz Nicolas, Scharwath Maxime

# Introduction

Nous effectuons ce travail dans le cadre du second laboratoire de DIL. Durant celui-ci, nous serons amené à trvailler en collaboration. Afin que cette collaboration se déroule de façon optimale, nous nous sommes accordés pour établir et respecter le code de conduite ci-après. Ce document sera structuré comme suit: Une présentation du projet, de l'équipe ainsi qu'une liste de règles à respecter au sein du groupe.


## Présentation du projet

Le laboratoire No 2 de DIL intitulé `Méthodologie` est un laboratoire ayant pour objectif de nous faire pratiquer un workflow git. Durant celui ci nous serons allons mettre en place un projet: Choix de la méthodologie à suivre, division du problème en différentes tâches(issues) auxquelles les membres du groupe seront assignés, création des branches pour chaque tâche, une fois la tâche éffectuée, verification et validation par le groupe. 

_A completer plus tard avec le informations du projet_


## Présentation des membres

_Akoumba Ludivine_: 26 ans, étudiante en ingénierie des données  

_Crausaz Nicolas_:  22 ans, étudiant en informatique logicielle  

_Scharwath Maxime_: 24 ans, étudiant en informatique logicielle

# Sprint 1

Début du premier sprint ! Temps de travail : 3 semaines.
## Étapes du sprint 1
- Planification
  - [ ] Diagramme de PERT
  - [ ] Diagramme UML Use Case
- Choix des formats
  - [ ] Choix du format des données structurées du site
  - [ ] Choix du format de saisie des données
- Affichage de la version
  - [ ] créer commande `--version` pour afficher la version du générateur de site
- Initialiser un site statique
  - [ ] commande `init /mon/site`
  - [ ] créer un fichier de configuration config.yaml
  - [ ] initialiser l'architecture des dossiers et fichiers (une sorte de site template)
- Compiler un site statique
  - [ ] commande ` build /mon/site`
  - [ ] parser les fichiers markdown et headers yaml
  - [ ] fusionner le résultat du parser en une page html
  - [ ] creation d'un dossier `build` contenant les fichiers/dossiers générés
- Nettoyer un site statique :
  - [ ] commande clean `clean /mon/site`
  - [ ] supprimer les fichiers générés (/mon/site/build)
- Intégration continue :
  - [ ] Mettre en place une validation des tests sur push
  - [ ] Ne pas autoriser de merge si les tests ne passent pas

## Temps estimé des étapes du sprint 1
| Étape     | Optimiste | Pessimiste | Attendu  | Réel     |
|-----------|-----------|------------|----------|----------|
| Diagramme de PERT | x heures  | x heures   | x heures | x heures |
| Diagramme UML Use Case | x heures  | x heures   | x heures | x heures |
| Choix du format des données structurées du site | x heures  | x heures   | x heures | x heures |
| Choix du format de saisie des données | x heures  | x heures   | x heures | x heures |
| créer commande `--version` pour afficher la version du générateur de site | x heures  | x heures   | x heures | x heures |
| créer un fichier de configuration config.yaml | x heures  | x heures   | x heures | x heures |
| initialiser l'architecture des dossiers et fichiers | x heures  | x heures   | x heures | x heures |
| créer un index.md à la racine du site | x heures  | x heures   | x heures | x heures |
| Parser les fichiers markdown et headers yaml | x heures  | x heures   | x heures | x heures |
| fusionner le résultat du parser en une page html | x heures  | x heures   | x heures | x heures |
| creation d'un dossier `build` contenant les fichiers/dossiers générés | x heures  | x heures   | x heures | x heures |
| supprimer les fichiers générés (/mon/site/build) | x heures  | x heures   | x heures | x heures |
| Mettre en place une validation des tests sur push | x heures  | x heures   | x heures | x heures |
| Ne pas autoriser de merge si les tests ne passent pas | x heures  | x heures   | x heures | x heures |



## Choix des formats
Nous avons choisi le format `YAML` pour la saisie des données structurées du site. Notre choix a été motivé par la simplicité de la syntaxe de ce formatage.

Nous avons choisi le format Markdown pour la saisie du contenu car en plus d'une syntaxe simple, il existe une panoplie de ressources  permettant de compiler du Markdown en HTML

