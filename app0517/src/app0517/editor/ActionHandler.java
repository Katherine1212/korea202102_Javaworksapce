package app0517.editor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionHandler implements ActionListener{
	MemoEditor editor;
	public ActionHandler(MemoEditor editor) {
		this.editor= editor;
	}
	// 액션리스너
	public void actionPerformed(ActionEvent e) {
		editor.area.append("Hello");
	}
	public static void main(String[] args) {
		
	}
}
