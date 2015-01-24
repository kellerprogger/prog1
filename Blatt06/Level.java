public class Level{
    char[][] mapData;
    char[][] map;
    int[]playerPosition = {0,0};
    boolean[] d = {false,false,false,false}; // 0==N,1==S,2==W,3==E
    boolean[][] usedField = new boolean [999][999]; //MAX FIELD SIZE
    Player spieler = new Player(333, 33, 42, 4, 0.8, 20, 3); 
    
    
    
    
    public Level(char[][] mapData){
        this.mapData = mapData;
        this.map = deepCopy(mapData);
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
    public char[][] deepCopy(char[][] map){
        char[][] copy = new char[map.length][map[0].length];
        for (int y = 0; y < map.length; y++){
            for (int x = 0; x < map[y].length; x++){
                copy[y][x] = map[y][x];
            }
        }
        return copy;
    }
    public void playerMapPosition(){
        map = deepCopy(mapData); 
        int x = playerPosition[0];
        int y = playerPosition[1];
        map[y][x] = 'P';
        printer(map);
        
    }
    public String movement(){
        d[0] = false;
        d[1] = false;
        d[2] = false;
        d[3] = false;

        int y = playerPosition[1];
        int x = playerPosition[0];
        String way  = "You can go: ";

        if (mapData[y - 1][x] != '#'){
         way += "North(n)";
         d[0] = true;

        } if (mapData[y + 1][x] != '#'){
         way += " South(s)";
         d[1] = true;

        } if (mapData[y][x - 1] != '#'){
         way += " West(w)";
         d[2] = true;
         
        } if (mapData[y][x + 1] !=  '#') {
         way += " East(e)";
         d[3] = true;

        } 
        return way;
    }
    public boolean move (String insert){
        if (insert.equals("n") && d[0]){
            playerPosition[1] -= 1;
            return true;

        }else if (insert.equals("s") && d[1]){
            playerPosition[1] += 1;  
            return true;

        }else if (insert.equals("w") && d[2]){
            playerPosition[0] -= 1;
            return true;

        }else if  (insert.equals("e") && d[3]){
            playerPosition[0] += 1;
            return true;
        }else {
            return false;
        }
            
    }


    public void setPlayerPosition(int x, int y){
        playerPosition[0] = x;
        playerPosition[1] = y;
    }
    public boolean possibleActions(){
        //test();
        int x = playerPosition[0];
        int y = playerPosition[1];
        if(usedField[x][y] == true ){
            System.out.println("I think you already know this Place...");
            return true;

        }else if (mapData[y][x] == 'B'){
            System.out.println("Battle");
            Game g = new Game();
            usedField[x][y] = true;

            return g.createMonsterFight(spieler);

        } else if (mapData[y][x] == 'F'){
            System.out.println("Forge");
            forge();
            usedField[x][y] = true;
            return true;
        
        } else if (mapData[y][x] == 'W'){
            System.out.println("Well");
            well();
            usedField[x][y] = true;
            return true;
        
        } else if (mapData[y][x] == 'Z'){
            System.out.println("You have Won the Game");
            return false;
        
        } else {
            System.out.println("Nothing Happend .. -.. .. --- -");
            return true;
        }
    }
    public void well(){
        spieler.hp = spieler.maxHp;
        spieler.ap = spieler.maxAp;
        System.out.println("You Hp and Ap are refreshed");

    }
    public void forge(){
        spieler.atk += 10;
        System.out.println("You got 10ATK");
    }
   /* public void test(){
        System.out.println("ATK: " + spieler.atk);
        System.out.println("MAXPHP: " + spieler.maxHp);
        System.out.println("HP: " + spieler.hp);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }*/
}

