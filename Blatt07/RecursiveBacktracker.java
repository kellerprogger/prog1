public class RecursiveBacktracker implements MazeGenerator {

char[][] map = {{'#','#','#','#','#','#','#','#','#'},
                        {'#',' ','#',' ','#',' ','#',' ','#'},
                        {'#','#','#','#','#','#','#','#','#'},
                        {'#',' ','#',' ','#',' ','#',' ','#'},
                        {'#','#','#','#','#','#','#','#','#'}
                      };


    public char[][] generate(int y, int x){
        if (pos[y][x] == true){
            
        } else {
            pos[y][x] = true;

            generate(y + yMod, x + xMod);
        }
    }    
    public int[] randDirection() {
        rand = math.Random();
        
        if (rand <= 0.25) {
            return int[] i = {0, 1}; // x = 1
        
        } else if (rand <= 0.5) {
            return int[] i = {1, 0}; // y = 1
        
        } else if (rand <= 0.75) {
            return int[] i = {0, -1}; // x = -1 
        
        } else {
            return int[] i = {-1, 0}; // y = -1
        }
    }
}


