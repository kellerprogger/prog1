public class RecursiveBacktracker implements MazeGenerator {
    
    char[][] map = {{'0','1','2','3','4','5','6','7','8'},
                    {'#','#','#','#','#','#','#','#','#'},
                    {'#',' ','#',' ','#',' ','#',' ','#'},
                    {'#','#','#','#','#','#','#','#','#'},
                    {'#',' ','#',' ','#',' ','#',' ','#'},
                    {'#','#','#','#','#','#','#','#','#'},
                    {'#',' ','#',' ','#',' ','#',' ','#'},
                    {'#','#','#','#','#','#','#','#','#'},
                    {'#',' ','#',' ','#',' ','#',' ','#'},
                    {'#','#','#','#','#','#','#','#','#'},
                    {'#','#','#','#','#','#','#','#','#'}
                    };

    private boolean[][] visitedField = new boolean[map.length][map[0].length];
     
    
    public char[][] generate(int y, int x){
        System.out.println(generator(x,y));
        
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

        if (!getVisitedField(x + 2, y)){ // If field Free return true
            orient[3] = true; //East

        } else if (!getVisitedField(x - 2, y)){
            orient[2] = true;// West

        } else if (!getVisitedField(x, y + 2)){
            orient[0] = true;// North

        } else if (!getVisitedField(x, y - 2)){
            orient[1] = true; //South

        } else {
            orient[4] = true; //NONE
        }
        return orient;
    }
    private boolean getVisitedField(int x, int y) { //Exeption out of bounds
        try {
            if (visitedField[y][x]){
                return true;
            }
            else{
                return false;
            }
        } catch(ArrayIndexOutOfBoundsException e){
            return true;
        }
    }
    private void setVisitedField(int x, int y) { //sets vistedfield
        //System.out.println(y +""+x);
        visitedField[y][x] = true;
    }
    private void removeWall(int orientation, int x, int y){
        try{
            if (orientation == 0){ // North
                map[y][x + 1] = FREE;
            } else if (orientation == 1){ //South
                map[y][x - 1] = FREE;
            } else if (orientation == 2){ //West
                map[y + 1][x] = FREE;
            } else if (orientation == 3){ //East
                map[y - 1][x] = FREE;
            } 
        }catch(ArrayIndexOutOfBoundsException r){
            System.out.println("Tried to remove non existing wall");
        }
    }
    /*
    randomField needs to to:
        get possible Fields
        choose a random one
        return orientation


    */
    private int[] randomField(int x, int y){
        boolean [] posField = freeField(x,y);
        
        int [] rField = new int[3];
        
        while(true){
            int rand = random();
            
            if (posField[rand] == true){
                rField[2] = rand;
                break;
            }
            else{
                continue;
            }
        }

        if (rField[2] == 0){ //North
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
        System.out.println("RANDOM: " + rField[0] +" "+rField[1] );
        return rField;

    }
    private int random(){
        int rand = (int)(Math.random() * 4); 
        return rand;
    }
}
