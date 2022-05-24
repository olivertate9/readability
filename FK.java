package readability;

public class FK {
    private static double FKScore;
    static final double INDEX1 = 0.39;
    static final double INDEX2 = 11.8;
    static final double INDEX3 = 15.59;

    public static double getFKScore() {
        return FKScore;
    }

    public static void setFKScore(Main main) {
        FKScore = INDEX1 * (main.getWords() / main.getSentences())
                + INDEX2 * (main.getSyllables() / main.getWords()) - INDEX3;
    }
}
