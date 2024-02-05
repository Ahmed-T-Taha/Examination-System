package main;

public class Question implements Comparable<Question> {

    private String q, a, b, c, d;
    private char CorrectAnswer;
    private int Grade, EvaluationRank, numberOfAttempts = 0, numberOfCorrectAnswers = 0;
    private float successRatio;

    public Question(String q, String a, String b, String c, String d, char CorrectAnswer, int Grade) {
        this.q = q;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.CorrectAnswer = CorrectAnswer;
        this.Grade = Grade;
    }

    public String getQ() {
        return q;
    }

    public String getA() {
        return a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public String getD() {
        return d;
    }

    public char getCorrectAnswer() {
        return CorrectAnswer;
    }

    public int getGrade() {
        return Grade;
    }

    public int getEvaluationRank() {
        EvaluationRank = ((int) (successRatio * 5));
        return EvaluationRank;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public void incrementNumberOfAttempts() {
        numberOfAttempts++;
    }

    public int getNumberOfCorrectAnswers() {
        return numberOfCorrectAnswers;
    }

    public void incrementNumberOfCorrectAnswers() {
        numberOfCorrectAnswers++;
    }

    public float getSuccessRatio() {
        try {
            if (numberOfAttempts == 0) {
                throw new ArithmeticException();
            }
            successRatio = numberOfCorrectAnswers / numberOfAttempts;
            return successRatio;
        } catch (ArithmeticException ae) {
            System.out.println("No students attempted question");
            return 0;
        }
    }

    @Override
    public int compareTo(Question q) {
        return Float.compare(this.getSuccessRatio(), q.getSuccessRatio());
    }

}
