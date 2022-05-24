package readability;

enum Rating {
    KINDERGARTEN(1, 6),
    FIRST_GRADE(2, 7),
    SECOND_GRADE(3, 9),
    THIRD_GRADE(4, 10),
    FOURTH_GRADE(5, 11),
    FIFTH_GRADE(6, 12),
    SIXTH_GRADE(7, 13),
    SEVENTH_GRADE(8, 14),
    EIGHTH_GRADE(9, 15),
    NINTH_GRADE(10, 16),
    TENTH_GRADE(11, 17),
    ELEVENTH_GRADE(12, 18),
    TWELFTH_GRADE(13, 24),
    COLLEGE_STUDENT(14, 100);

    final double score;
    final double UpperBound;

    Rating(double score, double UpperBound) {
        this.score = score;
        this.UpperBound = UpperBound;
    }
}
