public class Game{
    public static void main(String [] döner){
        
        Player spieler = new Player(100, 50, 42, 4, 0.5, 20, 3);
        
        Monster m1 = new Monster(100, 30, 0.4);
        Monster m2 = new Monster(120, 10, 0.3);
        Monster m3 = new Monster(420, 7, 0.6);
        Monster m5 = new Monster(123, 10, 0.11);
        Monster m4 = new Monster(666, 40, 0.01);
        
        double rand = Math.random();
        
        if (rand < 0.2){
            fight(spieler, m1);
        }
        else if (rand < 0.4){
            fight(spieler, m2);
        }
        else if (rand < 0.6){
            fight(spieler, m3);
        }
        else if (rand < 0.8){
            fight(spieler, m4);
        }
        else {
            fight(spieler, m5);
        }
        
    public void fight(Player player, Monster monster){
        
        
    }
    }
}
