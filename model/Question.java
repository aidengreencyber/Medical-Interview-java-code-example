package model;

public abstract class Question {
    protected String text;
    protected String answer;

    public Question(String text) {
        this.text = text;
    }

    public String getText() { return text; }
    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }
    public abstract String getType();
}
