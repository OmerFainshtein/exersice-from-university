/**
 * Represents time - hours:minutes. Values cannot be negative.
 * This program contain methods and constructors for class Time1
 * inside every method / constructor there is descreption of what they exectly do.
 * version : 03/2022
 * author : @OmerFainshtein
 */
public class Time1
{
    // instance variables - replace the example below with your own
    private int _hour;
    private int _minute;
    public final int MAX_HOUR = 23;
    public final int MIN_VALUE = 0;
    public final int MAX_MINUTE = 59;
    public final int HOURS_IN_DAY = 24;
    public final int MINUTE_IN_HOUR = 60;
    public final int MINUTE_IN_DAY = 1440;
    public final int DEFAULT_TIME = 00;
    public final int DIVIDE_PARAM= 10;
    
    //constructors
    /** constroctor1
    Constructs a Time1 object. Construct a new time instance with the specified hour and minute.
    hour should be between 0-23, otherwise it should be set to 0.
    minute should be between 0-59, otherwise it should be set to 0.
    @param : hour = _hour , minute = _minute
    */
    public Time1 (int hour, int minute)
    {
        if (hour < MIN_VALUE || hour > MAX_HOUR) 
            hour = DEFAULT_TIME;
        else _hour = hour;
        if (minute < MIN_VALUE || minute > MAX_MINUTE)
            minute = DEFAULT_TIME;
        else _minute = minute;
    }
    /** Copy constructor for Time1. Construct a time with the same instance variables as another time.
    @Parameters other - The time object from which to construct the new time
    */
    public Time1 (Time1 other){
        _hour = other._hour;
        _minute = other._minute;
    }
    //methods
    /**
     * @Returns the hour of the time.
     */
    public int getHour(){
        return _hour;
        }
    /**
     * @Returns the minute of the time.
     */
    public int getMinute(){
        return _minute;
    }
    /**
     * Changes the hour of the time. If an illegal number is received hour will be unchanged.
    @Parameters num - The new hour
     */
    public void setHour(int num){
        if (MIN_VALUE > num || num > MAX_HOUR)
        _hour = _hour;
            else _hour = num;
    }
    /**
     * Changes the minute of the time. If an illegal number is received minute will be unchanged.
    @Parameters num - The new minute
     */
    public void setMinute(int num){
        if (MIN_VALUE > num || num > MAX_MINUTE)
        _minute = _minute;
            else _minute = num;
    }
    /**
     * Return a string representation of this time.
    @Overrides toString in class java.lang.Object
    @returns String representation of this time (hh:mm).
     */
    public String toString(){
        return (_hour/DIVIDE_PARAM + "" + _hour%DIVIDE_PARAM + ":" + _minute/DIVIDE_PARAM + "" + _minute%DIVIDE_PARAM);
    }
    /**
     * Return the amount of minutes since midnight.
     @Returns amount of minutes since midnight.
     */
    public int minFromMidnight(){
        return MINUTE_IN_HOUR*_hour + _minute;
    }
    /**
     * Check if the received time is equal to this time.
    @Parameters other The time to be compared with this time
    @returns True if the received time is equal to this time
     */
    public boolean equals (Time1 other){
        return (_hour == other._hour && _minute == other._minute);
    }
    /**
     * Check if this time is before a received time.
    @Parameters other - The time to check if this point is before
    @returns  True if this time is before other time
    */
    public boolean before (Time1 other){
        return (this.minFromMidnight() < other.minFromMidnight());
    }
    /**
     * Check if this time is after a received time.
    @Parameters other - The time to check if this point is after
    @returns True if this time is after other time
     */
    public boolean after (Time1 other){
        return other.before(this);
    }
    /**
     * Calculates the difference (in minutes) between two times. Assumption: this time is after other time.
    @Parameters other - The time to check the difference to
    @returns int difference in minutes
    */
    public int difference(Time1 other){
        return (Math.abs(this.minFromMidnight() - other.minFromMidnight()));
    }
    /**
     * * set new object in Time1 format, doing a calculates and return the object after the neccecery calculates.
     @parameters num = int 
     */
    public Time1 addMinutes(int num)
    {
        int minute , hour;
        int newMinFromMid = this._hour*MINUTE_IN_HOUR + this._minute + num;
        if(newMinFromMid > MINUTE_IN_DAY)
            {
                hour = ((newMinFromMid%MINUTE_IN_DAY)/MINUTE_IN_HOUR);
                minute = ((newMinFromMid%MINUTE_IN_DAY)%MINUTE_IN_HOUR);
            }
            else if(newMinFromMid < MIN_VALUE){ //in java mod on negative number is negative.
                    hour = (((newMinFromMid%MINUTE_IN_DAY) + MINUTE_IN_DAY)/MINUTE_IN_HOUR);
                    minute = (((newMinFromMid%MINUTE_IN_DAY) + MINUTE_IN_DAY)%MINUTE_IN_HOUR);
            }
            else{
            hour = (newMinFromMid)/MINUTE_IN_HOUR;
            minute = (newMinFromMid)%MINUTE_IN_HOUR;
        }
            
        Time1 llegalTime1 = new Time1(hour, minute);
        return llegalTime1; 
    }
}