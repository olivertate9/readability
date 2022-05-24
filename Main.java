package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    private double characters;
    private double words;
    private double sentences;
    private double syllables;
    private double polysyllables;

    public double getCharacters() {
        return characters;
    }

    public double getWords() {
        return words;
    }

    public double getSentences() {
        return sentences;
    }

    public double getSyllables() {
        return syllables;
    }

    public double getPolysyllables() {
        return polysyllables;
    }

    public void setCharacters(String text) {
        this.characters = (double) text.chars().filter(ch -> ch != ' ').count();
    }

    public void setWords(String text) {
        this.words = text.split("\\s").length;
    }

    public void setSentences(String text) {
        this.sentences = text.split("[.?!]\\s").length;
    }

    public void setSyllables(int syllables) {
        this.syllables = syllables;
    }

    public void setPolysyllables(double polysyllables) {
        this.polysyllables = polysyllables;
    }

    public void countSyllables(String text) {
        String[] words = text.toLowerCase().replaceAll("\\p{P}", "").split("\\s+");
        int countSyllablesWord;
        int countPolysyllablesWord;
        int countAllSyllables = 0;
        int countAllPolysyllables = 0;
        for (String s : words) {
            countSyllablesWord = 0;
            Pattern p1 = Pattern.compile("[aeiouy]");
            Pattern p2 = Pattern.compile("[aeiouy]{2}|e$");
            Pattern p3 = Pattern.compile("you");
            Matcher m1 = p1.matcher(s);
            Matcher m2 = p2.matcher(s);
            Matcher m3 = p3.matcher(s);
            for (int j = 0; j < s.length(); j++) {
                if (m1.find()) {
                    countSyllablesWord++;
                } else if (m2.find()) {
                    countSyllablesWord--;
                }
                if (m3.matches()) {
                    countSyllablesWord = 1;
                }
            }
            countSyllablesWord = countSyllablesWord > 0 ? countSyllablesWord : 1;
            countAllSyllables += countSyllablesWord;
            countPolysyllablesWord = countSyllablesWord > 2 ? 1 : 0;
            countAllPolysyllables += countPolysyllablesWord;
        }
        setSyllables(countAllSyllables);
        setPolysyllables(countAllPolysyllables);
    }

    public static void main(String[] args) {
        try {
            String text = Files.readString(Paths.get(args[0]));
            ScoresInfo.showInfo(text);
        } catch (IOException e) {
            System.out.println("File is not found");
        }
    }
}

