import java.util.Scanner;

public class ChoseTeam extends Init {
    private static Pokemon[] player1;
    private static Pokemon[] player2;
    //<<<<<<< Updated upstream
    // private Pokemon player1[] = new Pokemon[3];
    //private Pokemon player2[] = new Pokemon[3];


    public static void Main() {
        Logo.clear();
        Logo.version1();
        team();

    }

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

    public static void team(){
        Scanner teamSelect = new Scanner(System.in);

        System.out.println("Select one to see stats!");
        System.out.println("(C)harmander     (S)quirtle     (B)ulbasaur");

        char selector1 = teamSelect.nextLine().charAt(0);

// Make player1Poke1 switch to player1Poke2 after choosing first pokemon

        if (selector1 == 'C' || selector1 == 'c'){
            System.out.println("Number: " + Charmander.Number());
            System.out.println("Name: " + Charmander.Name());
            System.out.println("Type: " + Charmander.Type());
            System.out.println("HP: " + Charmander.HP());
            System.out.println("Select?  Y / N");
            char selector2 = teamSelect.nextLine().charAt(0);
            if (selector2 == 'Y') {
                player1[0] = Charmander;

            }
        } else if (selector1 == 'S' || selector1 == 's'){
            System.out.println("Number: " + Squirtle.Number());
            System.out.println("Name: " + Squirtle.Name());
            System.out.println("Type: " + Squirtle.Type());
            System.out.println("HP: " + Squirtle.HP());
            System.out.println("Select?  Y / N");
            char selector2 = teamSelect.nextLine().charAt(0);
            if (selector2 == 'Y') {
                player1[0] = Squirtle;

            }
        } else if (selector1 == 'B' || selector1 == 'b'){
            System.out.println("Number: " + Bulbasaur.Number());
            System.out.println("Name: " + Bulbasaur.Name());
            System.out.println("Type: " + Bulbasaur.Type());
            System.out.println("HP: " + Bulbasaur.HP());
                System.out.println("Select?  Y / N");
                char selector2 = teamSelect.nextLine().charAt(0);
                if (selector2 == 'Y') {
                    player1[0] = Bulbasaur;
                }
        } else team();




    }

}
