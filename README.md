# Projet DIL

> Akoumba Ludivine, Crausaz Nicolas, Scharwath Maxime

# Introduction

Dans le cadre du cours DIL de la HEIG-VD, nous allons concevoir un projet consistant en la réalisation d'un générateur de site statique [*Jamstack*](https://jamstack.org/) en *Java*.

Le projet s'étend sur un semestre (~16 semaines) et sera divisé en *trois sprints*. En plus de mettre en oeuvre nos compétences techniques, la réalisation de ce projet nous permettra d'appliquer les différents aspects des méthodologies *Agiles*.

# Comment utiliser le projet ?
Le projet s'utilise en 4 étapes :
### 1. Initialisation du projet
Tout d'abord, nous allons initialiser le projet en créant un projet sous le nom de `mon/site`.
Nous allons utiliser la commande `statique init mon/site` pour cela. 
Cette commande va créer un dossier `mon/site` dans le dossier courant et va créer un exemple de site.
### 2. Ajouter du contenu et configurer le site
Maintenant que le projet est initialisé, nous allons ajouter du contenu et configurer le site.
A la racine du projet se trouve un fichier `config.yml` qui contient la configuration du site.
Comme l'URL, le titre et la langue du site. Vous remarquerez que le contenu du site utilise des fichiers Markdown.
Ces fichiers Markdown ont une entête en `yaml` qui contient les informations sur le contenu de la page.
Remarque : L'arborescence du site restera identique à celui du projet.

### 3. Construction du projet
Nous allons maintenant construire le projet.
Nous allons utiliser la commande `statique build mon/site` pour construire le site.
Cette commande va créer un dossier `build` dans le dossier courant et va convertir tous les fichiers Markdown en HTML.
Cela va également copier tous les autres fichiers du projet.
### 4. Création du serveur
Nous allons maintenant créer le serveur.
Nous allons utiliser la commande `statique serve mon/site` pour construire le serveur.
Nous pouvons specifier le port du serveur en utilisant la commande `statique serve mon/site -p 8080`, sinon
le port sera define par la configuration du site.

# Travail en équipe

## Présentation des membres

_Akoumba Ludivine_: 26 ans, étudiante en ingénierie des données.\
Pas de connaissances particulières en technologie web, bonnes connaissances du langage java et de l'outil gitHub. Je suis très enthousiaste à l'idée d'appliquer les pratiques agiles dans le cadre d'un projet réel. 

_Crausaz Nicolas_:  22 ans, étudiant en informatique logicielle.\
A l'aise avec les technologies web. N'a jamais travaillé avec des méthodologies agiles strictement appliquées et des outils d'intégration continue.


_Scharwath Maxime_: 25 ans, étudiant en informatique logicielle.\
Passionné par les technologies web et Java, il a joué à MineCraft Java édition une fois. Il n'a pas vraiment utilisé les methodologies agiles dans son travail, car il a surtout fait des projets en solo.
Il aime bien les outils d'intégration continue pour simplifier son travail.

## Rôle de chaque membre

En début de chaque sprint, une réunion se fera pour délimiter les attentes et les tâches selon le cahier des charges du client.
Après cela, une estimation de temps sera faite, les issues seront créées sur github puis le travail reparti entre tous les membres du groupe.
Chaque membre du groupe participera à toutes les étapes de réflexion, planification et développement.

# Méthodologies

Nous nous basons sur une méthodologie agile. En effet, nous souhaitons pouvoir avancer sur le travail de manière incrémentale afin de pouvoir intégrer pas à pas des fonctionnalités. Pour mettre en place cette méthodologie, nous utiliserons *GitHub* comme outil principal. En effet nous avons mis en place un certain nombre de procédures et d'automatisations qui nous permettront de travailler selon les méthodes Agiles (voir _échanges métier_).

## Communication

### Réunions de groupes

Les réunions en présentiel se feront lors des séances de laboratoires à l'école. Durant ces séances, nous ferons le point sur le travail accompli et le travail restant. Nous répondrons aux éventuelles incertitudes des membres du groupe et travaillerons sur des tâches qui demanderaient de la coopération (planification, ...).

### Échanges métiers

Les échanges / informations liés aux processus de développement et d'aspect technique se feront au travers des outils *GitHub* mis en place :

- Issues tracker
- Kanban
- Commentaires sur pull requests

### Autres échanges

Les autres échanges / questionnements se feront au travers d'un groupe d'équipe sur la plateforme *Discord*.

## Langue

La communication au sein au groupe et le rapport se fait en *Français*.

Les noms de branches, les commits, les commentaires et le code se font en *Anglais*.

## Git

### Branches

Chaque sprint aura sa propre branche. Les fonctionnalités seront mises en place dans des branches spécifiques, puis merge dans la branche du sprint concerné.

À l'issue de chaque sprint, la branche sera merge dans la branche principale (`main`). La branche `main` ainsi que les branches `sprint` sont protégées. Tout ajout de code à ces branches doit se faire au travers de Pull Requests, ces dernières doivent respecter certaines contraintes:

- Tous les tests unitaires doivent passer
- Au moins 1 reviewer doit accepter le code

Les noms des branches doivent être explicites et un préfixe indique quel travail est effectué :

- `fix_name`: branche de correction de bug
- `fb_name`: branche d'ajout de fonctionnalité
- `rf_name`: branche de refactoring

## Code review

### Processus de développement

Lors du travail sur une issue, créer une pull request en mode *draft* et lier l'issue concernée. Cela permet de voir l'historique des modifications et d'automatiser le kanban du projet.

Tant que la PR ne passe pas tous les tests ou qu'elle n'est pas prête à être review par un autre membres de l'équipe, il faut la laisser en mode draft.

Une fois que l'issue est corrigée, repasser la PR est mode review et ajouter des reviewers. Si cela est possible, demander une review à un membre qui n'a pas travaillé sur cette PR.

![image](https://user-images.githubusercontent.com/15279957/160237721-2a60c637-f8b8-438b-a173-e8af1f41917e.png)

Ci-dessus, le Kanban que nous utilisons pour notre projet. Il est automatisé et lié aux issues du repository: si l'on ajoute une nouvelle issue, elle est ajoutée dans "To do". Lorsqu'elle est attribué et liée à une PR, l'issue est déplacée dans le tableau "In progress". Lorsque le travail est terminé et qu'une review est nécessaire, on passe dans "To validate". Une fois validée, elle passe dans "Done".

### Format de message

Les messages de commit doivent expliquer les modifications effectuées, afin de permettre aux autres membres de pouvoir avoir une idée du travail effectué dans un commit.

## Code style

Un espace après les instructions, accolades sur la même ligne et espaces entre les éléments syntaxiques. Exemple :

```Java
class Test {
    
    public Test() {
       if (true) {
         // ..
       }
    }
}
```

### Commentaires

Les commentaires des classes et des méthodes respectent le format *JavaDoc*.

Pour les classes :
```Java
/**
   Class Description

   @author Akoumba Ludivine
   @author Crausaz Nicolas
   @author Scharwath Maxime
*/
class Test {
}
```

Pour les méthodes :
```Java
/**
   Method Description

   @param test int Test description

   @return Return description
*/
void test(int test) {
    // ..
}
```

### Règles de code
- La longueur des lignes doit être limitée à 120 caractères
- Les tabulations doivent être remplacées par 4 espaces.
- Utiliser la nomination appropriée au langage utilisé.
- Les noms de variables et commentaires doivent être en anglais.

Ces règles ont été appliquées grâce à la dépendance spotless, qui lint le code automatiquement lorsque nous effectuons un push sur n'importe quelle branche.
Nous avons appliqué une GitHub Action qui permet d'exécuter ce lint si nécessaire après un push (un nouveau commit est ainsi ajouté avec le code reformaté).

# Projet

Dans ce chapitre, nous expliquerons plus en détails le déroulement du projet. Nous discuterons notamment de nos choix d'implémentation, de modélisation et de code reuse au travers des différents sprints.

## Choix d'implémentation

### Choix des formats
Nous avons choisi le format `YAML` pour la saisie des données structurées du site. Notre choix a été motivé par la simplicité de la syntaxe de ce formatage.
Nous avons effectué ce choix parmi les formats JSON, YAML et TOML. Après avoir pesé les pour et contre de ces trois formats, ainsi que l'expérience du groupe avec ces formats, nous avons choisi YAML.

### Dépendances

| Nom               | Description                                                     | Version | Site officiel                             |
|-------------------|-----------------------------------------------------------------|---------|-------------------------------------------|
| Maven             | Gestionnaire de projet / dépendances                            | 3.6     | https://maven.apache.org/                 |
| JUnit             | Librairie de test automatisé                                    | 4.13.2  | https://junit.org/junit5/                 |
| Picocli           | Framework de création de CLI                                    | 4.6.3   | https://picocli.info/                     |
| Spotless          | Linter / formatter                                              | 2.22.0  | https://github.com/diffplug/spotless      |
| Jackson           | Outil de sérialisation, nous utilisons les sous-librairies YAML | 2.13.2  | https://github.com/FasterXML/jackson      |
| OkHttp            | Utilisé pour la construction d'URLs                             | 4.9.3   | https://square.github.io/okhttp/          |
| Commonmark        | Outils de parsing et conversion markdown                        | 0.18.2  |                                           |
| Handlebars (Java) | Moteur de templating                                            | 4.3.0   | https://github.com/jknack/handlebars.java |

## Sprint 1

Temps de travail : 3 semaines.

### Étapes du sprint 1
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

### Temps estimé des étapes du sprint 1
| No  | Étape                                                                     | Optimiste | Pessimiste | Attendu | Réel | Dépend de | Issue liée |
|-----|---------------------------------------------------------------------------|-----------|------------|---------|------|-----------|------------|
| 1   | Diagramme de PERT                                                         | 1h        | 2h         | 1h      | 1h   | -         | #25        |
| 2   | Diagramme UML Use Case                                                    | 1h        | 3h         | 2h      | 2h   | -         | #26        |
| 3   | Choix des différentes formats utilisés                                    | 1h        | 2h         | 1h      | 1h   | -         | -          |
| 4   | créer commande `--version` pour afficher la version du générateur de site | 1h        | 2h         | 1h      | 1h   | 1, 2      | #22        |
| 5   | commande `init`: créer une structure basique                              | 3h        | 5h         | 4h      | 4h   | 1, 2      | #20        |
| 6   | Parser les fichiers markdown                                              | 2h        | 4h         | 2h      | 2h   | 5         | #27        |
| 7   | Fusionner le résultat du parser en une page html                          | 2h        | 5h         | 3h      | 2h   | 6         | #28        |
| 8   | Supprimer les fichiers générés (/mon/site/build)                          | 1h        | 2h         | 1h      | 1h   | 7         | #23        |
| 9   | Mettre en place une validation des tests sur push + configration github   | 2h        | 4h         | 3h      | 2h   | 1, 2      | #24        |

#### PERT

Voici la réprésentation sous forme de diagramme PERT des étapes sur sprint 1.

<img width="1280" alt="PERT" src="https://user-images.githubusercontent.com/15279957/162083907-da00d909-0a1b-40cf-84bd-06335b9054a9.png">


Nous avons choisi le format Markdown pour la saisie du contenu car en plus d'une syntaxe simple, il existe une panoplie de ressources permettant de compiler du Markdown en HTML

### Use Case

Voici le UML use case diagram des fonctionnalités attendues à l'issue du sprint 1:

![usecasediagram_v1](https://user-images.githubusercontent.com/71764114/165733043-4d227858-a32c-4a2b-87e0-479c73d60e0a.png)

### Ressenti du groupe sur le sprint 1

Nous sommes arrivés à la fin de ce premier sprint. Pour cette première phase, nous avons pu atteindre la plupart des objectifs que nous nous sommes fixés. Nous avons passé beaucoup de temps sur la planification du travail, la rédaction des diagrammes et la séparation des tâches. De ce fait, nous avons été pressé par le temps et n'avons pas pu effectuer tout le travail souhaité.


Les fonctionnalités demandées ont été implémentées, mais nous aurions souhaité effectuer un refactor avant de clore ce premier sprint. Nous le ferons donc en début du second. Nous n'avons pas atteint notre productivité habituelle car pour le moment nous prenons encore en main certains des outils et nous nous efforçons de respecter les directives que nous avons imposées. Néanmoins tous les membres se sont impliqués et ont fourni des efforts techniques dans ce premier sprint. La communication au sein du groupe s'est très bien déroulée et nous sommes satisfaits de notre rendu pour cette première étape.

## Sprint 2

Début du second sprint ! Temps de travail : 3 semaines.

### Étapes du sprint 2

- Refactoring du sprint 1
- Planification
  - [x] Diagramme de PERT
  - [x] Enrichir le use case diagram
- Modélisation UML
  - [x] Diagramme de classe
  - [ ] Diagramme de sequence 
- Handlebar
  - [x] Intégration de Handlebar
- Création de layouts
  - [x] headerer
  - [x] footer
  - [x] navbar/menu
 
- Build du site 
  - [x] Injecter les variables
  - [x] Serveur HTTP: servir les fichiers build
- Délivration continue
  - [x] automatiser la création de release
- Tests :
  - [x] Tests d'intégration
  - [ ] Tests système


### Temps estimé des étapes du sprint 2
| No  | Étape                       | Optimiste | Pessimiste | Attendu | Réel | Dépend de | Issue liée |
|-----|-----------------------------|-----------|------------|---------|------|-----------|------------|
| 1   | Refactor du sprint          | 2h        | 5h         | 3h      | 3h   | -         | #45        |
| 2   | Diagramme UML               | 1h        | 3h         | 2h      | 1h   | 1         | #46        |
| 3   | Diagramme de séquence       | 1h        | 3h         | 2h      | -    | -         | #47        |
| 4   | Tests d'intégration         | 2h        | 4h         | 3h      | 3h   | 1,2       | #49        |
| 5   | Tests système               | 1h        | 3h         | 2h      | 1h   | 1,2       | #50        |
| 6   | Intégration moteur template | 2h        | 3h         | 2h      | 2h   | 1,2       | #52        |
| 7   | Use case UML                | 1h        | 2h         | 1h      | 1h   | -         | #53        |
| 8   | Création layouts            | 1h        | 2h         | 1h      | 1h   | 1         | #54        |
| 9   | Injection build             | 3h        | 6h         | 4h      | 5h   | 8         | #55        |
| 10  | Serveur HTTP                | 2h        | 4h         | 2h      | 2h   | 9         | #56        |
| 11  | Release automatique         | 1h        | 3h         | 1h      | 1h   | -         | #57        |
| 12  | Logging                     | 1h        | 3h         | 2h      | 1h   | 1         | #58        |

#### Comparaison temps estimé / temps réel

Globalement, nous avons pour la plupart des tâches respecté les temps attendus, pour certaines nous avons même réussi à atteindre des temps optimistes.

### Diagramme de cas d'utilisation

Ci-dessous le diagramme des cas d'utilisation des fonctionnalités attendues à l'issue du sprint 2

 ![usecasediagram_v2](https://user-images.githubusercontent.com/71764114/165730750-529c92c5-c7c8-4167-a76a-ac30d3cf8472.png)

### Diagramme de classe

Ci-dessous le diagramme de classes du sprint 

![diagrammeDeClasse](https://user-images.githubusercontent.com/71764114/165732377-1ed00884-ca77-4608-829d-96514a3bc4a7.png)


### Problèmes rencontrés

Nous avons rencontré plusieurs fois des merges compliqués vers la branche du sprint, avec beaucoup de conflits. Parfois nous avons perdu des bouts de code importants lors de merge automatiques, nous n'avons pas vraiment su pourquoi.  
Nous n'avons pas réalisé le diagramme de séquence, car nous sommes encore en train de réfléchir à la structure de notre projet, de ce fait nous réaliserons cette
tâche durant le prochain sprint.

### Ressenti du groupe sur le sprint 2

Le projet commence à prendre de l'ampleur et toutes les fonctionnalités créés lors du sprint 1 et celles du sprint2 commencent à cohabiter.  
L’équipe a dû répondre à de nouvelles questions et trouver des solutions pour pouvoir imbriquer toutes les fonctionnalités développées en parallèle.
Le projet devient de plus en plus complexe, mais comparé au premier sprint cela devient de plus en plus facile d’avancer car la base du projet est déjà présente et nous n’avons pas besoin de trop attendre sur un prérequis important.  
Nous nous réjouissons déjà d’une phase de refactoring avec une vision globale du projet pour pouvoir apporter une meilleure cohérence et communication entre fonctionnalités développées pendant ces derniers sprints. 
