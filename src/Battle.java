import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Battle {
    public static void main() throws InterruptedException {
        Main("John", new Pokemon[]{Init.Squirtle, Init.Bulbasaur, Init.Venusaur}, "test", ChoseTeam.BotRandom());
    }

    static void Main(String playerName, Pokemon[] Player1, String botName, Pokemon[] Player2) throws InterruptedException {
        Pokemon[] P1 = new Pokemon[] {
                new Pokemon(Player1[0].ID(), Player1[0].Name(), Player1[0].Type(), Player1[0].HP(), Player1[0].MaxHP(), Player1[0].moves()),
                new Pokemon(Player1[1].ID(), Player1[1].Name(), Player1[1].Type(), Player1[1].HP(), Player1[1].MaxHP(), Player1[1].moves()),
                new Pokemon(Player1[2].ID(), Player1[2].Name(), Player1[2].Type(), Player1[2].HP(), Player1[2].MaxHP(), Player1[2].moves()),
        };
        Pokemon[] P2 = new Pokemon[] {
                new Pokemon(Player2[0].ID(), Player2[0].Name(), Player2[0].Type(), Player2[0].HP(), Player2[0].MaxHP(), Player2[0].moves()),
                new Pokemon(Player2[1].ID(), Player2[1].Name(), Player2[1].Type(), Player2[1].HP(), Player2[1].MaxHP(), Player2[1].moves()),
                new Pokemon(Player2[2].ID(), Player2[2].Name(), Player2[2].Type(), Player2[2].HP(), Player2[2].MaxHP(), Player2[2].moves()),
        };
        Scanner userInput = new Scanner(System.in);
        byte[] ActPoke = {0, 0}; // integer which pokemon is currently selected & sets first pokemon

        while (true) {
            String userIn;
            while (true) {
                // Battle UI
                Logo.clear();
                scene(Player1, Player2, ActPoke);
                System.out.println("\n Choose your next action:");
                System.out.println("-------------------------------------------");
                System.out.println("|     (A)ttack           (B)ag            |");
                System.out.println("|     (S)witch Pokemon   (Q)uit           |");
                System.out.println("------------------------------------------- \n");
                userIn = userInput.nextLine();

                if (!userIn.isBlank() && userIn.matches("[aAbBsSqQ]")) break; // Tests for a proper character
            }

            if (userIn.toUpperCase().charAt(0) == 'A') {

                attack(P1, P2, ActPoke);
                break;

            } else if (userIn.toUpperCase().charAt(0) == 'B') {
                Bag(P1, P2, ActPoke);
                break;
            } else if (userIn.toUpperCase().charAt(0) == 'S') {
                System.out.println("This feature has not yet been implemented!");
                // Switch Pokemon
            } else if (userIn.toUpperCase().charAt(0) == 'Q') {
                TitleScreen.Start();
                break;
            }

            if (P2[ActPoke[1]].HP() == 0) {             // Is pokemon dead - > Then replace or win
                scene(P1, P2, ActPoke);
                Box(Player2[ActPoke[1]].Name() + " has fainted!");
                sleep(2000);
                if (P2[0].HP() == 0 && P2[1].HP() == 0 && P2[2].HP() == 0) {          // Was that the last pokemon
                    win();
                    break;
                } else { // Else send out next pokemon
                    ActPoke[1]++;
                    sceneP1Attack(P1, P2, ActPoke);
                    Box(botName + " sent out " + Player2[ActPoke[1]].Name() + "!");
                    sleep(1000);
                }
            }

/*------------------BOT ATTACK-----------------*/
            int botMove = (int) ((Math.random() * 4));
            String moveUsedToPrint = Player2[ActPoke[1]].Name() + " used " + Player2[ActPoke[1]].moves()[botMove].Name() + "!";
            P1[ActPoke[0]].subHP(Move.dmgDone(Player2[ActPoke[1]].moves()[botMove], Player1[ActPoke[0]]));

            System.out.println(Player1[ActPoke[0]] + ": " + P1[ActPoke[0]].HP() + "  " + Player2[ActPoke[1]].Name() + ": " + Player2[ActPoke[1]].HP());

            sceneP2Attack(P1, P2, ActPoke);
            Box(moveUsedToPrint);
            sleep(1000);

            if (P1[ActPoke[0]].HP() == 0) {
                scene(P1, P2, ActPoke);
                Box(Player1[ActPoke[0]].Name() + " has fainted!");
                sleep(1000);

                if (P1[0].HP() == 0 && P1[1].HP() == 0 && P1[2].HP() == 0) { // if player was on last pokemon
                    lose();
                    break;
                } else {
                    while (true) {
                        System.out.println("\n Which Pokemon would you like to send out next?");
                        System.out.println("-------------------------------------------");
                        System.out.println("| (1) " + P1[0].Name() + " " + P1[0].HP() + "/" + P1[0].MaxHP() + " ".repeat(10 - (Player1[0].Name().length())) +
                                " (2) " + P1[1].Name() + " " + P1[1].HP() + "/" + P1[1].MaxHP() +" ".repeat(10 - Player1[1].Name().length()) + "|");
                        System.out.println("| (3) " + P1[2].Name() + " " + P1[2].HP() + "/" + P1[2].MaxHP() + " ".repeat(10 - Player1[2].Name().length()) +
                                "      " + " ".repeat(14) + "|");
                        System.out.println("------------------------------------------- \n");
                        userIn = userInput.nextLine();
                        if (!userIn.isBlank() && userIn.matches("[123]")) {

                            Logo.clear();
                            sceneP1Attack(P1, P2, ActPoke);
                            int userInInt = Integer.parseInt(userIn.replaceAll("[\\D]", ""));

                            if (P1[userInInt-1].HP() == 0) { // ??????
                                        // This pokemon is dead.
                            } else {
                                ActPoke[0] = (byte) (userInInt - 1);
                                Box("You sent out " + P1[ActPoke[0]].Name() + "!");
                                sleep(1000);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void attack(Pokemon[] P1, Pokemon[] P2, byte[] ActPoke) throws InterruptedException {
        Scanner userInput = new Scanner(System.in);
        String userIn = "";
        while (userIn.isBlank() || !userIn.matches("[1234]")) {
            /* --------------- Character Chose move --------------- */
            scene(P1, P2, ActPoke);
            System.out.println("\n What move do you want " + P1[ActPoke[0]].Name() + " to use:");
            System.out.println("-------------------------------------------");
            System.out.println("|   (1) " + P1[ActPoke[0]].moves()[0].Name() + " ".repeat(15 - P1[ActPoke[0]].moves()[0].Name().length()) +
                    " (2) " + P1[ActPoke[0]].moves()[1].Name() + " ".repeat(14 - P1[ActPoke[0]].moves()[1].Name().length()) + "|");
            System.out.println("|   (3) " + P1[ActPoke[0]].moves()[2].Name() + " ".repeat(14 - P1[ActPoke[0]].moves()[2].Name().length()) +
                    "  (4) " + P1[ActPoke[0]].moves()[3].Name() + " ".repeat(14 - P1[ActPoke[0]].moves()[3].Name().length()) + "|");
            System.out.println("------------------------------------------- \n");
            userIn = userInput.nextLine();
            // if (!userIn.isBlank() && userIn.matches("[1234]")) break; Moved this to inside the while loop
        }

        int userInInt = Integer.parseInt(userIn.replaceAll("[\\D]", "")) - 1;

        String moveUsedToPrint = P1[ActPoke[0]].Name() + " used " + P1[ActPoke[0]].moves()[userInInt].Name() + "!";
        P2[ActPoke[1]].subHP(Move.dmgDone(P1[ActPoke[0]].moves()[userInInt], P2[ActPoke[1]]));
        sceneP1Attack(P1, P2, ActPoke);
        Box(moveUsedToPrint);
        sleep(1000);
    }
    private static void Bag(Pokemon[] P1, Pokemon[] P2, byte[] ActPoke) {
        scene(P1, P2, ActPoke);
        System.out.println("\n Which item would you like to use");
        System.out.println("-------------------------------------------");
        System.out.println("|     (P)otion           Re(v)ive         |");
        System.out.println("|     (S)witch Pokemon   (R)eturn         |");
        System.out.println("------------------------------------------- \n");
    }

    private static void Box(String text) {
        System.out.println("\n" + text);
        System.out.println("-------------------------------------------");
        System.out.println("|                                         |");
        System.out.println("|                                         |");
        System.out.println("------------------------------------------- \n");
    }

    private static void scene(Pokemon[] P1, Pokemon[] P2, byte[] ActPoke) {
        Logo.clear();
        System.out.println("\n");
        System.out.println(" ".repeat(30) + P2[ActPoke[1]].Name());
        System.out.println("                     \\o/      " + "\u9637".repeat(10 * P2[ActPoke[1]].HP() / P2[ActPoke[1]].MaxHP())
                + P2[ActPoke[1]].HP() + "/" + P2[ActPoke[1]].MaxHP() + "\n");
        System.out.println("              \\o/");
        System.out.println("  " + P1[ActPoke[0]].Name());
        System.out.println("  " + "\u9637".repeat(10 * P1[ActPoke[0]].HP() / P1[ActPoke[0]].MaxHP()) + P1[ActPoke[0]].HP() + "/" + P1[ActPoke[0]].MaxHP());
    }

    private static void sceneP1Attack(Pokemon[] P1, Pokemon[] P2, byte[] ActPoke) {
        Logo.clear();
        System.out.println("\n");
        System.out.println(" ".repeat(30) + P2[ActPoke[1]].Name());
        System.out.println("                     \\o/      " + "\u9637".repeat(10 * P2[ActPoke[1]].HP() / P2[ActPoke[1]].MaxHP())
                + P2[ActPoke[1]].HP() + "/" + P2[ActPoke[1]].MaxHP() + "\n");
        System.out.println("              \\o\\");
        System.out.println("  " + P1[ActPoke[0]].Name());
        System.out.println("  " + "\u9637".repeat(10 * P1[ActPoke[0]].HP() / P1[ActPoke[0]].MaxHP()) + P1[ActPoke[0]].HP() + "/" + P1[ActPoke[0]].MaxHP());
    }

    private static void sceneP2Attack(Pokemon[] P1, Pokemon[] P2, byte[] ActPoke) {
        Logo.clear();
        System.out.println("\n");
        System.out.println(" ".repeat(30) + P2[ActPoke[1]].Name());
        System.out.println("                     /o/      " + "\u9637".repeat(10 * P2[ActPoke[1]].HP() / P2[ActPoke[1]].MaxHP())
                + P2[ActPoke[1]].HP() + "/" + P2[ActPoke[1]].MaxHP() + "\n");
        System.out.println("              \\o/");
        System.out.println("  " + P1[ActPoke[0]].Name());
        System.out.println("  " + "\u9637".repeat(10 * P1[ActPoke[0]].HP() / P1[ActPoke[0]].MaxHP()) + P1[ActPoke[0]].HP() + "/" + P1[ActPoke[0]].MaxHP());
    }

    private static void win() throws InterruptedException {
        Logo.clear();
        System.out.println("__    __    ______    __    __       __        ____       __   ___________    ___     ___");
        System.out.println("\\ \\  / /   |     |   |  |  |  |      \\ \\      / /\\ \\      / /  |____  ____|   | |\\    | |");
        System.out.println(" \\ \\/ /    | ||  |   |  |  |  |       \\ \\    / /  \\ \\    / /       |  |       | |\\\\   | |");
        System.out.println("  \\  /     | ||  |   |  |  |  |        \\ \\  / /    \\ \\  / /        |  |       | | \\\\  | |");
        System.out.println("  | |      | ||  |   |  |__|  |         \\ \\/ /      \\ \\/ /    _____|  |____   | |  \\\\ | |");
        System.out.println("  |_|      |_||__|   |________|          \\__/        \\__/     |____________|  |_|   \\\\|_|");
        sleep(2500);
    }

    private static void lose() throws InterruptedException {
        Logo.clear();
        System.out.println("__    __    ______    __    __        ___          ______    _______     ________    __");
        System.out.println("\\ \\  / /   |     |   |  |  |  |      |  |         |     |   |  _____|   |  _____|   | |");
        System.out.println(" \\ \\/ /    | ||  |   |  |  |  |      |  |         | ||  |   |  |____    |  |____    | |");
        System.out.println("  \\  /     | ||  |   |  |  |  |      |  |         | ||  |   |____   |   |   ____|   | |");
        System.out.println("  | |      | ||  |   |  |__|  |      |  |______   | ||  |    ____|  |   |  |____     __");
        System.out.println("  |_|      |_____|   |________|      |________|   |_____|   |_______|   |_______|   |_|");
        sleep(2500);
    }
}
