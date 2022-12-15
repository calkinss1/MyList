import javax.swing.JButton;

public class ListCompleteButton extends JButton {
    private boolean done;
    public ListCompleteButton(String text){
        super(text);
        done = false;

    }
    /**
     * checks status of task
     * @return whether task is complete or incomplete
     */
    public boolean isDone(){
        return done;
    }

    /**
     * sets the task to comlete or incomplete
     * @param complete boolean value to tell if task is complete or not
     */
    public void setDone(boolean complete){
        done = complete;
    }
    
}
