import java.util.Scanner;

import static java.lang.Thread.sleep;

public class ChoseTeam extends Init {
    private static Pokemon[] User = new Pokemon[3];
    private static Pokemon[] Bot = new Pokemon[3];

    public static void team() throws InterruptedException {
        Scanner userIn = new Scanner(System.in);

        for (int i = 0; i < 3; i++) { // Make player1Poke1 switch to player1Poke2 after choosing first pokemon

            while (true) {
                Logo.clear();
                Logo.version1();
                System.out.println("\nSelect one to see stats!");
                for (int j = 0; j < ALL.length; j++) {
                    if (j % 3 == 0) System.out.print("\n"); // New line
                    System.out.print("(" + (j + 1) + ") " + ALL[j].Name() + " ".repeat(21 - (ALL[j].Name().length() + String.valueOf(j).length())));
                }

                System.out.println();
                String selector1 = userIn.nextLine();
                if (!selector1.isBlank() && selector1.matches("^[0-9]+$")) {
                    int selector1Int = Integer.parseInt(selector1.replaceAll("[\\D]", "")) - 1;
                    if (selector1Int >= 0 && selector1Int < ALL.length) {
                        if (info(ALL[selector1Int])) {
                            User[i] = ALL[selector1Int];
                            System.out.println("You have selected " + ALL[selector1Int].Name());
                            sleep(1000);
                        } else {
                            i -= 1;
                        }
                        break;
                    } else
                        {
                        System.out.println("Please enter a valid number!");
                        sleep(1500);
                    }
                } else
                    {
                    System.out.println("Please enter a valid number!");
                    sleep(1500);
                }
            }
        }

        Logo.version1();
        System.out.println("\nWould you like to start a battle?\n\n");
        String BattleCheck;

        while (true) {
            BattleCheck = userIn.nextLine();

            if (!BattleCheck.isBlank() && BattleCheck.toUpperCase().matches("[YN]")) {
                if (BattleCheck.contains("Y")) {
                    Battle.Main("test", User, "test", BotRandom());
                    break;
                } else {
                    Logo.version1();
                    System.out.println("\nI don't know what to tell you then!\n\n");
                }
            }
        }
    }

    private static boolean info(Pokemon poke) {
        while (true) {
            Logo.clear();
            Logo.version1();
            System.out.println("\nNumber: " + poke.ID());
            System.out.println("Name: " + poke.Name());
            System.out.println("Type: " + Type.getType(poke.Type()));
            System.out.println("HP: " + poke.HP());
            System.out.println("Select?  Y / N\n");
            Scanner Select = new Scanner(System.in);
            char selector2 = Select.nextLine().toUpperCase().charAt(0);
            if      (selector2 == 'Y') return true;
            else if (selector2 == 'N') return false;
        }
    }

    public static Pokemon[] BotRandom() {
        for (int i = 0; i <= 2; i++) Bot[i] = Init.ALL[(int)(Math.random() * (ALL.length - 1))];
        return Bot;
    }
}
