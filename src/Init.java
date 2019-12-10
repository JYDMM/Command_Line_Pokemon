import java.io.File;
import java.util.Scanner;

public class Init {
    public static void main(String[] args) throws Exception {
        File file =
                new File("C:\\Users\\Creep\\Documents\\Pokemon\\save.txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine())
            System.out.println(sc.nextLine());
    }
}
