package readability;

enum Rating {
    KINDERGARTEN(1, 5, 6),
    FIRST_GRADE(2, 6, 7),
    SECOND_GRADE(3, 7, 9),
    THIRD_GRADE(4, 9, 10),
    FOURTH_GRADE(5, 10, 11),
    FIFTH_GRADE(6, 11, 12),
    SIXTH_GRADE(7, 12, 13),
    SEVENTH_GRADE(8, 13, 14),
    EIGHTH_GRADE(9, 14, 15),
    NINTH_GRADE(10, 15, 16),
    TENTH_GRADE(11, 16, 17),
    ELEVENTH_GRADE(12, 17, 18),
    TWELFTH_GRADE(13, 18, 24),
    COLLEGE_STUDENT(14, 24, 100);

    final double score;
    final double LowerBound;
    final double UpperBound;

    Rating(double score, double LowerBound, double UpperBound) {
        this.score = score;
        this.LowerBound = LowerBound;
        this.UpperBound = UpperBound;
    }
}
