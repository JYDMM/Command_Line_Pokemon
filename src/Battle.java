import java.sql.SQLOutput;
import java.util.Scanner;

public class Battle {
    public static void main(String args[]) {
        Main("John", Init.Squirtle, Init.Bulbasaur, Init.Venusaur, Init.Charmander, Init.Ivysaur, Init.Charmeleon);
    }



    public static void Main(String PlayerName, Pokemon Player1Poke1, Pokemon Player1Poke2,
                            Pokemon Player1Poke3, Pokemon Player2Poke1, Pokemon Player2Poke2, Pokemon Player2Poke3) {
        Scanner userInput = new Scanner(System.in);
        Pokemon Player1ActivePokemon = Player1Poke1;
        Pokemon Player2ActivePokemon =  Player2Poke1;

        // STATIC MAX HP
        int Player1Poke1HP = Player1Poke1.HP();
        int Player1Poke2HP = Player1Poke1.HP();
        int Player1Poke3HP = Player1Poke1.HP();
        int Player2Poke1HP = Player1Poke1.HP();
        int Player2Poke2HP = Player1Poke1.HP();
        int Player2Poke3HP = Player1Poke1.HP();


        while (true) {
            // Battle UI
            Logo.clear();
            System.out.println("\n");
            System.out.println("                              " + Player2ActivePokemon.Name());
            System.out.println("                     \\o/      " + "\u9637".repeat(10 * Player1Poke1HP / Player1Poke1.HP()));
            System.out.println("");
            System.out.println("              \\o/");
            System.out.println("  " + Player1ActivePokemon.Name());
            System.out.println("  " + "\u9637".repeat(10 * Player1Poke1HP / Player1Poke1.HP()));
            // BOX
            System.out.println("-------------------------------------------");
            System.out.println("|   (A)ttack           (B)ag              |");
            System.out.println("|   (S)witch Pokemon   (Q)uit             |");
            System.out.println("------------------------------------------- \n");
            char userIn = userInput.nextLine().charAt(0);
            if (userIn == 'A' || userIn == 'a') {
                // Battle UI
                Logo.clear();
                System.out.println("\n");
                System.out.println("                              " + Player2ActivePokemon.Name());
                System.out.println("                     \\o/      " + "\u9637".repeat(10 * Player1Poke1HP / Player1Poke1.HP()));
                System.out.println();
                System.out.println("              \\o/");
                System.out.println("  " + Player1ActivePokemon.Name());
                System.out.println("  " + "\u9637".repeat(10 * Player1Poke1HP / Player1Poke1.HP()));
                // Box of moves
                System.out.println("-------------------------------------------");
                System.out.println("|   (1) " + Player1ActivePokemon.Move1().Name() + " ".repeat(15 - Player1ActivePokemon.Move1().Name().length()) +
                        " (2) " + Player1ActivePokemon.Move2().Name() + " ".repeat(14 - Player1ActivePokemon.Move2().Name().length()) + "|");
                System.out.println("|   (3) " + Player1ActivePokemon.Move3().Name() + " ".repeat(14 - Player1ActivePokemon.Move3().Name().length()) +
                        "  (4) " + Player1ActivePokemon.Move4().Name() + " ".repeat(14 - Player1ActivePokemon.Move4().Name().length()) + "|");
                System.out.println("------------------------------------------- \n");

                int userInInt = Integer.parseInt(userInput.nextLine().replaceAll("[\\D]", "")); // which move

                if (userInInt == 1) {
                    Player2ActivePokemon.setHP((int) (
                            Player2ActivePokemon.HP() - (0.25 * Player1ActivePokemon.Move1().Power() *
                                    Move.damageDone(Player1ActivePokemon.Move1(), Player2ActivePokemon))));
                } else if (userInInt == 2) {
                    Player2ActivePokemon.setHP((int) (
                            Player2ActivePokemon.HP() - (0.25 * Player1ActivePokemon.Move2().Power() *
                                    Move.damageDone(Player1ActivePokemon.Move2(), Player2ActivePokemon))));
                } else if (userInInt == 3) {
                    Player2ActivePokemon.setHP((int) (
                            Player2ActivePokemon.HP() - (0.25 * Player1ActivePokemon.Move3().Power() *
                                    Move.damageDone(Player1ActivePokemon.Move3(), Player2ActivePokemon))));
                } else if (userInInt == 4) {
                    Player2ActivePokemon.setHP((int) (
                            Player2ActivePokemon.HP() - (0.25 * Player1ActivePokemon.Move4().Power() *
                                    Move.damageDone(Player1ActivePokemon.Move4(), Player2ActivePokemon))));
                }



            } else if (userIn == 'B' || userIn == 'b') {
                System.out.println("This feature has not yet been implemented!");
            } else if (userIn == 'S' || userIn == 's') {
                System.out.println("This feature has not yet been implemented!");
            } else if (userIn == 'Q' || userIn == 'q') {
                TitleScreen.Start(false);
            }
        }

    }
}
