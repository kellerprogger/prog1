/**
    Hier befindet sich das Spiel
    @author Tyrfing
    @version 2.0.2
*/
import java.util.Scanner;
public class Game {
    public static void main(String [] doener) {

        Player spieler = new Player(333, 33, 42, 4, 0.8, 20, 3);
        // 5 Verschiedene Monster werden erstellt
        Monster m1 = new Monster1(100, 30, 0.4);
        Monster m2 = new Monster1(120, 10, 0.3);
        Monster m3 = new Monster1(420, 7, 0.6);
        Monster m5 = new Monster1(123, 10, 0.5);
        Monster m4 = new Monster1(666, 40, 0.5);

        double rand = Math.random();
        //Monster wird ausgewählt
        if (rand < 0.2) {
            fight(spieler, m1);
        } else if (rand < 0.4) {
            fight(spieler, m2);
        } else if (rand < 0.6) {
            fight(spieler, m3);
        } else if (rand < 0.8) {
            fight(spieler, m4);
        } else {
            fight(spieler, m5);
        }
    }
    /**
    Hier werden die Methoden für das Spiel aufgerufen:
    */
    public static void fight(Player player, Monster monster) {

        Scanner scan = new Scanner(System.in);
        int pDmg = 0;
        int mDmg;
        boolean pHeal;

        while (true) {
            System.out.println(player.toString());
            System.out.println(monster.toString());
            System.out.println(player.actions());
            String input = scan.nextLine();
            // Eingabe des Spielers wird ausgewertet
            if (input.equals("1")) {
                pDmg = player.attack(monster);

                if(pDmg == -1) {
                    System.out.println("Attack Missed");
                } else {
                    System.out.println("You've dealt: " + pDmg + " Damage" );
                }

            } else if (input.equals("2")) {

                pHeal = player.heal();

                if (pHeal == true ) {
                    System.out.println("You where healed by: "
                    + player.healingPower);
                } else {
                    System.out.println("Healing Failed!");
                }

            } else if (input.equals("3")) {
                System.out.println("Choose your Spell! :");
                System.out.println("*+*+*+*+*+*+*+* \n" +
                                   "1 --> Fireball (5 AP) \n" +
                                   "2 --> Iceball (13 AP) \n" +
                                   "3 --> Pokéball (19 AP) \n"+
                                   "Choose NOW !");
                String input2 = scan.nextLine();

                if (input2.equals("1")) {
                    pDmg = player.cast(1, monster);
                } else if (input2.equals("2")) {
                    pDmg = player.cast(2, monster);
                } else if (input2.equals("3")) {
                    pDmg = player.cast(3, monster);
                } else {
                    System.out.println("NOPE, thats not a Spell...");
                }

                if(pDmg == -1){
                    System.out.println("You have not enough AP!");
                } else {
                    System.out.println("You've dealt: " + pDmg + " Damage" );
                }

            } else {
                System.out.println("Invalid Action");
                continue;
            }
            if (monster.isDefeated() == true) {
                System.out.println("Monster is Defeated!");
                break;
            }

            //Monster starts here

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
