package codeGenerator;

import metaModel.Attribute;
import metaModel.Entity;
import metaModel.Model;
import metaModel.Visitor;

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

        code.append("public class ").append(capitalize(entity.getName())).append(" {\n");
        for (Attribute attribute : entity.getAttributes()) {
            code.append("\tprivate ").append(attribute.getType().getName()).append(" ").append(attribute.getName()).append(";\n");
        }
        code.append("\n");


        code.append("\tpublic ").append(entity.getName()).append("() {}\n\n");


        for (Attribute attribute : entity.getAttributes()) {
            attribute.accept(this);
        }

        code.append("}\n");
    }

    @Override
    public void visitAttribute(Attribute attribute) {
        String capitalized = capitalize(attribute.getName());
        code.append("\tpublic ").append(attribute.getType().getName()).append(" get").append(capitalized).append("() {\n")
                .append("\t\treturn ").append(attribute.getName()).append(";\n")
                .append("\t}\n\n");

        code.append("\tpublic void set").append(capitalized).append("(").append(attribute.getType().getName()).append(" ")
                .append(attribute.getName()).append(") {\n")
                .append("\t\tthis.").append(attribute.getName()).append(" = ").append(attribute.getName()).append(";\n")
                .append("\t}\n\n");
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
