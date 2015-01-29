public class RecursiveBacktracker implements MazeGenerator {
    
//    TODO WRITE CONSTRUCTOR !!!!

    boolean[][] visitedField = new boolean[33][33];
    char[][] map = new char[33][33];
    
    public char[][] generate(int y, int x){
       
        if ( y % 2 == 1 && x % 2 == 1){
            for (int i = 0; i < y; i++){
                for (int j = 0; j < x; j += 1){
                    if ( j % 2 == 0 || i == 0 || i == y - 1 || i % 2 == 0){
                        map[i][j] = '#';
                    } else {
                        map[i][j] = '.';
                    }
                }    
            }               

        } else{
            System.out.println("Upppsi");
        }

        System.out.println(generator(3,3));
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
        if (orient[0] || orient[1]|| orient[2]  || orient[3]){
            
            return orient;
    
        } else {
            orient[4] = true; 
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
