/**
@author Tyrfing
@version 4.0.0
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
