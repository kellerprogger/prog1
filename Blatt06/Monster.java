/**
    Monster Klasse nach spezifikationen
    @author Tyrfing
    @version 2.0.2
*/
public class Monster extends Entity {


    public Monster(int maxHp, int atk, double hitChance) {
        super(maxHp, atk, hitChance);
    }

    public int attack(Player player) {
        if (hitChance <= Math.random()) {
            return -1;
        } else {
            int x = (int) (atk *  (Math.random() + 1));
            player.takeDamage(x);
            return x;
        }
    }
    public String toString(){
        return
        "--------Monster-------\n" +
        "HP: "+ hp + "\n" +
        "ATK: "+ atk + "\n" +
        "----------------------" + "\n";
    }
}
