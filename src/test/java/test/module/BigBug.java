package test.module;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JTextField;

/**
 * Con bọ bự
 * @author vinh
 *
 */
public class BigBug {
	private static Robot robot;
	
	static {
		 try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	private static int coverStringToKey(String str) {
		switch (str.toLowerCase()) {
			case "a":
				return KeyEvent.VK_A;
			case "b":
				return KeyEvent.VK_B;
			case "c":
				return KeyEvent.VK_C;
			case "d":
				return KeyEvent.VK_D;
			case "e":
				return KeyEvent.VK_E;
			case "f":
				return KeyEvent.VK_F;
			case "g":
				return KeyEvent.VK_G;
			case "h":
				return KeyEvent.VK_H;
			case "i":
				return KeyEvent.VK_I;
			case "j":
				return KeyEvent.VK_J;
			case "k":
				return KeyEvent.VK_K;
			case "l":
				return KeyEvent.VK_L;
			case "m":
				return KeyEvent.VK_M;
			case "n":
				return KeyEvent.VK_N;
			case "o":
				return KeyEvent.VK_O;
			case "p":
				return KeyEvent.VK_P;
			case "q":
				return KeyEvent.VK_Q;
			case "r":
				return KeyEvent.VK_R;
			case "s":
				return KeyEvent.VK_S;
			case "t":
				return KeyEvent.VK_T;
			case "u":
				return KeyEvent.VK_U;
			case "v":
				return KeyEvent.VK_V;
			case "w":
				return KeyEvent.VK_W;
			case "x":
				return KeyEvent.VK_X;
			case "y":
				return KeyEvent.VK_Y;
			case "z":
				return KeyEvent.VK_Z;
			case "0":
				return KeyEvent.VK_0;
			case "1":
				return KeyEvent.VK_1;
			case "2":
				return KeyEvent.VK_2;
			case "3":
				return KeyEvent.VK_3;
			case "4":
				return KeyEvent.VK_4;
			case "5":
				return KeyEvent.VK_5;
			case "6":
				return KeyEvent.VK_6;
			case "7":
				return KeyEvent.VK_7;
			case "8":
				return KeyEvent.VK_8;
			case "9":
				return KeyEvent.VK_9;
			case "enter":
				return KeyEvent.VK_ENTER;
			case "capslock":
				return KeyEvent.VK_CAPS_LOCK;
			case " ":
				return KeyEvent.VK_SPACE;
			case "tab":
				return KeyEvent.VK_TAB;
			case "shift":
				return KeyEvent.VK_SHIFT;
			case "ctrl":
				return KeyEvent.VK_CONTROL;
			case "backspace":
				return KeyEvent.VK_BACK_SPACE;
			default:
				break;
		}
		
		return -1;
	}
	
	/**
	 * Bọ sẽ nhập vào chuổi ký tự
	 * @param str Chuổi ký tự
	 * @see #writeString(JTextField, String)
	 * @see #writeString(JTextField, String, boolean)
	 */
	public static void writeString(String str) {
		try {
			for (String s : str.split("")) {
				Thread.sleep(30);
				robot.keyPress(coverStringToKey(s));
				Thread.sleep(20);
				robot.keyRelease(coverStringToKey(s));
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Bọ sẽ nhập vào chuổi ký tự vào JTextField (sẽ xóa trống ô trước khi nhập)
	 * @param txt Ô text
	 * @param str Chuổi ký tự
	 * @see #writeString(String)
	 * @see #writeString(JTextField, String, boolean)
	 */
	public static void writeString(JTextField txt, String str) {
		try {
			txt.setText("");
			Thread.sleep(50);
			writeString(txt, str, true);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Bọ sẽ nhập vào chuổi ký tự vào JTextField
	 * @param txt Ô text
	 * @param str Chuổi ký tự
	 * @param append True nếu viết tiếp vào JTextField, False nếu xóa trống JTextField
	 * @see #writeString(String)
	 * @see #writeString(JTextField, String)
	 */
	public static void writeString(JTextField txt, String str, boolean append) {
		try {
			if (append) {
				for (String s : str.split("")) {
					Thread.sleep(50);
					txt.setText(txt.getText().concat(s));
				}
				return;
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
		writeString(txt, str);
	}
	
	/**
	 * Bấm 1 key bất kỳ
	 * @param keyName Tên phím
	 */
	public static void keyPress(String keyName) {
		try {
			Thread.sleep(300);
			robot.keyPress(coverStringToKey(keyName));
			Thread.sleep(20);
			robot.keyRelease(coverStringToKey(keyName));
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Bấm nhiều key cùng lúc
	 * @param keyName Tên phím
	 */
	public static void keyPressMutil(String...keyName) {
		try {
			Thread.sleep(500);
			for (String s : keyName) {
				robot.keyPress(coverStringToKey(s));
			}
			Thread.sleep(20);
			for (String s : keyName) {
				robot.keyRelease(coverStringToKey(s));
			}
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public static void mouseMove(int x, int y) {
		robot.mouseMove(x, y);
	}
	
	public static void mouseClick() {
		try {
			Thread.sleep(30);
			robot.mousePress(KeyEvent.getMaskForButton(1));
			Thread.sleep(20);
			robot.mouseRelease(KeyEvent.getMaskForButton(1));
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}
