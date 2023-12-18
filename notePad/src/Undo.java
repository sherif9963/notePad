public class Undo {
    GUI gui;
    public Undo( GUI gui) {
        this.gui = gui;
    }
    public void undo() {
        try {
            gui.um.undo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // redo
    public void redo() {
        try {
            gui.um.redo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
