package frames;

import Components.JmyMenuItem;
import Tools.Tools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class main extends JFrame implements ActionListener  {
    public  main(String name) {
        super(name);

        setPreferredSize(new Dimension(1024, 600));
        setExtendedState(MAXIMIZED_BOTH);
        JMenuBar menu = null;
        try {
            String json = Tools.fileRead(System.getProperty("user.dir") + "\\Data\\" + "menu.json");
            menu = Tools.parseLessonsMenu(json, this);
        } catch (org.json.simple.parser.ParseException pe) {
            pe.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cann't parse menu: file is not valid!");
            System.exit(1);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Cann't parse menu: file not found!");
            System.exit(1);
        }
        setJMenuBar(menu);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JmyMenuItem clickedItem = (JmyMenuItem)e.getSource();
        System.out.println(clickedItem.getName() + ": " + clickedItem.getFileName());
    }
}
