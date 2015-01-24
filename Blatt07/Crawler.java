import java.util.Scanner;
public class Crawler{
    public static void main (String[]args){
        Scanner scan = new Scanner(System.in);
        //Player Position
        int x = 1;
        int y = 1;
        //TODO ADD USER INPUT  
            
        
    
        MazeGenerator gen = new RecursiveBacktracker(3,33);
        char[][] mapData = gen.generate(x,y);
        
        Level m  = new Level(mapData);
        m.setPlayerPosition(y,x);
         
        
        while (true){
            m.playerMapPosition(); 
            System.out.println(m.movement()); 
            String input = scan.nextLine();
            if (m.move(input)){
                System.out.println("Movement Succesfull");
                 if(m.possibleActions() == false){
                    break;
                 }
            } else {
                System.out.println("Movement Failed \uD83D\uDCA9");
                continue;
            }
        
        }    
    }
}


