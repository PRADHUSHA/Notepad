package SimpleNotepad;
import java.awt.Container;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class GUI implements ActionListener {
	
	JFrame window;
	//Text area
	JTextArea textArea;
	JScrollPane scrollPane;
	boolean wordWrapOn = false;
	// Top menu
	JMenuBar menuBar;
	JMenu menuFile, menuEdit, menuFormat, menuColor;
	// Sub menu
	JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemExit;
	// format menu
	JMenuItem itemWrap, iFontArial, iFontCSMS, iFontTNR, iFontSize8,
	iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
	JMenu menuFont, menuFontSize;
	
	// color menu
	JMenuItem icolor1, icolor2, icolor3;	
	//edit menu
	JMenuItem itemUndo, itemRedo;
	
	
	
	Function_File file= new Function_File(this);
	Function_Format format= new Function_Format(this);
	Function_Color color= new Function_Color(this);
	Function_Edit edit= new Function_Edit(this);
	keyHandler kHandler = new keyHandler(this);
	
	UndoManager um = new UndoManager();
	
	public static void main(String[] args) {
		new GUI();
	}
	
	public GUI() {
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createEditMenu();
		createFormatMenu();
		createColorMenu();
		format.selectedFont="Arial";
		format.createFont(16);
		format.wordwrap();
		color.changeColor("White");
		window.setVisible(true);
	}

	public void createWindow() {
		window = new JFrame("Notepad");
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void createTextArea() {
		textArea = new JTextArea();
		textArea.setFont(format.arial);
		
		textArea.addKeyListener(kHandler);
		
		textArea.getDocument().addUndoableEditListener(
				 new UndoableEditListener() {
					public void undoableEditHappened(UndoableEditEvent e) {
						um.addEdit(e.getEdit());
					}
				});
		
		scrollPane = new  JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createEmptyBorder());
		window.add(scrollPane);
				
	}
	public void createMenuBar() {
		menuBar = new JMenuBar();
		window.setJMenuBar(menuBar);
		menuFile = new JMenu("File");
		menuBar.add(menuFile);
		menuEdit = new JMenu("Edit");
		menuBar.add(menuEdit);
		menuFormat = new JMenu("Format");
		menuBar.add(menuFormat);
		menuColor = new JMenu("Color");
		menuBar.add(menuColor);
		
	}
	public void createFileMenu() {
		itemNew = new JMenuItem("New");
		itemNew.addActionListener(this);
		itemNew.setActionCommand("New");
		menuFile.add(itemNew);
		
		itemOpen = new JMenuItem("Open");
		itemOpen.addActionListener(this);
		itemOpen.setActionCommand("Open");
		menuFile.add(itemOpen);
		
		itemSave = new JMenuItem("Save");
		itemSave.addActionListener(this);
		itemSave.setActionCommand("Save");
		menuFile.add(itemSave);
		
		itemSaveAs = new JMenuItem("Save As");
		itemSaveAs.addActionListener(this);
		itemSaveAs.setActionCommand("SaveAs");
		menuFile.add(itemSaveAs);
		
		itemExit = new JMenuItem("Exit");
		itemExit.addActionListener(this);
		itemExit.setActionCommand("Exit");
		menuFile.add(itemExit);
	}
	public void createEditMenu() {
		itemUndo = new JMenuItem("Undo");
		itemUndo.addActionListener(this);
		itemUndo.setActionCommand("Undo");
		menuEdit.add(itemUndo);
		
		itemRedo = new JMenuItem("Redo");
		itemRedo.addActionListener(this);
		itemRedo.setActionCommand("Redo");
		menuEdit.add(itemRedo);
	}

	public void createFormatMenu() {
		itemWrap = new JMenuItem("Word Wrap: Off");
		itemWrap.addActionListener(this);
		itemWrap.setActionCommand("Word Wrap");
		menuFormat.add(itemWrap);
		
		menuFont = new JMenu("Font");
		menuFormat.add(menuFont);
		
		iFontArial = new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial") ;
		menuFont.add(iFontArial);
		
		iFontCSMS = new JMenuItem("Comic Sans Ms");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic Sans Ms") ;
		menuFont.add(iFontCSMS);
		
		iFontTNR = new JMenuItem("Times New Roman");
		iFontTNR.addActionListener(this);
		iFontTNR.setActionCommand("Times New Roman");
		menuFont.add(iFontTNR);
		
		
		menuFontSize = new JMenu("FontSize");
		menuFormat.add(menuFontSize);
		
		iFontSize8 = new JMenuItem("Size 8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("Size 8");
		menuFontSize.add(iFontSize8);
		
		iFontSize12 = new JMenuItem("Size 12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("Size 12");
		menuFontSize.add(iFontSize12);
		
		iFontSize16 = new JMenuItem("Size 16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("Size 16");
		menuFontSize.add(iFontSize16);
		
		iFontSize20 = new JMenuItem("Size 20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("Size 20");
		menuFontSize.add(iFontSize20);
		
		iFontSize24 = new JMenuItem("Size 24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("Size 24");
		menuFontSize.add(iFontSize24);
		
		iFontSize28 = new JMenuItem("Size 28");
		iFontSize28.addActionListener(this);
		iFontSize28.setActionCommand("Size 28");
		menuFontSize.add(iFontSize28);
	}
    
	
	public void createColorMenu() {
		icolor1 = new JMenuItem("White");
		icolor1.addActionListener(this);
		icolor1.setActionCommand("White");
		menuColor.add(icolor1);
		icolor2 = new JMenuItem("Black");
		icolor2.addActionListener(this);
		icolor2.setActionCommand("Black");
		menuColor.add(icolor2);
		icolor3 = new JMenuItem("Blue");
		icolor3.addActionListener(this);
		icolor3.setActionCommand("Blue");
		menuColor.add(icolor3);
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		switch(command) {
		case "New" : file.newFile();break;
		case "Open" : file.open();break;
		case "SaveAs" : file.saveAs();break;
		case "Save" : file.save();break;
		case "Exit" : file.exit();break;
		case "Undo" : edit.undo();break;
		case "Redo" : edit.redo();break;
		case "Word Wrap" : format.wordwrap();break;
		case "Arial" : format.setFont(command);
		case "Comic Sans MS" : format.setFont(command);
		case "Times New Roman" : format.setFont(command);
		case "Size 8" : format.createFont(8);break;
		case "Size 12" : format.createFont(12);break;
		case "Size 16" : format.createFont(16);break;
		case "Size 20" : format.createFont(20);break;
		case "Size 28" : format.createFont(28);break;
		case "White" : color.changeColor(command);break;
		case "Black" : color.changeColor(command);break;
		case "Blue" : color.changeColor(command);break;
		
		
		}
	}

}
