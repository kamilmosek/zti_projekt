import org.apache.jena.query.*;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.riot.RDFDataMgr;
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
            Model model = RDFDataMgr.loadModel("src/data/file_1.ttl") ;

            // Create a dataset and read into it from file
            // "data.trig" assumed to be TriG.
            Dataset dataset = RDFDataMgr.loadDataset("src/data/file_1.ttl") ;

            // Read into an existing Model
            // RDFDataMgr.read(model, "data2.ttl") ;


            ResultSet rs = qexec.execSelect();
            ResultSetFormatter.out(System.out, rs, query);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

