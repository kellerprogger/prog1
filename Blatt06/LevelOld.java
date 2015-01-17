import java.util.Scanner;
public class Level {
    int[] playerPosition;
    final char[][] mapData = {
        {'#','#','#','#','#','#'},
        {'S','.','.','B','.','#'},
        {'#','.','#','.','.','#'},
        {'#','H','#','T','#','#'},
        {'#','.','#','.','Z','#'},
        {'#','#','#','#','#','#'},
        };
    char[][] newMapData = mapData;


    public  void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println(mapData);
        movement(input);

    }

    public int[] getPostionOfObject(char po){
        int[] objectPosition;
        for (int y = 0 ; mapData.length() < y ; y++){
            for (int x = 0; mapData[x].length() < x; x++){
                if (mapData[y][x].equals(po)){
                    objectPosition[0] = y; //Sets x and y Position of the Player
                    objectPosition[1] = x;
                }
            }
        }
        return objectPosition;
    }

    public void setPlayerMapPosition(int[] newPlayerPosition){
        int y = newPlayerPosition[0];
        int x = newPlayerPosition[1];
        newMapData[y][x] = 'P';
       
    }
    public void action(int[] pos){
        if (newMapData[pos[0]][pos[1]].equals('B')){
            LevelObjects.battle();
        } else if (newMapData[pos[0]][pos[1]].equals('O')){
           LevelObjects.well();
        } else if (newMapData[pos[0]][pos[1]].equals('T')){
            LevelObjects.Forge();
        } else if (newMapData[pos[0]][pos[1]].equals('Z')){
            LevelObjects.finish();
        } else{
            throw new IllegalArgumentException("Invalid Case");
        }
    }
    public boolean movement(String dest){
        int[] newPos = playerPosition;

        if (dest.equals('N')){
            newPos[0] -= 1;
        } else if (dest.equals('S')){
            newPos[0] += 1;
        } else if (dest.equals('W')){
            newPos[1] -= 1;
        } else if (dest.equals('O')){
            newPos[1] += 1;
        } else{
            return false;
        }
        if (mapData[newPos[0]][newPos[1]].equals('#')){
            return false;
        } else {
            setPlayerMapPosition(newPos);
            return true;
        }
    }

}
