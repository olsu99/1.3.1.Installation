import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StringBuilder log = new StringBuilder();

        List<String> directory = new ArrayList<String>();
        directory.add("C://Games/scr");
        directory.add("C://Games/res");
        directory.add("C://Games/savegames");
        directory.add("C://Games/temp");

        directory.add("C://Games/scr/main");
        directory.add("C://Games/scr/test");

        directory.add("C://Games/res/drawables");
        directory.add("C://Games/res/vectors");
        directory.add("C://Games/res/icons");


        List<String> file = new ArrayList<String>();

        file.add("C://Games/scr/main/Main.java");
        file.add("C://Games/scr/main/Utils.java");

        file.add("C://Games/temp/temp.txt");

        makeDir(directory, log);
        makeFile(file, log);

        saveLog(log);
    }

    public static void makeDir(List<String> list, StringBuilder str) {
        for (String nameOfDirectory : list) {
            File createDirectory = new File(nameOfDirectory);
            if (createDirectory.mkdir()) {
                str.append("Директория " + nameOfDirectory + " создана" + "\n");
            } else {
                str.append("Директория " + nameOfDirectory + " не создана" + "\n");
            }
        }
    }

    public static void makeFile(List<String> list, StringBuilder str) {
        for (String nameOfFile : list) {
            File createFile = new File(nameOfFile);
            try {
                if (createFile.createNewFile()) {
                    str.append("Файл " + nameOfFile + " создан в директории" + "\n");
                } else {
                    str.append("Файл " + nameOfFile + " не создан в директории" + "\n");
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void saveLog(StringBuilder str) {
        try (FileWriter writer = new FileWriter("C://Games/temp/temp.txt")) {
            writer.write(String.valueOf(str));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
