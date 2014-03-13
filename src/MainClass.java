import frames.main;

import javax.swing.*;

public class MainClass {
    public static void main(String []args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame bookFrame = new main("mainWindow");
                bookFrame.pack();
                bookFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                bookFrame.setVisible(true);
            }
        });
    }
}
