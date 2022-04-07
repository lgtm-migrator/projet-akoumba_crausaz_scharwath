# Projet DIL

> Akoumba Ludivine, Crausaz Nicolas, Scharwath Maxime

# Introduction

Dans le cadre du cours DIL de la HEIG-VD, nous allons concevoir un projet consistant en la réalisation d'un générateur de site statique [*Jamstack*](https://jamstack.org/) en *Java*.

Le projet s'étend sur un semestre (~16 semaines) et sera divisé en *trois sprints*. En plus de mettre en oeuvre nos compétences techniques, la réalisation de ce projet nous permettra d'appliquer les différents aspects des méthodologies *Agiles*.


## Présentation des membres

_Akoumba Ludivine_: 26 ans, étudiante en ingénierie des données.\
Pas de connaissances particulières en technologie web, bonnes connaissances du langage java et de l'outil gitHub. Je suis très enthousiaste à l'idée d'appliquer les pratiques agiles dans le cadre d'un projet réel. 

_Crausaz Nicolas_:  22 ans, étudiant en informatique logicielle.\
A l'aise avec les technologies web. N'a jamais travaillé avec des méthodologies agiles strictement appliquées et des outils d'intégration continue.


_Scharwath Maxime_: 25 ans, étudiant en informatique logicielle.\
Passionné par les technologies web et Java, il a joué à MineCraft Java édition une fois. Il n'a pas vraiment utilisé les methodologies agiles dans son travail, car il a surtout fait des projets en solo.
Il aime bien les outils d'intégration continue pour simplifier son travail.

### Rôle de chaque membre

En début de chaque sprint, une réunion se fera pour délimiter les attentes et les tâches selon le cahier des charges du client.
Après cela, une estimation de temps sera faite, les issues seront créées sur github puis le travail reparti entre tous les membres du groupe.
Chaque membre du groupe participera à toutes les étapes de réflexion, planification et développement.

# Sprint 1

Début du premier sprint ! Temps de travail : 3 semaines.
## Étapes du sprint 1
- Planification
  - [x] Diagramme de PERT
  - [x] Diagramme UML Use Case
- Choix des formats
  - [x] Choix du format des données structurées du site
  - [x] Choix du format de saisie des données
- Affichage de la version
  - [x] créer commande `--version` pour afficher la version du générateur de site
- Initialiser un site statique
  - [x] commande `init /mon/site`
  - [x] créer un fichier de configuration config.yaml
  - [x] initialiser l'architecture des dossiers et fichiers (une sorte de site template)
- Compiler un site statique
  - [x] commande ` build /mon/site`
  - [x] parser les fichiers markdown et headers yaml
  - [x] fusionner le résultat du parser en une page html
  - [x] creation d'un dossier `build` contenant les fichiers/dossiers générés
- Nettoyer un site statique :
  - [x] commande clean `clean /mon/site`
  - [x] supprimer les fichiers générés (/mon/site/build)
- Intégration continue :
  - [x] Mettre en place une validation des tests sur push
  - [x] Ne pas autoriser de merge si les tests ne passent pas

## Temps estimé des étapes du sprint 1
| No | Étape     | Optimiste | Pessimiste | Attendu  | Réel     | Dépend de | Issue liée |
|----|-----------|-----------|------------|----------|----------|-----------|------------|
|   1| Diagramme de PERT | 1h  | 2h   | 1h | 1h | - | #25 |
|   2| Diagramme UML Use Case | 1h  | 3h  | 2h | 2h | - | #26 |
|   3| Choix des différentes formats utilisés | 1h  | 2h   | 1h | 1h | - | - |
|   4| créer commande `--version` pour afficher la version du générateur de site | 1h  | 2h  | 1h | 1h | 1, 2 | #22 |
|   5| commande `init`: créer une structure basique | 3h  | 5h  | 4h | 4h | 1, 2 | #20 |
|   6| Parser les fichiers markdown | 2h  | 4h   | 2h | 2h | 5 | #27 |
|   7| Fusionner le résultat du parser en une page html | 2h  | 5h   | 3h | 2h | 6 | #28 |
|   8| Supprimer les fichiers générés (/mon/site/build) | 1h | 2h | 1h | 1h | 7 | #23 |
|   9| Mettre en place une validation des tests sur push + configration github | 2h | 4h | 3h | 2h | 1, 2 | #24 |

### PERT

Voici la réprésentation sous forme de diagramme PERT des étapes sur sprint 1.

<img width="1280" alt="PERT" src="https://user-images.githubusercontent.com/15279957/162083907-da00d909-0a1b-40cf-84bd-06335b9054a9.png">


## Choix des formats
Nous avons choisi le format `YAML` pour la saisie des données structurées du site. Notre choix a été motivé par la simplicité de la syntaxe de ce formatage.
Nous avons effectué ce choix parmi les formats JSON, YAML et TOML. Après avoir pesé les pour et contre de ces trois formats, ainsi que l'expérience du groupe avec ces formats, nous avons choisi YAML.


Nous avons choisi le format Markdown pour la saisie du contenu car en plus d'une syntaxe simple, il existe une panoplie de ressources permettant de compiler du Markdown en HTML

## Use Case

Voici le UML use case diagram des fonctionnalités attendues à l'issue du sprint 1:

<img width="729" alt="UML" src="https://user-images.githubusercontent.com/71764114/162074231-7896e53b-8225-4b90-8bc2-e84733e07b9d.png">


## Ressenti du groupe sur le sprint 1

Nous sommes arrivés à la fin de ce premier sprint. Pour cette première phase, nous avons pu atteindre la plupart des objectifs que nous nous sommes fixés. Nous avons passé beaucoup de temps sur la planification du travail, la rédaction des diagrammes et la séparation des tâches. De ce fait, nous avons été pressé par le temps et n'avons pas pu effectuer tout le travail souhaité. 

Les fonctionnalités demandées ont été implémentées, mais nous aurions souhaité effectuer un refactor avant de clore ce premier sprint. Nous le ferons donc en début du second. Nous n'avons pas atteint notre productivité habituelle car pour le moment nous prenons encore en main certains des outils et nous nous efforçons de respecter les directives que nous avons imposées. Néanmoins tous les membres se sont impliqués et ont fourni des efforts techniques dans ce premier sprint. La communication au sein du groupe s'est très bien déroulée et nous sommes satisfaits de notre rendu pour cette première étape.

# Sprint 2

Début du second sprint ! Temps de travail : 3 semaines.

## Étapes du sprint 2

- Refactoring du sprint 1
- Planification
  - [ ] Diagramme de PERT
  - [ ] Enrichir le use case diagram
- Modélisation UML
  - [ ] Diagramme de classe
  - [ ] Diagramme de sequence 
- Handlebar
  - [ ] Intégration de Handlebar
- Création de layouts
  - [ ] headerer
  - [ ] footer
  - [ ] navbar/menu
 
- Build du site 
  - [ ] Injecter les variables
  - [ ] Serveur HTTP: servir les fichiers build
- Delivration continue
  - [ ] automatiser la création de release
- Tests :
  - [ ] Tests d'intégration
  - [ ] Tests système


### PERT

Voici la réprésentation sous forme de diagramme PERT des étapes sur sprint 2

## Diagramme de cas d'utilisation

Voici le UML use case diagram des fonctionnalités attendues à l'issue du sprint 

## diagramme de classe

## Diagramme de sequence

## Ressenti du groupe sur le sprint 2
