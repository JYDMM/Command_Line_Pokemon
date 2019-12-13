import java.sql.SQLOutput;

public class Battle {
    public static void main(String args[]) {
        Main("John", Init.Squirtle, Init.Squirtle, Init.Squirtle, Init.Charmander, Init.Squirtle, Init.Squirtle);
    }
    public static void Main(String PlayerName, Pokemon Player1Poke1, Pokemon Player1Poke2,
                            Pokemon Player1Poke3, Pokemon Player2Poke1, Pokemon Player2Poke2, Pokemon Player2Poke3) {
        Pokemon Player1ActivePokemon = Player1Poke1;
        Pokemon Player2ActivePokemon =  Player2Poke1;
        int Player1Poke1HP = Player1Poke1.HP();
        int Player1Poke2HP = Player1Poke1.HP();
        int Player1Poke3HP = Player1Poke1.HP();
        int Player2Poke1HP = Player1Poke1.HP();
        int Player2Poke2HP = Player1Poke1.HP();
        int Player2Poke3HP = Player1Poke1.HP();


        System.out.println();
        System.out.println();
        System.out.println("                           " + Player2ActivePokemon.Name());
        System.out.println("                     \\o/     " + "|".repeat(10*));
        System.out.println("");
        System.out.println("            \\o/");
        System.out.println(Player1ActivePokemon.Name());

    }
}
