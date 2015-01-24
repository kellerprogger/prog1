public class Monster2 extends Monster{
    public Monster2(int maxHp, int atk, double hitChance, String name) {
        super(maxHp, atk, hitChance, name);
    }

    public int  takeDamage(int damage) {
        double rnd = Math.random();
        int realDamage;

        if (rnd >= 0.8){
            realDamage = (int) (damage / 10); //Take lessless Damage
        } else if (rnd >= 0.6) {
            realDamage = (int) (damage / 5); //Take less Damage
        } else if (rnd >= 0.1){
            realDamage = damage; //Normal Damage
        } else {
            realDamage = 0; //No Damage
        }
        hp -= realDamage;
        if (hp < 0){
            hp = 0;
        }
        return realDamage;
    }
}
