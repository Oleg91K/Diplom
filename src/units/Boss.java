package units;

public class Boss extends Enemy{

    public Boss(EnemyType type) {
        super(type, 1);
        setHealthPoints(getHealthPoints() * 2);
        setManaPoints((int) (getManaPoints() * 1.5));
        setAttackPoints(getAttackPoints() + 10);
        setArmorPoints(getArmorPoints() + 5);

        // нужно придумать, как будет генерироваться босс.
        // Делать это он будет, по EnemyType, с каким-то множителем характеристик.

    }
}
