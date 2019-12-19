import java.util.Scanner;

public class ChoseTeam extends Init {
    private static Pokemon[] player1;
    private static Pokemon[] player2;
    //<<<<<<< Updated upstream
    private static Pokemon User[] = new Pokemon[3];
    private static Pokemon Bot[] = new Pokemon[3];


    public static void Main() throws InterruptedException {
        Logo.clear();
        Logo.version1();
        team();

    }

    public static Pokemon getUserPoke1() {
        return User[0];
    }
    public static Pokemon getUserPoke2() {
        return User[1];
    }
    public static Pokemon getUserPoke3() {
        return User[2];
    }
//--
    public static Pokemon getBotPoke1() {
        return Bot[0];
    }
    public static Pokemon getBotPoke2() {
        return Bot[1];
    }
    public static Pokemon getBotPoke3() {
        return Bot[2];
    }
/*
    public Pokemon getPlayer1Poke1() {
        return player1[0];
    }

    public Pokemon getPlayer1Poke2() {
        return player1[1];
    }

    public Pokemon getPlayer1Poke3() {
        return player1[2];
    }

    public Pokemon getPlayer2Poke1() {
        return player2[0];
    }

    public Pokemon getPlayer2Poke2() {
        return player2[1];
    }

    public Pokemon getPlayer2Poke3() {
        return player2[2];
    }
*/

    public static void team() throws InterruptedException {
        Scanner teamSelect = new Scanner(System.in);

        System.out.println("Select one to see stats!");
        System.out.println("(C)harmander     (S)quirtle     (B)ulbasaur");

        char selector1 = teamSelect.nextLine().charAt(0);

// Make player1Poke1 switch to player1Poke2 after choosing first pokemon

        if (selector1 == 'C' || selector1 == 'c') {
            System.out.println("Number: " + Charmander.Number());
            System.out.println("Name: " + Charmander.Name());
            System.out.println("Type: " + Charmander.Type());
            System.out.println("HP: " + Charmander.HP());
            System.out.println("Select?  Y / N");
            char selector2 = teamSelect.nextLine().charAt(0);
            if (selector2 == 'Y' || selector2 == 'y') {
                System.out.println("You have selected Charmander!");
                User[0] = Charmander;
                Battle.Main("Pyam", new Pokemon[]{Init.Charmander, Init.Squirtle, Init.Bulbasaur}, "test", BotRandom());
            } else if (selector2 == 'N' || selector2 == 'n') {
                team();
            }
        } else if (selector1 == 'S' || selector1 == 's') {
            System.out.println("Number: " + Squirtle.Number());
            System.out.println("Name: " + Squirtle.Name());
            System.out.println("Type: " + Squirtle.Type());
            System.out.println("HP: " + Squirtle.HP());
            System.out.println("Select?  Y / N");
            char selector2 = teamSelect.nextLine().charAt(0);
            if (selector2 == 'Y' || selector2 == 'y') {
                System.out.println("You have selected Squirtle!");
                User[0] = Squirtle;
                Battle.Main("Pyam", new Pokemon[]{Init.Squirtle, Init.Charmander, Init.Bulbasaur}, "test", BotRandom());
            } else if (selector2 == 'N' || selector2 == 'n') {
                team();
            }
        } else if (selector1 == 'B' || selector1 == 'b') {
            System.out.println("Number: " + Bulbasaur.Number());
            System.out.println("Name: " + Bulbasaur.Name());
            System.out.println("Type: " + Bulbasaur.Type());
            System.out.println("HP: " + Bulbasaur.HP());
            System.out.println("Select?  Y / N");
            char selector2 = teamSelect.nextLine().charAt(0);
            if (selector2 == 'Y' || selector2 == 'y') {
                System.out.println("You have selected Bulbasaur!");
                User[0] = Bulbasaur;
                Battle.Main("Pyam", new Pokemon[]{Init.Bulbasaur, Init.Squirtle, Init.Charmander}, "test", BotRandom());
            } else if (selector2 == 'N' || selector2 == 'n') {
                team();
            }
        } else team();

        // Bot code?
    }
    public static Pokemon[] BotRandom() {

        for (int i = 0; i <= 2; i++) {
            Bot[i] = Init.ALL[(int)(Math.random() * (ALL.length - 1))];
        }
        return Bot;






    }

}
