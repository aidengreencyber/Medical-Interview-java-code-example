package model;

public class QuestionNode {
    private Question question;
    private QuestionNode yesNode;
    private QuestionNode noNode;

    public QuestionNode(Question question) {
        this.question = question;
    }

    public Question getQuestion() { return question; }
    public void setYesNode(QuestionNode yesNode) { this.yesNode = yesNode; }
    public void setNoNode(QuestionNode noNode) { this.noNode = noNode; }
    public QuestionNode getYesNode() { return yesNode; }
    public QuestionNode getNoNode() { return noNode; }
}