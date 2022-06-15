# Projet DIL

> Akoumba Ludivine, Crausaz Nicolas, Scharwath Maxime

# Introduction

Dans le cadre du cours DIL de la HEIG-VD, nous allons concevoir un projet consistant en la réalisation d'un générateur de site statique [*Jamstack*](https://jamstack.org/) en *Java*.

Le projet s'étend sur un semestre (~16 semaines) et sera divisé en *trois sprints*. En plus de mettre en oeuvre nos compétences techniques, la réalisation de ce projet nous permettra d'appliquer les différents aspects des méthodologies *Agiles*.

# Comment utiliser le projet ?

Le projet s'utilise en suivant les étapes suivantes :

### 1. Téléchargement

Il faut tout d'abord télécharger la [dernière release](https://github.com/dil-classroom/projet-akoumba_crausaz_scharwath/releases) du programme.

Décompressez le fichier `statique.zip` à un endroit souhaité puis ajoutez le programme à votre variable d'environnement `path`.

- Sur Linux / MacOS: `export PATH=$PATH:`pwd`/statique/bin`
- Sur Windows: https://www.pcastuces.com/pratique/astuces/5334.htm

Vous pouvez désormais lancer le programme grâce à la commande `statique`.

Vous trouverez au même endroit la JavaDoc de notre application, documentant tout le code plus en détail.

### 2. Initialisation du projet
Tout d'abord, nous allons initialiser le projet en créant un projet sous le nom de `mon/site`.
Nous allons utiliser la commande `statique init mon/site` pour cela. 
Cette commande va créer un dossier `mon/site` dans le dossier courant et va créer un exemple de site.

Voici la structure d'exemple générée par défault :

```text
├── config.yml              # Fichier de configuration globale
├── index.md                # Page principale du site
├── layouts                 # Dossier contenant les templates partiels
│   ├── footer.html   # Template pour le pied de page
│   ├── layout.html   # Template pour le layout par défaut
│   └── navbar.html   # Template pour la barre de navigation
├── page                    # Dossier pour une page secondaire
│   └── page.md       # Contenu de la page secondaire
└── photo.jpg               # Un asset d'exemple
```

### 3. Ajouter du contenu et configurer le site
Maintenant que le projet est initialisé, nous allons ajouter du contenu et configurer le site.
À la racine du projet se trouve un fichier `config.yml` qui contient la configuration du site.

```yml
title: "my nice website"    # Le titre du site
url: "localhost:8080"       # URL du site
language: "en"              # Langage du site, format ISO 639-1
publishDir: "/"             # Chemin de déploiement sur le serveur distant
publishServer: ""           # URL du serveur distant
publishUsername: ""         # Username pour la connexion au serveur distant
publishPassword: ""         # Mot de passe pour la connexion au serveur distant
```

Vous remarquerez que le contenu des pages sont des fichiers Markdown.
Ces fichiers Markdown ont un entête en `yaml` qui contient les informations sur le contenu de la page.

```yml
title: "Title page"     # Titre de la page
author: "My author"     # Auteur de la page
date: "2022-02-02"      # Date de publication

---                     # Section markdown
# Wahoou same site !

Link to my second page: [page 2](../index.md)

## Look ! the same picture ! Nice !
![Un meme](../photo.jpg)
```

La seconde partie du fichier contient le markdown qui sera tranformé en `html`.
Lien vers la [documentation markdown](https://www.markdownguide.org/basic-syntax/)

Il est possible de personnaliser l'apparence et la structure du site en utilisant les *layouts* se trouvant dans le dossier `mon/site/layouts`.
Quelques-uns sont déjà disponibles dans le site d'exemple. Le fichier `layout.html` est le layout principal du site, il suffit de créer de nouveau fichiers
`*.html` et de les inclure dans le layout principal en utilisant la syntaxe : `{{> <nom du fichier> }}`. Il est également possible d'utiliser des variables dans les layouts,
en utilisant la syntaxe `{{ variable }}`. Les variables disponibles sont :

- `site.title`
- `site.language`
- `site.url`
- `page.title`
- `page.author`
- `page.date`

### 4. Construction du projet
Nous allons maintenant construire le projet.
Nous allons utiliser la commande `statique build mon/site` pour construire le site.
Cette commande va créer un dossier `build` dans le dossier courant et va convertir tous les fichiers Markdown en HTML.
Les différents fichiers `markdown` et layouts des pages seront compilé en `html` et copié vers ce dossier.
La structure des fichiers sera conservée.

### 5. Création du serveur

Il est possible de voir le résultat directement au travers d'un serveur web sur votre machine locale.
Pour ce faire, nous allons utiliser la commande `statique serve mon/site` pour construire le serveur.
Nous pouvons specifier le port du serveur en utilisant la commande `statique serve mon/site -p 8080`, sinon
le port sera défini par la configuration du site.

#### 6. Déploiement FTP distant (optionnel)

Si vous souhaitez déployer directement le dossier `build` vers un serveur FTP, configurez le fichier `config.yaml` selon l'exemple suivant :
```yaml
publishDir: "/"
publishServer: "url.serveur.com"
publishUsername: "username"
publishPassword: "password"
```

Une fois la commande `statique build mon/site` effectuée, vous pouvez déployer votre site grâce à la commande `statique publish mon/site`.

Un exemple de site déployé avec cette commande: [https://heig-vd.site/](https://heig-vd.site/)

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
- `ref_name`: branche de refactoring

### Issues

Chaque tâche, correctif ou proposition d'amélioration se fait au travers d'une issue GitHub. Cela permettra de centraliser
le suivi du travail à faire / en cours, ces issues sont notamment intégrées à l'automatisation d'un Kanban.

Pour faciliter la création de ces issues, nous avons mis en place deux _issues templates_ sur GitHub:

#### Demande de fonctionnalité

Il s'agit du modèle que nous utilisons pour décrire une nouvelle fonctionnalité à ajouter dans notre application. 
Ce modèle est composé de quatres parties:

- L'estimation du temps nécessaire (est remplie par le(s) développeur(s), généralement en commun lors du début de sprint).
  Cette estimation contient le nombre d'heures optimiste, pessimiste, attendue et réelle. Cette dernière est indiquée après avoir terminé la tâche.
- Description de la problématique
- Description de la solution souhaitée
- Éventuelles alternatives à considérer
- Contenu additionnel

Dans certains cas, certaines de ces sections peuvent être omises.

#### Report de bug

Il s'agit du modèle que nous utilisons pour signaler la découverte d'un problème / bug dans notre application.
Ce modèle est séparé en quatres parties:

- Description concise du problème rencontré
- Actions à réaliser pour reproduire le bug / screenshots
- Comportement attendu
- Indications supplémentaires (OS, version etc.)

## Code review

### Processus de développement

Lors du travail sur une issue, créer une pull request en mode *draft* et lier l'issue concernée. Cela permet de voir l'historique des modifications et d'automatiser le kanban du projet.

Tant que la PR ne passe pas tous les tests ou qu'elle n'est pas prête à être review par un autre membre de l'équipe, il faut la laisser en mode draft.

Une fois que l'issue est corrigée, repasser la PR est mode review et ajouter des reviewers. Si cela est possible, demander une review à un membre qui n'a pas travaillé sur cette PR.

![image](https://user-images.githubusercontent.com/15279957/160237721-2a60c637-f8b8-438b-a173-e8af1f41917e.png)

Ci-dessus, le Kanban que nous utilisons pour notre projet. Il est automatisé et lié aux issues du repository : si l'on ajoute une nouvelle issue, elle est ajoutée dans "To do". Lorsqu'elle est attribué et liée à une PR, l'issue est déplacée dans le tableau "In progress". Lorsque le travail est terminé et qu'une review est nécessaire, on passe dans "To validate". Une fois validée, elle passe dans "Done".

### Processus de code review complet

Voici le processus de code review habituel.

- L'équipe reçoit une nouvelle story du client
- L'équipe se réunit afin d'analyser la story, d'en extraire les différentes étapes et d'évaluer leur complexité et le temps nécessaire à la réalisation.
- Un membre de l'équipe crée une issue sur GitHub pour chaque étape / regroupant plusieurs petites étapes, 
  il y indique le *milestone* correspondant au sprint actuel, ainsi que les estimations horaires
- Lors qu'un membre désirer travailler sur cette issue, il s'attribue l'issue et crée une branche pour son travail.
- Dès lors qu'un premier commit a été fait, le développeur créer une *Draft Pull Request* de sa branche vers la branche du sprint courant.
- Dès qu'il a terminé son travail, il passe sa *PR* en mode "ready for review" et demande la review d'un ou plusieurs membres de l'équipe.
- Les autres membres de l'équipe s'occupent donc de faire une review des modifications apportées au code. Ils font part de leur feedback en cas de problème ou de questions.
- Si tout en ordre, ils approuvent la *PR* et elle peut ensuite être *merge".

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


### Tests

Dans notre projet, nous avons mis en place différents types de tests: unitaires, intégration et systèmes, au travers de 
la librairie JUnit.

Durant le projet, nous nous efforçons à appliquer le *Test First Programming*. Cela consiste en le fait d'écrire une série
de tests visant à englober les scénarios d'utilisation d'une nouvelle fonctionnalité.

De manière générale, les scénarios de tests sont les suivants:

- Comportement en cas de paramètres invalides
- Comportement en cas d'état incohérent (principalement au niveau du système de fichiers pour les commandes).
- Vérification de comportement correct
- Détection de potentiels cas limites.

# Projet

Dans ce chapitre, nous expliquerons plus en détails le déroulement du projet. Nous discuterons notamment de nos choix d'implémentation, de modélisation et de code reuse au travers des différents sprints.

## Choix d'implémentation

### Choix des formats
Nous avons choisi le format `YAML` pour la saisie des données structurées du site. Notre choix a été motivé par la simplicité de la syntaxe de ce formatage.
Nous avons effectué ce choix parmi les formats JSON, YAML et TOML. Après avoir pesé les pour et contre de ces trois formats, ainsi que l'expérience du groupe avec ces formats, nous avons choisi YAML.

### Dépendances

| Nom                  | Description                                                     | Version | Site officiel                                  |
|----------------------|-----------------------------------------------------------------|---------|------------------------------------------------|
| Maven                | Gestionnaire de projet / dépendances                            | 3.6     | https://maven.apache.org/                      |
| JUnit                | Librairie de test automatisé                                    | 4.13.2  | https://junit.org/junit5/                      |
| Picocli              | Framework de création de CLI                                    | 4.6.3   | https://picocli.info/                          |
| Spotless             | Linter / formatter                                              | 2.22.0  | https://github.com/diffplug/spotless           |
| Jackson              | Outil de sérialisation, nous utilisons les sous-librairies YAML | 2.13.2  | https://github.com/FasterXML/jackson           |
| OkHttp               | Utilisé pour la construction d'URLs                             | 4.9.3   | https://square.github.io/okhttp/               |
| Commonmark           | Outils de parsing et conversion markdown                        | 0.18.2  | https://commonmark.org/                        |
| Handlebars (Java)    | Moteur de templating                                            | 4.3.0   | https://github.com/jknack/handlebars.java      |
| JaCoCo               | Outil de code coverage                                          | 0.8.3   | https://www.jacoco.org/jacoco/trunk/index.html |
| Maven Javadoc Plugin | Génération et configuration de la JavaDoc                       | 3.4.0   | https://github.com/jknack/handlebars.java      |


Les dépendances suivantes nous ont été imposées : Maven, JUnit, Picocli, JaCoCo, JavaDoc.

Les autres dépendances ont été choisies après diverses recherches et comparatifs :

**Spotless**

Nous avons été conseillés de mettre en place un linter et avons décidé de l'appliquer au niveau d'une CI. La popularité
de cet outil et ses nombreuses configurations préconçues ont motivé notre choix.

**Jackson**

Nous cherchions une librairie pour lire et écrire nos instances d'objets de configuration vers du YAML. Jackson semblait
très facile d'utilisation et nous a facilité cette sérialisation.

**OkHttp**

Cette librairie nous a permis de pouvoir effectuer facilement des vérifications sur des formats d'URL et nous a servi lors
de la rédaction de test d'intégrations (par exemple pour tester la commande serve).
La documentation concise et la facilité d'utilisation de cette librairie nous ont convaincus.

**Commonmark**

Cette librairie nous a permis de transformer du markdown en HTML très facilement, ce qui a motivé notre choix.

**Handlebars**

Handlebar est un moteur de templating très connu. Certains membres du groupes le connaissaient déjà et notre choix s'est donc
logiquement porté sur cet outil.

## Modélisation 

### Diagramme de cas d'utilisation

Ci-dessous le diagramme des cas d'utilisation final du site statique

![usecasediagram_v3](https://user-images.githubusercontent.com/71764114/172828900-6ff071bd-eba3-4d80-a5bb-e5216451fd91.png)

### Diagramme de classe 

Voici le diagramme des classes final du site statique

![classeDiagram](https://user-images.githubusercontent.com/15279957/173867005-ddd9ff26-8795-4f74-963f-92b14ce47eeb.png)


### Diagramme de sequence

![sequenceDiagram](https://user-images.githubusercontent.com/71764114/173450146-27317e7f-d758-4b3b-911a-a23312fb14d2.png)

### Diagrammes d'activité

Voici les diagrammes d'activité des commandes du site

#### Diagramme d'activité de la commande Init

![init](https://user-images.githubusercontent.com/71764114/173451896-122089c4-6ae4-4735-ac02-bdb6075cedf9.png)

#### Diagramme d'activité de la commande Build

![build](https://user-images.githubusercontent.com/71764114/173451913-ef495c4c-dea0-4b1c-9cd8-433ed18e6459.png)


#### Diagramme d'activité de la commande Serve

![serve](https://user-images.githubusercontent.com/71764114/173450089-02d10ae3-9bba-4f75-8a2c-c60663e54cb6.png)

#### Diagramme d'activité de la commande Clean

![clean](https://user-images.githubusercontent.com/71764114/173450045-b9634f3a-4453-4f59-92e1-098f80e3a584.png)



## Sprint 1

Temps de travail : 3 semaines.

### Étapes du sprint 1

En nous basant sur les stories fourni par les clients (voir document du sprint 1), nous avons issu les tâches suivantes :

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
| No       | Étape                                                                     | Optimiste | Pessimiste | Attendu | Réel | Dépend de | Issue liée | Complexité                                                                                                       |
|----------|---------------------------------------------------------------------------|-----------|------------|---------|------|-----------|------------|------------------------------------------------------------------------------------------------------------------|
| 1        | Diagramme de PERT                                                         | 1h        | 2h         | 1h      | 1h   | -         | #25        | Tâche relativement facile, mais importante                                                                       |
| 2        | Diagramme UML Use Case                                                    | 1h        | 3h         | 2h      | 2h   | -         | #26        | Tâche relativement facile, mais importante                                                                       |
| 3        | Choix des différentes formats utilisés                                    | 1h        | 2h         | 1h      | 1h   | -         | -          | Tâche facile mais critique pour le projet                                                                        |
| 4        | créer commande `--version` pour afficher la version du générateur de site | 1h        | 2h         | 1h      | 1h   | 1, 2      | #22        | Tâche de complexité moyenne, peu d'impact sur le fonctionnement du logiciel mais demande demande de la recherche |
| 5        | commande `init`: créer une structure basique                              | 3h        | 5h         | 4h      | 4h   | 1, 2      | #20        | Tâche de complexité moyenne, très importante pour le projet                                                      |
| 6        | Parser les fichiers markdown                                              | 2h        | 4h         | 2h      | 2h   | 5         | #27        | Tâche relativement complexe, choix de librairies et importante pour le projet                                    |
| 7        | Fusionner le résultat du parser en une page html                          | 2h        | 5h         | 3h      | 2h   | 6         | #28        | Tâche relativement complexe, choix de librairies et importante pour le projet                                    |
| 8        | Supprimer les fichiers générés (/mon/site/build)                          | 1h        | 2h         | 1h      | 1h   | 7         | #23        | Tâche facile                                                                                                     |
| 9        | Mettre en place une validation des tests sur push + configuration github  | 2h        | 4h         | 3h      | 2h   | 1, 2      | #24        | Tâche de complexité moyenne, impact sur le long terme                                                            |
| *Totaux* |                                                                           | 14h       | 29h        | 18h     | 16h  |           |            |                                                                                                                  |


#### PERT

Voici la réprésentation sous forme de diagramme PERT des étapes sur sprint 1.

<img width="1280" alt="PERT" src="https://user-images.githubusercontent.com/15279957/162083907-da00d909-0a1b-40cf-84bd-06335b9054a9.png">


Nous avons choisi le format Markdown pour la saisie du contenu, car en plus d'une syntaxe simple, il existe une panoplie de ressources permettant de compiler du Markdown en HTML

### Use Case

Voici le UML use case diagram des fonctionnalités attendues à l'issue du sprint 1:

![usecasediagram_v1](https://user-images.githubusercontent.com/71764114/165733043-4d227858-a32c-4a2b-87e0-479c73d60e0a.png)

### Ressenti du groupe sur le sprint 1

Nous sommes arrivés à la fin de ce premier sprint. Pour cette première phase, nous avons pu atteindre la plupart des objectifs que nous nous sommes fixés. Nous avons passé beaucoup de temps sur la planification du travail, la rédaction des diagrammes et la séparation des tâches. De ce fait, nous avons été pressé par le temps et n'avons pas pu effectuer tout le travail souhaité.

Les fonctionnalités demandées ont été implémentées, mais nous aurions souhaité effectuer un refactor avant de clore ce premier sprint. Nous le ferons donc en début du second. Nous n'avons pas atteint notre productivité habituelle, car pour le moment nous prenons encore en main certains des outils et nous nous efforçons de respecter les directives que nous avons imposées. Néanmoins, tous les membres se sont impliqués et ont fourni des efforts techniques dans ce premier sprint. La communication au sein du groupe s'est très bien déroulée et nous sommes satisfaits de notre rendu pour cette première étape.

## Sprint 2

Début du second sprint ! Temps de travail : 3 semaines.

### Étapes du sprint 2

En nous basant sur les stories fourni par les clients (voir document du sprint 2), nous avons issu les tâches suivantes :

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
  - [x] Tests système


### Temps estimé des étapes du sprint 2
| No       | Étape                       | Optimiste | Pessimiste | Attendu | Réel | Dépend de | Issue liée | Complexité                                             |
|----------|-----------------------------|-----------|------------|---------|------|-----------|------------|--------------------------------------------------------|
| 1        | Refactor du sprint          | 2h        | 5h         | 3h      | 3h   | -         | #45        | Complexité moyenne, mais critique pour le projet       |
| 2        | Diagramme UML               | 1h        | 3h         | 2h      | 1h   | 1         | #46        | Relativement facile                                    |
| 3        | Diagramme de séquence       | 1h        | 3h         | 2h      | -    | -         | #47        | Relativement facile                                    |
| 4        | Tests d'intégration         | 2h        | 4h         | 3h      | 3h   | 1,2       | #49        | Complexité moyenne, critique sur le moyen / long terme |
| 5        | Tests système               | 1h        | 3h         | 2h      | 1h   | 1,2       | #50        | Complexité moyenne, critique sur le moyen / long terme |
| 6        | Intégration moteur template | 2h        | 3h         | 2h      | 2h   | 1,2       | #52        | Tâche complexe et critique pour le projet              |
| 7        | Use case UML                | 1h        | 2h         | 1h      | 1h   | -         | #53        | Relativement facile                                    |
| 8        | Création layouts            | 1h        | 2h         | 1h      | 1h   | 1         | #54        | Relativement facile                                    |
| 9        | Injection build             | 3h        | 6h         | 4h      | 5h   | 8         | #55        | Tâche complexe et critique pour le projet              |
| 10       | Serveur HTTP                | 2h        | 4h         | 2h      | 2h   | 9         | #56        | Complexité moyenne, impact moyen                       |
| 11       | Release automatique         | 1h        | 3h         | 1h      | 1h   | -         | #57        | Complexité moyenne, impact moyen                       |
| 12       | Logging                     | 1h        | 3h         | 2h      | 1h   | 1         | #58        | Relativement facile, peu d'impact                      |
| *Totaux* |                             | 18h       | 41h        | 25h     | 21h  |           |            |                                                        |

#### Comparaison temps estimé / temps réel

Globalement, nous avons pour la plupart des tâches respecté les temps attendus, pour certaines nous avons même réussi à atteindre des temps optimistes.

### Diagramme de cas d'utilisation

Ci-dessous le diagramme des cas d'utilisation des fonctionnalités attendues à l'issue du sprint 2

 ![usecasediagram_v2](https://user-images.githubusercontent.com/71764114/165730750-529c92c5-c7c8-4167-a76a-ac30d3cf8472.png)

### Diagramme de classe

Ci-dessous le diagramme de classes du sprint 

![diagrammeDeClasse](https://user-images.githubusercontent.com/71764114/165732377-1ed00884-ca77-4608-829d-96514a3bc4a7.png)
### Diagramme de sequence

Ci-dessous le diagramme de sequence du sprint

![sequenceDiagram](https://user-images.githubusercontent.com/71764114/169264324-7c6d9ad3-fa74-4c99-94a3-244d43bb4919.png)

### Refactoring

Dans ce sprint, nous avons principalement effectué du refactoring sur le code existant du sprint 1, en créant de nouvelles classes pour abstraire des fonctionnalités récurrentes et complexes.

### Problèmes rencontrés

Nous avons rencontré plusieurs fois des merges compliqués vers la branche du sprint, avec beaucoup de conflits. Parfois nous avons perdu des bouts de code importants lors de merge automatiques, nous n'avons pas vraiment su pourquoi.  
Nous n'avons pas réalisé le diagramme de séquence, car nous sommes encore en train de réfléchir à la structure de notre projet, de ce fait nous réaliserons cette
tâche durant le prochain sprint.

### Ressenti du groupe sur le sprint 2

Le projet commence à prendre de l'ampleur et toutes les fonctionnalités créés lors du sprint 1 et celles du sprint2 commencent à cohabiter.  
L’équipe a dû répondre à de nouvelles questions et trouver des solutions pour pouvoir imbriquer toutes les fonctionnalités développées en parallèle.
Le projet devient de plus en plus complexe, mais comparé au premier sprint cela devient de plus en plus facile d’avancer car la base du projet est déjà présente et nous n’avons pas besoin de trop attendre sur un prérequis important.  
Nous nous réjouissons déjà d’une phase de refactoring avec une vision globale du projet pour pouvoir apporter une meilleure cohérence et communication entre fonctionnalités développées pendant ces derniers sprints. 

## Sprint 3

Temps de travail: 3 semaines

### Étapes du sprint 3

En nous basant sur les stories fourni par les clients (voir document du sprint 3), nous avons issu les tâches suivantes :

- Modélisation UML
  - [x] Modélisation du FileWatcher
  - [x] Diagramme de sequence
  - [x] Enrichir le use case diagram
- Javadoc, Manuel utilisateur
  - [x] Build la JavaDoc
  - [x] Rédaction d'un manuel utilisateur
- Génération du site statique à la volée
  - [x] Implémenter une abstraction
  - [x] Implémenter la commande `--watch`
- Code coverage, Code benchmarking , Code quality
  - [x] Code coverage avec  `Jacoco`
  - [x] Mesure de performance avec `JMH`  et `VisualVM` pour la visualisation
  - [x] Qualité de code avec ` LGTM` et `SonarQube` 
- Publication du site dans un répertoire distant
  - [x] Modifier la configuration
  - [x] Implémenter la commande `publish` pour publier le build sur un server distant
- Délivration continue
  - [x] Ajouter la JavaDoc à la release
- Optionnel
  - [x] Template CSS

### Modélisation de l'abstraction du FileWatcher

![FilesWatcher](https://user-images.githubusercontent.com/15279957/169917117-16d5df5c-2304-4b9c-a37e-cd6c0ff3c6e4.png)

### Resultats du Code coverage

Pour analyser la couverture du code, en d'autres termes le nombre de lignes de notre code qui sont exécutées lors des tests, nous avons utilisé la technologie JaCoCo, ci-dessous les résultats que vous avons obtenus:

Vue globale:
![jacoco_main](https://user-images.githubusercontent.com/15279957/169917927-06c5fedf-9ef5-414a-a686-6c70a7920ab1.png)

Vue détailée par package:
![jacoco_commands](https://user-images.githubusercontent.com/15279957/169917951-6aa220a9-18a4-446d-95e7-e5386298deb8.png)
![jacoco_core](https://user-images.githubusercontent.com/15279957/169917953-f93b8e8b-27ae-43a9-bf2b-2494c19c43af.png)
![jacoco_filemanager](https://user-images.githubusercontent.com/15279957/169917955-5177afb9-7502-408b-a0e3-26dedd59278f.png)
![jacoco_project](https://user-images.githubusercontent.com/15279957/169917957-b201a6b1-59a9-4b13-983e-6d5b44c5c10c.png)

Nous constatons que nous devrions améliorer nos tests concernant le FTPPublisher et la classe Configuration.

### Mesure de performance

Afin de mesurer les performances de notre implémentation, nous avons utilisé 2 technologies principalement, `JMH` afin  et `VisualMH`.

Avec `JMH`, nous avons effectué un test de performance de la méthode qui injecte du contenu dans un template Handlebars, voici le résultat:

![jmh](https://user-images.githubusercontent.com/15279957/169984490-ddc3f361-666b-43b1-ace3-f48a6f714420.png)

Avec `VisualVM`, nous mesurons la performance de la commande `build` selon la métrique temps en `ms`. Ci-dessous, les résultats que nous avons obtenus:

Nous n'avons pas réussi à obtenir des résultats cohérents en utilisant VisualVM. Nous allons retenter l'expérience au prochain sprint.

### Qualité de code

L'outil LGTM a été ajouté de manière globale sur notre projet (par le client). De ce fait, nous n'avons pas vraiment effectué de comparaison
entre plusieurs outils semblables.

Cet outil effectue une analyse statique de notre code Java sur notre projet.
Nous avons pu regarder les résultats de l'analyse, LGTM donne à notre code la note de A+. Des informations sur comment cette note est calculée
sont trouvable sur le site [officiel LGTM](https://lgtm.com/help/lgtm/project-scoring-grading).

### Temps estimé des étapes du sprint 3

| No       | Étape                                             | Optimiste | Pessimiste | Attendu | Réel | Dépend de | Issue liée | Complexité                                   |
|----------|---------------------------------------------------|-----------|------------|---------|------|-----------|------------|----------------------------------------------|
| 1        | Créer diagramme de séquence                       | 1h        | 3h         | 2h      | 2h   | -         | #47        | Relativement facile                          |
| 2        | Build la JavaDoc avec une commande                | 1h        | 2h         | 1h      | 1h   | -         | #73        | Relativement facile                          |
| 3        | Ajouter la JavaDoc dans la release (CI)           | 1h        | 2h         | 1h      | 1h   | 2         | #74        | Relativement facile                          |
| 4        | Implémenter une abstraction de FileWatcher        | 3h        | 5h         | 4h      | 4h   | 11        | #75        | Tâche complexe et critique pour le projet    |
| 5        | Intégrer l'abstraction FileWatcher à notre projet | 3h        | 5h         | 4h      | 1h   | 4         | #76        | Tâche moyenne mais critique pour le projet   |
| 7        | Manuel utilisateur                                | 1h        | 2h         | 1h      | 1h   | -         | #77        | Tâche facile mais critique pour le projet    |
| 6        | Intégrer un outil de code coverage                | 1h        | 3h         | 2h      | 1h   | -         | #78        | Tâche facile, impact moyen                   |
| 8        | Mesure de performance                             | 2h        | 5h         | 3h      | -    | -         | #79        | Tâche moyenne, peu d'impact                  |
| 9        | Outils d'analyse de qualité de code               | 1h        | 3h         | 2h      | -h   | -         | #80        | Tâche moyenne, peu d'impact                  |
| 10       | Commande publish                                  | 3h        | 6h         | 5h      | 3h   | -         | #81        | Tâche complexe, importante sur le long terme |
| 11       | Modélisation du filewatcher (UML, use case)       | 3h        | 6h         | 5h      | 2h   | -         | #82        | Tâche moyenne et critique pour ce sprint     |
| 12       | Ajouter du CSS au site (optionnel)                | 1h        | 2h         | 1h      | 1h   | -         | #84        | Tâche facile                                 |
| *Totaux* |                                                   | 21h       | 44h        | 31h     | 17h  |           |            |                                              |

#### Comparaison temps estimé / temps réel

Globalement, nous avons respecté pour la plupart des tâches les temps attendus, pour certaines nous avons même réussi à atteindre des temps optimistes.

### Refactoring

Dans ce sprint, nous avons refactor le code existant afin de le rendre utilisable par plusieurs de nos composants de l'application.

### Problèmes rencontrés

Nous avons passé pas mal de temps à nous documenter sur le fonctionnement du WatchService afin de réaliser une abstraction simple
et cohérente pour notre application. Nous n'avons pas réussi à faire un profilage de la commande build avec VisualVM.

### Ressenti du groupe sur le sprint 3

Nous sommes globalement convaincus de notre travail effectué lors de sprint. Nous avons réussi à accomplir les tâches critiques
du backlog et ceci dans le temps imposé. Notre application contient des fonctionnalités très intéressantes telles que le système
de re-build à la volée et la publication vers un serveur distant en FTP.


### Etat du backlog en fin de sprint

Les tâches attribuées selon les stories client ont toutes été réalisés, nous avons cependant laissé quelques recommandations des clients (feedback)
en backlog pour le 4e et dernier sprint.

| Étape                          | Description                                                                                                                               |
|--------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------|
| Ajout de tests                 | Sur la commande build, il faut ajouter des tests d'intégration                                                                            |
| Remise à niveau des diagrammes | Il nous faut mettre à jour les diagrammes de séquences, activité et UML                                                                   |
| Complexité des tâches          | Notre rapport devra contenir une évaluation de complexité des tâches et mieux mettre en avant la séparation des étapes selon les stories. |
| Mesure de performance          | Terminer la seconde partie de l'évaluation de performance avec VisualVM                                                                   |


## Sprint final

Temps de travail: 3 semaines

### Étapes du sprint final

Les étapes de ce sprint final sont basées sur des commentaires du client ou sur les suggestions des membres de l'équipe.
Comme il s'agit dans l'ensemble de correctifs rapidement mis en place et de rédaction du rapport, nous avons décidé de ne pas faire
d'estimation de temps précise, mais nous avons énuméré les diverses tâches à réaliser:

- [x] Mettre à niveau la modélisation UML
- [x] Refactor global
- [x] Exporter les méthodes des commandes dans des classes externes
- [x] Ajout de tests pour la commande build
- [x] Commenter le code ET les tests
- [ ] Faire un diagramme d'activité pour chaque commande
- [x] Remettre à jour de diagramme de séquence
- [x] Faire l'analyse VisualVm sur la commande serve 
- [x] Ajouter les estimations de complexité et séparation des tâches pour chaque sprint, avant le tableau d'estimation horaire
- [x] On aimerait bien avoir le processus complet de review résumé à un endroit 
- [x] Parler des étapes de refactoring
- [x] Expliquer le contenu des dossiers / apres un init /build (dans manuel utilisateur)
- [x] Ajouter explication de comment utiliser les layouts
- [ ] Indiquer ou trouver la JavaDoc et ajouter une description "about" dans la JavaDoc
- [ ] Use case diagramme: Ajouter le file watcher
- [x] Ajouter les résultats LGMT et les documenter
- [ ] Commenter le code coverage
- [ ] Review Finale : on aimerait bien avoir toutes les stories (ou les tâches à choix) du backlog pour avoir une vision générale de ce qui a été fait depuis le début
- [x] Tests : serve dossier qui n'existe pas. Commande build. + de test d'intégration

### Refactoring

Ce sprint était surtout axé sur le refactoring, au niveau de la structure du code et des classes et du code global de l'application.


### Ressenti du groupe sur le sprint final

Nous voilà arrivé à la fin du projet ! Ce dernier sprint nous a permit de fignoler et d'ajouter les derniers éléments manquants à notre rapport de projet. Nous avons le sentiment d'avoir produit du travail de bonne qualité et d'avoir toujours respecté les délais.
Nous avons effectué toutes les tâches demandées et nous en sommes satisfait. Ce projet à été très enrichissant pour chacun des membres du groupe et pensons
qu'il nous a permis de pouvoir mieux travailler en groupe sur du développement logiciel, ce qui nous sera fort utile dans le futur.
