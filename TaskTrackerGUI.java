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


    //Save Tasks

    public static void saveTasks() {
        try (PrintWriter writer = new PrintWriter("E:\\projects\\taskTracker\\my tasks/task.txt")) {
            for (int i = 0; i < taskModel.getSize(); i++){
                writer.println(taskModel.get(i));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    //Load Task
    public static void loadTasks(){
        File file = new File("E:\\projects\\taskTracker\\my tasks/task.txt");
        if(file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    taskModel.addElement(line);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }





    public static void main(String a[]){
        //creating the main window frame (Main Window using Java Swing)
        JFrame frame = new JFrame("Task Tracker");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        //Set Task List (task list area)
        JList<String> taskList = new JList<>(taskModel);
        JScrollPane scrollPane = new JScrollPane(taskList);
        frame.add(scrollPane, BorderLayout.CENTER);

        loadTasks();
        //Buttons: Add Task, Delete Task
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Task");
        JButton deleteButton = new JButton("Delete Task");
        JButton saveButton = new JButton("saveButton");
        JButton clearTask = new JButton("Clear");
       // JButton loadTask = new JButton("Load Task");

        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(clearTask);
        //buttonPanel.add(loadTask);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        //SHow the frame
        //frame.setVisible(true);


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

        saveButton.addActionListener(e -> saveTasks() );

        //********************************Add Clear All Task Button***********************
        clearTask.addActionListener(e -> {
            int confirm = JOptionPane.showConfirmDialog(frame, "Delete all tasks permanently?", "Confirm Clear", JOptionPane.YES_NO_OPTION);

            // if the user click's yes
            if(confirm == JOptionPane.YES_OPTION){
                //clear the task model
                taskModel.clear();

                //overwrite the previous saved tasks
                saveTasks();
            }
        });
        frame.setVisible(true);


    }

}
