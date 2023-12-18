import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    // text area
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    // menu bar
    JMenuBar menuBar;

    // file menu
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    // undo manager
    UndoManager um = new UndoManager();
    // redo manager

    //format menu
    JMenuItem wordWrapItem;
    // sub menu
    JMenuItem ifontArial, ifontCSMS, ifontTNR, ifontVerdana;
    JMenuItem fontsize8, fontsize12;
    JMenu fontItem;
    JMenu fontsizeItem;
    // end
    // word wrap on or off
    boolean wordWrapOn = false;
    // current font
    String currentFont = "Arial";



    keyHandler kHandler = new keyHandler(this);
    // get class function_file
    function_file file = new function_file(this);
    // constructor
    function_format format = new function_format(this);


    public GUI() {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createEditMenu();
        // wrap menu
        createWrapMenu();
        createColorMenu();
        addComponentsToWindow();
        window.setVisible(true);
    }
    public void createWindow() {
        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void createTextArea() {
        textArea = new JTextArea();
        textArea.setFont(new java.awt.Font("Monospaced", 0, 12));
        textArea.setTabSize(4);
        textArea.setMargin(new java.awt.Insets(10, 10, 10, 10));
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(java.awt.Color.WHITE);
        textArea.setForeground(java.awt.Color.BLACK);
        // add key listener
        textArea.addKeyListener(kHandler);
        // end

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new java.awt.Dimension(800, 600));
        scrollPane.setBackground(java.awt.Color.WHITE);
        // add undo manager
        textArea.getDocument().addUndoableEditListener(
                new javax.swing.event.UndoableEditListener() {
                    public void undoableEditHappened(javax.swing.event.UndoableEditEvent evt) {
                        um.addEdit(evt.getEdit());
                    }
                }
        );
    }
    public void createMenuBar() {
        menuBar = new JMenuBar();
        menuFile = new JMenu("File");

        menuEdit = new JMenu("Edit");
        menuFormat = new JMenu("Format");
        menuColor = new JMenu("Color");
    }
    public void createFileMenu() {
        JMenuItem newFile = new JMenuItem("New");
        // add action listener for file
        newFile.addActionListener(this);
        newFile.setActionCommand("new");
        // end
        JMenuItem openFile = new JMenuItem("Open");
        // add action listener for file
        openFile.addActionListener(this);
        openFile.setActionCommand("open");
        // end
        JMenuItem saveFile = new JMenuItem("Save");
        // add action listener for file
        saveFile.addActionListener(this);
        saveFile.setActionCommand("saveFile");
        // end
        JMenuItem saveAsFile = new JMenuItem("Save As");
        // add action listener for file
        saveAsFile.addActionListener(this);
        saveAsFile.setActionCommand("saveAsFile");
        // end
        JMenuItem printFile = new JMenuItem("Print");
        JMenuItem exitFile = new JMenuItem("Exit");
        // add action listener for file
        exitFile.addActionListener(this);
        exitFile.setActionCommand("Exit");
        // end
        // undo

        menuFile.add(newFile);

        menuFile.add(openFile);
        menuFile.add(saveFile);
        menuFile.add(saveAsFile);
        menuFile.addSeparator();
        menuFile.add(printFile);
        menuFile.addSeparator();
        menuFile.add(exitFile);
    }
    public void createEditMenu() {
        JMenuItem undoEdit = new JMenuItem("Undo");
        undoEdit.addActionListener(this);
        undoEdit.setActionCommand("undo");
        menuEdit.add(undoEdit);

        JMenuItem redoEdit = new JMenuItem("Redo");
        redoEdit.addActionListener(this);
        redoEdit.setActionCommand("redo");
        menuEdit.add(redoEdit);

        JMenuItem cutEdit = new JMenuItem("Cut");
        JMenuItem copyEdit = new JMenuItem("Copy");
        JMenuItem pasteEdit = new JMenuItem("Paste");
        JMenuItem selectAllEdit = new JMenuItem("Select All");
        menuEdit.addSeparator();
        menuEdit.add(cutEdit);
        menuEdit.add(copyEdit);
        menuEdit.add(pasteEdit);
        menuEdit.addSeparator();
        menuEdit.add(selectAllEdit);
    }

    public void createColorMenu() {
        JMenuItem background = new JMenuItem("Background");
        JMenuItem foreground = new JMenuItem("Foreground");
        menuColor.add(background);
        menuColor.add(foreground);
    }
    public void addComponentsToWindow() {
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuFormat);
        menuBar.add(menuColor);
        window.add(menuBar, java.awt.BorderLayout.NORTH);
        window.add(scrollPane, java.awt.BorderLayout.CENTER);
    }
    public void createWrapMenu() {
        wordWrapItem = new JMenuItem("Word Wrap: Disabled");
        wordWrapItem.addActionListener(this);
        wordWrapItem.setActionCommand("wordWrap");
        fontItem = new JMenu("Font");
        fontsizeItem = new JMenu("Font Size");
        // font
        ifontArial = new JMenuItem("Arial");
        ifontCSMS = new JMenuItem("Comic Sans MS");
        ifontTNR = new JMenuItem("Times New Roman");
        ifontVerdana = new JMenuItem("Verdana");
        // add font to font menu
        fontItem.add(ifontArial);
        fontItem.add(ifontCSMS);
        fontItem.add(ifontTNR);
        fontItem.add(ifontVerdana);
        // add action listener for font
        ifontArial.addActionListener(this);
        ifontArial.setActionCommand("Arial");
        ifontCSMS.addActionListener(this);
        ifontCSMS.setActionCommand("Comic Sans MS");
        ifontTNR.addActionListener(this);
        ifontTNR.setActionCommand("Times New Roman");
        ifontVerdana.addActionListener(this);
        ifontVerdana.setActionCommand("Verdana");
        // end
        menuFormat.add(wordWrapItem);
        menuFormat.add(fontItem);
        menuFormat.add(fontsizeItem);
        // font sub menu size
        fontsize8 = new JMenuItem("8");
        fontsize8.addActionListener(this);
        fontsize8.setActionCommand("size8");
        fontsizeItem.add(fontsize8);

        fontsize12 = new JMenuItem("12");
        fontsize12.addActionListener(this);
        fontsize12.setActionCommand("size12");
        fontsizeItem.add(fontsize12);


    }



    /// action listener

    @Override
    public void actionPerformed(ActionEvent e) {
        // string variable to get the action command
        String command = e.getActionCommand();
        // switch the command is new
        switch (command) {
            case "new":
                // create new file
                file.newFile();
                break;
            case "open":
                file.open();
                break;
            case "saveAsFile":
                file.saveAs();
                break;
            case "saveFile":
                file.save();
                break;
            case "Exit":
                file.exit();
                break;
            case "wordWrap":
                format.wordWrap();
                break;
            case "size8":
                format.fontType(8);
                break;
            case "size12":
                format.fontType(12);
                break;
            case "Arial":
                currentFont = "Arial";
                format.setFont("Arial");
                break;
            case "Comic Sans MS":
                currentFont = "Comic Sans MS";
                format.setFont("Comic Sans MS");
                break;
            case "Times New Roman":
                currentFont = "Times New Roman";
                format.setFont("Times New Roman");
                break;
            case "Verdana":
                currentFont = "Verdana";
                format.setFont("Verdana");
                break;
            case "undo":
                Undo undo = new Undo(this);
                undo.undo();
                break;
            case "redo":
                Undo redo = new Undo(this);
                redo.redo();
                break;



        }

    }
}
