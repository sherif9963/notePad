import java.awt.*;

public class function_format {
    GUI gui;
    Font arial, comicSansMS, timesNewRoman, verdana;
    String currentFont = "Arial";
    public function_format(GUI gui){
        this.gui = gui;
    }
    public void wordWrap(){
        if(gui.wordWrapOn == false){
            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.wordWrapItem.setSelected(true);
            gui.wordWrapItem.setText("Word Wrap: On");
        }else if(gui.wordWrapOn == true){
            gui.wordWrapOn = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.wordWrapItem.setSelected(false);
            gui.wordWrapItem.setText("Word Wrap: Off");

        }
    }
    // font size
    public void fontType(int fontSize) {
        // get current font
        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
        verdana = new Font("Verdana", Font.PLAIN, fontSize);
        // set font
    }
    public void setFont(String fontType){
        currentFont = fontType;
        switch (fontType){
            case "Arial":
                gui.textArea.setFont(arial);
                break;
            case "Comic Sans MS":
                gui.textArea.setFont(comicSansMS);
                break;
            case "Times New Roman":
                gui.textArea.setFont(timesNewRoman);
                break;
            case "Verdana":
                gui.textArea.setFont(verdana);
                break;
        }
    }
}
