import java.util.Scanner;

public class ChoseTeam extends Init {
    private static Pokemon User[] = new Pokemon[3];
    private static Pokemon Bot[] = new Pokemon[3];


    public static void Main() throws InterruptedException {
        Logo.clear();
        Logo.version1();
        team();

    }

    public static void team() throws InterruptedException {
        Scanner teamSelect = new Scanner(System.in);

        System.out.println("Select one to see stats!");
        System.out.println("(C)harmander     (S)quirtle     (B)ulbasaur");

        char selector1 = teamSelect.nextLine().charAt(0);

// Make player1Poke1 switch to player1Poke2 after choosing first pokemon

        if (selector1 == 'C' || selector1 == 'c') {
            if (info(Charmander)) {
                System.out.println("You have selected Charmander!");
                User[0] = Charmander;
                Battle.Main("Pyam", new Pokemon[]{Init.Charmander, Init.Squirtle, Init.Bulbasaur}, "test", BotRandom()); // ONLY FOR TESTING
            } else {
                team();
            }
        } else if (selector1 == 'S' || selector1 == 's') {
            if (info(Squirtle)) {
                System.out.println("You have selected Squirtle!");
                User[0] = Squirtle;
                Battle.Main("Pyam", new Pokemon[]{Init.Squirtle, Init.Charmander, Init.Bulbasaur}, "test", BotRandom()); // ONLY FOR TESTING
            } else {
                team();
            }
        } else if (selector1 == 'B' || selector1 == 'b') {
            if (info(Bulbasaur)) {
                System.out.println("You have selected Bulbasaur!");
                User[0] = Bulbasaur;
                Battle.Main("Pyam", new Pokemon[]{Init.Bulbasaur, Init.Squirtle, Init.Charmander}, "test", BotRandom()); // ONLY FOR TESTING
            } else {
                team();
            }
        } else team();

    }

    private static boolean info(Pokemon poke) {
        while (true) {
            System.out.println("Number: " + poke.Number());
            System.out.println("Name: " + poke.Name());
            System.out.println("Type: " + poke.Type());
            System.out.println("HP: " + poke.HP());
            System.out.println("Select?  Y / N");
            Scanner Select = new Scanner(System.in);
            char selector2 = Select.nextLine().charAt(0);
            if (selector2 == 'Y' || selector2 == 'y') {
                return true;
            } else if (selector2 == 'N' || selector2 == 'n') {
                return false;
            }
        }
    }

    public static Pokemon[] BotRandom() {
        for (int i = 0; i <= 2; i++) Bot[i] = Init.ALL[(int)(Math.random() * (ALL.length - 1))];
        return Bot;
    }

}
