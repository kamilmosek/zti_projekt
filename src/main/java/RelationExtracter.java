import edu.stanford.nlp.ling.CoreAnnotations;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.pipeline.CoreDocument;
import edu.stanford.nlp.pipeline.CoreSentence;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

public class RelationExtracter {
    private final String text;
    private CoreDocument coreDocument;
    private StanfordCoreNLP stanfordCoreNLP;
    private List<CoreLabel> coreLabelList;
    private List<CoreSentence> sentenceList;
    File file;// = new File("filename.txt");
    private final String filename;
    private PositionMapper positionMapper;

    public RelationExtracter(String text) {
        this.text = text;
        positionMapper = new PositionMapper();
        this.stanfordCoreNLP = Pipeline.getPipeline();
        this.coreDocument = new CoreDocument(text);
        stanfordCoreNLP.annotate(coreDocument);
        tokenizeText();
        breakTextIntoSentences();
        this.filename = UUID.randomUUID().toString() + ".txt";
        createFile();
    }

    public void getRelations() throws IOException {
        FileWriter fileWriter = new FileWriter(this.filename);

        System.out.println("Tokenizacja");
        fileWriter.write("ORIGINAL TEXT: \n");
        fileWriter.write(this.text + "\n");
        for (CoreLabel c : coreLabelList) {
            System.out.println(c.originalText());
        }

        System.out.println("DIVISION OF INPUT INTO SENTENCES AND THEIR SENTIMENT");
        fileWriter.write("\n\nDIVISION OF INPUT INTO SENTENCES AND THEIR SENTIMENT \t\t\n");
        List<CoreSentence> sentenceList = coreDocument.sentences();
        for (CoreSentence s : sentenceList) {
            System.out.println("Sentiment: " + s.sentiment() + "\t" + s.toString());
            fileWriter.write("Sentiment: " + s.sentiment() + "\t SENTENCE: " + s.toString() + "\n");
        }


        System.out.println("\n\nRELATION\n\nPOSITION | LEMMAEMMATIZATION | NAMED ENTITY RECOGNITION\n");
        fileWriter.write("\n\nRELATION\n\nPOSITION | LEMMAEMMATIZATION | NAMED ENTITY RECOGNITION\n");
        for (CoreLabel coreLabel : coreLabelList) {

            String position = coreLabel.get(CoreAnnotations.PartOfSpeechAnnotation.class);
            String lemma = coreLabel.lemma();
            String ner = coreLabel.get(CoreAnnotations.NamedEntityTagAnnotation.class);
            System.out.println("original text: " + coreLabel.originalText() + "\t\t\t position: " + position +
                    " " + positionMapper.getPositionDescription(position) +
                    "\t\t\t lemmaemmatization: " + lemma + "\t\t\t named entity recognition: " + ner + "\n");
            fileWriter.write("original text: " + coreLabel.originalText() + "\t\t\t position: " + position +
                    " " + positionMapper.getPositionDescription(position) +
                    "\t\t\t lemmaemmatization: " + lemma + "\t\t\t named entity recognition: " + ner + "\n");

        }

        System.out.println("RESULTS SAVED TO FILE " + this.filename);
        fileWriter.close();
    }

    private void tokenizeText() {
        this.coreLabelList = coreDocument.tokens();
    }

    private void breakTextIntoSentences() {
        this.sentenceList = coreDocument.sentences();
    }

    private void createFile() {
        try {
            this.file = new File(this.filename);
            if (this.file.createNewFile()) {
                System.out.println("File created: " + this.file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
