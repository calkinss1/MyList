import javax.swing.JFrame;
/**
 * To do task list application
 * @author Sean Calkins
 */
public class MyList{
    public static void main(String[] args) {
        JFrame frame = new JFrame("My List");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new MyListPanel());
		frame.setSize(675,675);
		frame.setVisible(true);
    }
}