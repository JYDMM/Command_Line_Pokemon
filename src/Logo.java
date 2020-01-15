import static java.lang.Thread.sleep;

public class Logo {
    public static void version1() {
        System.out.println("______   ______   __    __  _________   __    __   _______   __    __  ");
        System.out.println("|     |  |     |  | |  / /  | _______| |  \\  /  |  |     |  |  \\   | |");
        System.out.println("|  |  |  | ||  |  | | / /   | |______  | |\\\\//| |  | ||  |  | |\\\\  | |");
        System.out.println("|-----|  | ||  |  | |/ /\\   | _______| | |    | |  | ||  |  | | \\\\ | | ");
        System.out.println("| |      | ||  |  | |/  \\\\  | |______  | |    | |  | ||  |  | |  \\\\| |");
        System.out.println("|_|      |_____|  |_|    \\\\ |________| |_|    |_|  |_____|  |_|   \\|_|");
        System.out.println("By Aliya Alsafa, Pyam Pendleton, and John Wallar");
    }

    public static void clear() {
        for (int i = 0; i < 40; i++) {
            System.out.println();
        }
    }
}
