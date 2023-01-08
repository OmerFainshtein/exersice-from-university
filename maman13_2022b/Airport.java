/**
 * This class represent flights scheduel in array
 * Airport class contain methods to check interaction between flights.
 *
 * @author OmerFainshtein
 * @version 11/04/2022
 */
public class Airport
{
    // instance variables
    Flight[] _flightSchedule;
    private int _noOfFlights;
    private String _city;
    private final int MAX_FLIGHTS = 200;//by defination
    private final int MIN_VALUE = 0 ,MAX_VALUE = 250;
    
    /**
    * Constructor for a Airport object
    * @param city its the location of the airport that the flight departs from
    */
    public Airport(String city)
    {
        _flightSchedule = new Flight[MAX_FLIGHTS];
        _noOfFlights = MIN_VALUE;
        _city = new String(city);
    }
    /**
    * Check if there is place in flight schedule and if the input flight matching to destination / origin
    * If the answer for both qustion is yes - method add flight f from flight schedule
    * @param f - represent object of Flight class
    * @return true if f was added
    * @return false if f wasn't added
    */
    public boolean addFlight(Flight f)
    {
        if(_noOfFlights == MAX_FLIGHTS)//no empty cell on the array
            return false;
        if(f.getOrigin().equals(_city) || f.getDestination().equals(_city))
        {
            _flightSchedule[_noOfFlights] = new Flight(f);
            _noOfFlights++;
            return true;
        }
        return false;
    }
    /**
    * Check if there is flights in the flight schedule, then check if the input flight exist
    * If the answer for both qustion is yes - method remove flight f from flight schedule
    * @param f - represent object of Flight class
    * @return true if f was removed
    * @return false if f wasn't removed / exist
    */
    public boolean removeFlight(Flight f)
    {
        int i;
        for(i = 0; i < _noOfFlights ; i++)
        {
            if(_flightSchedule[i].equals(f))
            {
                for(int j = i; j < _noOfFlights -1 ; j++)
                    {
                        _flightSchedule[j] = _flightSchedule[j+1];//move all cell 1 step back 
                    }
                _flightSchedule[_noOfFlights-1] = null;//the last cell cant be ovveriding so we must do it "menual"
                _noOfFlights--;
                return true;
            }
        }
        return false;
    }
    /**
    * Get string represent the flight origin and check if their is flights from this city in schedule
    * If there is at least 1 flight from 'place' - method find the first flight departure time
    * @param String place - represent the origin of flight
    * @return Time1 object represent departure time of first flight from origin (if their is flights from there)
    * @return null if there is no flights from this origin
    */
    public Time1 firstFlightFromOrigin(String place) {
        if (_noOfFlights == MIN_VALUE) 
            return null;
        Flight firstFlight = null;
        for(int i = 0; i < _noOfFlights; i++){
            if(_flightSchedule[i].getOrigin().equals(place)){
                firstFlight = new Flight(_flightSchedule[i]);//set flight that departs from place
                break;
            }
        }
        for(int j = 0; j < _noOfFlights; j++){
            if(_flightSchedule[j].getOrigin().equals(place))
            {
                if(firstFlight != null && _flightSchedule[j].getDeparture().before(firstFlight.getDeparture()))
                    firstFlight = new Flight(_flightSchedule[j]); // ovveride the first object i set in last loop
            }
        }
        if(firstFlight == null) // if there is no flight from the place parameter
            return null;
        return new Time1(firstFlight.getDeparture());
    }
    /**
    * Check how many flights from the flight schedule is full
    * @return int represent number of full flights
    * @return 0 (MIN_VALUE) if there is no full flights
    */
    public int howManyFullFlights()
    {
        if(_noOfFlights == MIN_VALUE)//check if their is flights in array
            return MIN_VALUE;
        int howMany = 0;
        for(int i = 0 ; i < _noOfFlights ; i++)
        {
            if (_flightSchedule[i].getIsFull())
                howMany++;//counting full flights
        }
        return howMany;
    }
    /**
    * Check how many flights are between _city and parameter 'place'
    * @param String place represent the city name that flight depart or land at
    * @return the number of flights between _city and 'place'
    */
    public int howManyFlightsBetween (String place)
    {
        int flightsBetween = 0;
        for(int i = 0 ; i < _noOfFlights ; i++)
        {   if(_flightSchedule[i].getOrigin().equals(place) || _flightSchedule[i].getDestination().equals(place))
            flightsBetween++;//counting flights between
        }
        return flightsBetween;
    }
    /**
    * Count the number of flights which lands in every city in flight scheudle 
    * @return String represent the city that most flight lands at
    * @return null if there is no flights on flights scedule
    */
    public String mostPopularDestination()
    {
        if(_noOfFlights == MIN_VALUE)//check if their is flights in array
            return null;
        int mostPopular = 0;
        int i;
        int maxIndex = 0;
        for(i = 0 ; i < _noOfFlights ; i++)
        {
            int noDest = 0;
            for(int j = i; j <  _noOfFlights ; j++)
            {
             if(_flightSchedule[j].getDestination().equals(_flightSchedule[i].getDestination()))
                noDest++;//counting how many flights landed at destination
            }
            if (mostPopular < noDest)//compare the destination that showed up most time and new destination we count now
            {
                mostPopular = noDest;
                maxIndex = i; 
            }
            else mostPopular = mostPopular;
        }
        return new String(_flightSchedule[maxIndex].getDestination());// max index is the index of the destination that most flights landed at
    }
    /**
    * Check which flight's ticket cost the most
    * If more then 1 flight have the most exepnsice ticket (same price) - method return the first flight that check first
    * @return Flight object represent the flight with the most expensive flight ticket
    * @return null if there is no flight on flight schedule
    */
    public Flight mostExpensiveTicket()
    {
        if(_noOfFlights == MIN_VALUE)//check if their is flights in array
        return null;
        Flight highestPrice = _flightSchedule[0];
        for(int i = 1 ; i < _noOfFlights ; i++)
        {
            if(_flightSchedule[i].getPrice() > highestPrice.getPrice())//compare prices
            highestPrice = _flightSchedule[i];
        }
        return new Flight(highestPrice);
    }
    /**
    * Check which flight's duration in flights schedule is the longest
    * @return Flight object which represent the longest flight on flight schedule
    */
    public Flight longestFlight()
    {
        if(_noOfFlights == MIN_VALUE)//check if their is flights in array
        return null;
        Flight longestFlight = _flightSchedule[0];
        for(int i = 0 ; i < _noOfFlights ; i++)
        {
            if(_flightSchedule[i].getFlightDuration() > longestFlight.getFlightDuration())//compare flights duration
            longestFlight = _flightSchedule[i];
        }
        return new Flight(longestFlight);
    }
    /**
    * This method useing toString method from class Flight
    * Return a string representation of all the flights from some airport 
    * (for example: "The flights for airport Tel-aviv today are: +
                        Flight from Amsterdam to Tel-aviv departs at 01:05. Flight is full.")
    * @returns null if there is no flight on the flight Schedule (array is empty)
    * @return string representation of all flights from specific city
    * (for example: "The flights for airport Tel-aviv today are: +
                        Flight from Amsterdam to Tel-aviv departs at 01:05. Flight is full.")
    */
    public String toString()
    {
        if(_noOfFlights == 0)
        return null;
        String toPrint = new String ("The flights for airport " +_city + " today are:\n");
        String isFull; 
        for (int i = 0 ; i < _noOfFlights ; i++)
        {
            if(_flightSchedule[i].getIsFull())
            isFull = "full";
            else isFull = "not full";
            toPrint = toPrint + _flightSchedule[i].toString() + "\n";//using toString of class Flight
        }
        return new String(toPrint);
    }
}