package test.module;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

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
			default:
				break;
		}
		
		
		return -1;
	}
	
	/**
	 * Bọ sẽ nhập vào chuổi ký tự
	 * @param str Chuổi ký tự
	 * @throws InterruptedException Lỗi về luồng
	 */
	public static void writeString(String str) throws InterruptedException {
		for (String s : str.split("")) {
			robot.keyPress(coverStringToKey(s));
			Thread.sleep(50);
			robot.keyRelease(coverStringToKey(s));
		}
	}
	
	/**
	 * Bấm 1 key bất kỳ
	 * @param keyName Tên phím
	 * @throws InterruptedException Lỗi về xử lý luồng
	 */
	public static void keyClick(String keyName) throws InterruptedException {
		Thread.sleep(500);
		robot.keyPress(coverStringToKey(keyName));
		Thread.sleep(50);
		robot.keyRelease(coverStringToKey(keyName));
	}
	
	/**
	 * Bấm nhiều key cùng lúc
	 * @param keyName Tên phím
	 * @throws InterruptedException Lỗi về xử lý luồng
	 */
	public static void keyPressMutil(String...keyName) throws InterruptedException {
		Thread.sleep(500);
		for (String s : keyName) {
			robot.keyPress(coverStringToKey(s));
		}
		Thread.sleep(50);
		for (String s : keyName) {
			robot.keyRelease(coverStringToKey(s));
		}
	}
}
