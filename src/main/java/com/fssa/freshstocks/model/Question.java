package com.fssa.freshstocks.model;

public class Question {
	// Fields
    private String question;
    private String[] options;
    private String correctAnswer;
    private String option1;
    private String option2;
    private String option3;
    private String option4;

    // Getters and Setters
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options) {
        this.options = options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
    
    public void setoption1(String option1) {
        this.option1 = option1;
    }

    public String getOption1() {
        return option1;
    }

    public void setoption2(String option2) {
        this.option2 = option2;
    }

    public String getOption2() {
        return option2;
    }

    public void setoption3(String option3) {
        this.option3 = option3;
    }

    public String getOption3() {
        return option3;
    }

    public void setoption4(String option4) {
        this.option4 = option4;
    }

    public String getOption4() {
        return option4;
    }

}
