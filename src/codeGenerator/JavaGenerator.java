package codeGenerator;

import metaModel.Attribute;
import metaModel.Entity;
import metaModel.Model;
import metaModel.Visitor;
import metaModel.type.Collection;
import metaModel.type.Primitive;
import metaModel.type.Reference;
import metaModel.type.Type;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;



public class JavaGenerator extends Visitor {

    private StringBuilder code;


    public JavaGenerator() {
        this.code = new StringBuilder();
    }

    @Override
    public void visitModel(Model model) {
        code.append("// Code généré pour le modèle ");
        for (Entity entity : model.getEntities()) {
            entity.accept(this);
            code.append("\n");
        }
    }

    @Override
    public void visitEntity(Entity entity) {

        if(entity.getParent() != null) {
            code.append("public class ").append(capitalize(entity.getName())).append(" extends ").append(entity.getParent().getName()).append(" {\n");
        } else {
            code.append("public class ").append(capitalize(entity.getName())).append(" {\n");
        }
        for (Attribute attribute : entity.getAttributes()) {
            code.append("\tprivate ").append(formatTypeName(attribute.getType())).append(" ").append(attribute.getName()).append(";\n");
        }
        code.append("\n");


        code.append("\tpublic ").append(capitalize(entity.getName())).append("() {}\n\n");


        for (Attribute attribute : entity.getAttributes()) {
            attribute.accept(this);
        }

        code.append("}\n");
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        String capitalized = capitalize(attribute.getName());

        code.append("\tpublic ").append(formatTypeName(attribute.getType())).append(" get").append(capitalized).append("() {\n")
                .append("\t\treturn ").append(attribute.getName()).append(";\n")
                .append("\t}\n\n");

        code.append("\tpublic void set").append(capitalized).append("(").append(formatTypeName(attribute.getType())).append(" ")
                .append(attribute.getName()).append(") {\n")
                .append("\t\tthis.").append(attribute.getName()).append(" = ").append(attribute.getName()).append(";\n")
                .append("\t}\n\n");
    }

    /**
     * Formate le nom du type en fonction de son type réel
     * @param type Le type à formater
     * @return Le nom du type formaté
     */
    private String formatTypeName(Type type) {
        if (type instanceof Primitive) {
            // Pour les types primitifs, retourne simplement le nom
            return type.getName();
        } else if (type instanceof Collection) {
            Collection Collection = (Collection) type;

            // Détermine le nom de la collection
            String collectionName = determineCollection(Collection.getName());

            // Formate le type de base
            String baseTypeName = formatTypeName(Collection.getBaseType());

            // Retourne le type de collection avec son type de base
            return collectionName + "<" + baseTypeName + ">";
        } else if ( type instanceof Reference) {
            Reference reference = (Reference) type;
            return reference.getEntity().getName();
        }

        // Cas par défaut
        return type.getName();
    }


    private String determineCollection(String collectionName) {
        // Mapping des types de collections
        switch (collectionName.toLowerCase()) {
            case "list":
                return "List";
            case "set":
                return "Set";
            case "array":
                return "Array";
            case "map":
                return "Map";
            default:
                return "List"; // Par défaut, utilise List
        }
    }

    private String extractClassName(String classCode) {
        int start = classCode.indexOf("class") + 6;
        int end = classCode.indexOf(" ", start);
        if (start > 5 && end > start) {
            return classCode.substring(start, end).trim();
        }
        return null;
    }

    private String capitalize(String str) {
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public String getCode() {
        return code.toString();
    }

    public void writeJavaFiles(String outputDirectory) throws IOException {
        File dir = new File(outputDirectory);
        if (!dir.exists()) {
            dir.mkdirs(); // Crée le répertoire si nécessaire
        }

        // Sépare chaque classe Java par le mot-clé "public class"
        String[] classes = code.toString().split("(?=public class)");
        for (String classCode : classes) {
            if (!classCode.trim().isEmpty()) {
                // Extraire le nom de la classe
                String className = extractClassName(classCode);
                if (className != null) {
                    // Écrire chaque classe dans un fichier séparé
                    File file = new File(dir, className + ".java");
                    try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {
                        writer.println(classCode.trim());
                    }
                }
            }
        }
    }

}
