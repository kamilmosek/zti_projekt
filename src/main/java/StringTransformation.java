import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringTransformation {

    public List<String> stopwords;

    public void loadStopwords() throws IOException {
        this.stopwords = Files.readAllLines(Paths.get("stopwords.txt"));
    }

    public String removeStopwords(String original) throws IOException {
        this.loadStopwords();
        ArrayList<String> allWords =
                Stream.of(original.toLowerCase().split(" "))
                        .collect(Collectors.toCollection(ArrayList<String>::new));
        allWords.removeAll(stopwords);

        return allWords.stream().collect(Collectors.joining(" "));
    }
}
