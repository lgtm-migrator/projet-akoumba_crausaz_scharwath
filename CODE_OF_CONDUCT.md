# Code de conduite
*Mis à jour le : 2022-04-06*


Le code de conduite définit l'ensemble des règles que nous devrons respecter durant la réalisation de notre projet. Il concerne aussi bien la méthodologie de développement que nous allons choisir, que les règles de communication au sein du groupe.

## Méthodologies

Nous nous basons sur une méthodologie agile. En effet, nous souhaitons pouvoir avancer sur le travail de manière incrémentale afin de pouvoir intégrer pas à pas des fonctionnalités. Pour mettre en place cette méthodologie, nous utiliserons *GitHub* comme outil principal. En effet nous avons mis en place un certain nombre de procédures et d'automatisations qui nous permettront de travailler selon les méthodes Agiles (voir _échanges métier_).

## Communication

### Réunions de groupes

Les réunions en présentiel se feront lors des séances de laboratoires à l'école. Durant ces séances, nous ferons le point sur le travail accompli et le travail restant. Nous répondrons aux éventuelles incertitudes des membres du groupe et travaillerons sur des tâches qui demanderaient de la coopération (planification, ...).

### Echanges métiers

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

Une fois que l'issue est corrigée, repasser la PR est mode review et ajouter des reviewers.

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

Ces règles ont été appliquée grâce à la dépendance spotless, qui lint le code automatiquement lorsque nous effectuons un push sur n'importe quelle branche.
Nous avons appliqué une GitHub Action qui permet d'exécuter ce lint si nécessaire après un push (un nouveau commit est ainsi ajouté avec le code reformaté).

