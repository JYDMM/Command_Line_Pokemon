import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws Exception {
        Logo.version1();
        System.out.println("\n\nWelcome to Command Line Pokemon!\nWe hope you enjoy the game!\n\n\n");
        sleep(1500);

        TitleScreen.Start();
    }
}
