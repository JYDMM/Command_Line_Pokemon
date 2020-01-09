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
        Scanner userInput = new Scanner(System.in);
        Pokemon[] activePoke = {Player1[0], Player2[0]}; // Sets first pokemon
        byte[] playerPokemon = {1, 1}; // integer which pokemon is currently selected & sets first pokemon
        int[] player1HP = {Player1[0].HP(), Player1[1].HP(), Player1[2].HP()};
        int[] player2HP = {Player2[0].HP(), Player2[1].HP(), Player2[2].HP()};
        int[] activePokeHP = {player1HP[0], player2HP[0]};
        int[] activePokeMaxHP = {Player1[0].HP(), Player2[0].HP()};
        boolean quit = false;

        while (!quit) {
            while (true) {
                String userIn;
                while (true) {
                    // Battle UI
                    Logo.clear();
                    scene(activePoke, activePokeMaxHP, activePokeHP);
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

                    attack(activePoke, activePokeHP, activePokeMaxHP);
                    break;

                } else if (userIn.charAt(0) == 'B' || userIn.charAt(0) == 'b') {

                    scene(activePoke, activePokeMaxHP, activePokeHP);
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





            if (activePoke[1].HP() == 0) {             // Is pokemon dead - > Then replace or win
                scene(activePoke, activePokeMaxHP, activePokeHP);
                Box(activePoke[1].Name() + " has fainted!");
                sleep(1000);
                if (playerPokemon[1] == 3) {          // Was that the last pokemon
                    win();
                    break;
                } else { // Else send out next pokemon
                    playerPokemon[1]++;
                    activePoke[1] = Player2[((int) playerPokemon[1] - 1)];
                    activePokeMaxHP[1] = player2HP[(int) playerPokemon[1] - 1];
                    activePoke[1].setHP(activePokeMaxHP[1]);

                    sceneP1Attack(activePoke, activePokeMaxHP, activePokeHP);
                    Box(botName + " sent out " + activePoke[1].Name() + "!");
                    sleep(1000);
                }
            }

            int botMove = (int) ((Math.random() * 4));
            String moveUsedToPrint = activePoke[1].Name() + " used " + activePoke[1].moves()[botMove].Name() + "!";
            activePoke[0].setHP(activePokeHP[0] - Move.dmgDone(activePoke[1].moves()[botMove], activePoke[0]));

            System.out.println(activePokeHP[0] + ": " + activePokeHP[0] + "  " + activePoke[1].Name() + ": " + activePoke[1].HP());

            sceneP2Attack(activePoke, activePokeMaxHP, activePokeHP);
            Box(moveUsedToPrint);
            sleep(1000);

            if (activePokeHP[0] == 0) {
                scene(activePoke, activePokeMaxHP, activePokeHP);
                Box(activePoke[0].Name() + " has fainted!");
                sleep(1000);

                if (playerPokemon[0] == 3) { // if player was on last pokemon
                    lose();
                    break;
                } else {
                    playerPokemon[0]++;
                    activePoke[0] = Player1[((int) playerPokemon[0] - 1)];
                    activePokeMaxHP[0] = player1HP[(int) playerPokemon[0] - 1];
                    activePoke[0].setHP(activePokeMaxHP[0]);

                    sceneP1Attack(activePoke, activePokeMaxHP, activePokeHP);
                    Box("You sent out " + activePoke[0].Name() + "!");
                    sleep(1000);
                }
            }
        }
    }

    private static void attack(Pokemon[] activePoke, int[] activePokeHP, int[] activePokeMaxHP) throws InterruptedException {
        Scanner userInput = new Scanner(System.in);
        String userIn;
        while (true) {
            scene(activePoke, activePokeMaxHP, activePokeHP);
            System.out.println("\n What move do you want " + activePoke[0].Name() + " to use:");
            System.out.println("-------------------------------------------");
            System.out.println("|   (1) " + activePoke[0].moves()[0].Name() + " ".repeat(15 - activePoke[0].moves()[0].Name().length()) +
                    " (2) " + activePoke[0].moves()[1].Name() + " ".repeat(14 - activePoke[0].moves()[1].Name().length()) + "|");
            System.out.println("|   (3) " + activePoke[0].moves()[2].Name() + " ".repeat(14 - activePoke[0].moves()[2].Name().length()) +
                    "  (4) " + activePoke[0].moves()[3].Name() + " ".repeat(14 - activePoke[0].moves()[3].Name().length()) + "|");
            System.out.println("------------------------------------------- \n");

            userIn = userInput.nextLine();
            if (!userIn.isBlank()) {
                if (userIn.matches("[1234]")) break; // this does not break but does not fix...
            }
        }

        // Scanner for which move
        int userInInt = Integer.parseInt(userIn.replaceAll("[\\D]", "")) - 1;

        String moveUsedToPrint = activePoke[0].Name() + " used " + activePoke[0].moves()[userInInt].Name() + "!";

        activePoke[1].setHP( (int) (activePoke[1].HP() - (Move.dmgDone(activePoke[0].moves()[userInInt], activePoke[1]))));

        sceneP1Attack(activePoke, activePokeMaxHP, activePokeHP);
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


    private static void scene(Pokemon[] activePoke, int[] activePokeMaxHP, int[] activePokeHP) {
        Logo.clear();
        System.out.println("\n");
        System.out.println(" ".repeat(30) + activePoke[1].Name());
        System.out.println("                     \\o/      " + "\u9637".repeat(10 * activePoke[1].HP() / activePokeMaxHP[1])
                + activePoke[1].HP() + "/" + activePokeMaxHP[1] + "\n");
        System.out.println("              \\o/");
        System.out.println("  " + activePoke[0].Name());
        System.out.println("  " + "\u9637".repeat(10 * activePokeHP[0] / activePokeMaxHP[0]) + activePokeHP[0] + "/" + activePokeMaxHP[0]);
    }

    private static void sceneP1Attack(Pokemon[] activePoke, int[] activePokeMaxHP, int[] activePokeHP) {
        Logo.clear();
        System.out.println("\n");
        System.out.println(" ".repeat(30) + activePoke[1].Name());
        System.out.println("                     \\o/      " + "\u9637".repeat(10 * activePoke[1].HP() / activePokeMaxHP[1])
                + activePoke[1].HP() + "/" + activePokeMaxHP[1] + "\n");
        System.out.println("              \\o\\");
        System.out.println("  " + activePoke[0].Name());
        System.out.println("  " + "\u9637".repeat(10 * activePokeHP[0] / activePokeMaxHP[0]) + activePokeHP[0] + "/" + activePokeMaxHP[0]);
    }

    private static void sceneP2Attack(Pokemon[] activePoke, int[] activePokeMaxHP, int[] activePokeHP) {
        Logo.clear();
        System.out.println("\n");
        System.out.println(" ".repeat(30) + activePoke[1].Name());
        System.out.println("                     /o/      " + "\u9637".repeat(10 * activePoke[1].HP() / activePokeMaxHP[1])
                + activePoke[1].HP() + "/" + activePokeMaxHP[1] + "\n");
        System.out.println("              \\o/");
        System.out.println("  " + activePoke[0].Name());
        System.out.println("  " + "\u9637".repeat(10 * activePokeHP[0] / activePokeMaxHP[0]) + activePokeHP[0] + "/" + activePokeMaxHP[0]);
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
