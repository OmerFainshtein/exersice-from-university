/**
 * This program contain methods and constructors for class Time2.
 * inside every method / constructor there is descreption of what they exectly do.
 * Represents time - hours:minutes. Values must represent a proper time.
 * version : 03/2022
 * author : OmerFainshtein
 */
public class Time2
{
    // instance variables - replace the example below with your own
    private int _minFromMid;
    private int minute;
    private int hour;
    public final int DEFAULT_NUM = 00;
    public final int MAX_HOUR = 23;
    public final int MIN_VALUE = 0;
    public final int MAX_MINUTE = 59;
    public final int MIN_IN_HOUR = 60;
    public final int HOURS_IN_DAY = 24;
    public final int MINUTE_IN_DAY = 1440;
    public final int FIX_STRING = 10;
    //constructors
    /** constroctor1
    Constructs a Time2 object. Construct a new time instance with the specified hour and minute.
    hour should be between 0-23, otherwise it should be set to 0.
    minute should be between 0-59, otherwise it should be set to 0.
    @param : hour , minute.
    */
    public Time2 (int hour, int minute)
    {
        if (hour < MIN_VALUE || hour > MAX_HOUR) 
            hour = DEFAULT_NUM;
            else this.hour = hour;
        if (minute < MIN_VALUE || minute > MAX_MINUTE)
            minute = DEFAULT_NUM;
            else this.minute = minute;
        _minFromMid = hour*MIN_IN_HOUR + minute;
    }
    /**Copy constructor for Time2. Constructs a time with the same variables as another time.
     * @param other - The time object from which to construct the new time
     */
    public Time2 (Time2 other)
    {
        if (other.hour < MIN_VALUE || other.hour > MAX_HOUR) 
            hour = DEFAULT_NUM;
            else hour = other.hour;
        if (other.minute < MIN_VALUE || other.minute > MAX_MINUTE)
            minute = DEFAULT_NUM;
            else minute = other.minute;
        _minFromMid = hour*MIN_IN_HOUR + minute;
    }
    //methods
    /**
     * @Returns the hour of the time.
     */
    public int getHour()
    {
        return (_minFromMid/MIN_IN_HOUR);
    }
    /**
     * @Returns the minute of the time.
     */
    public int getMinute()
    {
        return _minFromMid%MIN_IN_HOUR;
    }
    /**
     * Changes the hour of the time. If an illegal number is received hour will be unchanged.
    @Parameters num - The new hour
     */
    public void setHour(int num)
    {
        if (num > MAX_HOUR || num < MIN_VALUE)
        _minFromMid = this._minFromMid;
    else _minFromMid = num*MIN_IN_HOUR + this._minFromMid%MIN_IN_HOUR;
    }
    /**
     * Changes the minute of the time. If an illegal number is received minute will be unchanged.
    @Parameters num - The new minute
     */
    public void setMinute(int num)
    {
        if (num > MAX_MINUTE || num < MIN_VALUE)
        _minFromMid = _minFromMid;
    else _minFromMid = this._minFromMid - this._minFromMid%MIN_IN_HOUR + num;
    }
    /**
     * Return the amount of minutes since midnight.
     @Returns amount of minutes since midnight.
     */
    public int minFromMidnight()
    {
     return _minFromMid;
    }
    /**
     * Check if the received time is equal to this time.
    @Parameters other The time to be compared with this time
    @returns True if the received time is equal to this time
     */
    public boolean equals(Time2 other)
    {   
        return (other._minFromMid == this._minFromMid);
    }
    /**
     * Check if this time is before a received time.
    @Parameters other - The time to check if this point is before
    @returns  True if this time is before other time
    */
    public boolean before(Time2 other)
    {
        return (this._minFromMid < other._minFromMid);
    }
    /**
     * Check if this time is after a received time.
    @Parameters other - The time to check if this point is after
    @returns True if this time is after other time
     */
    public boolean after(Time2 other)
    {
        return (other.before(this));
    }
    /**
     * Calculates the difference (in minutes) between two times. Assumption: this time is after other time.
    @Parameters other - The time to check the difference to
    @returns int difference in minutes
    */
    public int difference(Time2 other)
    {      
        return (this._minFromMid - other._minFromMid); 
    }
    /**
     * Return a string representation of this time.
    @Overrides toString in class java.lang.Object
    @returns String representation of this time (hh:mm).
     */
    public String toString()
    {
        return ((_minFromMid/MIN_IN_HOUR)/FIX_STRING + "" + (_minFromMid/MIN_IN_HOUR)%FIX_STRING + ":" + (_minFromMid%MIN_IN_HOUR)/FIX_STRING + "" + (_minFromMid%MIN_IN_HOUR)%FIX_STRING);
    }
    /**
     * set new object in Time2 format, doing a calculates and return the object after the neccecery calculates.
     @parameters num = int 
     */
    public Time2 addMinutes(int num)
    {
        int newMinute , newHour;
        int newMinFromMid = this._minFromMid + num;
        
        if(newMinFromMid > MINUTE_IN_DAY)
            {
                newHour = ((newMinFromMid%MINUTE_IN_DAY)/MIN_IN_HOUR);
                newMinute = ((newMinFromMid%MINUTE_IN_DAY)%MIN_IN_HOUR);
            }
            else if(newMinFromMid < MIN_VALUE){
                    newHour = (((newMinFromMid%MINUTE_IN_DAY) + MINUTE_IN_DAY)/MIN_IN_HOUR);
                    newMinute = (((newMinFromMid%MINUTE_IN_DAY) + MINUTE_IN_DAY)%MIN_IN_HOUR);
            }
            else
            {
            newHour = newMinFromMid/MIN_IN_HOUR;
            newMinute = newMinFromMid%MIN_IN_HOUR;
            }
        Time2 llegalTime2 = new Time2(newHour, newMinute);
        return llegalTime2;
    }
}