public class Level{
    char[][] mapData;
    public Level(char[][] mapData){
    this.mapData = mapData;
    
    }
    public void printer(char[][]map){
        for (int y = 0; y < map.length; y++){
            for (int x = 0; x < map[y].length; x++){
                if (x + 1  == map[y].length){
                    System.out.println(map[y][x]);
                }else{
                    System.out.print(map[y][x] + " ");
                }
            }
        }
    }
    public void setPlayerMapPosition(int x, int y){
        char[][]map = mapData;
        map[y][x] = 'P';
        printer(map);
    }
}

