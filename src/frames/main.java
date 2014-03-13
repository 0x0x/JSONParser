package frames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main extends JFrame implements ActionListener  {
    public  main(String name) {
        super(name);


        setPreferredSize(new Dimension(300, 400));

        JMenuBar menu = new JMenuBar();
        JMenu menuParts = new JMenu("Part I");
        JMenu jmiOpen = new JMenu("Lesson 1");
        JMenuItem jmiOpen1 = new JMenuItem("Part 13");
        jmiOpen1.addActionListener(this);

        jmiOpen.add(jmiOpen1);
        menuParts.add(jmiOpen);
        menu.add(menuParts);

        menuParts = new JMenu("Part II");
        menu.add(menuParts);

        setJMenuBar(menu);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());

    }
}
