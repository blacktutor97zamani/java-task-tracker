/*
* I'm creating
* The Main Window using Java Swing
* the task list area
* the Buttons: Add Task, Delete Task
* */

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class TaskTrackerGUI {
    private static DefaultListModel<String> taskModel = new DefaultListModel<>(); 
    
    public static void main(String[] args){

        //creating the main window frame (Main Window using Java Swing)
        JFrame frame = new JFrame("Task Tracker");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        //Set Task List (task list area)
        
        JList<String> taskList = new JList<>(taskModel);
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


        //adding Task Functionality to the add task button
        addButton.addActionListener(e -> {
            String task = JOptionPane.showInputDialog(frame, "Enter New Task");
            if (task != null && !task.trim().isEmpty()){
                taskModel.addElement(task);
            }
        });


        //adding Task Functionality to the delete task button

        deleteButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1){
                taskModel.remove(selectedIndex);

            }else{
                JOptionPane.showMessageDialog(frame, "Please select a task to delete");
            }
        });


    }

}
