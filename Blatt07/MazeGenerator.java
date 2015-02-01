/**
@author Tyrfing
@version 4.0.0
*/
public interface MazeGenerator {

    char WALL = '#';
    char FREE = '.';
    char START = 'S';
    char BATTLE = 'B';
    char FORGE = 'F';
    char WELL = 'W';
    char GOAL = 'Z';

    char[][] generate(int height, int width);

}
