import dungeon.Stage;
import units.Hero;

public class game {

    static {
        new Hero("Roma", 3,1, 2);
    }

    public static void main(String[] args) {
        new Stage().fightGen(new Hero("Roma", 3,1, 2), 1);
    }


}
