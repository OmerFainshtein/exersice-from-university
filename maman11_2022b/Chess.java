//this program read 2 out of 3 possible chessmen and their locations.
// first, the program check if the inputs are llegal.
// then chacking if there is a threat between the chessmens.
// if there is no threat - the progrem print 'no threat'
import java.util.Scanner;
public class Chess
{
    public static void main (String [] args)
    {
        //declarations
        String bishop = "bishop";
        String knight = "knight";
        String rook = "rook";

        Scanner scan = new Scanner (System.in);
        System.out.println("Please enter the type"+
        " of the first chessman");
        char first = scan.next().charAt(0);
        System.out.println ("Please enter the number of row");
        int row1 = scan.nextInt();
        System.out.println ("Please enter the number of column");
        int col1 = scan.nextInt();
        System.out.println("Please enter the type"+
        " of the second chessman");
        char second = scan.next().charAt(0);
        System.out.println ("Please enter the number of row");
        int row2 = scan.nextInt();
        System.out.println ("Please enter the number of column");
        int col2 = scan.nextInt();
        //declare string name for the intaraction between first and second. i'll use this to avoid write each formula twice.
        String name = "";
        if (second == 'b')
        name = bishop;
        else if (second == 'k')
        name = knight;
        else if (second == 'r')
        name = rook;
        // make sure the input is llegal. by demend this code will read all the input and then chack if each input is llegal.
        if (row1<1 || row1>8 || col1<1 || col1>8 || row2<1 || row2>8 || col2<1 || col2>8)
            System.out.println("Position is not legal");
        else{
            if(first == second)
                System.out.println("Chessmen should be different from each other");
            else{
                if(row1 == row2 && col1 == col2)
                    System.out.println("Chessmen positions should not be identical");
                else{
                    //i've splited the option into switch cases for the first chessman, inside every case there is 3 inner option :first threat second (second == name), second threat first (2 options).
                    switch (first){
                        case 'b' : if((name == rook) &&(row1 - row2) == 0 || (col1 - col2) == 0) //formula for rook's threat
                                        System.out.println("rook threats bishop");
                                        else
                                        if(((name == knight) && (Math.abs(row1 - row2)+Math.abs(col1 - col2)) == 3))//formula for knight's threat
                                            System.out.println("knight threats bishop");
                                            else
                                            if(row1 - col1 == row2 - col2 || row1 + col1 == row2 + col2)//formula for bishop's threat
                                                System.out.println("bishop threats " + name);
                                                    else System.out.println("no threat");
                        break;
                        case 'k' : if((name == rook) && (row1 - row2) == 0 || (col1 - col2) == 0)
                                        System.out.println("rook threats knight");
                                        else
                                        if((name == bishop) && (row1 - col1 == row2 - col2 || row1 + col1 == row2 + col2))
                                                System.out.println("bishop threats knight");
                                            else
                                            if((Math.abs(row1 - row2)+Math.abs(col1 - col2)) == 3)
                                            System.out.println("knight threats " + name);
                                                else System.out.println("no threat");
                        break;
                        case 'r' : if((name == knight) && (Math.abs(row1 - row2)+Math.abs(col1 - col2)) == 3)
                                            System.out.println("knight threats rook");
                                            else
                                            if((name == bishop) &&(row1 - col1 == row2 - col2 || row1 + col1 == row2 + col2))
                                                System.out.println("bishop threats rook");
                                                else
                                                if((row1 - row2) == 0 || (col1 - col2) == 0)
                                                System.out.println("rook threats " + name);
                                                    else System.out.println("no threat");
                        break;
                        }//switch end
                    }                    
                }
            }
        }// end of method main
    } //end of class Chess