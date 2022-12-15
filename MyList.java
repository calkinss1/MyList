import javax.swing.JFrame;

public class MyList{
    public static void main(String[] args) {
        JFrame frame = new JFrame("My List");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new MyListPanel());
		frame.setSize(675,675);
		frame.setVisible(true);
    }
}