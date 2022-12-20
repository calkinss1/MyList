# MyList

****************
* MyList
* Sean Calkins
**************** 

OVERVIEW:
 This program creates a GUI for a To-Do list of up to 10 items with the ability to mark tasks as complete
 and remove completed tasks from the list. Included is both a light and a dark mode functionality.


INCLUDED FILES:

 List the files required for the project with a brief
 explanation of why each is included.

 e.g.
 * ListPanel.java - source file
 * MyListPanel.java - source file
 * MyList.java - source file
 * Task.java - source file
 * README - this file


COMPILING AND RUNNING:

 From the directory containing all source files, compile the
 driver class (and all dependencies) with the command:
 $ javac ListPanel.java MyListPanel.java MyList.java Task.java 

 Run the compiled class file with the command:
 $ java MyList


PROGRAM DESIGN AND IMPORTANT CONCEPTS:


 MyList.java is the driver for this program which creates the GUI frame and adds the MyListPanel to the frame.
 MyListPanel creates and organizes the application GUI by creating and placing the appropriate subpanels
 using a BorderLayout. ListPanel creates a panel where the To do lsit will be displayed and when a new task is created it is added to this list panel. Tasks are created as JPanels with a label, a text field, and a button. The label is used to give the task a number, the text field is where the user types in a description of their task and the button is used to mark the task as complete so it can be removed using the remove completed button.

 Currently the application only supports a list of 10 items, future improvements will be made to increase the number of items on the list and the ability to scroll through the list will be added. Future updates may include: a login, ability to store multiple lists, GUI improvement using JavaFx.

----------------------------------------------------------------------------
