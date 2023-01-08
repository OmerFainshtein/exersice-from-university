/**
 * This program contain my solution for maman14
 * American qustions will show on first qustion API
 * @author OmerFainshtein
 * @version 05.2022
 */
public class Ex14
{
    /**
     * answer for qustion number 1 seif a
     * the corrent sentenses are : 3,5,6
     */
    //***************** qustion #1 ******************
    // the corrent sentenses are : 3,5,6
    /**
     * qustion number 1 seif b part 1
     * this method check if input value is in the known array
     * when what return true the array sorted so every row and every col sorted itself from small value to big value
     * the method trying to 'follow' the input val by the defination of array in method what - move left if val is < then current cell and down if val > then current cell
     * @param val - input value we looking for
     *        m - the array we search in
     * return true if val in array and false for else
     * number of steps is known and each loop contain maximum 2 steps so O(2n) = O(n) its the complexity time, and we dont build the array in this method so space complexity is O(1)
     */
    public static boolean findValWhat (int [][] m, int val)
    {//given that number of row = number of col
        if (val > m[m.length-1][m.length-1] || val < m[0][0])//chack if val bigger then max value in array or smaller then min value in array
            return false;
        int i=0, j=m.length-1;
        while(i<m.length && j>=0)//.
        {
            if(val==m[i][j])//check if this cell contain val 
                return true;
            if(val<m[i][j])//check if the cell value bigger then val - and move left in the same row if its happen
                j--;
            if(val>m[i][j])//check if the cell value smaller then val - and move down in the same col if its happen
                i++;
        }
        return false;//val not found
    }
    /**
     * qustion number 1 seif b part 2
     * this method search for input value in array - given that method test return true so we know every cell in row i is smaller / equals to every cell in row i+1
     * start with check the first and last row 
     * then check for every followed row if val between the first value in each row - if val is between so we search in this 2 row for val 
     * by defination of test method - if val not found in that case - o is not in the array.
     * @param val - input value we looking for
     *        m - array we search in
     * return true if val in array and false if not
     * n+n+n +2n = 5n => O(n). this method dont creat the array so space complexity is O(1).
     */
    public static boolean findValTest(int[][]m, int val)
    {
        for(int i=0; i<m.length; i++)//sercing in first row of array. n step
        {
            if(val == m[0][i])
                return true;
            if(val == m[m.length-1][i])
                return true;
        }
        for(int k=0; k<m.length-1; k++) //max n steps => O(n)
        {
            if(val >= m[k][0] && val <= m[k+1][0])//checking if val is between 2 value (array sort so every value in row <= every value in the next row)
            {
                for(int n=0; n < m.length; n++)//once we got in if - we make 2n steps
                {
                    if(val == m[k][n] || val == m[k+1][n])//serching in 2 rows - if val shows in array - he will be in one of this rows.
                        return true;
                }
                return false;
            }
        }
        return false;
    }
    //qustion #2
    /**
     * qustion number 2
     * this method gets array and looking for the longest strictly increasing number
     * @param - a = 1D array 
     * return the number of the longest strictly increasing number
     * //O(n+param) = O(n) time. this method get the array as a parameter so space complexity is O(1)
     */
    public static int strictlyIncreasing(int[] a)
    {
        int strike = 1 , count = 0;//strike is a temporary variable remmember the corrent long of srtictly increasing. count is varieble that sum the number +
        // + of combination of strictly increasing
        for(int i=0; i<a.length-1; i++)//n steps => O(n)
        {
            if(a[i]<a[i+1])
            {
                strike++;// counting number of strictly increasing cells
            }
            else 
            {
                count += ((strike*(strike-1))/2); // calculate count by adding the num of combination we got from strike
                strike = 1;
            }
        }
        if(strike > 1)//checking if we need to update count for the last time
            {
                count += (((strike - 1) * strike) / 2);
            }
        return count;//return the value of count which reprersent the num of subarray that strictly increasing.
    }
    //qustion #3
    /**
     * qustion number 3
     * this method is a assistant method, get 1D array from spesific index and return the longest lengthFlat (defination of lengthFlat in maman14)
     * @param : arr - array we work with
     *          index - the col index we start to check from
     *          jump - number of cell we move forword to check from index
     *          counterUp - counter that keeps and update the current lengthFlat
     *          counterDown - same as up just counting for number smaller by 1 or equals to val in index
     *          maxCounter - keep and update the maximum of counterUp and counterDown all way long so we can know what is the max lengthFlat
     * return the number of max lengthFlat in the cells we looked in
     */
    private static int lengthFlat (int [] arr, int index, int jump, int counterUp, int counterDown, int maxCounter)//assistant method
    {
        if(index == arr.length)//checking if the array end
            return maxCounter;
        if(index+jump != arr.length)//checking if the cell index+jump in array (once index+jump = arr.length we finish the check of cell index)
        {
            if(arr[index] == arr[index+jump] || arr[index]+1 == arr[index+jump])//cheking the terms of the sequence (should be equals or bigger then [index] by one)
            {
                counterUp++;
                if(counterUp > maxCounter)//update the maxCounter
                    maxCounter = counterUp;
                return lengthFlat(arr, index, jump+1, counterUp, 0, maxCounter);//continue checking the flat sequence for jump+1
            }
            if(arr[index] == arr[index+jump] || arr[index]-1 == arr[index+jump])//cheking the terms of the sequence (should be equals or smaller then [index] by one)
            {
                counterDown++;
                if(counterDown > maxCounter)//update the maxCounter
                    maxCounter = counterDown;
                return lengthFlat(arr, index, jump+1, 0, counterDown, maxCounter);//continue checking the flat sequence for jump+1
            }
        }
        return lengthFlat(arr, index+1, 0, 0, 0, maxCounter);//finish with [index] and start checking for [index+1]
    }
    /**
     * qustion number 3
     * this method use the lengthFlat method - starting the checks from the first index so we can get the longest lengthFlat in the array
     * @param arr - array we search in
     * return the int we get from lengthFlat method
     */
    public static int longestFlatSequence (int[] arr)
    {
        return lengthFlat(arr, 0, 0, 0, 0, 0);//call to method lengthFlat with param that will do the search on all array cells
    }
    //qustion #4
    /**
     * this method check if the cell we want to go into is vaild
     * vaild mean value is different from -1 and in array borders
     * @param mat - array
     *        indRox - row index
     *        indCol - col index
     * return true if cell is vaild and false for else
     */
    private static boolean isSafe(int[][] mat, int indRow, int indCol)
    {
        return !(indRow < 0 || indRow >= mat.length || indCol < 0 || indCol >= mat[0].length ||
                mat[indRow][indCol] == -1);
    }
    // Function to collect the maximum number of ones starting from
    // cell mat[i][j]
    /**
     * this method get array and index of row and col and walking in all vaild route and sum the numbers in the cell (0 or 1, -1 not vaild)
     * @param  mat - array
     *        indRox - row index
     *        indCol - col index
     * return the number of max score we get in the routes.
     */
    public static int findCurMaximum(int[][] mat, int indRow, int indCol)
    {
        if (mat[0][0] == -1 || mat.length == 0) {
            return -1;
        }
 
        // return if cell (i, j) is invalid or unsafe to visit
        if (!isSafe(mat, indRow, indCol)) {
            return 0;
        }
 
        // if the row is odd, we can go left or down
        if (indRow%2 != 0) {
            if(findCurMaximum(mat, indRow, indCol - 1) > findCurMaximum(mat, indRow + 1, indCol))
            
            return mat[indRow][indCol] + (findCurMaximum(mat, indRow, indCol - 1));
            else return mat[indRow][indCol] + findCurMaximum(mat, indRow + 1, indCol);
        }
 
        // if the row is even, we can go right or down
        else {
            if(findCurMaximum(mat, indRow, indCol + 1) >  findCurMaximum(mat, indRow + 1, indCol))
                return mat[indRow][indCol] + findCurMaximum(mat, indRow, indCol + 1);
            else return mat[indRow][indCol] +findCurMaximum(mat, indRow + 1, indCol);
        }
    }
    /**
     * this mathod use findCurMaximum method with param of cell (0,0) 
     * @param mat - array we work with
     * return the maximum score we can achive in array 
     */
    public static int findMaximum(int [][] mat)
    {
        return findCurMaximum(mat, 0,0);// using findCurMaximum from index (0,0) and search in all array for max score
    }
}