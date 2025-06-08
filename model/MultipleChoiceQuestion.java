package model;

import java.util.List;

public class MultipleChoiceQuestion extends Question {
    private List<String> options;

    public MultipleChoiceQuestion(String text, List<String> options) {
        super(text);
        this.options = options;
    }

    public List<String> getOptions() { return options; }

    @Override
    public String getType() { return "MultipleChoice"; }
}