# Chouaib Bouchraibia

## Vue d'ensemble
Ce projet est un générateur de code Java qui utilise le modèle de conception Visiteur pour générer du code Java à partir d'un méta-modèle. Le méta-modèle inclut différents types tels que `Primitive`, `Collective` et `Reference`.

## Structure du projet
- `src/metaModel` : Contient les classes du méta-modèle.
  - `Model.java` : Représente le modèle contenant des entités.
  - `Entity.java` : Représente une entité dans le modèle.
  - `Visitor.java` : Classe abstraite pour le modèle de conception Visiteur.
  - `Type.java` : Classe de base pour différents types.
  - `Primitive.java` : Représente les types primitifs.
  - `Collective.java` : Représente les types collectifs comme les listes et les tableaux.
  - `Reference.java` : Représente les types de référence.
- `src/javaMetaModel` : Contient les classes spécifiques au méta-modèle Java.
  - `JavaModel.java` : Représente un modèle Java.
  - `JavaPrimitive.java` : Représente un type primitif Java.

## Branches
Le projet contient trois branches principales :
- **Spec 1** : Contient la version où les attributs utilisent le type `String`.
- **Spec 2** : Contient la version où les attributs utilisent les types `Primitive`, `Collective` et `Reference`.
- **Spec 3** : Contient la version où l'on peut également ajouter le package et l'héritage.

## Utilisation
1. **Cloner le dépôt :**
   ```sh
   git clone https://github.com/ChouaibBouchraibia/Minispec/
   cd Minispec
   ```

## Ouvrir le projet dans IntelliJ IDEA
- Ouvrez IntelliJ IDEA.
- Sélectionnez File > Open et choisissez le répertoire du projet.

## Construire le projet
Utilisez les outils de construction fournis par IntelliJ IDEA pour compiler le projet.

## Exécuter le générateur de code
- Implémentez la classe JavaGenerator pour générer du code Java à partir du méta-modèle.
- Utilisez le modèle de conception Visiteur pour parcourir le modèle et générer le code Java correspondant.

## Exemple
Voici un exemple d'utilisation de JavaGenerator :

```java
package codeGenerator;

import metaModel.Entity;
import metaModel.Model;
import metaModel.Visitor;

public class JavaGenerator extends Visitor {
    @Override
    public void visitModel(Model e) {
        // Implémentation pour générer le modèle en Java
    }

    @Override
    public void visitEntity(Entity e) {
        // Implémentation pour générer l'entité en Java
    }
}
```

## Version fournie
La version fournie avec le fichier ZIP contient la branche Spec 3.

## Contribuer
Les contributions sont les bienvenues ! Veuillez ouvrir une issue ou soumettre une pull request.

## Licence
Ce projet est sous licence MIT.
