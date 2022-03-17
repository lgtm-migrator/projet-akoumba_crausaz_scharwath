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
- Affichage de la version
  - [ ] créer commande `--version` pour afficher la version du générateur de site
- Initialiser un site statique
  - [ ] commande `init /mon/site`
  - [ ] créer un fichier de configuration config.yaml
  - [ ] initialiser l'architecture des dossiers
  - [ ] créer un index.md à la racine du site
  - [ ] créer un exemple de dossier avec une image (une sorte de site template)
- Compiler un site statique
  - [ ] commande ` build /mon/site`
  - [ ] compiler les fichiers markdown en body html
  - [ ] compiler les headers yaml en html
  - [ ] fusionner les body et headers html en une page html
  - [ ] creation d'un dossier `build` contenant les fichiers/dossiers générés
- Nettoyer un site statique :
  - [ ] commande clean `clean /mon/site`
  - [ ] supprimer les fichiers générés (/mon/site/build)
- Intégration continue :
  - [ ] Mettre en place une validation des tests sur push
  - [ ] Ne pas autoriser de merge si les tests ne passent pas
  - [ ] Ne pas autoriser de merge si le code n'est pas correctement indenté / formatté (https://github.com/diffplug/spotless)

## Temps estimé des étapes du sprint 1
| Étape     | Optimiste | Pessimiste | Attendu  | Réel     |
|-----------|-----------|------------|----------|----------|
| Nom étape | x heures  | x heures   | x heures | x heures |