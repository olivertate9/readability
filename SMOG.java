package readability;

import static readability.ScoresInfo.scoreRating;

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

    public static void Info() {
        System.out.printf("%s%.2f%s%.0f%s%n",
                "Simple Measure of Gobbledygook: ",
                getSMOGScore(),
                " (about ",
                scoreRating(getSMOGScore()),
                "-year-olds).");
    }
}
