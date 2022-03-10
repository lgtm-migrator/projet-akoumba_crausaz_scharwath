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

_Scharwath Maxime_: 24 ans, étudiant en Informatique logicielle  

# Code de conduite

Le code de conduite défini l'ensemble des règles que nous devrons respecter durant la réalisation de notre projet. Il concerne aussi bien la méthodologie de développement que nous allons choisir , que les règles de communication au sein du groupe.

## Méthodologies

Nous nous basons sur une méthodologie agile. En effet, nous souhaitons pouvoir avancer sur le travail de manière incrémentale afin de pouvoir intégrer pas à pas les fonctionnalités.

## Communication

### Réunions de groupes

Les réunions en présentiel se feront lors des séances de laboratoires à l'école

### Echanges métiers

Les échanges / informations liés aux processus de développement et d'aspect technique se feront au travers des outils *GitHub* mis en place:

- Issues tracker
- Kanban
- Commentaires sur pull requests

### Autres échanges

Les autres échanges / questionnements se feront au travers d'une groupe d'équipe sur la plateforme *Discord*.

## Langue

La communication au sein au groupe et le rapport se font en *Français*.

Les noms de branches, les commits, les commentaires et le code se font en *Anglais*.

## Git

### Branches

Chaque sprint aura sa propre branche. Les fonctionnalités seront mises en place dans des branches spécifiques, puis merge dans la branche du sprint concerné.

A l'issue de chaque sprint, la branche sera merge dans la branche principale (main).

Le nom des branches doivent être explicites et un préfixe indique quel travail est effectué:

- fix_name: branche de correction de bug
- fb_name: branche d'ajout de fonctionnalité
- rf_name: branche de refactoring

Lors du travail sur une issue, créer une pull request en mode *draft* et lier l'issue concernée. Cela permet de voir l'historique des modification et d'automatiser le kanban du projet.

Une fois que l'issue est corrigée, repasser la PR est mode review et ajouter des reviewer.

### Format de message

Les messages de commit doivent être explicites sur les modifications effectuées.

## Code style

Un espace après les instructions, accolades sur la même ligne et espaces entre les élèments syntaxiques. Exemple:

```Java
class Test {

   public Test() {
      if (true) {
         // ..
      }
   }
}

```

## Code review

La confirmation d'au moins 1 reviewer est nécessaire pour autoriser un merge sur la branche `main` et les branches `sprint`.

## Commentaires

Les commentaires des classes et des méthodes respectent le format *JavaDoc*.

Pour les classes:
```Java
/**
   Description de la classe

   @author Akoumba Ludivine
   @author Crausaz Nicolas
   @author Scharwath Maxime
*/
```

Pour les méthodes:
```Java
/**
   description de la méthode

   @param test description de test

   @return description du retour
*/
```
