package Ex5;

import Ex5.Class.Periodical;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

import static Ex5.Util.XMLParser.parse;

public class Main {
    public static void main(String[] args) {
        List<Periodical> periodicalList = null;
        File file = new File("src/Ex5/Files/ex1.xml");

        try {
            periodicalList = parse(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (Objects.nonNull(periodicalList)) {
            periodicalList.sort(Comparator.comparing((Periodical::getPages)));
            periodicalList.forEach(System.out::println);
        }
    }
}
