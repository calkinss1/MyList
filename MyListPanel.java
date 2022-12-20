import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI panel for To Do List
 * @author Sean Calkins
 */
public class MyListPanel extends JPanel {
    
  
    private JMenuItem quitItem;
    private JMenuItem settings;
    private JMenuItem darkMode;
    private JMenuItem lightMode;
    private JPanel titlePanel;
    private JPanel bottomPanel;
    private JPanel topPanel;
    private JButton newItemButton;
    private JButton clearSelectedButton;
    private ListPanel list;
    private JLabel title;

    /**
     * creates a new panel to contain to do list with menu bar and ability to create and clear to do tasks
     */
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
        titlePanel.setBackground(new Color(0,0,153));
        title = new JLabel("MyList");
        title.setForeground(Color.WHITE);
        titlePanel.add(title);

        //top Panel
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.add(menuBar,BorderLayout.NORTH);
        topPanel.add(titlePanel, BorderLayout.SOUTH);
        add(topPanel, BorderLayout.NORTH);

        //botom panel
        bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(0,0,153));
        newItemButton = new JButton("New Item");
        newItemButton.setBackground(new Color(255,178,0));
        newItemButton.addActionListener(new ButtonListener());
        clearSelectedButton = new JButton("Clear Selected");
        clearSelectedButton.setBackground(new Color(255,178,0));
        clearSelectedButton.addActionListener(new ButtonListener());
        bottomPanel.add(newItemButton);
        bottomPanel.add(clearSelectedButton);
        add(bottomPanel, BorderLayout.SOUTH);

        //list panel
         list = new ListPanel();
         JScrollPane scroll = new JScrollPane(list,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
         scroll.getViewport().setBackground(new Color(68, 188, 207));
        add(scroll, BorderLayout.CENTER);
        
    }

/**
 * Action Listener for menu items
 * @author Sean Calkins
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
                    titlePanel.setBackground(Color.BLACK);
                    titlePanel.setForeground(Color.WHITE);
                    topPanel.setBackground(Color.BLACK);
                    topPanel.setForeground(Color.WHITE);
                    bottomPanel.setBackground(Color.BLACK);
                    bottomPanel.setForeground(Color.WHITE);
                    newItemButton.setBackground(Color.BLACK);
                    newItemButton.setForeground(Color.WHITE);
                    clearSelectedButton.setBackground(Color.BLACK);
                    clearSelectedButton.setForeground(Color.WHITE);
                    title.setForeground(Color.WHITE);
                  
            }
            else if(e.getSource() == lightMode){
                list.setBackground(new Color(68, 188, 207));
                titlePanel.setBackground(new Color(0,0,153));
                bottomPanel.setBackground(new Color(0,0,153));
                newItemButton.setBackground(new Color(255,178,0));
                newItemButton.setForeground(Color.BLACK);
                clearSelectedButton.setBackground(new Color(255,178,0));
                clearSelectedButton.setForeground(Color.BLACK);
                

                
            }
        }
        
    }

    /**
     * Button Listener for the new item and clear selected buttons
     * @author Sean Calkins
     */
    private class ButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if( e.getSource().equals(newItemButton)){
                Task task = new Task();
                list.add(task); // Add new task to list
                list.updateNumbers();
                list.revalidate();
            }
            if(e.getSource().equals(clearSelectedButton)){
                list.removeCompletedTasks();
                repaint();
            }
        }
        
    }
}
