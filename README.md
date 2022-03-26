# Projet DIL

> Akoumba Ludivine, Crausaz Nicolas, Scharwath Maxime

# Introduction

Dans le cadre du cours DIL de la HEIG-VD, nous allons réaliser un projet consistant en la réalisation d'un générateur de site statique [*Jamstack*](https://jamstack.org/) en *Java*.

Le projet s'étend sur un semestre (~16 semaines) et sera divisé en *trois sprints*. En plus de mettre en oeuvre nos compétences techniques, la réalisatio de ce projet nous permettra d'appliquer les différents aspects des méthodologies *Agile*.


## Présentation des membres

_Akoumba Ludivine_: 26 ans, étudiante en ingénierie des données  

_Crausaz Nicolas_:  22 ans, étudiant en informatique logicielle.


_Scharwath Maxime_: 24 ans, étudiant en informatique logicielle

### Rôle de chaque membre

En début de chaque sprint, une réunion se fera pour délimiter les attentes et les tâches selon le cahier des charges du client.
Après cela, une estimation de temps sera faite, les issues seront créées sur github puis le travail reparti entre tous les membres du groupes.
Chaque membre du groupe participera à toutes les étapes de réfléxion, planification et développement.

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
| No | Étape     | Optimiste | Pessimiste | Attendu  | Réel     | Dépend de | Issue liée |
|----|-----------|-----------|------------|----------|----------|-----------|------------|
|   1| Diagramme de PERT | 1h  | 2h   | 1h | x heures | - | #25 |
|   2| Diagramme UML Use Case | 1h  | 3h  | 2h | x heures | - | #26 |
|   3| Choix des différentes formats utilisés | x heures  | x heures   | x heures | x heures | - | - |
|   4| créer commande `--version` pour afficher la version du générateur de site | 1h  | 2h   | 1h | x heures | - | #22 |
|   5| commande `init`: créer une structure basique | x heures  | x heures   | x heures | x heures | - | #20 |
|   6| Parser les fichiers markdown | 2h  | 4h   | 2h | xh | - | #27 |
|   7| Fusionner le résultat du parser en une page html | 2h  | 5h   | 3h | xh | - | #28 |
|   8| Supprimer les fichiers générés (/mon/site/build) | 1h | 2h | 1h | x heures | - | #23 |
|   9| Mettre en place une validation des tests sur push + configration github | 2h | 4h | 3h | x heures | - | #24 |


## Choix des formats
Nous avons choisi le format `YAML` pour la saisie des données structurées du site. Notre choix a été motivé par la simplicité de la syntaxe de ce formatage.
Nous avons effectuer ce choix parmi les formats JSON, YAML et TOML. Après avoir pesé les pour et contre de ces trois formats, ainsi que l'expérience du groupe avec ces formats, nous avons choisi YAML.


Nous avons choisi le format Markdown pour la saisie du contenu car en plus d'une syntaxe simple, il existe une panoplie de ressources permettant de compiler du Markdown en HTML

