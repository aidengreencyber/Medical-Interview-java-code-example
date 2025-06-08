package controller;

import model.*;
import view.InterviewView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InterviewController {
    private InterviewView view;
    private QuestionNode currentNode;
    private Patient currentPatient;

    public InterviewController(InterviewView view) {
        this.view = view;
        setupTree();
        bindEvents();
    }

    private void setupTree() {
        QuestionNode root = new QuestionNode(new YesNoQuestion("Do you have allergies?"));
        root.setYesNode(new QuestionNode(new YesNoQuestion("Are they food-related?")));
        root.setNoNode(new QuestionNode(new YesNoQuestion("Do you smoke?")));
        currentNode = root;
        view.questionArea.setText(currentNode.getQuestion().getText());
    }

    private void bindEvents() {
        view.nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (currentPatient == null) {
                    String name = view.nameField.getText();
                    int age = Integer.parseInt(view.ageField.getText());
                    String gender = view.genderField.getText();
                    currentPatient = new Patient(name, age, gender);
                }

                String answer = view.answerField.getText();
                currentNode.getQuestion().setAnswer(answer);
                saveAnswerToDatabase(currentNode.getQuestion());

                if (answer.equalsIgnoreCase("yes") && currentNode.getYesNode() != null) {
                    currentNode = currentNode.getYesNode();
                } else if (answer.equalsIgnoreCase("no") && currentNode.getNoNode() != null) {
                    currentNode = currentNode.getNoNode();
                } else {
                    view.questionArea.setText("Interview complete. Thank you!");
                    return;
                }
                view.questionArea.setText(currentNode.getQuestion().getText());
                view.answerField.setText("");
            }
        });
    }

    private void saveAnswerToDatabase(Question question) {
        try {
            String sql = "INSERT INTO responses (question_text, answer) VALUES (?, ?)";
            PreparedStatement stmt = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            stmt.setString(1, question.getText());
            stmt.setString(2, question.getAnswer());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}