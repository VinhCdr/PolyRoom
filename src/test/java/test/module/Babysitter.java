package test.module;

import java.awt.Window;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import poro.MainClass;
import poro.gui.DangNhapJDialog;
import poro.gui.QLMainJFrame;

public class Babysitter {
	
	public static void showMain() {
		try {
			new Thread(() -> {
				MainClass.main(null);
			}).start();
			Thread.sleep(5000);
			MainClass.mainJFrame.setAlwaysOnTop(true);
			MainClass.dangNhapJDialog.setAlwaysOnTop(true);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends JPanel> T getTabPanelSelected() {
		JScrollPane jsp = (JScrollPane) MainClass.mainJFrame.tabContent.getSelectedComponent();
		return (T) jsp.getViewport().getComponents()[0];
	}
	
	public static void closeMain() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("Lỗi nhỏ về luồng, không cần quan tâm: ".concat(e.toString()));
		}
		MainClass.dangNhapJDialog.setVisible(false);
		MainClass.mainJFrame.setVisible(false);
//		MainClass.mainJFrame = new QLMainJFrame();
//		MainClass.dangNhapJDialog = new DangNhapJDialog(MainClass.mainJFrame, true);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Window> T getWindow(Class<T> t) {
		List<Window> ls = new ArrayList<Window>(Arrays.asList(MainClass.mainJFrame.getOwnedWindows()));
		for (Window w : ls) {
			if (w.getClass().toString().equals(t.toString()) && w.isVisible()) {
				return (T) w;
			}
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends Window> T getWindow(Window window, Class<T> t) {
		List<Window> ls = new ArrayList<Window>(Arrays.asList(window.getOwnedWindows()));
		for (Window w : ls) {
			if (w.getClass().toString().equals(t.toString()) && w.isVisible()) {
				return (T) w;
			}
		}
		return null;
	}

}
