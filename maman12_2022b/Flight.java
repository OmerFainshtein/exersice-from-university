
/**
 * This class represents a flight. A Flight object is represented by the flight's origin,destination,departure time, flight duration, no of passengers and the price.
 * And contain methods that chack the intraction between the flights.
 * @author OmerFainshtein
 * @version 04/2022
 */
public class Flight
{
    // declarations
    private String _origin;
    private String _destination;
    private Time1 _departure;
    private int _flightDuration;
    private int _noOfPassengers;
    private boolean _isFull;
    private int _price;
    public final int MAX_CAPACITY = 250 ,MIN_VALUE = 0, MINUTE_IN_DAY = 1440, MINUTE_IN_HOUR = 60; 
    private int _hour;
    private int _minute;

    /**
     * Constructor for a Flight object. If the number of passengers exceeds the maximum capacity the number of passengers will be set to the maxmum capacity If the number of passengers is negative the number of passengers will be set to zero. If the flight duration is negative the flight duration will be set to zero. If the price is negative the price will be set to zero.
    @Parameters:
    dest - The city the flight lands at.
    origin - The city the flight leaves from.
    depHour - the departure hour (should be between 0-23).
    depMinute - The departure minute (should be between 0-59).
    durTimeMinutes - The duration time in minutes(should not be negative).
    noOfPass - The number of passengers (should be between 0-maximum capacity).
    price - The price (should not be negative).
     */
    public Flight​(String origin,String dest,int depHour,int depMinute,int durTimeMinutes,int noOfPass,int price)
    {
        _origin = origin;
        _destination = dest;
        _departure = new Time1(depHour, depMinute);
        if(noOfPass > MAX_CAPACITY)
            _noOfPassengers = MAX_CAPACITY;
            else 
            {
                if(noOfPass < MIN_VALUE)
                    _noOfPassengers = MIN_VALUE;
                else _noOfPassengers = noOfPass;
            }
        if(_noOfPassengers == MAX_CAPACITY)
            _isFull = true;
            else _isFull = false;
        if(durTimeMinutes < MIN_VALUE)
            durTimeMinutes = MIN_VALUE;
        else _flightDuration = durTimeMinutes;
        if(price < MIN_VALUE)
            price = MIN_VALUE;
            else _price = price;
    }
    /**
     * copy constructor
     */
    public Flight(Flight other)
    {
        this._origin = other._origin;
        this._destination = other._destination;
        this._departure = new Time1 (other._departure);
        this._noOfPassengers = other._noOfPassengers;
        this._isFull = other._isFull;
        this._flightDuration = other._flightDuration;
        this._price = other._price;       
    }
    /**
     * Returns the flight origin.
     * Returns The flight origin.
     */
    public String getOrigin()
    {
        return this._origin;
    }
    /**
     * Returns the flight destination.
     * Returns The flight destination.
     */
    public String getDestination()
    {
        return this._destination;
    }
    /**
     * Returns the flight departure time.
    Returns A copy of the flight departure time.
     */
    public Time1 getDeparture()
    {
        return _departure = new Time1(_departure);
    }
    /**
     * Returns the flight duration time in minutes.
    Returns The flight duration.
     */
    public int getFlightDuration()
    {
        return this._flightDuration;
    }
    /**
     * Returns the number of passengers on the flight.
    Returns The number of passengers.
     */
    public int getNoOfPassengers()
    {
        return this._noOfPassengers;
    }
    /**
     * Returns whether the flight is full or not.
    Returns True if the flight is full.
     */
    public boolean getIsFull()
    {
        return this._isFull;
    }
    /**
     * Returns the price of the flight .
    Returns The price.
     */
    public int getPrice()
    {
        return this._price;
    }
    /**
     * Changes the flight's destination.
    Parameters dest - The flight's new destination.
    */
    public void setDestination​(java.lang.String dest)
    {
        _destination = dest;
    }
    /**
     * Changes the flight's origin.
    Parameters origin - The flight's new origin.
     */
    public void setOrigin​(java.lang.String origin)
    {
        _origin = origin;
    }
    /**
     * Changes the flight's departure time.
    Parameters departureTime - The flight's new departure time.
     */
    public void setDeparture​(Time1 departureTime)
    {
        _departure = new Time1(departureTime);
    }
    /**
     * Changes the flight's duration time. If the parameter is negative the duration time will remain unchanged.
    Parameters durTimeMinutes - The flight's new duration time.
     */
    public void setFlightDuration​(int durTimeMinutes)
    {
        if (durTimeMinutes < MIN_VALUE)
        _flightDuration = _flightDuration;
        else _flightDuration = durTimeMinutes;
    }
    /**
     * Changes the number of passengers. If the parameter is negative or larger than the maximum capacity the number of passengers will remain unchanged.
    Parameters noOfPass - The new number of passengers.
     */
    public void setNoOfPassengers​(int noOfPass)
    {
        if (noOfPass > MAX_CAPACITY || noOfPass < MIN_VALUE)
            _noOfPassengers = _noOfPassengers;
        else _noOfPassengers = noOfPass;
    }
    /**
     * Changes the flight price. If the parameter is negative the price will remain unchanged.
    Parameters price - The new price.
     */
    public void setPrice​(int price)
    {
        if (price < MIN_VALUE)
        _price = _price;
        else _price = price;
    }
    /**
     * Return a string representation of this flight (for example: "Flight from London to Paris departs at 09:24.Flight is full.").
    Overrides:
    toString in class java.lang.Object
    Returns String representation of this flight 
    (for example: "Flight from London to Paris departs at 09:24.Flight is full.").
     */
    public String toString()
    { 
        if (this._isFull == true)
        return ("Flight from " + _origin + " to " + _destination + " departs at " + _departure + ". Flight is full.");
        else
        return ("Flight from " + _origin + " to " + _destination + " departs at " + _departure + ". Flight is not full.");
    }
    /**
     * Check if the received flight is equal to this flight. Flights are considered equal if the origin, destination and departure times are the same.
    Parameters other - The flight to be compared with this flight.
    Returns True if the received flight is equal to this flight.
     */
    public boolean equals​(Flight other)
    {
        return ((this._origin).equals(other._origin) && (this._destination).equals(other._destination) && (this._departure).equals(other._departure));
    }
    /**
     * Returns the arrival time of the flight .
    Returns The arrival time of this flight.
     */
    public Time1 getArrivalTime()
    {
        Time1 arrivalTime = new Time1(_departure);
        return arrivalTime.addMinutes(_flightDuration);   
    }
    /**
     * Add passengers to this flight. If the number of passengers exceeds he maximum capacity, no passengers are added and alse is returned. If the flight becomes full, the boolean attribute describing whether the flight if full becomes true.
    Parameters num - The number of passengers to be added to this flight.
    Returns True if the passengers were added to the flight.
     */
    public boolean addPassengers​(int num)
    {
        if (_noOfPassengers + num > MAX_CAPACITY)
        _noOfPassengers = _noOfPassengers;
        else if (_noOfPassengers + num == MAX_CAPACITY)
        getIsFull();
        return ((_noOfPassengers + num) <= MAX_CAPACITY);
    }
    /**
     * Check if this flight is cheaper than another flight.
    Parameters other - The flight whose price is to be compared with this flight's price.
    Returns True if this flight is cheaper than the received flight .
     */
    public boolean isCheaper​(Flight other)
    {
        return this._price < other._price;
    }
    /**
     * Calculate the total price of the flight.
    Returns The total price of the flight.
     */
    public int totalPrice()
    {
        return (this._price * this._noOfPassengers);
    }
    /**
     * Check if this flight lands before another flight. Note - the flights may land on different days, the method checks which flight lands first.
    Parameters other - The flight whose arrival time to be compared with this flight's arrival time.
    Returns True if this flight arrives before the received flight.
    */
    public boolean landsEarlier​(Flight other)
    {  
        return (this.getArrivalTime().before(other.getArrivalTime()));
    }
}