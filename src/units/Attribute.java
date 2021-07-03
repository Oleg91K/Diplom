package units;

public enum Attribute {
    AGILITY(1),
    INTELLIGENCE(25),
    STRENGTH(50);

    private int incomePoints;

    Attribute(int incomePoints) {
        this.incomePoints = incomePoints;
    }

    public int getIncomePoints() {
        return incomePoints;
    }
}
