import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Task panel for To Do list GUI
 * @author Puja Kumari, Sean Calkins
 */
public class Task extends JPanel {
    

        JLabel index;
        JTextField taskName;
        JButton done;
    
        Color lavender = new Color(213, 116, 242);
        Color green = new Color(31, 204, 62);
        Color doneColor = new Color(156, 6, 201);
    
        private boolean checked;

        /**
         * Creates new Task panel with associated index label and button to mark completed
         */
        Task() {
            // this.setPreferredSize(new Dimension(400, 20)); // set size of task
            this.setBackground (lavender); // set background color of task
            this.setPreferredSize(new Dimension(400,20));
            this.setLayout(new BorderLayout()); // set layout of task
    
            checked = false;
    
            index = new JLabel(""); // create index label
            index.setPreferredSize(new Dimension(20, 20)); // set size of index label
            index.setHorizontalAlignment(JLabel.CENTER); // set alignment of index label
            this.add(index, BorderLayout.WEST); // add index label to task
    
            taskName = new JTextField("Write something.."); // create task name text field
            taskName.setBorder(BorderFactory.createEmptyBorder()); // remove border of text field
            taskName.setBackground (lavender); // set background color of text field
    
            this.add(taskName, BorderLayout.CENTER);
    
            done = new JButton("Done");
            done.setPreferredSize(new Dimension(80, 20));
            done.setBorder(BorderFactory.createEmptyBorder());
            done.setBackground(doneColor);
            done.setFocusPainted(false);
            done.addActionListener(new DoneListener());
    
            this.add(done, BorderLayout.EAST);
    
        }
        
        /**
         * changes the index of the task
         * @param num number to change the index to
         */
        public void changeIndex(int num) {
            this.index.setText(num + ""); // num to String
            this.revalidate(); // refresh
        }
    
        /**
         * 
         * @return the done button
         */
        public JButton getDone() {
            return done;
        }
    
        /**
         * gets the completed state of the task
         * @return true if task was completed, false otherwise
         */
        public boolean getState() {
            return checked;
        }
    
        /**
         * changes the completed state of the task and recolors to indicate task is completed
         */
        public void changeState() {
            this.setBackground(green);
            taskName.setBackground(green);
            checked = true;
            revalidate();
        }

        /**
         * 
         * @author Sean Calkins
         */
        private class DoneListener implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent e) {
               changeState();
                
            }

        }
    }

