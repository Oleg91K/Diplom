package units;

public enum EnemyType {
    SKELETON(150, 100, 1, 10, 10),
    DRAGON(100, 150, 2, 12, 15),
    ORC(200, 50, 3, 15, 20);

    private int healthPoints;
    private int manaPoints;
    private int armorPoints;
    private int attackPoints;
    private int giveExp;

    EnemyType(int healthPoints, int manaPoints, int armorPoints, int attackPoints, int giveExp) {
        this.healthPoints = healthPoints;
        this.manaPoints = manaPoints;
        this.armorPoints = armorPoints;
        this.attackPoints = attackPoints;
        this.giveExp = giveExp;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public int getArmorPoints() {
        return armorPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public int getGiveExp() {
        return giveExp;
    }
}
