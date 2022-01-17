import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.sparql.engine.http.QueryEngineHTTP;

public class DBpediaService {
    public Model query(String queryParameter) {
        String queryStr = "SELECT ?prop ?place WHERE { <http://dbpedia.org/resource/" + queryParameter + "> ?prop ?place .}";
        Query query = QueryFactory.create(queryStr);

        // Example of taking data from dbpedia
        QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);

        // Set the DBpedia specific timeout.
        ((QueryEngineHTTP)qexec).addParam("timeout", "10000") ;

        return qexec.execConstruct();
    }
}
