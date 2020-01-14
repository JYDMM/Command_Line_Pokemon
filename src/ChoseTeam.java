import java.security.AllPermission;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class ChoseTeam extends Init {
    private static Pokemon[] User = new Pokemon[3];
    private static Pokemon[] Bot = new Pokemon[3];


    public static void Main() throws InterruptedException {
        Logo.clear();
        Logo.version1();
        team();

    }

    public static void team() throws InterruptedException {
        Scanner userIn = new Scanner(System.in);


// Make player1Poke1 switch to player1Poke2 after choosing first pokemon

        for (int i = 0; i < 3; i++) {
            Logo.clear();
            Logo.version1();
            System.out.println("\nSelect one to see stats!");
            System.out.println("(1)Bulbasaur     (2)Ivysaur      (3)Venusaur");
            System.out.println("(4)Charmander    (5)Charmeleon   (6)Charizard");
            System.out.println("(7)Squirtle      (8)Wartortle    (9)Blastoise");
            System.out.println("(10)Caterpie     (11)Metapod     (12)Butterfree");

            System.out.println();
            String selector1 = userIn.nextLine();
            int selector1Int;
            while (true) {
                selector1Int = Integer.parseInt(selector1.replaceAll("[\\D]", "")) - 1;

                if (info(ALL[selector1Int])) {
                    User[i] = ALL[selector1Int];
                    System.out.println("You have selected " + ALL[selector1Int].Name());
                    sleep(1000);
                    break;
                } else
                    team();
            }
        }

        Logo.version1();
        System.out.println("\nWould you like to start a battle?\n\n");
        String BattleCheck;
        while (true) {
            BattleCheck = userIn.nextLine();
            if (!BattleCheck.isBlank() && BattleCheck.matches("[YyNn]")) {
                if (BattleCheck.contains("Y") || BattleCheck.contains("y")) {
                    Battle.Main("test", User, "test", BotRandom());
                }

            }
        }
    }

    private static boolean info(Pokemon poke) {
        while (true) {
            System.out.println("Number: " + poke.ID());
            System.out.println("Name: " + poke.Name());
            System.out.println("Type: " + poke.Type());
            System.out.println("HP: " + poke.HP());
            System.out.println("Select?  Y / N");
            Scanner Select = new Scanner(System.in);
            char selector2 = Select.nextLine().charAt(0);
            if (selector2 == 'Y' || selector2 == 'y') {
                return true;
            } else if (selector2 == 'N' || selector2 == 'n') {
                return false;
            }
        }
    }

    public static Pokemon[] BotRandom() {
        for (int i = 0; i <= 2; i++) Bot[i] = Init.ALL[(int)(Math.random() * (ALL.length - 1))];
        return Bot;
    }

}
