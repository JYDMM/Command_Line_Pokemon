import java.util.Scanner;

public class ChoseTeam extends Init {
//<<<<<<< Updated upstream
    private Pokemon player1Poke1;
    private Pokemon player1Poke2;
    private Pokemon player1Poke3;
    private Pokemon player2Poke1;
    private Pokemon player2Poke2;
    private Pokemon player2Poke3;


    public static void Main() {
        Logo.clear();
        Logo.version1();

    }

    public Pokemon getPlayer1Poke1() {
        return player1Poke1;
    }

    public Pokemon getPlayer1Poke2() {
        return player1Poke2;
    }

    public Pokemon getPlayer1Poke3() {
        return player1Poke3;
    }

    public Pokemon getPlayer2Poke1() {
        return player2Poke1;
    }

    public Pokemon getPlayer2Poke2() {
        return player2Poke2;
    }

    public Pokemon getPlayer2Poke3() {
        return player2Poke3;
    }
//=======
    public void team(){
        Scanner teamSelect = new Scanner(System.in);

        System.out.println("Select one to see stats!");
        System.out.println("(C)harmander     (S)quirtle     (B)ulbasaur");

        char selector1 = teamSelect.nextLine().charAt(0);

        if (selector1 == 'C' || selector1 == 'c'){
            System.out.println("Number: " + Charmander.Number());
            System.out.println("Name: " + Pokemon.Name());
            System.out.println("Type: " + Pokemon.Type());
            System.out.println("HP: " + Pokemon.HP());
        } else if (selector1 == 'S' || selector1 == 's'){
            System.out.println("Number: " + Pokemon.Number());
            System.out.println("Name: " + Pokemon.Name());
            System.out.println("Type: " + Pokemon.Type());
            System.out.println("HP: " + Pokemon.HP());
        } else if (selector1 == 'B' || selector1 == 'b'){
            System.out.println("Number: " + Bulbasaur.Number());
            System.out.println("Name: " + Bulbasaur.Name());
            System.out.println("Type: " + Bulbasaur.Type());
            System.out.println("HP: " + Bulbasaur.HP());
        } else team();


//>>>>>>> Stashed changes
    }

}
