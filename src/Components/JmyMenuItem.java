package Components;

import javax.swing.*;

// наследовал стандартный класс, чтобы в нем хранить путь к файлу урока.
// Может еще что-то надо будет сюда запихнуть.
public class JmyMenuItem extends JMenuItem {
    private String fileName;

    public JmyMenuItem(String text) {
        super(text);
    }

    public JmyMenuItem(String text, Icon icon) {
        super(text, icon);
    }

    public JmyMenuItem(Action a) {
        super(a);
    }

    public JmyMenuItem(String text, int mnemonic) {
        super(text, mnemonic);
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
