import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Battle {
    public static void main(String[] args) throws InterruptedException {
        Main("John", new Pokemon[]{Init.Squirtle, Init.Bulbasaur, Init.Beedrill}, "test", ChoseTeam.BotRandom());

        // Box("This is text", "text 1", "text 2", "text 3", "text 4");
    }
    public static void main() throws InterruptedException {
        Main("John", new Pokemon[]{Init.Squirtle, Init.Bulbasaur, Init.Beedrill}, "test", ChoseTeam.BotRandom());
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
/*------------------First Screen-----------------*/

            do {
                Logo.clear();
                scene(P1, P2, ActPoke);
                Box("\nChoose your next action:", "(A)ttack", "(B)ag", "(S)witch Pokemon", "(Q)uit");
                userIn = userInput.nextLine();

            } while (userIn.isBlank() || !userIn.toUpperCase().matches("[ABSQ]"));
            switch(userIn.charAt(0)) {
                case 'A':
                    attack(P1, P2, ActPoke);
                    break;
                case 'B':
                    Bag(P1, P2, ActPoke);
                    break;
                case 'S':
                    System.out.println("\n Which Pokemon would you like to send out?");
                    if (switchPokemon(P1, P2, ActPoke)) break;
                case 'Q':
                    TitleScreen.Start();
                    break;
            }


/*------------------Did Player Kill Opponent Pokemon-----------------*/
            if (P2[ActPoke[1]].HP() == 0) {
                scene(P1, P2, ActPoke);
                Box(P2[ActPoke[1]].Name() + " has fainted!");
                sleep(2000);

                if (P2[0].HP() == 0 && P2[1].HP() == 0 && P2[2].HP() == 0) {
                    win();
                    break;

                } else {
                    ActPoke[1]++;
                    sceneP1Attack(P1, P2, ActPoke);
                    Box(botName + " sent out " + P2[ActPoke[1]].Name() + "!");
                    sleep(1000);
                }
            }

/*--------------------------BOT ATTACK-------------------------------*/
            int botMove = (int) ((Math.random() * 4));
            while (P2[ActPoke[1]].moves()[botMove].IndexNumber() == 0) { // if move chosen is null
                botMove = (int) ((Math.random() * 4));
            }

            String mvPrint = P2[ActPoke[1]].Name() + " used " + P2[ActPoke[1]].moves()[botMove].Name() + "!";
            P1[ActPoke[0]].subHP(Move.dmgDone(P2[ActPoke[1]].moves()[botMove], P1[ActPoke[0]]));
            if (P1[ActPoke[0]].HP() < 0) P1[ActPoke[0]].setHP(0); //If attacked pokemon HP is less than zero

            sceneP2Attack(P1, P2, ActPoke);
            Box(mvPrint);
            sleep(1250);


/*----------------------Did BOT kill Player Pokemon--------------------*/
            if (P1[ActPoke[0]].HP() == 0) {
                System.out.println("[INFO] [POINT D1]: P1 Active is Dead" + P1[ActPoke[0]] + " " + P1[ActPoke[0]] + ": " + P1[ActPoke[0]].HP());
                scene(P1, P2, ActPoke);
                Box(P1[ActPoke[0]].Name() + " has fainted!");
                sleep(1000);

                if (P1[0].HP() == 0 && P1[1].HP() == 0 && P1[2].HP() == 0) { // Was last player pokemon
                    lose();
                    break;

                } else {
                    while (true) {
                        if (switchPokemon(P1, P2, ActPoke)) break;
                    }
                }
            }
        }
    }

    static boolean switchPokemon(Pokemon[] p1, Pokemon[] p2, byte[] actPoke) throws InterruptedException {
        Scanner userInput = new Scanner(System.in);
        String userIn;

        scene(p1, p2, actPoke);
        Box("\nWhich Pokemon would you like to send out next?",
                "(1) " + p1[0].Name() + " " + p1[0].HP() + "/" + p1[0].MaxHP(),
                "(2) " + p1[1].Name() + " " + p1[1].HP() + "/" + p1[1].MaxHP(),
                "(3) " + p1[2].Name() + " " + p1[2].HP() + "/" + p1[2].MaxHP(),
                "");

//        System.out.println("\n Which Pokemon would you like to send out next?");
//        System.out.println("-------------------------------------------");
//        System.out.println("| (1) " + p1[0].Name() + " " + p1[0].HP() + "/" + p1[0].MaxHP() + " ".repeat(10 - (p1[0].Name().length())) +
//                " (2) " + p1[1].Name() + " " + p1[1].HP() + "/" + p1[1].MaxHP() +" ".repeat(10 - p1[1].Name().length()) + "|");
//        System.out.println("| (3) " + p1[2].Name() + " " + p1[2].HP() + "/" + p1[2].MaxHP() + " ".repeat(10 - p1[2].Name().length()) +
//                "      " + " ".repeat(14) + "|");
//        System.out.println("------------------------------------------- \n");

        userIn = userInput.nextLine();
        if (!userIn.isBlank() && userIn.matches("[123]")) {
            sceneP1Attack(p1, p2, actPoke);
            int chosePoke = Integer.parseInt(userIn.replaceAll("[\\D]", "")) - 1;

            if (p1[chosePoke].HP() == 0) { // If the new selected pokemon was already killed
                Logo.clear();
                System.out.println(p1[chosePoke].Name() + " is dead! Please select a different Pokemon");
                sleep(1250);

            } else {
                actPoke[0] = (byte) (chosePoke);
                Box("You sent out " + p1[actPoke[0]].Name() + "!");
                sleep(1000);
                Logo.clear();
                return true;
            }
        }
        Logo.clear();
        return false;
    }

    private static void attack(Pokemon[] P1, Pokemon[] P2, byte[] ActPoke) throws InterruptedException {
        Scanner userInput = new Scanner(System.in);
        String userIn = "";
        while (userIn.isBlank() || !userIn.matches("[1234]")) {
            /* --------------- Character Chose move --------------- */
            scene(P1, P2, ActPoke);
            Box("\n What move do you want " + P1[ActPoke[0]].Name() + " to use:",
                    "(1) "  + P1[ActPoke[0]].moves()[0].Name(),
                    "(2) "  + P1[ActPoke[0]].moves()[1].Name(),
                    "(3) " + P1[ActPoke[0]].moves()[2].Name(),
                    "(4) "  + P1[ActPoke[0]].moves()[3].Name());
            userIn = userInput.nextLine();
        }

        int MoveUsed = Integer.parseInt(userIn.replaceAll("[\\D]", "")) - 1;

        P2[ActPoke[1]].subHP(Move.dmgDone(P1[ActPoke[0]].moves()[MoveUsed], P2[ActPoke[1]]));

        sceneP1Attack(P1, P2, ActPoke);
        Box(P1[ActPoke[0]].Name() + " used " + P1[ActPoke[0]].moves()[MoveUsed].Name() + "!");

        sleep(1000);
    }

    private static void scene(Pokemon[] P1, Pokemon[] P2, byte[] ActPoke) {
        Logo.clear();
        System.out.println("\n");
        System.out.println(" ".repeat(30) + P2[ActPoke[1]].Name());
        System.out.println("                     \\o/      " + hpBar(P2[ActPoke[1]]) + "\n");
        System.out.println("              \\o/");
        System.out.println("  " + P1[ActPoke[0]].Name());
        System.out.println("  " + hpBar(P1[ActPoke[0]]));
    }

    private static void Box(String text) {
        Box(text, "", "","","");
    }

    private static void Box(String topText, String textOne, String textTwo, String textThree, String textFour) {
        System.out.println("\n" + topText);
        String lineOne = "  " + textOne     + " ".repeat((20 - textOne.length()  )) + textTwo   + " ".repeat(19 - (textTwo.length()));
        String lineTwo = "  " + textThree   + " ".repeat((20 - textThree.length())) + textFour  + " ".repeat(19 - (textFour.length()));
        System.out.println("--------------------------------------------");
        System.out.println("|" + lineOne + " |");
        System.out.println("|" + lineTwo + " |");
        System.out.println("-------------------------------------------- \n");
    }

    private static String hpBar(Pokemon pokemon) {
        return "\u9637".repeat(10 * pokemon.HP() / pokemon.MaxHP()) + " " + pokemon.HP() + "/" + pokemon.MaxHP();
    }

    private static void sceneP1Attack(Pokemon[] P1, Pokemon[] P2, byte[] ActPoke) {
        Logo.clear();
        System.out.println("\n\n" + " ".repeat(30) + P2[ActPoke[1]].Name());
        System.out.println("                     \\o/      " + hpBar(P2[ActPoke[1]]) + "\n");
        System.out.println("              \\o\\");
        System.out.println("  " + P1[ActPoke[0]].Name());
        System.out.println("  " + hpBar(P1[ActPoke[0]]));
    }

    private static void sceneP2Attack(Pokemon[] P1, Pokemon[] P2, byte[] ActPoke) {
        Logo.clear();
        System.out.println("\n\n" + " ".repeat(30) + P2[ActPoke[1]].Name());
        System.out.println("                     /o/      " + hpBar(P2[ActPoke[1]]) + "\n");
        System.out.println("              \\o/");
        System.out.println("  " + P1[ActPoke[0]].Name());
        System.out.println("  " + hpBar(P1[ActPoke[0]]));
    }

    private static void Bag(Pokemon[] P1, Pokemon[] P2, byte[] ActPoke) {
        scene(P1, P2, ActPoke);
        System.out.println("\n Which item would you like to use");
        System.out.println("-------------------------------------------");
        System.out.println("|     (P)otion           Re(v)ive         |");
        System.out.println("|     (S)witch Pokemon   (R)eturn         |");
        System.out.println("------------------------------------------- \n");
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
        System.out.println("  |_|      |_____|   |________|      |________|   |_____|   |_______|   |_______|   |_|\n\n");
        for (int i = 0; i < 10; i++) {
            System.out.print(".");
            sleep(750);
        }
        sleep(1500);
    }
}
