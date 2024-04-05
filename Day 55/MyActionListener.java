import java.awt.event.*;

class MyActionListener implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action event occurred.");
    }
}

class MyMouseListener implements MouseListener {
    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse clicked at: (" + e.getX() + ", " + e.getY() + ")");
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}
}

class MyMouseMotionListener implements MouseMotionListener {
    public void mouseDragged(MouseEvent e) {}

    public void mouseMoved(MouseEvent e) {
        System.out.println("Mouse moved to: (" + e.getX() + ", " + e.getY() + ")");
    }
}

public class EventHandlingDemo {
    public static void main(String[] args) {
        // ActionListener
        MyActionListener actionListener = new MyActionListener();
        actionListener.actionPerformed(null); // Simulating action event

        // MouseListener
        MyMouseListener mouseListener = new MyMouseListener();
        mouseListener.mouseClicked(new MouseEvent(new Object(), MouseEvent.MOUSE_CLICKED, System.currentTimeMillis(), 0, 10, 20, 1, false)); // Simulating mouse click event

        // MouseMotionListener
        MyMouseMotionListener mouseMotionListener = new MyMouseMotionListener();
        mouseMotionListener.mouseMoved(new MouseEvent(new Object(), MouseEvent.MOUSE_MOVED, System.currentTimeMillis(), 0, 30, 40, 1, false)); // Simulating mouse motion event
    }
}
