package model;

import java.util.List;

public class QuestionFactory {
    public static Question createQuestion(String type, String text, List<String> options) {
        return switch (type) {
            case "YesNo" -> new YesNoQuestion(text);
            case "MultipleChoice" -> new MultipleChoiceQuestion(text, options);
            default -> throw new IllegalArgumentException("Unknown question type");
        };
    }
}