import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyListPanel extends JPanel {
    
  
    private JMenuItem quitItem;
    private JMenuItem settings;
    private JMenuItem darkMode;
    private JMenuItem lightMode;
    private JPanel titlePanel;
    private JButton newItemButton;
    private JButton clearSelectedButton;
    private JPanel listPanel;
    private ListPanel list;

    public MyListPanel(){
        setLayout(new BorderLayout());
        
        // menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu quit = new JMenu("Quit");
        quitItem = new JMenuItem("Quit");
        quitItem.addActionListener(new MenuItemListener());
        quit.add(quitItem);
        menuBar.add(quit);

        settings = new JMenu("Settings");
        darkMode = new JMenuItem("Dark Mode");
        darkMode.addActionListener(new MenuItemListener());
        lightMode = new JMenuItem("Light Mode");
        lightMode.addActionListener(new MenuItemListener());
        settings.add(darkMode);
        settings.add(lightMode);
        menuBar.add(settings);

        titlePanel = new JPanel();
        JLabel title = new JLabel("MyList");
        titlePanel.add(title);

        //top Panel
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(menuBar,BorderLayout.NORTH);
        topPanel.add(titlePanel, BorderLayout.SOUTH);
        add(topPanel, BorderLayout.NORTH);

        //botom panel
        JPanel bottomPanel = new JPanel();
        newItemButton = new JButton("New Item");
        newItemButton.addActionListener(new ButtonListener());
         clearSelectedButton = new JButton("Clear Selected");
        clearSelectedButton.addActionListener(new ButtonListener());
        bottomPanel.add(newItemButton);
        bottomPanel.add(clearSelectedButton);
        add(bottomPanel, BorderLayout.SOUTH);

        //list panel
         list = new ListPanel();
         JScrollPane scroll = new JScrollPane(list);
         scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
         
         scroll.getViewport().setBackground(new Color(68, 188, 207));
        add(scroll, BorderLayout.CENTER);
        
    }

   

    public void addTask(){
        JPanel taskPanel = new JPanel();
        JLabel index = new JLabel(""); // create index label
         // set size of index label
        index.setHorizontalAlignment(JLabel.CENTER); // set alignment of index label
        taskPanel.add(index, BorderLayout.WEST); // add index label to task

        JTextField taskName = new JTextField("Write something.."); // create task name text field
        taskName.setBorder(BorderFactory.createEmptyBorder()); // remove border of text field
        taskName.setBackground(Color.BLUE); // set background color of text field

        taskPanel.add(taskName, BorderLayout.CENTER);

        ListCompleteButton done = new ListCompleteButton("Done");
        done.setPreferredSize(new Dimension(80, 20));
        done.setBorder(BorderFactory.createEmptyBorder());
        done.setBackground(Color.GREEN);
        done.setFocusPainted(false);
        taskPanel.add(done, BorderLayout.EAST);
       
        listPanel.add(taskPanel);
        add(listPanel, BorderLayout.CENTER);
    }

    /**
     * 
     */
    private class MenuItemListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource() == quitItem)
            System.exit(0);
            else if(e.getSource() == darkMode){
                    setBackground(Color.BLACK);
                    setForeground(Color.WHITE);
                    list.setBackground(Color.BLACK);
                    list.setForeground(Color.WHITE);
                  
            }
            else if(e.getSource() == lightMode){
                
                
            }
        }
        
    }

    /**
     * 
     */
    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            if( e.getSource().equals(newItemButton)){
                Task task = new Task();
                list.add(task); // Add new task to list
                list.updateNumbers();
            }
            if(e.getSource().equals(clearSelectedButton)){
                list.removeCompletedTasks();
                repaint();
            }
        }
        
    }
}
