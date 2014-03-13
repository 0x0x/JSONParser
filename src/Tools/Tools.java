package Tools;

import Components.JmyMenuItem;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Tools {
    public static String fileRead(String fileName) throws IOException {
        StringBuilder res = new StringBuilder("");
        //Объект для чтения файла в буфер
        BufferedReader in = new BufferedReader(new FileReader(fileName));
        try {
            //В цикле построчно считываем файл
            String s;
            while ((s = in.readLine()) != null) {
                if (s.length() > 0) {
                    res.append(s);
                }
            }
        } finally {
            in.close();
        }
        return res.toString();
    }

    public static JMenuBar parseLessonsMenu(String json, ActionListener actList) throws org.json.simple.parser.ParseException {
        JMenuBar menu = new JMenuBar();
        JSONParser parser = new JSONParser();
        Object obj =  parser.parse(json);
        JSONObject jsonObj = (JSONObject) obj;

        JSONObject JSONmenu = (JSONObject) jsonObj.get("menu");
        JSONArray menuItems = (JSONArray) JSONmenu.get("menuItems");

        for (int i = 0; i < menuItems.size(); i++) {
            // тут получаем пункты Part1, Part2 ...
            JSONObject part = (JSONObject) menuItems.get(i);
            JMenu menuParts = new JMenu(part.get("-caption").toString());
            JSONArray themes = (JSONArray) part.get("themes");
            for (int j = 0; j < themes.size(); j++) {
                // тут получаем имена уроков: Everyday English
                JSONObject theme = (JSONObject) themes.get(j);
                JMenu menuTheme = new JMenu(theme.get("-caption").toString());
                JSONArray lessons = (JSONArray) theme.get("lessons");
                for (int k =0; k < lessons.size(); k++) {
                    // тут получаем имена уроков: Lesson1, Lesson2 ...
                    JSONObject lesson = (JSONObject) lessons.get(k);
                    JMenu menuLesson = new JMenu(lesson.get("-caption").toString());
                    JSONArray operations = (JSONArray) lesson.get("operations");
                    for (int l = 0; l < operations.size(); l++) {
                        // тут получаем операции: Operation 1 - 5
                        JSONObject operation = (JSONObject) operations.get(l);
                        JmyMenuItem menuOperation = new JmyMenuItem(operation.get("-caption").toString());
                        menuOperation.addActionListener(actList);
                        menuOperation.setFileName("!!!" + new Integer(i*1000+j*100+k*10+l).toString());
                        // тут дальше вытаскивать имена файлов, параметры для операций.

                        menuLesson.add(menuOperation);
                    }
                    menuTheme.add(menuLesson);
                }
                menuParts.add(menuTheme);
            }
            menu.add(menuParts);
        }

        return menu;
    }
}
