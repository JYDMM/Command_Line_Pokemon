import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Battle {
    public static void main(String[] args) throws InterruptedException {
        //win();
        Main("John", new Pokemon[]{Init.Squirtle, Init.Bulbasaur, Init.Venusaur}, "test", ChoseTeam.BotRandom());
    }

    static void Start() throws InterruptedException {
        Main("John", new Pokemon[]{Init.Squirtle, Init.Bulbasaur, Init.Venusaur}, "test", ChoseTeam.BotRandom());
    }

    static void Main(String playerName, Pokemon[] Player1, String botName, Pokemon[] Player2) throws InterruptedException {
        Scanner userInput = new Scanner(System.in);
        Pokemon[] activePoke = {Player1[0], Player2[0]}; // Sets first pokemon

        byte[] playerPokemon = {1, 1}; // integer which pokemon is currently selected & sets first pokemon
        int[] maxPlayer1PokeHP = {Player1[0].HP(), Player1[1].HP(), Player1[2].HP()}; // Array of all player 1's pokemon
        int[] maxPlayer2PokeHP = {Player2[0].HP(), Player2[1].HP(), Player2[2].HP()}; // Array of all player 2's pokemon


        while (true) {
            int[] activePokeMaxHP = new int[2];
            // Max HP for active pokemon
            if (playerPokemon[0] == 1) {
                activePokeMaxHP[0] = maxPlayer1PokeHP[0];
            } else if (playerPokemon[0] == 2) {
                activePokeMaxHP[0] = maxPlayer1PokeHP[1];
            } else if (playerPokemon[0] == 3) {
                activePokeMaxHP[0] = maxPlayer1PokeHP[2];
            } else {
                activePokeMaxHP[0] = maxPlayer1PokeHP[0];
            }
            if (playerPokemon[1] == 1) {
                activePokeMaxHP[1] = maxPlayer2PokeHP[0];
            } else if (playerPokemon[1] == 2) {
                activePokeMaxHP[1] = maxPlayer2PokeHP[1];
            } else if (playerPokemon[1] == 3) {
                activePokeMaxHP[1] = maxPlayer2PokeHP[2];
            } else {
                activePokeMaxHP[1] = maxPlayer2PokeHP[0];
            }

                // Battle UI
            Logo.clear();
            scene(activePoke, activePokeMaxHP);
            // BOX
            System.out.println("\n Choose your next action:");
            System.out.println("-------------------------------------------");
            System.out.println("|   (A)ttack           (B)ag              |");
            System.out.println("|   (S)witch Pokemon   (Q)uit             |");
            System.out.println("------------------------------------------- \n");
            char userIn = userInput.nextLine().charAt(0);


            if (userIn == 'A' || userIn == 'a') {
                // Battle UI
                scene(activePoke, activePokeMaxHP);

                // Box of moves
                System.out.println("\n What move do you want " + activePoke[0].Name() + " to use:");
                System.out.println("-------------------------------------------");
                System.out.println("|   (1) " + activePoke[0].Move1().Name() + " ".repeat(15 - activePoke[0].Move1().Name().length()) +
                        " (2) " + activePoke[0].Move2().Name() + " ".repeat(14 - activePoke[0].Move2().Name().length()) + "|");
                System.out.println("|   (3) " + activePoke[0].Move3().Name() + " ".repeat(14 - activePoke[0].Move3().Name().length()) +
                        "  (4) " + activePoke[0].Move4().Name() + " ".repeat(14 - activePoke[0].Move4().Name().length()) + "|");
                System.out.println("------------------------------------------- \n");


                int userInInt = Integer.parseInt(userInput.nextLine().replaceAll("[\\D]", "")); // Scanner for which move
                String moveUsedToPrint = null;
                if (userInInt == 1) {
                    moveUsedToPrint = activePoke[0].Name() + " used " + activePoke[0].Move1().Name() + "!";
                    if (activePoke[1].HP() - (0.25 * Move.dmgDone(activePoke[0].Move1(), activePoke[1])) > 0){
                        activePoke[1].setHP((int) (activePoke[1].HP() - (0.25 * Move.dmgDone(activePoke[0].Move1(), activePoke[1]))));
                        System.out.println(activePoke[1].HP());
                    } else activePoke[1].setHP(0);

                } else if (userInInt == 2) {
                    moveUsedToPrint = activePoke[0].Name() + " used " + activePoke[0].Move2().Name() + "!";
                    if (activePoke[1].HP() - (0.25 * Move.dmgDone(activePoke[0].Move2(), activePoke[1])) > 0) {
                        activePoke[1].setHP((int) (activePoke[1].HP() - (0.25 * Move.dmgDone(activePoke[0].Move2(), activePoke[1]))));

                    } else activePoke[1].setHP(0);

                } else if (userInInt == 3) {
                    moveUsedToPrint = activePoke[0].Name() + " used " + activePoke[0].Move3().Name() + "!";
                    if (activePoke[1].HP() - (0.25 * Move.dmgDone(activePoke[0].Move3(), activePoke[1])) > 0) {
                        activePoke[1].setHP((int) (activePoke[1].HP() - (0.25 * Move.dmgDone(activePoke[0].Move3(), activePoke[1]))));

                    } else activePoke[1].setHP(0);

                } else if (userInInt == 4) {
                    moveUsedToPrint = activePoke[0].Name() + " used " + activePoke[0].Move4().Name() + "!";
                    if (activePoke[1].HP() - (0.25 * Move.dmgDone(activePoke[0].Move4(), activePoke[1])) > 0) {
                        activePoke[1].setHP((int) (activePoke[1].HP() - (0.25 * Move.dmgDone(activePoke[0].Move4(), activePoke[1]))));

                    } else activePoke[1].setHP(0);
                }

                sceneP1Attack(activePoke, activePokeMaxHP);
                System.out.println("\n" + moveUsedToPrint);
                System.out.println("-------------------------------------------");
                System.out.println("|                                         |");
                System.out.println("|                                         |");
                System.out.println("------------------------------------------- \n");
                sleep(1000);


            } else if (userIn == 'B' || userIn == 'b') {
                System.out.println("This feature has not yet been implemented!");
                // BAG
            } else if (userIn == 'S' || userIn == 's') {
                System.out.println("This feature has not yet been implemented!");
                // Switch Pokemon
            } else if (userIn == 'Q' || userIn == 'q') { TitleScreen.Start(); break; }

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
                    playerPokemon[1] ++;
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
                String moveUsedToPrint = null;
                int botMove = (int) Math.random() * 4 + 1;
                if (botMove == 1) {
                    moveUsedToPrint = activePoke[1].Name() + " used " + activePoke[1].Move1().Name() + "!";
                    if (activePoke[0].HP() - (0.25 * Move.dmgDone(activePoke[1].Move1(), activePoke[0])) > 0){
                        activePoke[0].setHP((int) (activePoke[0].HP() - (0.25 * Move.dmgDone(activePoke[1].Move1(), activePoke[0]))));
                        System.out.println(activePoke[1].HP());
                    } else activePoke[0].setHP(0);

                } else if (botMove == 2) {
                    moveUsedToPrint = activePoke[1].Name() + " used " + activePoke[1].Move2().Name() + "!";
                    if (activePoke[0].HP() - (0.25 * Move.dmgDone(activePoke[1].Move2(), activePoke[0])) > 0) {
                        activePoke[0].setHP((int) (activePoke[0].HP() - (0.25 * Move.dmgDone(activePoke[1].Move2(), activePoke[0]))));

                    } else activePoke[0].setHP(0);

                } else if (botMove == 3) {
                    moveUsedToPrint = activePoke[1].Name() + " used " + activePoke[1].Move3().Name() + "!";
                    if (activePoke[0].HP() - (0.25 * Move.dmgDone(activePoke[1].Move3(), activePoke[0])) > 0) {
                        activePoke[0].setHP((int) (activePoke[0].HP() - (0.25 * Move.dmgDone(activePoke[1].Move3(), activePoke[0]))));

                    } else activePoke[0].setHP(0);

                } else if (botMove == 4) {
                    moveUsedToPrint = activePoke[1].Name() + " used " + activePoke[1].Move4().Name() + "!";
                    if (activePoke[0].HP() - (0.25 * Move.dmgDone(activePoke[1].Move4(), activePoke[0])) > 0) {
                        activePoke[0].setHP((int) (activePoke[0].HP() - (0.25 * Move.dmgDone(activePoke[1].Move4(), activePoke[0]))));

                    } else activePoke[0].setHP(0);
                }


                sceneP2Attack(activePoke, activePokeMaxHP);
                System.out.println("\n" + moveUsedToPrint);
                System.out.println("-------------------------------------------");
                System.out.println("|                                         |");
                System.out.println("|                                         |");
                System.out.println("------------------------------------------- \n");
                sleep(1000);

            }
        }
    }

    private static void scene(Pokemon[] activePoke, int[] activePokeMaxHP) {
        Logo.clear();
        System.out.println("\n");
        System.out.println(" ".repeat(30) + activePoke[1].Name());
        System.out.println("                     \\o/      " + "\u9637".repeat(10 * activePoke[1].HP()/activePokeMaxHP[1])
                + activePoke[1].HP() + "/" + activePokeMaxHP[1] + "\n");
        System.out.println("              \\o/");
        System.out.println("  " + activePoke[0].Name());
        System.out.println("  " + "\u9637".repeat(10 * activePoke[0].HP()/activePokeMaxHP[0]) + activePoke[0].HP() + "/" + activePokeMaxHP[0]);
    }

    private static void sceneP1Attack(Pokemon[] activePoke, int[] activePokeMaxHP) {
        Logo.clear();
        System.out.println("\n");
        System.out.println(" ".repeat(30) + activePoke[1].Name());
        System.out.println("                     \\o/      " + "\u9637".repeat(10 * activePoke[1].HP()/activePokeMaxHP[1])
                + activePoke[1].HP() + "/" + activePokeMaxHP[1] + "\n");
        System.out.println("              \\o\\");
        System.out.println("  " + activePoke[0].Name());
        System.out.println("  " + "\u9637".repeat(10 * activePoke[0].HP()/activePokeMaxHP[0]) + activePoke[0].HP() + "/" + activePokeMaxHP[0]);
    }
    private static void sceneP2Attack(Pokemon[] activePoke, int[] activePokeMaxHP) {
        Logo.clear();
        System.out.println("\n");
        System.out.println(" ".repeat(30) + activePoke[1].Name());
        System.out.println("                     /o/      " + "\u9637".repeat(10 * activePoke[1].HP()/activePokeMaxHP[1])
                + activePoke[1].HP() + "/" + activePokeMaxHP[1] + "\n");
        System.out.println("              \\o/");
        System.out.println("  " + activePoke[0].Name());
        System.out.println("  " + "\u9637".repeat(10 * activePoke[0].HP()/activePokeMaxHP[0]) + activePoke[0].HP() + "/" + activePokeMaxHP[0]);
    }

    private static void win() {
        Logo.clear();
        System.out.println("__    __    ______    __    __       __        ____       __   ___________    ___     ___");
        System.out.println("\\ \\  / /   |     |   |  |  |  |      \\ \\      / /\\ \\      / /  |____  ____|   | |\\    | |");
        System.out.println(" \\ \\/ /    | ||  |   |  |  |  |       \\ \\    / /  \\ \\    / /       |  |       | |\\\\   | |");
        System.out.println("  \\  /     | ||  |   |  |  |  |        \\ \\  / /    \\ \\  / /        |  |       | | \\\\  | |");
        System.out.println("  | |      | ||  |   |  |__|  |         \\ \\/ /      \\ \\/ /    _____|  |____   | |  \\\\ | |");
        System.out.println("  |_|      |_||__|   |________|          \\__/        \\__/     |____________|  |_|   \\\\|_|");
    }
}
