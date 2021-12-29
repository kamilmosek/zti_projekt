import java.util.HashMap;

public class PositionMapper {
    private HashMap<String, String> positions;

    public String getPositionDescription(String positionKey) {
        String val = this.positions.get(positionKey);
        if (val != null) return val;
        return "";
    }

    public PositionMapper() {
        this.positions = new HashMap<>();
        this.positions.put("CC", "Coordinating conjunction");
        this.positions.put("CD", "Cardinal number");
        this.positions.put("DT", "Determiner");
        this.positions.put("EX", "Existential there");
        this.positions.put("FW", "Foreign word");
        this.positions.put("IN", "Preposition or subordinating conjunction");
        this.positions.put("JJ", "Adjective");
        this.positions.put("JJR", "Adjective, comparative");
        this.positions.put("JJS", "Adjective, superlative");
        this.positions.put("LS", "List item marker");
        this.positions.put("MD", "Modal");
        this.positions.put("NN", "Noun, singular or mass");
        this.positions.put("NNS", "Noun, plural");
        this.positions.put("NNP", "Proper noun, singular");
        this.positions.put("NNPS", "Proper noun, plural");
        this.positions.put("PDT", "Predeterminer");
        this.positions.put("POS", "Possessive ending");
        this.positions.put("PRP", "Personal pronoun");
        this.positions.put("PRP$", "Possessive pronoun");
        this.positions.put("RB", "Adverb");
        this.positions.put("RBR", "Adverb, comparative");
        this.positions.put("RBS", "Adverb, superlative");
        this.positions.put("RP", "Particle");
        this.positions.put("SYM", "Symbol");
        this.positions.put("TO", "to");
        this.positions.put("UH", "Interjection");
        this.positions.put("VB", "Verb, base form");
        this.positions.put("VBD", "Verb, past tense");
        this.positions.put("VBG", "Verb, gerund or present participle");
        this.positions.put("VBN", "Verb, past participle");
        this.positions.put("VBP", "Verb, non -3 rd person singular present");
        this.positions.put("VBZ", "Verb, 3 rd person singular present");
        this.positions.put("WDT", "Wh -determiner");
        this.positions.put("WP", "Wh -pronoun");
        this.positions.put("WP$", "Possessive wh - pronoun");
        this.positions.put("WRB", "Wh -adverb");
    }
}
