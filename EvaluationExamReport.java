package main;

public class EvaluationExamReport {

    private String ExamCode;
    StatisticalGraph graph;
    String ToughQuestions[];

    public EvaluationExamReport(String ExamCode) {
        this.ExamCode = ExamCode;
        graph = new StatisticalGraph(ExamCode);
    }

    public String getExamCode() {
        return ExamCode;
    }

}
