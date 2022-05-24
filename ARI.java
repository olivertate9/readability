package readability;

public class ARI {
    private static double score;
    static final double INDEX1 = 4.71;
    static final double INDEX2 = 0.5;
    static final double INDEX3 = 21.43;

    public static double getARIScore() {
        return score;
    }

    public static void setARIScore(Main main) {
        score = INDEX1 * (main.getCharacters() / main.getWords()) +
                INDEX2 * (main.getWords() / main.getSentences()) - INDEX3;
    }
}
