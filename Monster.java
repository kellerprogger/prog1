public class Monster{
    int maxHp;
    int hp;
    int atk;
    double hitChance;

    public Monster(int maxHp, int atk, double hitChance){
        this.maxHp = maxHp;
        this.atk = atk;
        this.hitChance = hitChance;
        hp = maxHp;
    }
    public boolean isDefeated(){
        if(hp == 0){
            return true;
        }
        else {
            return false;
        }
    }
    public void takeDamage(int damage){
        hp -= damage;
        if (hp < 0){
            hp = 0;
        }
    }
    public int attack(Player player){
        if (hitChance <= Math.random()){
            return -1;
        } else {
            int x = atk * (int) (Math.random() + 1); 
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
