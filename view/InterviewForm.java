package view;

import javax.swing.*;
import java.awt.*;

public class InterviewForm extends JFrame {
    public JTextField nameField;
    public JTextField ageField;
    public JComboBox<String> genderBox;
    public JLabel questionLabel;
    public JButton yesButton;
    public JButton noButton;

    public InterviewForm() {
        setTitle("Medical Interview");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1));

        nameField = new JTextField("Name");
        ageField = new JTextField("Age");
        genderBox = new JComboBox<>(new String[]{"Male", "Female", "Other"});

        questionLabel = new JLabel("Question will appear here");
        yesButton = new JButton("Yes");
        noButton = new JButton("No");

        add(nameField);
        add(ageField);
        add(genderBox);
        add(questionLabel);
        add(yesButton);
        add(noButton);
    }
}
