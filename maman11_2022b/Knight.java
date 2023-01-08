//this program read to number that symbol the location of knight on chessboard and pring the optionals movement posiotion.
import java.util.Scanner;
public class Knight
{
 public static void main (String [] args)
 {
    //declarations
    final int maxMovement = 2;// max possible move knight can make in one step.
    final int minMovement = 1;// min possible move knight can make in one step.
    final int maxChessboard = 8;//max row/col on standart chessboard
    final int outOfChessBoard = 0;//min row/col on standart chessboard
    Scanner scan = new Scanner (System.in);
    System.out.println ("This program reads two integers which " +
    "represent the knight's location on the chess board: ");
    System.out.println ("Please enter the number of row");
    int row = scan.nextInt();
    System.out.println ("Please enter the number of column");
    int col = scan.nextInt();
    if (row<1 || row>8 || col<1 || col>8) // checking if the input is inside the chaessboard
        System.out.println("Input is illegal");
    else
    {
        System.out.println("moves:");//checking every movement option - if the output are inside the chesscorad - it will print this movement option and continue to next movement option, else it just move for next one.
        if (row+maxMovement<=maxChessboard && col+minMovement<=maxChessboard)
             System.out.println(row+maxMovement + " " + (col+minMovement));
        if (row+maxMovement<=maxChessboard && outOfChessBoard<col-minMovement)
             System.out.println(row+maxMovement + " " + (col-minMovement));   
        if (outOfChessBoard<row-maxMovement && col+minMovement<=maxChessboard)
             System.out.println(row-maxMovement + " " + (col+minMovement));   
        if (outOfChessBoard<row-maxMovement && outOfChessBoard<col-minMovement)
             System.out.println(row-maxMovement + " " + (col-minMovement));   
        if (outOfChessBoard<row-minMovement && col+maxMovement<=maxChessboard)
             System.out.println(row-minMovement + " " + (col+maxMovement)); 
        if (row+minMovement<=maxChessboard && col+maxMovement<=maxChessboard)
             System.out.println(row+minMovement + " " + (col+maxMovement)); 
        if (outOfChessBoard<row-minMovement && outOfChessBoard<col-maxMovement)
             System.out.println(row-minMovement + " " + (col-maxMovement)); 
        if (row+minMovement<=maxChessboard && outOfChessBoard<col-maxMovement)
             System.out.println(row+minMovement + " " + (col-maxMovement)); 
    }
 } // end of method main
} //end of class Knight