//Run this file to run the program

import controller.InterviewController;
import view.InterviewView;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            InterviewView view = new InterviewView();
            InterviewController controller = new InterviewController(view);
            view.setVisible(true);
        });
    }
}