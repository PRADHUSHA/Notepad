package SimpleNotepad;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class keyHandler implements KeyListener {
	
	GUI gui;
	
	
	public keyHandler(GUI gui) {
		this.gui=gui;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if(e.isControlDown()&&  e.getKeyCode()==KeyEvent.VK_S) {
			gui.file.save();
		}
		if(e.isControlDown()&&  e.getKeyCode()==KeyEvent.VK_N) {
			gui.file.newFile();
		}
		if(e.isControlDown()&&  e.getKeyCode()==KeyEvent.VK_E) {
			gui.file.exit();
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
