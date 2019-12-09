import java.util.Arrays;
import java.util.List;

public class Move {
    private String name;
    private String type;
    private boolean physical;
    private int power;

    public Move(String name, String type, boolean physical, int power) {
        this.name = name;
        List<String> Types[] = Arrays.asList("fire", "water", "electric", "");
        if (Types.contains(this.type.toLowerCase()) {
            this.type = type;
        }
    }
        this.physical = physical;
        this.power = power;
    }

}
