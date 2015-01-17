/**
    Monster Klasse nach spezifikationen
    @author Tyrfing
    @version 3.0.1
*/
public class Monster extends Entity {
    String name;

    public Monster(int maxHp, int atk, double hitChance, String name) {
        super(maxHp, atk, hitChance);
        this.name = name;
    }

    public String toString(){
        return
        "--------"+ name + "-------\n" +
        "HP: "+ hp + "\n" +
        "ATK: "+ atk + "\n" +
        "----------------------" + "\n";
    }
}
