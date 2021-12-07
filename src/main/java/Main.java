import org.apache.jena.query.*;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String queryStr = "SELECT ?prop ?place WHERE { <http://dbpedia.org/resource/Paris> ?prop ?place .}";
        Query query = QueryFactory.create(queryStr);

        try {
            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter sentence to extract:");

            String input = myObj.nextLine();
            // removing stopwords
            StringTransformation stringTransformation = new StringTransformation();
            System.out.println("String without stopwords: " + stringTransformation.removeStopwords(input));

            // Example of taking data from dbpedia
            QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
            // Set the DBpedia specific timeout.
            ((QueryEngineHTTP)qexec).addParam("timeout", "10000") ;

            // Execute.
            ResultSet rs = qexec.execSelect();
            ResultSetFormatter.out(System.out, rs, query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

