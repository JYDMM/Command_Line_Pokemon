import java.util.Scanner;

public class Battle {
    public static void main(String[] args) {
        Main("John", Init.Squirtle, Init.Bulbasaur, Init.Venusaur, Init.Charmander, Init.Ivysaur, Init.Charmeleon);
    }

    static void Start() {
        Main("John", Init.Squirtle, Init.Bulbasaur, Init.Venusaur, Init.Charmander, Init.Ivysaur, Init.Charmeleon);
    }

    static void Main(String PlayerName, Pokemon Player1Poke1, Pokemon Player1Poke2,
                            Pokemon Player1Poke3, Pokemon Player2Poke1, Pokemon Player2Poke2, Pokemon Player2Poke3) {
        Scanner userInput = new Scanner(System.in);
        Pokemon[] ActivePokemon = {Player1Poke1, Player2Poke1}; // Sets first pokemon

        byte[] PlayerPokemon = {1, 1}; // integer which pokemon is currently selected & sets first pokemon
        int[] maxPlayer1PokeHP = {Player1Poke1.HP(), Player1Poke1.HP(), Player1Poke1.HP()}; // Array of all player 1's pokemon
        int[] maxPlayer2PokeHP = {Player2Poke1.HP(), Player2Poke2.HP(), Player2Poke3.HP()}; // Array of all player 2's pokemon


        while (true) {
            int[] activePokemonMaxHP = new int[2];
            // Max HP for active pokemon
            if (PlayerPokemon[0] == 1) {
                activePokemonMaxHP[0] = maxPlayer1PokeHP[0];
            } else if (PlayerPokemon[0] == 2) {
                activePokemonMaxHP[0] = maxPlayer1PokeHP[1];
            } else if (PlayerPokemon[0] == 3) {
                activePokemonMaxHP[0] = maxPlayer1PokeHP[2];
            } else {
                activePokemonMaxHP[0] = maxPlayer1PokeHP[0];
            }
            if (PlayerPokemon[1] == 1) {
                activePokemonMaxHP[1] = maxPlayer2PokeHP[0];
            } else if (PlayerPokemon[1] == 2) {
                activePokemonMaxHP[1] = maxPlayer2PokeHP[1];
            } else if (PlayerPokemon[1] == 3) {
                activePokemonMaxHP[1] = maxPlayer2PokeHP[2];
            } else {
                activePokemonMaxHP[1] = maxPlayer2PokeHP[0];
            }

                // Battle UI
            Logo.clear();
            scene(ActivePokemon, activePokemonMaxHP);
            // BOX
            System.out.println("\n Chose your next action:");
            System.out.println("-------------------------------------------");
            System.out.println("|   (A)ttack           (B)ag              |");
            System.out.println("|   (S)witch Pokemon   (Q)uit             |");
            System.out.println("------------------------------------------- \n");
            char userIn = userInput.nextLine().charAt(0);


            if (userIn == 'A' || userIn == 'a') {
                // Battle UI
                scene(ActivePokemon, activePokemonMaxHP);

                // Box of moves
                System.out.println("\n What move do you want " + ActivePokemon[0].Name() + " to use:");
                System.out.println("-------------------------------------------");
                System.out.println("|   (1) " + ActivePokemon[0].Move1().Name() + " ".repeat(15 - ActivePokemon[0].Move1().Name().length()) +
                        " (2) " + ActivePokemon[0].Move2().Name() + " ".repeat(14 - ActivePokemon[0].Move2().Name().length()) + "|");
                System.out.println("|   (3) " + ActivePokemon[0].Move3().Name() + " ".repeat(14 - ActivePokemon[0].Move3().Name().length()) +
                        "  (4) " + ActivePokemon[0].Move4().Name() + " ".repeat(14 - ActivePokemon[0].Move4().Name().length()) + "|");
                System.out.println("------------------------------------------- \n");


                int userInInt = Integer.parseInt(userInput.nextLine().replaceAll("[\\D]", "")); // Scanner for which move
                String moveUsedToPrint = "";
                if (userInInt == 1) {
                    ActivePokemon[1].setHP((int) (
                            ActivePokemon[1].HP() - (0.25  * Move.damageDone(ActivePokemon[0].Move1(), ActivePokemon[1]))));
                    moveUsedToPrint = ActivePokemon[0].Name() + " used " + ActivePokemon[0].Move1().Name() + "!";
                    System.out.println(ActivePokemon[1].HP());
                } else if (userInInt == 2) {
                    ActivePokemon[1].setHP((int) (
                            ActivePokemon[1].HP() - (0.25 * Move.damageDone(ActivePokemon[0].Move2(), ActivePokemon[1]))));
                    moveUsedToPrint = ActivePokemon[0].Name() + " used " + ActivePokemon[0].Move2().Name() + "!";
                } else if (userInInt == 3) {
                    ActivePokemon[1].setHP((int) (
                            ActivePokemon[1].HP() - (0.25 * Move.damageDone(ActivePokemon[0].Move3(), ActivePokemon[1]))));
                    moveUsedToPrint = ActivePokemon[0].Name() + " used " + ActivePokemon[0].Move3().Name() + "!";
                } else if (userInInt == 4) {
                    ActivePokemon[1].setHP((int) (
                            ActivePokemon[1].HP() - (0.25 * Move.damageDone(ActivePokemon[0].Move4(), ActivePokemon[1]))));
                    moveUsedToPrint = ActivePokemon[0].Name() + " used " + ActivePokemon[0].Move4().Name() + "!";
                }

                scene(ActivePokemon, activePokemonMaxHP);
                // BOX
                System.out.println("\n" + moveUsedToPrint);
                System.out.println("-------------------------------------------");
                System.out.println("|                                         |");
                System.out.println("|                                         |");
                System.out.println("------------------------------------------- \n");

                //
                // Is pokemon dead - > Then what




            } else if (userIn == 'B' || userIn == 'b') {
                System.out.println("This feature has not yet been implemented!");
                // BAG
            } else if (userIn == 'S' || userIn == 's') {
                System.out.println("This feature has not yet been implemented!");
                // Switch Pokemon
            } else if (userIn == 'Q' || userIn == 'q') { TitleScreen.Start(); break; }

        }
    }

    private static void scene(Pokemon[] activePokemon, int[] activePokemonMaxHP) {
        Logo.clear();
        System.out.println("\n");
        System.out.println(" ".repeat(30) + activePokemon[1].Name());
        System.out.println("                     \\o/      " + "\u9637".repeat(10 * activePokemon[1].HP()/activePokemonMaxHP[1])
                + activePokemon[1].HP() + "/" + activePokemonMaxHP[1] + "\n");
        System.out.println("              \\o/");
        System.out.println("  " + activePokemon[0].Name());
        System.out.println("  " + "\u9637".repeat(10 * activePokemon[0].HP()/activePokemonMaxHP[0]) + activePokemon[0].HP() + "/" + activePokemonMaxHP[0]);
    }
}
