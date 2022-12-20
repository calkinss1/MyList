import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;

/**
 * Scrollable JPanel for holding a list of tasks
 * @author Sean Calkins
 */
public class ListPanel extends JPanel implements Scrollable {
private int visibleRowCount;
   
    /**
     * Creates a new list panel to add list tasks to
     */
    public ListPanel() {
        visibleRowCount = 10;
        Color listColor = new Color(68, 188, 207);
        GridLayout layout = new GridLayout(10,1);
        layout.setVgap(5);
        setLayout(layout);
        setBackground(listColor);
        setPreferredSize(new Dimension(400,560));

    }
    
    /**
     * update the task numbers when completed tasks are removed
     */
    public void updateNumbers() {
        Component[] listItems = this.getComponents();

        for (int i = 0; i < listItems.length; i++) {
            if (listItems[i] instanceof Task) {
                ((Task) listItems[i]).changeIndex(i + 1);
            }
        }

    }

    /**
     * removes completed tasks
     */
    public void removeCompletedTasks() {

        for (Component c : getComponents()) {
            if (c instanceof Task) {
                if (((Task) c).getState()) {
                    remove(c); // remove the component
                    updateNumbers(); // update the indexing of all items
                }
            }
        }
}

    @Override
    public Dimension getPreferredScrollableViewportSize() {
        if (getComponentCount() > 0) {
            JComponent comp = (JComponent) getComponents()[0];
            int width = getPreferredSize().width;
            int height = visibleRowCount * comp.getPreferredSize().height;
            Dimension d = new Dimension(width, height);
            System.out.println(d);
            return d;
        } else {
            return new Dimension(0, 0);
        }
    }

    @Override
    public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
        int dim = 0;
        if (getComponentCount() > 0) {
            JComponent comp = (JComponent) getComponents()[0];
            Dimension d = comp.getPreferredSize();
            if (orientation == SwingConstants.VERTICAL) {
                dim = visibleRowCount * d.height;
            } else {
                dim= d.width;
            }
        }
        return dim;
    }

    @Override
    public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
        int dim = 0;
        if (getComponentCount() > 0) {
            JComponent comp = (JComponent) getComponents()[0];
            Dimension d = comp.getPreferredSize();
            if (orientation == SwingConstants.VERTICAL) {
                dim = visibleRowCount * d.height;
            } else {
                dim= d.width;
            }
        }
        return dim;
    }

    @Override
    public boolean getScrollableTracksViewportWidth() {
        return true;
    }

    @Override
    public boolean getScrollableTracksViewportHeight() {
        return true;
    }
}
