package poro;

import poro.module.Mailer;

/**
 *
 * @author vinh
 */
public class MainClass {

    public static void main(String[] args) {
        Mailer mail = new Mailer("ngocntypc01187@fpt.edu.vn", "Test nè", "ko thì thôi");
        new Thread(mail).start();
    }
    
}
