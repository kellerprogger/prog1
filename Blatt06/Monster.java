/**
    Monster Klasse nach spezifikationen
    @author Tyrfing
    @version 2.0.2
*/
public class Monster extends Entity {


    public Monster(int maxHp, int atk, double hitChance) {
        super(maxHp, atk, hitChance);
    }

    public String toString(){
        return
        "--------Monster-------\n" +
        "HP: "+ hp + "\n" +
        "ATK: "+ atk + "\n" +
        "----------------------" + "\n";
    }
}
