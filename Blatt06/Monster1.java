public class Monster1 extends Monster{
    public Monster1(int maxHp, int atk, double hitChance) {
        super(maxHp, atk, hitChance);
    }
    public int attack(Player player) {
        double rnd = Math.random();
        if (hitChance <= rnd) {
            return -1;
        } else if (0.7 <= Math.random()) { //Critical Hit
            int x = (int) (atk *  (rnd + 3));
            player.takeDamage(x);
            return x;
        } else if (0.2 >= rnd){
            int x = (int) (atk / (rnd +1)); //Weak Hit
            player.takeDamage(x);
            return x;
        } else {
            int x = (int) (atk *  (rnd + 1)); //Normal Hit
            player.takeDamage(x);
            return x;
        }

    }    
}
