public class Entity{
    int maxHp;
    int hp;
    int atk;
    double hitChance;

    public Entity(int maxHp, int atk, double hitChance) {
        this.maxHp = maxHp;
        this.atk = atk;
        this.hitChance = hitChance;
        hp = maxHp;
    }
    public boolean isDefeated() {
        if(hp == 0){
            return true;
        }
        else {
            return false;
        }
    }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp < 0){
            hp = 0;
        }
    }
    public int attack(Entity entity) {
        if (hitChance <= Math.random()) {
            return -1;
        } else {
            int x = (int) (atk *  (Math.random() + 1));
            monster.takeDamage(x);
            return x;
        }
    }

}
