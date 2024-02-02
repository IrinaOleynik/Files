import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    static Calendar c = new GregorianCalendar();

    public static void main(String[] args) {
        File src = new File("C://Users/User/Documents/Games/src");
        createDir(src);
        File res = new File("C://Users/User/Documents/Games/res");
        createDir(res);
        File savegames = new File("C://Users/User/Documents/Games/savegames");
        createDir(savegames);
        File temp = new File("C://Users/User/Documents/Games/temp");
        createDir(temp);

        File main = new File("C://Users/User/Documents/Games/src/main");
        createDir(main);
        File test = new File("C://Users/User/Documents/Games/src/test");
        createDir(test);

        File mainJava = new File("C://Users/User/Documents/Games/src/main", "Main.java");
        createFile(mainJava);
        File utilsJava = new File("C://Users/User/Documents/Games/src/main", "Utils.java");
        createFile(utilsJava);

        File drawables = new File("C://Users/User/Documents/Games/res/drawables");
        createDir(drawables);
        File vectors = new File("C://Users/User/Documents/Games/res/vectors");
        createDir(vectors);
        File icons = new File("C://Users/User/Documents/Games/res/icons");
        createDir(icons);

        File tempTxt = new File("C://Users/User/Documents/Games/temp", "temp.txt");
        createFile(tempTxt);
    }

    public static void createDir(File file) {
        log(file, file.mkdir());
    }

    public static void createFile(File file) {
        try {
            log(file, file.createNewFile());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void log(File file, boolean append) {
        StringBuilder sb = new StringBuilder();
        if (true) {
            sb.append(c.getTime() + " в каталоге " + file.getPath() + " успешно создан(а) " +
                    (file.isDirectory() ? "директория " : "файл ") + file.getName() + "\n");
        } else {
            sb.append(c.getTime() + "произошла ошибка при создании " + (file.isDirectory() ? "директории " : "файла ") +
                    file.getName() + " в каталоге " + file.getPath() + "\n");
        }
        try (FileWriter writer = new FileWriter("C://Users/User/Documents/Games/temp/temp.txt", true)) {
            writer.write(sb.toString());
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}