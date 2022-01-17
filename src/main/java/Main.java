import edu.stanford.nlp.ie.util.RelationTriple;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            // Get user input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter sentence to extract:");
            String text = scanner.nextLine();

            // Get relations
            RelationExtractor relationExtractor = new RelationExtractor(text);
            relationExtractor.printRelations();
            ArrayList<RelationTriple> relationsList = relationExtractor.getRelations();

            // Query DBpedia
            DBpediaService dbpediaService = new DBpediaService();

            for (RelationTriple triple : relationsList) {
                String object = triple.objectLink().replaceAll(" ", "_");
                String subject = triple.subjectLink().replaceAll(" ", "_");

                Model objectDBP = dbpediaService.query(object);
                Model subjectDBP = dbpediaService.query(subject);

                OutputStream out1 = new FileOutputStream("object.ttl");
                RDFDataMgr.write(out1, objectDBP, Lang.TURTLE);

                OutputStream out2 = new FileOutputStream("subject.ttl");
                RDFDataMgr.write(out2, subjectDBP, Lang.TURTLE);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}