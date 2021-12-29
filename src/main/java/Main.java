import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            Scanner scanner = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter sentence to extract:");
            // uncomment to enter text from the console
            String text = scanner.nextLine();
//            String text = "Hey! Maciek is cool guy. He is a CEO of ISIS, the largest terrorist group in Iran. I hate pizza with pineapple which I ordered from PizzaHut for 54$. Tom was born in Casablanca "+
//             "his email address tom.jerry@gmail.com you can write a message to him. Tom is a famous since 11.11.1998 because this day he played there "+
//                    "a role with Antonio. Antonio is a actor who is Jewish, he won three Oscar statuette and 30 thousand euros. A year ago, he died of cancer."+
//                    "His funeral was held in Paris. It was the saddest thing I have ever seen. The closing speech was given by PhD. Brown"+
//                    "Next to his grave, there is a monument to the great Pole, John Paul II. THE END OF THIS BEAUTIFUL STORY!";
            RelationExtracter relationExtracter = new RelationExtracter(text);
            relationExtracter.getRelations();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


//String queryStr = "SELECT ?prop ?place WHERE { <http://dbpedia.org/resource/Paris> ?prop ?place .}";
//Query query = QueryFactory.create(queryStr);
//            Scanner myObj = new Scanner(System.in);  // Create a Scanner object
//            System.out.println("Enter sentence to extract:");

//          String input = myObj.nextLine();
//            String input = "Hey! Maciek is cool guy. I hate CJ and Poznan University of Technology! Tom was born in California";
//            StanfordCoreNLP stanfordCoreNLP = Pipeline.getPipeline();
//            CoreDocument coreDocument = new CoreDocument(input);
//            stanfordCoreNLP.annotate(coreDocument);
//            List<CoreLabel> coreLabelList = coreDocument.tokens();
//            System.out.println("Tokenizacja");
//            for(CoreLabel c : coreLabelList){
//                System.out.println(c.originalText());
//            }
//
//            System.out.println("Podział inputu na zdania i ich sentyment");
//            List<CoreSentence> sentenceList = coreDocument.sentences();
//            for(CoreSentence s : sentenceList){
//                System.out.println("Sentiment: "+s.sentiment()+"\t"+s.toString());
//            }
//
//
//            System.out.println("Position");
//            for(CoreLabel coreLabel : coreLabelList) {
//
//                String position = coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class);
//                String lemma = coreLabel.lemma();
//                String ner = coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class);
//                System.out.println("original text: "+coreLabel.originalText() + "\t position: "+ position+
//                        "\t lemmaemmatization: "+lemma+"\t named entity recognition: "+ner);
//
//            }


// removing stopwords
//            StringTransformation stringTransformation = new StringTransformation();
//            System.out.println("String without stopwords: " + stringTransformation.removeStopwords(input));

// Execute.
//            Model model = RDFDataMgr.loadModel("src/data/file_1.ttl") ;

// Create a dataset and read into it from file
// "data.trig" assumed to be TriG.
//            Dataset dataset = RDFDataMgr.loadDataset("src/data/file_1.ttl") ;

// Read into an existing Model
// RDFDataMgr.read(model, "data2.ttl") ;

//            System.out.println("String which you want to search in dbpedia:");
//            String param = myObj.nextLine();
//            String queryStr = "SELECT ?prop ?place WHERE { <http://dbpedia.org/resource/"+param+"> ?prop ?place .}";
//            Query query = QueryFactory.create(queryStr);
//            // Example of taking data from dbpedia
//            QueryExecution qexec = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
//            // Set the DBpedia specific timeout.
//            ((QueryEngineHTTP)qexec).addParam("timeout", "10000") ;
//            ResultSet rs = qexec.execSelect();
//            ResultSetFormatter.out(System.out, rs, query);