package Ex1;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/Ex1/ex1.xml");
        parseFile(file);
    }

    private static void parseFile(File file) {
        String newLine = "";
        String format = "%-12s%s%s%n";
        Pattern p = Pattern.compile("<(\\+?)(.*?)>(.*?)<");
        Matcher matcher = p.matcher(newLine);

        try (BufferedReader br = new BufferedReader(new FileReader(file));
            LineNumberReader lineReader = new LineNumberReader(br)) {

            while ((newLine = lineReader.readLine()) != null) {
                matcher.reset(newLine);
                if (matcher.find()) {
                    System.out.printf(format, matcher.group(2),":  ", matcher.group(3));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}