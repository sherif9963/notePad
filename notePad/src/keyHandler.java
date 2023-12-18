import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.TextHitInfo;

public class keyHandler implements KeyListener {

    GUI gui;
    public keyHandler(GUI gui) {
        this.gui = gui;

    }
    @Override
    public void keyTyped(KeyEvent e) {


    }

    @Override
    public void keyPressed(KeyEvent e) {
        if ( e.isControlDown() && e.getKeyCode()== KeyEvent.VK_S){
            function_file file = new function_file(gui);
            file.save();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
