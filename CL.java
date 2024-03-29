package readability;

public class CL {
    private static double CLScore;
    static final double INDEX1 = 0.0588;
    static final double INDEX2 = 0.296;
    static final double INDEX3 = 15.8;
    static final double ONEHUNDREDWORDS = 100;

    public static double getCLScore() {
        return CLScore;
    }

    public static void setCLScore(Main main) {
        CLScore = INDEX1 * (main.getCharacters() / main.getWords() * ONEHUNDREDWORDS) - INDEX2 *
                (main.getSentences() / main.getWords() * ONEHUNDREDWORDS) - INDEX3;
    }
}
