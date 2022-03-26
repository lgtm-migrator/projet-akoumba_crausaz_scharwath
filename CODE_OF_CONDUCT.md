# Code de conduite
*Mis à jour le : 2022-03-26*


Le code de conduite défini l'ensemble des règles que nous devrons respecter durant la réalisation de notre projet. Il concerne aussi bien la méthodologie de développement que nous allons choisir, que les règles de communication au sein du groupe.

## Méthodologies

Nous nous basons sur une méthodologie agile. En effet, nous souhaitons pouvoir avancer sur le travail de manière incrémentale afin de pouvoir intégrer pas à pas des fonctionnalités. Pour mettre en place cette méthodologie, nous utiliserons *GitHub* comme outil principal. En effet nous avons mis en place un certain nombre de procédure et d'automatisations qui nous permetteront de travailler selon les méthodes Agile (voir _échanges métier_).

## Communication

### Réunions de groupes

Les réunions en présentiel se feront lors des séances de laboratoires à l'école. Durant ces séeances, nous ferons le point sur le travail accompli et le travail restant. Nous répondrons aux éventuelles incertitudes des membres du groupes et travaillerons sur des tâches qui demanderaient de la coopération (planification, ...).

### Echanges métiers

Les échanges / informations liés aux processus de développement et d'aspect technique se feront au travers des outils *GitHub* mis en place :

- Issues tracker
- Kanban
- Commentaires sur pull requests

### Autres échanges

Les autres échanges / questionnements se feront au travers d'un groupe d'équipe sur la plateforme *Discord*.

## Langue

La communication au sein au groupe et le rapport se font en *Français*.

Les noms de branches, les commits, les commentaires et le code se font en *Anglais*.

## Git

### Branches

Chaque sprint aura sa propre branche. Les fonctionnalités seront mises en place dans des branches spécifiques, puis merge dans la branche du sprint concerné.

À l'issue de chaque sprint, la branche sera merge dans la branche principale (`main`). La branche `main` ainsi que les branches `sprint` sont protégées. Tout ajout de code à ces branches doivent se faire au travers de Pull Requests, ces dernières doivent respecter certaines contraintes:

- Tous les tests unitaires doivent passer
- Au moins 1 reviewer doit accepter le code

Le nom des branches doit être explicites et un préfixe indique quel travail est effectué :

- `fix_name`: branche de correction de bug
- `fb_name`: branche d'ajout de fonctionnalité
- `rf_name`: branche de refactoring

Lors du travail sur une issue, créer une pull request en mode *draft* et lier l'issue concernée. Cela permet de voir l'historique des modifications et d'automatiser le kanban du projet.

Une fois que l'issue est corrigée, repasser la PR est mode review et ajouter des reviewer.

![image](https://user-images.githubusercontent.com/15279957/160237721-2a60c637-f8b8-438b-a173-e8af1f41917e.png)


### Format de message

Les messages de commit doivent expliquer les modifications effectuées.

## Code style

Un espace après les instructions, accolades sur la même ligne et espaces entre les elements syntaxiques. Exemple :

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

