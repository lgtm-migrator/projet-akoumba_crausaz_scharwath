# Code de conduite
*Mis à jour le : 2022-03-10*


Le code de conduite défini l'ensemble des règles que nous devrons respecter durant la réalisation de notre projet. Il concerne aussi bien la méthodologie de développement que nous allons choisir, que les règles de communication au sein du groupe.

## Méthodologies

Nous nous basons sur une méthodologie agile. En effet, nous souhaitons pouvoir avancer sur le travail de manière incrémentale afin de pouvoir intégrer pas à pas des fonctionnalités.

## Communication

### Réunions de groupes

Les réunions en présentiel se feront lors des séances de laboratoires à l'école.

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

À l'issue de chaque sprint, la branche sera merge dans la branche principale (`main`).

Le nom des branches doit être explicites et un préfixe indique quel travail est effectué :

- `fix_name`: branche de correction de bug
- `fb_name`: branche d'ajout de fonctionnalité
- `rf_name`: branche de refactoring

Lors du travail sur une issue, créer une pull request en mode *draft* et lier l'issue concernée. Cela permet de voir l'historique des modifications et d'automatiser le kanban du projet.

Une fois que l'issue est corrigée, repasser la PR est mode review et ajouter des reviewer.

### Format de message

Les messages de commit doivent être explicites sur les modifications effectuées.

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
### Règles de code
- La longueur des lignes doit être limitée à 120 caractères
- Les tabulations doivent être remplacées par 4 espaces.
- Utiliser la nomination appropriée au langage utilisé.
- Les noms de variables et commentaires doivent être en anglais.

## Code review

La confirmation d'au moins 1 reviewer est nécessaire pour autoriser un merge sur la branche `main` et les branches `sprint`.
## Commentaires

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
