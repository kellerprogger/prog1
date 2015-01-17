public class Crawler{
    public static void main (String[]args){
        char [][]mapData = {
        {'#','#','#','#','#','#','#'},
        {'#','Z','.','#','S','O','#'},
        {'#','#','.','#','.','#','#'},
        {'#','.','B','#','T','#','#'},
        {'#','.','.','#','.','.','#'},
        {'#','#','.','.','B','#','#'},
        {'#','#','#','#','#','#','#'}
        };
        
        Level m  = new Level(mapData);
        m.printer(mapData);
        m.setPlayerMapPosition(4,1); // Format x,y 
        
        //System.out.println(mapData[0][1]);
    
    }
  }


