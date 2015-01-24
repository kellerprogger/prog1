public class RecursiveBacktracker implements MazeGenerator {
    
    char[][] map = {{'#','#','#','#','#','#','#','#','#'},
                    {'#',' ','#',' ','#',' ','#',' ','#'},
                    {'#','#','#','#','#','#','#','#','#'},
                    {'#',' ','#',' ','#',' ','#',' ','#'},
                    {'#','#','#','#','#','#','#','#','#'}
                    };
    
    boolean[][] pos = new boolean[map.length()][map[].length()];

    public char[][] generate(int y, int x){
                  
        yMod = randDirection()[0];
        xMod = randDirection()[1];
        
        if (pos[y][x] == true){
            
        } else {
            pos[y][x] = true;
            map[y][x] = '.';
            generate(y + yMod, x + xMod);
        }
        return map;
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


