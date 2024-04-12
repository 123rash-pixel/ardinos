import java.util.Random;

public class Player {
    private int health;
    private int strength;
    private int attack;

    public Player(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void receiveDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public int attack(Player defender) {
        Random rand = new Random();
        int attackRoll = rand.nextInt(6) + 1;
        int damage = attack * attackRoll;
        
        int defenseRoll = rand.nextInt(6) + 1;
        int defended = defender.getStrength() * defenseRoll;

        int damageTaken = Math.max(0, damage - defended);
        defender.receiveDamage(damageTaken);

        return damageTaken;
    }
}
