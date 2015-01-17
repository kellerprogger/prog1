import java.util.Scanner;
public class Level {
    final char[][] mapData = {
    {"#","#","#","#","#","#","#"},
    {"#","S","B",".","T",".","#"},
    {"#",".","#","#","#","O","#"},
    {"#","B","O","#","#",".","#"},
    {"#",".",".","B","Z","T","#"},
    {"#","#","#","#","#","#","#"}
    };
    int[] playerPosition;
    char[][] newMapData;
    public Level(char[][] mapData){
        this.mapData = mapData;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        System.out.println(mapData)
    }

    public int[] GetPostionOfObject(char po){
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

    public void SetPlayerPosition(int[] newPlayerPosition){
        playerPosition = new PlayerPosition;

    }
    public  Action(int[] pos){
        if (newMapData[pos[0]][pos[1]].equals("B")){
            Battle();
        } else if (newMapData[pos[0]][pos[1]].equals("O")){
            Well();
        } else if (newMapData[pos[0]][pos[1]].equals("T")){
            Forge();
        } else if (newMapData[pos[0]][pos[1]].equals("Z")){
            Finish();
        } else{
            throw new IllegalArgumentException("Invalid Case");
        }
    }
    public boolean Movement(String dest){
        int[] newPos = playerPosition;

        if (dest.equals("N")){
            newPos[0] -= 1;
        } else if (dest.equals("S")){
            newPos[0] += 1;
        } else if (dest.equals("W")){
            newPos[1] -= 1;
        } else if (dest.equals("O")){
            newPos[1] += 1;
        } else{
            return false;
        }
        if (mapData[newPos[0]][newPos[1]].equals("#")){
            return false;
        } else {
            SetPlayerPosition(newPos)
            return true;
        }
    }

}
