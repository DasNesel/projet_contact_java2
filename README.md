# projet_contact_java2

## Indications diverses

Le projet a été réalisé avec l'IDE IntellJ de jetBrain. Nous avons aussi importé le projet sur Eclipse pour s'assurer qu'il fonctionne bien sur les différents IDE. 

Le projet est réalisé avec Maven comme demander dans l'énoncé.

Les tests unitaires sont fait à l'aide de JUnit.

L'interface graphique est réalisée avec JavaFX.

## Base de données

Voici un schéma sur la base de données : 
![](img\contact_photo.png)

### DAO

Pour l'interface entre le programme et la base de données, nous avons utilisé SQLite comme demandé dans l'énoncé. Nous avons aussi pu réaliser différents tests unitaires pour chaque fonctions de la DAO. Ils sont tous validés comme on peut le voir sur la photo ci-dessous. 

![image-20210307185433607](.\img\image-20210307185433607.png)



## Intégration 

Nous avons eu un problème lors de l'intégration de la partie graphique avec le reste du code. Nous avons une erreur qui est la suivante :

![Capture d’écran 2021-03-14 204439](img\é.png)

Malgré nos recherches sur différents forum, aucune solution ne fonctionne. voici les liens que nous avons utilisés :

- https://openjfx.io/openjfx-docs/#maven
- https://stackoverflow.com/questions/61752020/failed-to-execute-goal-org-openjfxjavafx-maven-plugin0-0-1run-default-cli-a
- https://github.com/openjfx/samples/issues/28

 ## Problèmes rencontrés 
 
 La liste des contacts, bien que mise en place, rencontre quelques problèmes d'affichage.
 
 On ne peut pas récupérer ou générer les différentes données des contacts (sous format VCard), cependant, les fonctions qui les traitent sont au point et opérationnelles.
 
