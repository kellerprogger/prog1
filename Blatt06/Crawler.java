import java.util.Scanner;
public class Crawler{
    public static void main (String[]args){
        Scanner scan = new Scanner(System.in);
        char [][]mapData0 = {
        {'#','#','#','#','#','#','#'},
        {'#','S','.','#','B','F','#'},
        {'#','#','B','.','.','#','#'},
        {'#','#','.','#','.','#','#'},
        {'#','.','O','B','#','#','#'},
        {'#','#','.','.','.','Z','#'},
        {'#','.','B','.','T','#','#'},
        {'#','.','.','.','.','.','#'},
        {'#','#','.','.','#','#','#'},
        {'#','#','#','#','#','#','#'}
        }; 
        
        Level m  = new Level( mapData0);
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


