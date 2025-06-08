package view;

import javax.swing.*;
import java.awt.*;

public class InterviewView extends JFrame {
    public JTextField nameField = new JTextField(20);
    public JTextField ageField = new JTextField(5);
    public JTextField genderField = new JTextField(10);
    public JTextArea questionArea = new JTextArea(3, 30);
    public JTextField answerField = new JTextField(30);
    public JButton nextButton = new JButton("Next");

    public InterviewView() {
        setTitle("Medical Interview");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Age:"));
        add(ageField);
        add(new JLabel("Gender:"));
        add(genderField);
        add(questionArea);
        questionArea.setEditable(false);
        add(new JLabel("Your Answer:"));
        add(answerField);
        add(nextButton);
    }
}