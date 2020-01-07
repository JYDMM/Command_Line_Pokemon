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
        int[] activePokeMaxHP = {Player1[0].HP(), Player2[0].HP()};

        while (true) {

            // Battle UI
            Logo.clear();
            scene(activePoke, activePokeMaxHP);
            // BOX
            System.out.println("\n Choose your next action:");
            System.out.println("-------------------------------------------");
            System.out.println("|   (A)ttack           (B)ag              |");
            System.out.println("|   (S)witch Pokemon   (Q)uit             |");
            System.out.println("------------------------------------------- \n");
            String userIn;

            while (true) {
                userIn = userInput.nextLine();
                if (!userIn.isBlank()) {                                        // Makes sure that something is input
                    if (userIn.matches(".*[aAbBsSqQ]*.")) {
                        System.out.println("[INFO] Attack worked");
                        break;         // Makes sure that a proper character is input // this does not break but does not fix...
                    }
                }
            }

            if (userIn.charAt(0) == 'A' || userIn.charAt(0) == 'a') {
                // Battle UI
                scene(activePoke, activePokeMaxHP);

                // Box of moves
                System.out.println("\n What move do you want " + activePoke[0].Name() + " to use:");
                System.out.println("-------------------------------------------");
                System.out.println("|   (1) " + activePoke[0].moves()[0].Name() + " ".repeat(15 - activePoke[0].moves()[0].Name().length()) +
                        " (2) " + activePoke[0].moves()[1].Name() + " ".repeat(14 - activePoke[0].moves()[1].Name().length()) + "|");
                System.out.println("|   (3) " + activePoke[0].moves()[2].Name() + " ".repeat(14 - activePoke[0].moves()[2].Name().length()) +
                        "  (4) " + activePoke[0].moves()[3].Name() + " ".repeat(14 - activePoke[0].moves()[3].Name().length()) + "|");
                System.out.println("------------------------------------------- \n");


                int userInInt;
                while (true) {
                    userIn = userInput.nextLine();
                    if (!userIn.isBlank()) {
                        if (userIn.matches(".*[1234]*.")) break; // this does not break but does not fix...
                    }
                }

                userInInt = Integer.parseInt(userIn.replaceAll("[\\D]", "")) - 1; // Scanner for which move

                String moveUsedToPrint = activePoke[0].Name() + " used " + activePoke[0].moves()[userInInt].Name() + "!";
                if (activePoke[1].HP() - (0.25 * Move.dmgDone(activePoke[0].moves()[userInInt], activePoke[1])) > 0) {
                    activePoke[1].setHP( (int) (activePoke[1].HP() - (0.25 * Move.dmgDone(activePoke[0].moves()[userInInt], activePoke[1]))));
                    System.out.println(activePoke[1].HP());
                } else activePoke[1].setHP(0);



                sceneP1Attack(activePoke, activePokeMaxHP);
                System.out.println("\n" + moveUsedToPrint);
                System.out.println("-------------------------------------------");
                System.out.println("|                                         |");
                System.out.println("|                                         |");
                System.out.println("------------------------------------------- \n");
                sleep(1000);


            } else if (userIn.charAt(0) == 'B' || userIn.charAt(0) == 'b') {
                System.out.println("This feature has not yet been implemented!");
                // BAG
            } else if (userIn.charAt(0) == 'S' || userIn.charAt(0) == 's') {
                System.out.println("This feature has not yet been implemented!");
                // Switch Pokemon
            } else if (userIn.charAt(0) == 'Q' || userIn.charAt(0) == 'q') {
                TitleScreen.Start();
                break;
            }

            // Is pokemon dead - > Then replace or win
            if (activePoke[1].HP() == 0) {
                scene(activePoke, activePokeMaxHP);
                System.out.println("\n" + activePoke[1].Name() + " has fainted!");
                System.out.println("-------------------------------------------");
                System.out.println("|                                         |");
                System.out.println("|                                         |");
                System.out.println("------------------------------------------- \n");
                sleep(1000);

                if (playerPokemon[1] == 3) {
                    win();
                    break;
                } else {
                    playerPokemon[1]++;
                    activePoke[1] = Player2[((int) playerPokemon[1] - 1)];
                    activePokeMaxHP[1] = Player2[(int) playerPokemon[1] - 1].HP();

                    sceneP1Attack(activePoke, activePokeMaxHP);
                    System.out.println("\n" + botName + " sent out " + activePoke[1].Name() + "!");
                    System.out.println("-------------------------------------------");
                    System.out.println("|                                         |");
                    System.out.println("|                                         |");
                    System.out.println("------------------------------------------- \n");
                    sleep(1000);
                }
            }

            int botMove = (int) ((Math.random() * 4) + 1);
            String moveUsedToPrint = activePoke[1].Name() + " used " + activePoke[1].moves()[botMove].Name() + "!";
            if (activePoke[0].HP() - (0.25 * Move.dmgDone(activePoke[1].moves()[botMove], activePoke[0])) > 0) {
                activePoke[0].setHP((int) (activePoke[0].HP() - (0.25 * Move.dmgDone(activePoke[1].moves()[botMove], activePoke[0]))));
                System.out.println(activePoke[1].HP());
            } else activePoke[0].setHP(0);


            sceneP2Attack(activePoke, activePokeMaxHP);
            System.out.println("\n" + moveUsedToPrint);
            System.out.println("-------------------------------------------");
            System.out.println("|                                         |");
            System.out.println("|                                         |");
            System.out.println("------------------------------------------- \n");
            sleep(1000);

            if (activePoke[0].HP() == 0) {
                scene(activePoke, activePokeMaxHP);
                System.out.println("\n" + activePoke[0].Name() + " has fainted!");
                System.out.println("-------------------------------------------");
                System.out.println("|                                         |");
                System.out.println("|                                         |");
                System.out.println("------------------------------------------- \n");
                sleep(1000);

                if (playerPokemon[0] == 3) { // if player was on last pokemon
                    lose();
                    break;
                } else {
                    playerPokemon[0]++;
                    activePoke[0] = Player1[((int) playerPokemon[0] - 1)];
                    activePokeMaxHP[0] = Player1[(int) playerPokemon[0] - 1].HP();

                    sceneP1Attack(activePoke, activePokeMaxHP);
                    System.out.println("\nYou sent out " + activePoke[0].Name() + "!");
                    System.out.println("-------------------------------------------");
                    System.out.println("|                                         |");
                    System.out.println("|                                         |");
                    System.out.println("------------------------------------------- \n");
                    sleep(1000);
                }
            }
        }
    }

    private static void scene(Pokemon[] activePoke, int[] activePokeMaxHP) {
        Logo.clear();
        System.out.println("\n");
        System.out.println(" ".repeat(30) + activePoke[1].Name());
        System.out.println("                     \\o/      " + "\u9637".repeat(10 * activePoke[1].HP() / activePokeMaxHP[1])
                + activePoke[1].HP() + "/" + activePokeMaxHP[1] + "\n");
        System.out.println("              \\o/");
        System.out.println("  " + activePoke[0].Name());
        System.out.println("  " + "\u9637".repeat(10 * activePoke[0].HP() / activePokeMaxHP[0]) + activePoke[0].HP() + "/" + activePokeMaxHP[0]);
    }

    private static void sceneP1Attack(Pokemon[] activePoke, int[] activePokeMaxHP) {
        Logo.clear();
        System.out.println("\n");
        System.out.println(" ".repeat(30) + activePoke[1].Name());
        System.out.println("                     \\o/      " + "\u9637".repeat(10 * activePoke[1].HP() / activePokeMaxHP[1])
                + activePoke[1].HP() + "/" + activePokeMaxHP[1] + "\n");
        System.out.println("              \\o\\");
        System.out.println("  " + activePoke[0].Name());
        System.out.println("  " + "\u9637".repeat(10 * activePoke[0].HP() / activePokeMaxHP[0]) + activePoke[0].HP() + "/" + activePokeMaxHP[0]);
    }

    private static void sceneP2Attack(Pokemon[] activePoke, int[] activePokeMaxHP) {
        Logo.clear();
        System.out.println("\n");
        System.out.println(" ".repeat(30) + activePoke[1].Name());
        System.out.println("                     /o/      " + "\u9637".repeat(10 * activePoke[1].HP() / activePokeMaxHP[1])
                + activePoke[1].HP() + "/" + activePokeMaxHP[1] + "\n");
        System.out.println("              \\o/");
        System.out.println("  " + activePoke[0].Name());
        System.out.println("  " + "\u9637".repeat(10 * activePoke[0].HP() / activePokeMaxHP[0]) + activePoke[0].HP() + "/" + activePokeMaxHP[0]);
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
