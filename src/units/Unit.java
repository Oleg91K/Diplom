package units;

import utils.Skill;

import java.util.ArrayList;

public class Unit {
    private int level;
    private int healthPoints;
    private final int maxHealthPoints;
    private int manaPoints;
    private int maxManaPoints;
    private int attackPoints;
    private int armorPoints;
    private UnitStatus unitStatus = UnitStatus.ALIVE;


    public Unit(int level, int healthPoints, int manaPoints, int armorPoints, int attackPoints) {
        this.level = level;
        this.healthPoints = healthPoints;
        this.maxHealthPoints = healthPoints;
        this.manaPoints = manaPoints;
        this.maxManaPoints = manaPoints;
        this.armorPoints = armorPoints;
        this.attackPoints = attackPoints;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getMaxHealthPoints() {
        return maxHealthPoints;
    }

    public int getMaxManaPoints() {
        return maxManaPoints;
    }

    public void setMaxManaPoints(int maxManaPoints) {
        this.maxManaPoints = maxManaPoints;
    }

    public int getManaPoints() {
        return manaPoints;
    }

    public void setManaPoints(int manaPoints) {
        this.manaPoints = manaPoints;
    }

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getArmorPoints() {
        return armorPoints;
    }

    public void setArmorPoints(int armorPoints) {
        this.armorPoints = armorPoints;
    }

    public UnitStatus getUnitStatus() {
        return unitStatus;
    }

    public void setUnitStatus(UnitStatus unitStatus) {
        this.unitStatus = unitStatus;
    }



    @Override
    public String toString() {
        return "Unit{" +
                "level=" + level +
                ", healthPoints=" + healthPoints +
                ", maxHealthPoints=" + maxHealthPoints +
                ", manaPoints=" + manaPoints +
                ", maxManaPoints=" + maxManaPoints +
                ", attackPoints=" + attackPoints +
                ", armorPoints=" + armorPoints +
                ", unitStatus=" + unitStatus +
                '}';
    }
}
