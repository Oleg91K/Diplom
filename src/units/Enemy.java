package units;

public class Enemy extends Unit implements AttackAble{
    private EnemyType type;
    private int giveExp;

    public Enemy(EnemyType type, int level) {
        super(level, type.getHealthPoints(), type.getManaPoints(), type.getArmorPoints(), type.getAttackPoints());
        this.type = type;
        this.giveExp = (int) (EnemyType.ORC.getGiveExp() + (EnemyType.ORC.getGiveExp() * (level * 0.5)));
    }

    public EnemyType getType() {
        return type;
    }

    public int getGiveExp() {
        return giveExp;
    }

    @Override
    public String toString() {
        int i = 0;
        return  "Враг: " + type +
                ", уровень: " + getLevel() +
                ", здоровье: " + getHealthPoints() +
                "/" + getMaxHealthPoints() +
                ", мана: " + getManaPoints() +
                "/" + getMaxManaPoints() +
                ", атака: " + getAttackPoints() +
                ", защита: " + getArmorPoints();
    }

    @Override
    public void attack(Unit enemy) {
        enemy.setHealthPoints(enemy.getHealthPoints() - this.getAttackPoints());
        System.out.println(this.getType() + " наносит " + this.getAttackPoints() + " урона.");
    }


}
