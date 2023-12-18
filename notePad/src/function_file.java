import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class function_file {

    GUI gui;
    String filename;
    String fileAddress;
    public function_file(GUI gui){
        this.gui = gui;
    }
    public void newFile(){
        gui.textArea.setText("");
        gui.window.setTitle("New");
        // modify filename and fileAddress
        filename = null;
        fileAddress = null;
    }
    // open file
    public void open() {
        //display dialog where user can select a file to open
        FileDialog dialog = new FileDialog(gui.window, "Open File", FileDialog.LOAD);
        dialog.setVisible(true);
        if (dialog.getFile() != null) {
            filename = dialog.getFile();
            gui.window.setTitle(filename);
        }

        // read content from file
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dialog.getDirectory() + dialog.getFile()));
            // locate file
            gui.textArea.setText("");
            // read line by line
            String line = null;
            while ((line = reader.readLine()) != null) {
                gui.textArea.append(line + "\n");
            }


        }catch (Exception e){
            System.out.println("File not found");
        }

    }
    // save file
    public void saveAs() {
        // last parameter for button type save
        FileDialog fd = new FileDialog(gui.window, "Save", FileDialog.SAVE);
        fd.setVisible(true);

        if (fd.getFile() != null) {
            filename = fd.getFile();
            fileAddress = fd.getDirectory();
            gui.window.setTitle(filename);
        }
        try {
            FileWriter fw = new FileWriter(fileAddress + filename);
            fw.write(gui.textArea.getText());
            fw.close();
        } catch (Exception e) {
            System.out.println("File not found");
        }
    }
        public void save(){
            if(filename == null){
                saveAs();
            }else{
                try {
                    FileWriter fw = new FileWriter(fileAddress + filename);
                    fw.write(gui.textArea.getText());
                    fw.close();
                }catch (Exception e){
                    System.out.println("File not found");
                }
            }
        }

    public void exit() {
        System.exit(0);
    }
}



