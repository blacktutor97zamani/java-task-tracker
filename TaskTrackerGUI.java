/*
* I'm creating
* The Main Window using Java Swing
* the task list area
* the Buttons: Add Task, Delete Task
* */

import javax.swing.*;
import java.awt.*;

public class TaskTrackerGUI {
    public static void main(String[] args){

        //creating the main window frame (Main Window using Java Swing)
        JFrame frame = new JFrame("Task Tracker");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        //Set Task List (task list area)
        DefaultListModel<String> taskModel = new DefaultListModel<>();
        JList<String> taskList = new JList<>();
        JScrollPane scrollPane = new JScrollPane(taskList);
        frame.add(scrollPane, BorderLayout.CENTER);

        //Buttons: Add Task, Delete Task
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        //SHow the frame
        frame.setVisible(true);





    }

}
