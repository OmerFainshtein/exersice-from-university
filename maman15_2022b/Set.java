/**
 * this program contain methods for link list call Set.
 * a short discription of every method will show before the method.
 * the O of run time and memory will show in each method API
 *
 * @author OmerFainshtein
 * @version 06/2022
 */
public class Set
{
    private IntNode _head;
    /**
     * empty constractor that set the head of list as null
     */
    public Set()
    {
        _head = null;
    }
    /**
     * this method checking if the list is empty
     * return true if head position of the list is null (list must start with the haed position)
     * return false if head is different from null
     * run time & memory - O(1)
     */
    public boolean isEmpty()
    {
        return _head == null;
    }
    /**
     * this method checking if input number is in the link list Set
     * @param int - the number we checking for
     * return true if num is in the list
     * return false if num is not in the list
     * run time - O(n) , memory - O(1)
     */
    public boolean isMember(int num)
    {
        IntNode curr = _head;//new IntNode object
        while(curr != null)//the cell in list is not null
        {
            if(curr.getValue() == num)// if the object contain the int num
                return true;
            curr = curr.getNext();//moving forword the object to the next cell of the list
        }
        return false;// if we finish the list and didnt find num
    }
    /**
     * checking if 2 divverent list are equals or not
     * equals means every number list 1 contain is in list 2 , and the same for every number list 2 contain.
     * @param another list to compare with
     * return true if lists are equals 
     * return false if lists are not equals
     * run time - worst case is O(n^2), memory O(1)
     */
    public boolean equals(Set other)
    {
        if(other.numOfElements() == this.numOfElements())//checking if number of elements is the same on both of lists
        {
            if(this.subSet(other))//if the lists are with same amount of elements - checking if every number in other is in this and then they must be equals
                return true;
            return false;
        }
        return false;// not the same amount of elemnts mean not  equals
    }
    /**
     * checking how much elemnts there is in the list
     * return the number of elements in the list
     * run time - O(n) , memory - O(1)
     */
    public int numOfElements()
    {
        int counter=0;//set new counter with zero
        IntNode current = _head;//set IntNode obj that we use to move forword in list ( we dont want _head will show in the middle of list)
        while(current != null)//chcking if the list not end yet
        {
            counter++;//adding 1 o the counter
            current = current.getNext();//moving forword the object
        }
        return counter;
    }
    /**
     * checking if our list contain the given list
     * @param - other list to check with
     * return true if this list contain other list
     * return false else
     * run time - O(n), memory - O(1)
     */
    public boolean subSet(Set other)
    {
        if(other.isEmpty())//empty list is always subSet
            return true;
        //craete a copy of head 
        IntNode thisCurr = this._head;
        IntNode otherCurr = other._head;
        while(otherCurr != null)//if otherCurr == null, so we find every other list numbers in this list -> true
        {
            if(thisCurr == null)//if we finish this list numbers and didnt find match -> false
                return false;
            if(thisCurr.getValue() == otherCurr.getValue())// if we have match on specific value we move other list to next node and return this list to begining
            {
                    otherCurr = otherCurr.getNext();
                    thisCurr = this._head;
            }
            thisCurr = thisCurr.getNext();// if there is no match on current node we continue check other node with the rest of this list.
        }
        return true;
    }
    /**
     * assistent method theat check if the input int we get is vaild by the rule of the maman
     */
    private boolean isVaild(int x) //assistant method to know if param int is vaild for the rules of the link list
    {
        if(x%2!=0 && x>0) // positive and odd
            return true;
        return false;
    }
    /**
     * this method checking if the number is vaild and if he not in the list - then add him to the list
     * this method add number in sort way! it might having bigger run time but it make other method with smaller run time and more right to work with
     * @param int x - number we want to add to the list
     * run time O(n), memory - O(1)
     */
    public void addToSet(int x)
    {
        if(!isMember(x) && isVaild(x))//make sure the given num is vaild and not in the list
        {    
            IntNode add = new IntNode(x,null);//set new IntNde object with x in it
            if(isEmpty())//if the list is empty we adding the object with x to be the head
                _head = add;
            else if(_head.getValue()>x)//if head is bigger then x so x need to add in head postion
            {
                IntNode tmp = _head;
                _head = add;
                add.setNext(tmp);
            }
            else{//we need to move forword in list to fing the place the x need to be in
                IntNode ptr = _head;
                while(ptr.getNext() != null)//checking we didnt finish the list
                {
                    if(ptr.getNext().getValue()<x)//if x is bigger current cell in list we move the current cell forword on the list
                        ptr = ptr.getNext();
                    else break;//once we find the place x should be we break the while loop
                }
                add.setNext(ptr.getNext());//set add object with the cell we find that x need to be in
                ptr.setNext(add);
            }
        }
    }
    /**
     * remove given num x from the list (if x is in the list...)
     * @param int x - number we want to remove from list
     * run time - O(n) , memory - O(1)
     */
    public void removeFromSet(int x)
    {
        if(isVaild(x) && !isEmpty())//if list is empty or x is invaild so we cant to the remove
        {
            if (_head.getValue() == x)//if we found x so we fix the pointer
                _head = _head.getNext();
            else {
                IntNode behind = _head;
                if(isMember(x))//make sure x is in the list - if is not we dont need to check with the while loop
                {
                    while (behind.getNext() != null)//make sure list isnt end
                    {
                        if(behind.getNext().getValue()==x)//if we found x
                        {
                            behind.setNext(behind.getNext().getNext());//fix the pointer and remove x from the list
                            break;//break the loop cause we finish
                        }
                        behind = behind.getNext();//moving the cell in the list forword
                    }
                }
            }
        }
    }
    /**
     * build the String object that we will use to print the list
     * @return the String obj that we build from the list
     * run time - O(n) , memory - O(n) - i think so...
     */
    public String toString()
    {
        String str = "{";
        if(!isEmpty())//if the list is empty we have no number to print 
        {
            IntNode ind = _head;
            while(ind != null)
            {
                str =  str + ind.getValue();//adding the value in the current cell to the String obj
                if(ind.getNext() != null)//if we have more value to add to the String obj we add ,
                    str = str + ",";
                ind = ind.getNext();//moving forword the cell in the list
            }
        }
        str = str + "}";//finish the String obj 
        return str;
    }
    /**
     * check which number are in two different lists and build a new list that contain those numbers
     * @param other list to compare with our list
     * return new list that contain the number are in two of the lists]
     * run time - O(2n*n) = O(n^2), memory - O(n)(worst case)
     */
    public Set intersection (Set other)
    {
        IntNode tmp = _head;//create IntNode which we will move forword in the list instead head
        Set intersec = new Set();//create new Set object to fill with the numbers that shows on both lists
        while(tmp != null)//list not end
        {
            if(this.isMember(tmp.getValue()) && other.isMember(tmp.getValue()))//if current value is in both lists
                intersec.addToSet(tmp.getValue());// adding current value to new list
            tmp = tmp.getNext();//moving forword in list
        }
        return intersec;//return new list
    }
    /**
     * create a new list with the numbers that shows at list in one of the lists
     * @param other list to work with
     * return new list with all the numbers that shows in at least one of the list
     * run time - O(n^2) , memory - O(n)
     */
    public Set union (Set other)
    {
        IntNode tmp = this._head;//object that will move forword in this list
        IntNode sectmp = other._head;//object that will move forword in other list
        Set uni = new Set();//create new list which will contain the values in the union
        while(tmp != null)//adding all the values from this list to the new list
        {
            uni.addToSet(tmp.getValue());//adding all the values
            tmp = tmp.getNext(); //moving the object forword in the list 
        }
        while(sectmp != null)//make sure list isnt getting to the end
        {
            if(!(uni.isMember(sectmp.getValue())))//make sure the current value is not part of the new list (for senario that the value in both lists
                uni.addToSet(sectmp.getValue());//if value not in the uni list we add him
            sectmp = sectmp.getNext();//moving the object forword in the list
        }
        return uni;//return the new list we build
    }
    /**
     * create new list the contain the values in the 'this' list and not in 'other' list
     * @param other list to work with
     * return new list with the values shows in 'this' and not in 'other'
     * ru time - O(n^2) memory - O(n)
     */
    public Set difference (Set other)
    {
        IntNode tmp = this._head;//object that will move forword in this list
        IntNode sectmp = other._head;//object that will move forword in other list
        Set diff = new Set();//create new list which will contain the values in the difference
        while(tmp != null)//this list not end yet
        {
            if(!(other.isMember(tmp.getValue())))//make sure the value we check for isnt in the other list
                diff.addToSet(tmp.getValue());//if the value shows only in this list we adding him to the new list
            tmp = tmp.getNext();//moving the object forword in this list
        }
        return diff;//return the new list we create
    }
}
