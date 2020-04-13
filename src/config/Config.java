package config;
import java.math.BigInteger;
public interface Config {

    int SIZE_X = 7;
    int SIZE_Y = 6;
    int BOARD_CENTER= 3;

    //Search
    int DEPTH = 2;

    //Scores
    int ONE_IN_A_ROW = 1;

    int TWO_IN_A_ROW = 4;
    int TWO_IN_A_ROW_W_SPACES = 3;

    int THREE_IN_A_ROW = 9;
    int THREE_IN_A_ROW_W_SPACES = 8;

//    int SPACE_TO_GROW = 2;

    //Constants
    double CONSECUTIVE = 1;
    double SPACE_TO_GROW = 1;
    double SIBLINGS = 1;

    double FOUR_IN_A_ROW = 1000;
    int LOSE = -1000;


}
