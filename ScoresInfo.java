package readability;

import java.util.Scanner;

public class ScoresInfo {

    public static double scoreRating(double score) {
        double age = 0;
        for (Rating i : Rating.values()) {
            if (Math.round(score) < i.score + 1) {
                age = i.UpperBound;
                break;
            }
        }
        return age;
    }

    public static void showAverage() {
        double averageAge = (scoreRating(ARI.getARIScore()) +
                scoreRating(FK.getFKScore()) +
                scoreRating(SMOG.getSMOGScore()) +
                scoreRating(CL.getCLScore())) / 4;
        System.out.println();
        System.out.printf("%s%.2f%s%n",
                "This text should be understood in average by ",
                averageAge,
                "-year-olds.");
    }

    public static void showInfo(String text) {
        var content = new Main();
        content.setCharacters(text);
        content.setWords(text);
        content.setSentences(text);
        content.countSyllables(text);
        ARI.setARIScore(content);
        FK.setFKScore(content);
        SMOG.setSMOGScore(content);
        CL.setCLScore(content);
        var scanner = new Scanner(System.in);

        System.out.println("The text is:\n" + text + "\n");


        System.out.printf("%s%.0f%n", "Words: ", content.getWords());
        System.out.printf("%s%.0f%n", "Sentences: ", content.getSentences());
        System.out.printf("%s%.0f%n", "Characters: ", content.getCharacters());
        System.out.printf("%s%.0f%n", "Syllables: ", content.getSyllables());
        System.out.printf("%s%.0f%n", "Polysyllables: ", content.getPolysyllables());
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");

        switch (scanner.next()) {
            case "ARI":
                System.out.println();
                ARI.Info();
                break;
            case "FK":
                System.out.println();
                FK.Info();
                break;
            case "SMOG":
                System.out.println();
                SMOG.Info();
                break;
            case "CL":
                System.out.println();
                CL.Info();
                break;
            case "all": {
                System.out.println();
                ARI.Info();
                FK.Info();
                SMOG.Info();
                CL.Info();
                showAverage();
                break;
            }
            default:
                System.out.println("Incorrect score input");
                break;
        }
    }
}
