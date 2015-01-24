public class RecursiveBacktracker implements MazeGenerator {

    private boolean[][] visitedField = new boolean[map.length()][map[].length()];

    public char[][] generate(int y, int x){

        char[][] map = {{'#','#','#','#','#','#','#','#','#'},
                        {'#',' ','#',' ','#',' ','#',' ','#'},
                        {'#','#','#','#','#','#','#','#','#'},
                        {'#',' ','#',' ','#',' ','#',' ','#'},
                        {'#','#','#','#','#','#','#','#','#'}
                        };
    }

    public boolean generator(int x, int y){
        while(freeField(x,y)){
            int[] field = randomField(x,y);
            removeWall(field[3], x, y); //field[3] holds orientation
            setVisitedField(field);
            generator(field[0], field[1]);

        }
        return true;
    }
    private boolean freeField(int x, int y){
        if (!getVisitedField(x + 1, y)){ // If field Free return true
            return true;
        } else if (!getVisitedField(x - 1, y)){
            return true;
        } else if (!getVisitedField(x, y + 1)){
            return true;
        } else if (!getVisitedField(x, y - 1)){
            return true;
        else{
            return false;
        }
    }
    private boolean getVisitedField(int x, int y){
        if (visitedField[y][x]){
            return true;
        }
        else{
            return false;
        }
    }
    private void setVisitedField(int x, int y){
        visitedField[y][x] = true;
    }
    private void removeWall(int orientation, int x, int y){
        if (orientation == 0){ // North
            map[y][x + 1] = '.';
        } else if (orientation == 1){ //South
            map[y][x - 1] = '.';
        } else if (orientation == 2){ //West
            map[y + 1][x] = '.';
        } else if (orientation == 3){ //East
            map[y - 1][x] = '.';
        }
    }
    private int[]randomField(int x, int y){
        
    }
}
