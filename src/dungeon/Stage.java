package dungeon;

import units.Enemy;
import units.EnemyType;
import units.Hero;
import units.UnitStatus;

import java.util.ArrayList;
import java.util.Scanner;

public class Stage {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Enemy> enemyStack;
    private String killedBy;
    private int level;


    public void fightGen(Hero hero, int level) {
        int playerInput;
        enemyStack = new ArrayList<>();
        int y =  1 + (int) (Math.random() * 3);
        int enemiesRemaining;
        for (int i = 0; i < y; i++) {
            enemyStack.add(new Enemy(EnemyType.values()[(int) (Math.random() * 3)], level));
        }
        while (true) {
            enemiesRemaining = y;
            System.out.println(hero);
            for (Enemy enemy : enemyStack) {
                System.out.println(enemyStack.indexOf(enemy) + 1 + ". " + enemy.toString());
            }
            // ход игрока
            playerInput = scanner.nextInt() - 1;
            if (enemyStack.get(playerInput) != null) {
                hero.attack(enemyStack.get(playerInput));
            }
            if (enemyStack.get(playerInput).getHealthPoints() <= 0) {
                enemyStack.get(playerInput).setUnitStatus(UnitStatus.DEAD);
                hero.setExp(hero.getExp() + enemyStack.get(playerInput).getGiveExp()); // передает герою опыт за убийство врага (нужно сделать левелап) <-----------
            }
            for (Enemy enemy : enemyStack) { // проверяет статус врага и изменяет значение enemiesRemaining
                if (enemy.getUnitStatus() == UnitStatus.DEAD) {
                    enemiesRemaining--;
                }
            }
            if (enemiesRemaining == 0) { // если enemiesRemaining = 0, то бой заканчивается
                System.out.println("Вы победили!");
                break;
            }
            //---------------------------------------------------------------------------------------------------------
            // ход врага
            for (Enemy enemy : enemyStack) {
                if (enemy.getUnitStatus() == UnitStatus.ALIVE) {
                    enemy.attack(hero);
                }
                if (hero.getHealthPoints() <= 0) { // если здоровье игрока опустится ниже 0, то его статус поменяется на DEAD
                    hero.setUnitStatus(UnitStatus.DEAD);
                    killedBy = enemy.getType().toString();
                    break;
                }
            }
            if (hero.getUnitStatus() == UnitStatus.DEAD) { // если статус игрока DEAD, то игра проиграна
                System.out.println("\n" + hero.getName() + " получает смертельный удар от " + killedBy + "\nВы програли!");
                break;
            }
            //---------------------------------------------------------------------------------------------------------
        }
    }

    public void eventGen() {


    }

    public void bossFightGen() {


    }

    public ArrayList<Enemy> getEnemyStack() {
        return enemyStack;
    }

    @Override
    public String toString() {
        return "Stage{" +
                "enemyStack=" + enemyStack +
                '}';
    }



}
