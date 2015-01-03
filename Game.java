import java.util.Scanner;
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
    }
    public static void fight(Player player, Monster monster){
        
        Scanner scan = new Scanner(System.in);
        int pDmg;
        int mDmg;
        boolean pHeal;
        
        while (true){
            System.out.println(player.toString());
            System.out.println(monster.toString());
            System.out.println(player.actions());
            String input = scan.nextLine();
        
            if (input.equals("1")){
                pDmg = player.attack(monster);
                
                if(pDmg == -1){
                    System.out.println("Attack Missed");
                } else {
                    System.out.println("You've dealt: " + pDmg + " Damage" );
                }
                
            } else if (input.equals("2")){
                
                pHeal = player.heal();
                
                if (pHeal == true ){
                    System.out.println("You where healed by: "
                    +  player.healingPower);
                } else {
                    System.out.println("Healing Failed!");
                }

            } else if (input.equals("3")){

            } else {
                System.out.println("Invalid Action");
                continue;
            
            }
            if (monster.isDefeated() == true){
                System.out.println("Monster is Defeated!");
                break;
            }
            //Monster starts here
            System.out.println(player.toString());
            System.out.println(monster.toString());
            
            mDmg = monster.attack(player);
            
            if (mDmg == -1){
                System.out.println("Monster Missed!");
            } else {
                System.out.println("Monster dealt " + mDmg +" Damage!");
            }
            
            if (player.isDefeated() == true) {
                System.out.println("Player is Defeated!");
                break;
            }   
        }
    }
}
