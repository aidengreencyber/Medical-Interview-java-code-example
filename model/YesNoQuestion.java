package model;

public class YesNoQuestion extends Question {
    public YesNoQuestion(String text) { super(text); }

    @Override
    public String getType() { return "YesNo"; }
}