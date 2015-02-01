/**
@author Tyrfing
@version 4.0.0
*/
public class RecursiveBacktracker implements MazeGenerator {

    int ySize;
    int xSize;
    boolean[][] visitedField; //= new boolean[ySize][xSize];
    char[][] map;


    RecursiveBacktracker(int ySize, int xSize){
        this.ySize = ySize;
        this.xSize = xSize;
        this.visitedField = new boolean[ySize][xSize];
        this.map = new char[ySize][xSize];
    }



       public char[][] generate(int yStart, int xStart){ // wants players start position

        if ( ySize % 2 == 1 && xSize % 2 == 1 && xSize*ySize >= 15){
            for (int i = 0; i < ySize; i++){
                for (int j = 0; j < xSize; j += 1){
                    if ( j % 2 == 0 || i == 0 || i == xSize - 1 || i % 2 == 0){
                        map[i][j] = WALL;

                    } else {
                        int rand = random();

                        if (rand == 1 && j % 2 == 1){
                            map[i][j] = BATTLE;
                        } else if(rand == 2 && j % 3 == 0) {
                            map[i][j] = FORGE;
                        } else if (rand == 3 && i % 3 == 1) {
                            map[i][j] = WELL;
                        } else{
                            map[i][j] = FREE;
                        }
                    }
                }
            }
            map[yStart][xStart] = START; //Sets Start
            //TODO FIX FINISH
            try{
                int yTarget = 1 + ( yStart * random() * ySize / 4) % ySize ;
                int xTarget = 1 + ( xStart * random() * xSize / 3) % xSize ;
                map[yTarget][xTarget] = GOAL ;

            }catch(ArrayIndexOutOfBoundsException e){
                int yTarget = ySize - 2;
                int xTarget = xSize - 2;
                map[yTarget][xTarget] = GOAL ;
            }


         } else{
            System.out.println("FAIL :'( \uD83D\uDCA9 ");
            return null; // Gen FAILED
        }

        System.out.println(generator(xStart, yStart));
        return map;
    }


    public boolean generator(int x, int y){
        while(freeField(x,y)[4] == false){
            int[] field = randomField(x,y);//returns a Random Field with Orientation

            removeWall(field[2], x, y); //field[2] holds orientation

            setVisitedField(field[0], field[1]);

            generator(field[0], field[1]);

        }
        return true;
    }
    private boolean[] freeField(int x, int y){
        boolean [] orient = new boolean [5];

        if (getVisitedField(x + 2, y) == 1){ // If field Free return true
            orient[3] = true; //East

        } if (getVisitedField(x - 2, y) == 1){
            orient[2] = true;// West

        } if (getVisitedField(x, y + 2) == 1){
            orient[0] = true;// North

        } if (getVisitedField(x, y - 2) ==1){
            orient[1] = true; //South


        }
        //System.out.println(orient[0] +" "+orient[1]+" "+orient[2]+" "+orient[3]);
        if (orient[0] || orient[1]|| orient[2]  || orient[3]){ //if one orient true..

            return orient;

        } else {
            orient[4] = true; // 4 means
            return orient;

        }


    }
    private int getVisitedField(int x, int y) { //Exeption out of bounds
        int i ;
        try {
            if (visitedField[y][x]){ //False == not visted
                i = 0;
                return i;
            }
            else{
                i = 1;
                return i;
            }
        } catch(ArrayIndexOutOfBoundsException e){
            i = -1;
            return i;
        }
    }
    private void setVisitedField(int x, int y) { //sets vistedfield
        //System.out.println(y +""+x);
        try{
        visitedField[y][x] = true;
        } catch (ArrayIndexOutOfBoundsException e){
            //NOTHING :)
        }
    }
    private void removeWall(int orientation, int x, int y){
        try{
            if (orientation == 0){ // North
                map[y + 1][x] = FREE;
            } else if (orientation == 1){ //South
                map[y - 1][x] = FREE;
            } else if (orientation == 2){ //West
                map[y][x - 1] = FREE;
            } else if (orientation == 3){ //East
                map[y][x + 1] = FREE;
            }
        }catch(ArrayIndexOutOfBoundsException r){
            System.out.println("Tried to remove non existing wall");
        }
    }

    private int[] randomField(int x, int y){
        boolean [] posField = freeField(x,y);

        int [] rField = new int[3];

        while (true) {
            int rand = random();
            //System.out.println(posField[0]+ " " + posField[1]+ " " + posField[2] +" " +posField[3] +" "+  posField[4]);
            //System.out.println(rand);
            if (posField[rand] == true) {

                rField[2] = rand;
                break;
            }
            if (posField[4]) {
                break;
            }
            else {
                continue;
            }
        }

        if (rField[2] == 0) { //North
            rField[0] = x;
            rField[1] = y + 2;

        } else if(rField[2] == 1){ // South
            rField[0] = x;
            rField[1] = y - 2;

        } else if(rField[2] == 2){ //West
            rField[0] = x - 2;
            rField[1] = y;

        } else if(rField[2] == 3){ //East
            rField[0] = x + 2;
            rField[1] = y;
        }
        //System.out.println("x = " + rField[0] +" y =  "+rField[1] );
        return rField;

    }
    private int random(){
        int rand = (int)(Math.random() * 4);
        return rand;
    }
}
