import lombok.extern.slf4j.Slf4j;
import org.apache.jena.query.*;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;

public class Main {
    public static void main(String[] args) {
        String queryStr = "SELECT ?prop ?place WHERE { <http://dbpedia.org/resource/Paris> ?prop ?place .}";
        Query query = QueryFactory.create(queryStr);

        // Remote execution.
        try {
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

