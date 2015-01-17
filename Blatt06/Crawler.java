import java.util.Scanner;
public class Crawler{
    public static void main (String[]args){
        Scanner scan = new Scanner(System.in);
        char [][]mapData0 = {
        {'#','#','#','#','#','#','#'},
        {'#','Z','.','#','S','O','#'},
        {'#','#','.','.','.','#','#'},
        {'#','.','B','.','T','#','#'},
        {'#','.','.','.','.','.','#'},
        {'#','#','.','.','B','#','#'},
        {'#','#','#','#','#','#','#'}
        }; 
        

        Level m  = new Level( mapData0);
        m.setPlayerPosition(1,1);
        m.playerMapPosition(); 
        
        while (true){
            System.out.println(m.movement()); 
            String input = scan.nextLine();
            if (m.move(input)){
                System.out.println("Movement Succesfull");
                m.playerMapPosition();
            } else {
                System.out.println("Movement Failed");
                continue;
            }
        
        }    
    }
}


