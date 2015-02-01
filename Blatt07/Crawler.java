/**
@author Tyrfing
@version 4.0.0
*/
import java.util.Scanner;
public class Crawler{
    public static void main (String[]args){
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);
        //Player Position
        int x = 1;
        int y = 1;
        //Map Size
        int xSize;
        int ySize;

        try{
            System.out.println("Mapsize must be greater than 15 Fields, you can only input odd Numbers");
            System.out.println("Enter the width of your Map!");
            xSize = scan.nextInt();

            System.out.println("Enter the height of your Map!");
            ySize = scan.nextInt();

            if (xSize < 3 || ySize < 3 || xSize * ySize < 15){
                throw new java.util.InputMismatchException();
            }
        }catch(java.util.InputMismatchException e){
            System.out.println("You can't type numbers so we're using the default value (15x15)");
            xSize = 15;
            ySize = 15;
        }

        MazeGenerator gen = new RecursiveBacktracker(ySize,xSize);
        char[][] mapData = gen.generate(x,y);

        Level m  = new Level(mapData);
        m.setPlayerPosition(y,x);


        while (true){
            m.playerMapPosition();
            System.out.println(m.movement());
            String input = scan1.nextLine();
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
