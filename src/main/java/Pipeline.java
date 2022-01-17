import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.util.Properties;

public class Pipeline {
    private static final Properties properties;
    private static String propertiesName = "tokenize, ssplit, pos, lemma, parse, ner, sentiment, relation, kbp";
    private static StanfordCoreNLP stanfordCoreNLP;

    private Pipeline() { }

    static {
        properties = new Properties();
        properties.setProperty("annotators", propertiesName);
    }

    public static StanfordCoreNLP getPipeline() {
        if(stanfordCoreNLP == null) {
            stanfordCoreNLP = new StanfordCoreNLP(properties);
        }
        return stanfordCoreNLP;
    }
}
