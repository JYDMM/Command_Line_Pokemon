import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Battle {
    public static void main(String[] args) throws InterruptedException {
        Main("John", new Pokemon[]{Init.Squirtle, Init.Bulbasaur, Init.Venusaur}, "test", ChoseTeam.BotRandom());
    }

    static void Start() throws InterruptedException {
        Main("John", new Pokemon[]{Init.Squirtle, Init.Bulbasaur, Init.Venusaur}, "test", ChoseTeam.BotRandom());
    }

    static void Main(String playerName, Pokemon[] Player1, String botName, Pokemon[] Player2) throws InterruptedException {
        System.out.println(Player1[0].Name() + " " + Player1[1].Name() + " " + Player1[2].Name());
        System.out.println(Player2[0].Name() + " " + Player2[1].Name() + " " + Player2[2].Name());
        Scanner userInput = new Scanner(System.in);
        byte[] ActPoke = {0, 0}; // integer which pokemon is currently selected & sets first pokemon
        int[] P1HP = {Player1[0].HP(), Player1[1].HP(), Player1[2].HP()};
        int[] P2HP = {Player2[0].HP(), Player2[1].HP(), Player2[2].HP()};
        int[] P1HPMax = {Player1[0].HP(), Player1[1].HP(), Player1[2].HP()};
        int[] P2HPMax = {Player2[0].HP(), Player2[1].HP(), Player2[2].HP()};

        boolean quit = false;

        while (!quit) {
            while (true) {
                String userIn;
                while (true) {
                    // Battle UI
                    Logo.clear();
                    scene(Player1, Player2, P1HP, P1HPMax, P2HP, P2HPMax, ActPoke);
                    // BOX
                    System.out.println("\n Choose your next action:");
                    System.out.println("-------------------------------------------");
                    System.out.println("|     (A)ttack           (B)ag            |");
                    System.out.println("|     (S)witch Pokemon   (Q)uit           |");
                    System.out.println("------------------------------------------- \n");
                    userIn = userInput.nextLine();

                    if (!userIn.isBlank() && userIn.matches("[aAbBsSqQ]")) break; // Tests for a proper character
                }

                if (userIn.charAt(0) == 'A' || userIn.charAt(0) == 'a') {

                    attack(Player1, Player2, P1HP, P1HPMax, P2HP, P2HPMax, ActPoke);
                    break;

                } else if (userIn.charAt(0) == 'B' || userIn.charAt(0) == 'b') {

                    scene(Player1, Player2, P1HP, P1HPMax, P2HP, P2HPMax, ActPoke);
                    System.out.println("\n Which item would you like to use");
                    System.out.println("-------------------------------------------");
                    System.out.println("|     (P)otion           Re(v)ive         |");
                    System.out.println("|     (S)witch Pokemon   (R)eturn         |");
                    System.out.println("------------------------------------------- \n");

                    System.out.println("This feature has not yet been implemented!");
                    // BAG
                } else if (userIn.charAt(0) == 'S' || userIn.charAt(0) == 's') {
                    System.out.println("This feature has not yet been implemented!");
                    // Switch Pokemon
                } else if (userIn.charAt(0) == 'Q' || userIn.charAt(0) == 'q') {
                    TitleScreen.Start();
                    quit = true;
                    break;
                }
            } // END outer while

            if (P2HP[ActPoke[1]] == 0) {             // Is pokemon dead - > Then replace or win
                scene(Player1, Player2, P1HP, P1HPMax, P2HP, P2HPMax, ActPoke);
                Box(Player2[ActPoke[1]].Name() + " has fainted!");
                sleep(2000);
                if (P2HP[0] == 0 && P2HP[1] == 0 && P2HP[2] == 0) {          // Was that the last pokemon
                    win();
                    break;
                } else { // Else send out next pokemon
                    ActPoke[1]++;
                    sceneP1Attack(Player1, Player2, P1HP, P1HPMax, P2HP, P2HPMax, ActPoke);
                    Box(botName + " sent out " + Player2[ActPoke[1]].Name() + "!");
                    sleep(1000);
                }
            }

/*------------------BOT ATTACK-----------------*/
            int botMove = (int) ((Math.random() * 4));
            String moveUsedToPrint = Player2[ActPoke[1]].Name() + " used " + Player2[ActPoke[1]].moves()[botMove].Name() + "!";
            P1HP[ActPoke[0]] =P1HP[ActPoke[0]] - Move.dmgDone(Player2[ActPoke[1]].moves()[botMove], Player1[ActPoke[0]], P1HP, ActPoke);

            System.out.println(Player1[ActPoke[0]] + ": " + P1HP[ActPoke[0]] + "  " + Player2[ActPoke[1]].Name() + ": " + Player2[ActPoke[1]].HP());

            sceneP2Attack(Player1, Player2, P1HP, P1HPMax, P2HP, P2HPMax, ActPoke);
            Box(moveUsedToPrint);
            sleep(1000);

            if (P1HP[ActPoke[0]] == 0) {
                scene(Player1, Player2, P1HP, P1HPMax, P2HP, P2HPMax, ActPoke);
                Box(Player1[ActPoke[0]].Name() + " has fainted!");
                sleep(1000);

                if (P1HP[0] == 0 && P1HP[1] == 0 && P1HP[2] == 0) { // if player was on last pokemon
                    lose();
                    break;
                } else {
                    String userIn;
                    while (true) {
                        System.out.println("\n Which Pokemon would you like to send out next?");
                        System.out.println("-------------------------------------------");
                        System.out.println("| (1) " + Player1[0].Name() + " " + P1HP[0] + "/" + P1HPMax[0] + " ".repeat(10 - (Player1[0].Name().length())) +
                                " (2) " + Player1[1].Name() + " " + P1HP[1] + "/" + P1HPMax[1] +" ".repeat(10 - Player1[1].Name().length()) + "|");
                        System.out.println("| (3) " + Player1[2].Name() + " " + P1HP[2] + "/" + P1HPMax[2] + " ".repeat(10 - Player1[2].Name().length()) +
                                "      " + " ".repeat(14) + "|");
                        System.out.println("------------------------------------------- \n");
                        userIn = userInput.nextLine();
                        if (!userIn.isBlank() && userIn.matches("[123]")) {

                            Logo.clear();
                            sceneP1Attack(Player1, Player2, P1HP, P1HPMax, P2HP, P2HPMax, ActPoke);
                            int userInInt = Integer.parseInt(userIn.replaceAll("[\\D]", ""));

                            if (P1HP[userInInt-1] == 0) {
                                        // This pokemon is dead.
                            } else {
                                ActPoke[0] = (byte) (userInInt - 1);
                                Box("You sent out " + Player1[ActPoke[0]].Name() + "!");
                                sleep(1000);
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void attack(Pokemon[] Player1, Pokemon[] Player2, int[] P1HP, int[] P1HPMax, int[] P2HP, int[] P2HPMax, byte[] ActPoke) throws InterruptedException {
        Scanner userInput = new Scanner(System.in);
        String userIn;
        while (true) {
            scene(Player1, Player2, P1HP, P1HPMax, P2HP, P2HPMax, ActPoke);
            System.out.println("\n What move do you want " + Player1[ActPoke[0]].Name() + " to use:");
            System.out.println("-------------------------------------------");
            System.out.println("|   (1) " + Player1[ActPoke[0]].moves()[0].Name() + " ".repeat(15 - Player1[ActPoke[0]].moves()[0].Name().length()) +
                    " (2) " + Player1[ActPoke[0]].moves()[1].Name() + " ".repeat(14 - Player1[ActPoke[0]].moves()[1].Name().length()) + "|");
            System.out.println("|   (3) " + Player1[ActPoke[0]].moves()[2].Name() + " ".repeat(14 - Player1[ActPoke[0]].moves()[2].Name().length()) +
                    "  (4) " + Player1[ActPoke[0]].moves()[3].Name() + " ".repeat(14 - Player1[ActPoke[0]].moves()[3].Name().length()) + "|");
            System.out.println("------------------------------------------- \n");

            userIn = userInput.nextLine();
            if (!userIn.isBlank() && userIn.matches("[1234]")) break;
        }

        // Scanner for which move
        int userInInt = Integer.parseInt(userIn.replaceAll("[\\D]", "")) - 1;

        String moveUsedToPrint = Player1[ActPoke[0]].Name() + " used " + Player1[ActPoke[0]].moves()[userInInt].Name() + "!";

        P2HP[ActPoke[1]] = P2HP[ActPoke[1]] - Move.dmgDone(Player1[ActPoke[0]].moves()[userInInt], Player2[ActPoke[1]], P2HP, ActPoke);

        sceneP1Attack(Player1, Player2, P1HP, P1HPMax, P2HP, P2HPMax, ActPoke);
        Box(moveUsedToPrint);
        sleep(1000);
        return;
    }

    private static void Box(String text) {
        System.out.println("\n" + text);
        System.out.println("-------------------------------------------");
        System.out.println("|                                         |");
        System.out.println("|                                         |");
        System.out.println("------------------------------------------- \n");
    }


    private static void scene(Pokemon[] Player1, Pokemon[] Player2, int[] P1HP, int[] P1HPMax, int[] P2HP, int[] P2HPMax, byte[] ActPoke) {
        Logo.clear();
        System.out.println("\n");
        System.out.println(" ".repeat(30) + Player2[ActPoke[1]].Name());
        System.out.println("                     \\o/      " + "\u9637".repeat(10 * P2HP[ActPoke[1]] / P2HPMax[ActPoke[1]])
                + P2HP[ActPoke[1]] + "/" + P2HPMax[ActPoke[1]] + "\n");
        System.out.println("              \\o/");
        System.out.println("  " + Player1[ActPoke[0]].Name());
        System.out.println("  " + "\u9637".repeat(10 * P1HP[ActPoke[0]] / P1HPMax[ActPoke[0]]) + P1HP[ActPoke[0]] + "/" + P1HPMax[ActPoke[0]]);
    }

    private static void sceneP1Attack(Pokemon[] Player1, Pokemon[] Player2, int[] P1HP, int[] P1HPMax, int[] P2HP, int[] P2HPMax, byte[] ActPoke) {
        Logo.clear();
        System.out.println("\n");
        System.out.println(" ".repeat(30) + Player2[ActPoke[1]].Name());
        System.out.println("                     \\o/      " + "\u9637".repeat(10 * P2HP[ActPoke[1]] / P2HPMax[ActPoke[1]])
                + P2HP[ActPoke[1]] + "/" + P2HPMax[ActPoke[1]] + "\n");
        System.out.println("              \\o\\");
        System.out.println("  " + Player1[ActPoke[0]].Name());
        System.out.println("  " + "\u9637".repeat(10 * P1HP[ActPoke[0]] / P1HPMax[ActPoke[0]]) + P1HP[ActPoke[0]] + "/" + P1HPMax[ActPoke[0]]);
    }

    private static void sceneP2Attack(Pokemon[] Player1, Pokemon[] Player2, int[] P1HP, int[] P1HPMax, int[] P2HP, int[] P2HPMax, byte[] ActPoke) {
        Logo.clear();
        System.out.println("\n");
        System.out.println(" ".repeat(30) + Player2[ActPoke[1]].Name());
        System.out.println("                     /o/      " + "\u9637".repeat(10 * P2HP[ActPoke[1]] / P2HPMax[ActPoke[1]])
                + P2HP[ActPoke[1]] + "/" + P2HPMax[ActPoke[1]] + "\n");
        System.out.println("              \\o/");
        System.out.println("  " + Player1[ActPoke[0]].Name());
        System.out.println("  " + "\u9637".repeat(10 * P1HP[ActPoke[0]] / P1HPMax[ActPoke[0]]) + P1HP[ActPoke[0]] + "/" + P1HPMax[ActPoke[0]]);
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
