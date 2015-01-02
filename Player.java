public class Player{
    int maxHp;
    int hp;
    int atk;
    int healingPower;
    int remainingItemUses;
    double hitChance;
    int ap;
    int maxAp;
    int apRegen;


    public Player(int maxHp, int atk, int healingPower, int remainingItemUses,
                    double hitChance, int maxAp, int apRegen){
        this.maxHp = maxHp;
        this.atk = atk;
        this.healingPower = healingPower;
        this.remainingItemUses = remainingItemUses;
        this.hitChance = hitChance;
        this.maxAp = maxAp;
        this.apRegen = apRegen;
        hp = maxHp;
        ap = maxAp;
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

    public int attack(Monster monster){
        if (hitchance <= Math.random()){
            return -1;
        } else {
            int x = atk * (int (Math.random() + 1) )
            monster.takeDamage(x);
            return x;
        }
    }

    public int getRemainingItemUses(){
        return remainingItemUses;
    }

    public boolean heal(){
        if (remainingItemUses > 0){
            remainingItemUses -= 1;
            hp += healingPower;
            if (hp > maxHp){
                hp = maxHp;
            }
            return true;
        } else {
            return false;
        }
    }

    public String toString(){
        return 
            "--------Spieler-------\n" +
            "HP: "+ hp + "\n" +
            "ATK: "+ atk + "\n" +
            "ATK: "+ atk + "\n" +
            "AP: "+ ap + "\n" +
            "Remaining Items: "+ getRemainingItemUses()) + "\n" +
            "----------------------" + "\n";
    
    }

    public int regenerateAp(){
        ap += apRegen;
        if (ap < maxAp){
            return ap;
        } else{
            return maxAp;
        }
    }

    public int cast(int spell, Monster monster){
        int dmg;
        int cost;
        switch (spell){
            case 1: dmg = 10; cost = 5;
            case 2: dmg = 20; cost = 13;
            case 3: dmg = 30; cost = 19;
        }
        if (ap >= cost){
            monster.takeDamage(dmg);
            ap -= cost;
            return dmg;
        } else {
            return -1;
        }
    }
    public String actions(){
        return
        "Moegliche Aktionen: \n" +
        "1 -> Attack \n" +
        "2 -> Item (" + getRemainingItemUses(); + " remaining) \n" +
        "3 -> Spell" +
        "Welche Aktion?:\n";
    }
}
