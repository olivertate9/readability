package readability;

public class SMOG {
    private static double SMOGScore;
    static final double INDEX1 = 1.043;
    static final double INDEX2 = 30;
    static final double INDEX3 = 3.1291;

    public static double getSMOGScore() {
        return SMOGScore;
    }

    public static void setSMOGScore(Main main) {
        SMOGScore = INDEX1 * Math.sqrt(main.getPolysyllables() *
                (INDEX2 / main.getSentences())) + INDEX3;
    }
}
