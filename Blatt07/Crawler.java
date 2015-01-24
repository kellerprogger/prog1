import java.util.Scanner;
public class Crawler{
    public static void main (String[]args){
        Scanner scan = new Scanner(System.in);
        
        /*char [][]mapData0 = {
        {'#','#','#','#','#','#','#'},
        {'#','S','.','#','B','F','#'},
        {'#','#','B','.','.','#','#'},
        {'#','#','.','#','W','#','#'},
        {'#','.','W','B','#','#','#'},
        {'#','#','.','.','.','Z','#'},
        {'#','.','B','.','F','#','#'},
        {'#','.','.','.','.','.','#'},
        {'#','#','.','.','#','#','#'},
        {'#','#','#','#','#','#','#'}
        }; */ 
        
        MazeGenerator gen = new RecursiveBacktracker();
        char[][] mapData = gen.generate(1,1);
        
        Level m  = new Level(mapData);
        m.setPlayerPosition(1,1);
         
        
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
                System.out.println("Movement Failed");
                continue;
            }
        
        }    
    }
}


