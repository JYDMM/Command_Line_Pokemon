import java.util.Scanner;

// NEEDS Error control, otherwise DONE

public class TitleScreen {
    public static void Start(boolean debug) {
        Scanner titleScreenSelect = new Scanner(System.in);
        Logo.clear();
        Logo.version1();
        System.out.println();
        System.out.println("Quick (B)attle   (C)hose Team   Create (n)ew Pokemon");
        System.out.println("(S)ave           (i)nfo         (Q)uit");
        if (debug == false) { System.out.println("(P)okedex      Turn (D)ebug mode on");
        } else { System.out.println("(P)okedex      Turn (D)ebug mode off"); }
        System.out.println(); System.out.println(); System.out.println(); System.out.println();

        char selector = titleScreenSelect.nextLine().charAt(0);
        if (selector == 'B' || selector == 'b') {
            if (debug == true) {
                System.out.println("Going to battle!");
            }
            // GO TO BATTLE
        } else if (selector == 'C' || selector == 'c') {
            if (debug == true) {
                System.out.println("Going to Char Select!");
            }
            // Go to choseTeam
        } else if (selector == 'N' || selector == 'n') {
            if (debug == true) {
                System.out.println("Going to Chose Team!");
            }
            // GO to Pokemon
        } else if (selector == 'S' || selector == 's') {
            if (debug == true) {
                System.out.println("*WARNING* SAVE NOT YET IMPLEMENTED!");
            }
            // Execute Save
        } else if (selector == 'I' || selector == 'i') {
            info();
            selector = titleScreenSelect.nextLine().charAt(0);
            if (selector == 'r' || selector == 'R') {
                TitleScreen.Start(debug);
            }
        } else if (selector == 'Q' || selector == 'q') {
            if (debug == true) {
                System.out.println("Quitting");
            }
        } else if (selector == 'P' || selector == 'p') {
            if (debug == true) {
                System.out.println("Going to Pokedex");
            }
        }
        else if (selector == 'D' || selector == 'd') {
            if (debug == false) {
                System.out.println("Enabling Debug!");
                Start(true);
            } else {
                System.out.println("Disabling Debug! Goodbye my friend!");
                Start(false);
            }
        }
    }

    public static void info() {
        Logo.clear();
        Logo.version1();
        System.out.println();
        System.out.println();
        System.out.println("Copyright 2019-2020");
        System.out.println("Version: Alpha 1.0");
        System.out.println();
        System.out.println("                                             (r)eturn");
        System.out.println();
        System.out.println();
    }
}
