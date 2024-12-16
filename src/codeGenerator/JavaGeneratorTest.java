package codeGenerator;

import XMLIO.XMLAnalyser;
import XMLIO.XMLSerializer;
import metaModel.Model;
import org.junit.Test;
import org.w3c.dom.Document;

import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JavaGeneratorTest {

    @Test
    public void test1() throws IOException {
        XMLAnalyser analyser = new XMLAnalyser();
        Model model = analyser.getModelFromFilenamed("Exemple2.xml");

        // Sérialise le modèle et génère le code Java
        JavaGenerator generator = new JavaGenerator();
        model.accept(generator);

        String outputDir = "output";
        generator.writeJavaFiles(outputDir);

        // Vérifie qu'un fichier attendu existe
        File outputFile = new File(outputDir, "Satellite.java"); // Exemple d'une entité Satellite
        assertTrue(outputFile.exists(), "Le fichier Satellite.java devrait être créé.");
    }



}
