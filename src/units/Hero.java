package units;

import java.util.Arrays;

public class Hero extends Unit implements AttackAble {
    private String name;
    private int[] attributes;
    private int exp = 0;
    private int expLimit = getLevel() * 50;

    public Hero(String name, int a, int i, int s) {
        super(1,
                s * Attribute.STRENGTH.getIncomePoints(),
                i * Attribute.INTELLIGENCE.getIncomePoints(),
                a * Attribute.AGILITY.getIncomePoints(),
                100); // тут надо сделать, чтобы атака считалась от оружия
        this.name = name;
        this.attributes = new int[] {a, i, s};
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getAttributes() {
        return attributes;
    }

    public void setAttributes(int a, int i, int s) {
        this.attributes[0] = a;
        this.attributes[1] = i;
        this.attributes[2] = s;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getExpLimit() {
        return expLimit;
    }

    public void setExpLimit(int expLimit) {
        this.expLimit = expLimit;
    }

    @Override
    public String toString() {
        return  name + "\n" +
                "Характеристики: " + "ловкость: " + attributes[0] + ", интелект: " + attributes[1] + ", сила: " + attributes[2] + "\n" +
                "Уровень: " + getLevel() +
                ", опыт: " + getExp() +
                "/" + getExpLimit() +
                ", здоровье: " + getHealthPoints() +
                "/" + getMaxHealthPoints() +
                ", мана: " + getManaPoints() +
                "/" + getMaxManaPoints() +
                ", атака: " + getAttackPoints() +
                ", защита: " + getArmorPoints() + "\n";
    }

    public void levelUp() {
        int agilityIncome, intelligenceIncome, strengthIncome;
        agilityIncome = 1;
        intelligenceIncome = 1;
        strengthIncome = 2;
        setAttributes(this.attributes[0] + agilityIncome, this.attributes[1] + intelligenceIncome, this.attributes[2] + strengthIncome);
        setArmorPoints(this.attributes[0] * Attribute.AGILITY.getIncomePoints());
        setManaPoints(this.attributes[1] * Attribute.INTELLIGENCE.getIncomePoints());
        setHealthPoints(this.attributes[2] * Attribute.STRENGTH.getIncomePoints());
    }

    @Override
    public void attack(Unit enemy) {
        enemy.setHealthPoints(enemy.getHealthPoints() - this.getAttackPoints());
        System.out.println(this.getName() + " наносит " + this.getAttackPoints() + " урона.");
    }
}
