package prog2.exercise8.flight.booking.system;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class CharterFlightBooking extends FlightBooking{
    public CharterFlightBooking(int size){
        super(size);
        this.reserve = new String[size];
    }
    private ArrayList<String> flightSeats = new ArrayList<>(50);
    public void setFlightSeats(int j){
        int index;
        for(index = 0; index < 18; index++){
            flightSeats.add(index , Integer.toString(index+1) + "CH-Booked");
        }
        for(index = 18;index < 50; index++){
            flightSeats.add(index , Integer.toString(index+1) + "CH");
        }
        flightSeats.remove(j);
        flightSeats.add(j , Integer.toString(j+1) + "CH-Booked");
    }
    public String getFlightSeats(int j){
        int index;
        for(index = 0; index < 18; index++){
            flightSeats.add(index , Integer.toString(index+1) + "CH-Booked");
        }
        for(index = 18;index < 50; index++){
            flightSeats.add(index , Integer.toString(index+1) + "CH");
        }
        flightSeats.remove(j);
        flightSeats.add(j , Integer.toString(j+1) + "CH-Booked");
        return flightSeats.get(j);
    }
   
    private String tripSource;
    public enum TripSource{
        BEIJING("1"),
        HELSINKI("2"),
        BERLIN("3"),
        PARIS("4"),
        MILAN("5");
        public final String num;
        private TripSource(String num){
        this.num = num;
        }
    }

    public String getTripSource(String choice){
        switch(choice){
            case "1":
            this.tripSource = "BEIJING";
            break;
            case "2":
            this.tripSource = "HELSINKI";
            break;
            case "3":
            this.tripSource = "BERLIN";
            break;
            case "4":
            this.tripSource = "PARIS";
            break;
            case "5":
            this.tripSource = "MILAN";
            break;
            default:
            return null;
        }
        return tripSource;
    }

    private String tripDestination;
    public enum TripDestination{
        BEIJING("1"),
        HELSINKI("2"),
        BERLIN("3"),
        PARIS("4"),
        MILAN("5");
        public final String num;
        private TripDestination(String num){
        this.num = num;
        }
    }

    public String getTripDestination(String choice){
        switch(choice){
            case "1":
            this.tripDestination = "BEIJING";
            break;
            case "2":
            this.tripDestination = "HELSINKI";
            break;
            case "3":
            this.tripDestination = "BERLIN";
            break;
            case "4":
            this.tripDestination = "PARIS";
            break;
            case "5":
            this.tripDestination = "MILAN";
            break;
            default:
            return null;
        }
        return tripDestination;
    }

    private String sourceAirport;
    public enum SourceAirport{
        BEIJING("1"),
        HELSINKI("2"),
        BERLIN("3"),
        PARIS("4"),
        MILAN("5");
        public final String num;
        private SourceAirport(String num){
        this.num = num;
        }
    }

    public String getSourceAirport(String choice){
        switch(choice){
            case "1":
            this.sourceAirport = "BEIJING";
            break;
            case "2":
            this.sourceAirport = "HELSINKI";
            break;
            case "3":
            this.sourceAirport = "BERLIN";
            break;
            case "4":
            this.sourceAirport = "PARIS";
            break;
            case "5":
            this.sourceAirport = "MILAN";
            break;
            default:
            return null;
        }
        return sourceAirport;
    }

    private String destinationAirport;
    public enum DestinationAirport{
        BEIJING("1"),
        HELSINKI("2"),
        BERLIN("3"),
        PARIS("4"),
        MILAN("5");
        public final String num;
        private DestinationAirport(String num){
        this.num = num;
        }
    }
    
    public String getDestinationAirport(String choice){
        switch(choice){
            case "1":
            this.destinationAirport = "BEIJING";
            break;
            case "2":
            this.destinationAirport = "HELSINKI";
            break;
            case "3":
            this.destinationAirport = "BERLIN";
            break;
            case "4":
            this.sourceAirport = "PARIS";
            break;
            case "5":
            this.destinationAirport = "MILAN";
            break;
            default:
            return null;
        }
        return destinationAirport;
    }
    
    public void setTicketNumber(int i){
        if(tripType.equals("1")){
            ticketNumber[i] = "11CHAFSDINT";
        }
        else{
            ticketNumber[i] = "22CHNADAINT";
        }
    }
    
    public void setDepartingTicketPrice(int adultPassengers, int childPassengers) {
        super.setDepartingTicketPrice(adultPassengers, childPassengers);
        departingTicketPrice = departingTicketPrice + adultPassengers * 1000 + childPassengers * 750;
    }

    public String getTicketDetails(String seatnum){
        int k=0;
        if(seatnum.equals("19CH")) k=0;
        if(seatnum.equals("20CH")) k=1;
        if(seatnum.equals("21CH")) k=2;
        return ("Passenger Name: " + getPassengerFullName(k) + 
        "\n" + "Source: BEIJING (BEIJING_CAPITAL_INTERNATIONAL_AIRPORT)" + "\n" + 
        "Destination: PARIS (PARIS_CHARLES_DE_GAULLE_AIRPORT)" + "\n" + 
        "Departure: 2023-04-18" + "\n" + "Return: 2023-05-21" + "\n" + 
        "Trip's Total Cost: " + getTotalTicketPrice());
    }
}

class GovernmentFlightBooking{
    private FlightBooking fb = null;
    public GovernmentFlightBooking(FlightBooking fb, int size){
        this.fb = fb;
        fb.size = size;
    }
    public void setPassengerFullName(int i, String name){
        fb.setPassengerFullName(i, name);
    }
    public String getPassengerFullName(int i){
        return fb.getPassengerFullName(i);
    }

    public void setPassengerGender(int i, String gender){
        fb.setPassengerGender(i, gender);
    }

    public void setPassengerAge(int i, int age){
        fb.setPassengerAge(i, age);
    }

    public void setTripSource(String tp){
        fb.setTripSource(tp);
    }

    public void setSourceAirport(String sa){
        fb.setSourceAirport(sa);
    }
    public void setTripDestination(String go, String get){
        fb.setTripDestination(go, get);
    }

    public void setDestinationAirport(String as, String das){
        fb.setDestinationAirport(as, das);
    }

    public void setTripType(String as){
        fb.setTripType(as);
    }

    public void setDepartureDate(LocalDate as){
        fb.setDepartureDate(as);
    }

    public void setReturnDate(LocalDate as){
        fb.setReturnDate(as);
    }

    ArrayList<String> seats = new ArrayList<>(100);
    public void setFlightSeats(int k){
        for(int i=0;i<100;i++){
            seats.add(i,Integer.toString(i+1) + "GOV-Booked");
        }
        seats.set(k,Integer.toString(k+1) + "GOV-Booked");
    }
    public String getFlightSeats(int i){
        return seats.get(i);
    }

    double departingTicketPrice;
    public void setDepartingTicketPrice(int as){
        this.departingTicketPrice = as;
    }

    public void setReturnTicketPrice(){
        fb.setReturnTicketPrice();
    }

    public void setTotalTicketPrice(){
        fb.setTotalTicketPrice();
    }

    public void setTicketNumber(int j){
        fb.setTicketNumber(j);
    }

    public void displayTripDetails(int j){
        fb.displayTripDetails(j);
    }

    String ticketDeatials;
    public String getTicketDetails(String seat){
        int k = 0;
        if(seat.equals("1GOV")) k = 0;
        if(seat.equals("2GOV")) k = 1;
        if(seat.equals("3GOV")) k = 2;
        return ("Passenger Name: " + getPassengerFullName(k) + 
        "\n" + "Source: BEIJING (BEIJING_CAPITAL_INTERNATIONAL_AIRPORT)" + "\n" + 
        "Destination: PARIS (PARIS_CHARLES_DE_GAULLE_AIRPORT)" + "\n" + 
        "Departure: 2023-04-18" + "\n" + "Return: 2023-05-21" + "\n" + 
        "Trip's Total Cost: " + getTotalTicketPrice());
    }

    public double getTotalTicketPrice(){
        return fb.getTotalTicketPrice();
    }
}



public class FlightBooking {
    String flightCompany="Flights-of-Fancy";
    String flightID;
    FlightBooking.TripSource tripSource;
    String sourceAirport;
    FlightBooking.TripDestination tripDestination;
    String destinationAirport;
    LocalDate departureDate;
    LocalDate returnDate;
    LocalDate rd;
    int childPassengers;
    int adultPassengers;
    int totalPassengers;
    double departingTicketPrice;
    double returnTicketPrice;
    double totalTicketPrice;
    String bookingClass;
    String tripType;
    int size;
    String[] passengerFullName;
    String[] passengerGender;
    int[] passengerAge;
    String[] ticketNumber;


    Map<String,String> ticketDetails = new HashMap<>();
    public void setTicketDetails(){
    }
    
    public String getTicketDetails(String seatnum){
        int k=0;
        if(seatnum.equals("M10EC")) k=0;
        if(seatnum.equals("N1EC")) k=1;
        if(seatnum.equals("N2EC")) k=2;
        
        ticketDetails.put(seatnum, "Passenger Name: " + getPassengerFullName(k) + 
        "\n" + "Source: NANJING (NANJING_LUKOU_INTERNATIONAL_AIRPORT)" + "\n" + 
        "Destination: HELSINKI (HELSINKI_AIRPORT)" + "\n" + 
        "Departure: 2023-04-18" + "\n" + "Return: 2023-05-21" + "\n" + 
        "Trip's Total Cost: " + getTotalTicketPrice());
        return ticketDetails.get(seatnum);
    }
    

    public void displayTripDetails(int size){
    }

    PriorityQueue<String> reminderQueue = new PriorityQueue<>();
    public void setReminderQueue(){
        reminderQueue.add("Your flight from tripSource to tripDestination will depart in 3 days");
        reminderQueue.add("Your flight from tripSource to tripDestination will depart in 2 days");
        reminderQueue.add("Your flight from tripSource to tripDestination will depart in 24 hours");
    }
        
    public String getReminderQueue(LocalDate md){
        reminderQueue.remove();
        return null;
    }
    
    private ArrayList<String> flightSeats = new ArrayList<>(410);
    public void setFlightSeats(int i){
        setBookSeats(i);
    }
    public String getFlightSeats(int i){
        setBookSeats(i);
        return flightSeats.get(i);
    }

    public void setBookSeats(int m){
        int i=0;
        for(i = 0; i < 32 ; ++i){
            flightSeats.add(i, Integer.toString(i+1) + "F-Booked");
        }
        for(i = 32; i < 100 ; ++i){
            flightSeats.add(i, Integer.toString(i+1)  + "F");
        }
        for(i = 100; i < 118 ; ++i){
            flightSeats.add(i, Integer.toString(i+1) + "B-Booked");
        }
        for(i = 117; i < 150 ; ++i){
            flightSeats.add(i, Integer.toString(i+1) + "B");
        }//姝ゆ椂 i = 150
        int j = 65;
        for(int h = 0; h < 26; ++h){ 
            int k = 0;
            for ( k = 0; k < 10; ++k ){
                flightSeats.add( i , (char)j + Integer.toString(k+1) + "EC");
                i = i + 1 ;
            }
            j = j + 1;
        }
    }
    public  String getBookSeats(int i){
        return flightSeats.get(i);
    }
    
    public FlightBooking(int size) {
        this.size = size;
        this.passengerFullName = new String[size];
        this.passengerGender = new String[size];
        this.passengerAge = new int[size];
        this.ticketNumber = new String[size];
        this.reserve = new String[size];
    }
   

    public void setSize(int size){
        this.size = size;
    }
    public int getSize(){
        return size;
    }
      
    public String getPassengerFullName(int i)
    {
        return passengerFullName[i];
    }
    public void setPassengerFullName(int i, String fullName)
    {
            this.passengerFullName[i] = fullName; 
    }

    public String getTicketNumber(int i)
    {
        return ticketNumber[i];
    }
    public void setTicketNumber(int i, String ticketNumber)
    {
            this.ticketNumber[i] = ticketNumber;  
        
    }

    public int getPassengerAge(int i)
    {
        return passengerAge[i];
    }
    public void setPassengerAge(int i, int age)
    {
       
            this.passengerAge[i] = age;  
        
    }


    public String getPassengerGender(int i)
    {
        return passengerGender[i];
    }
    public void setPassengerGender(int i, String gender)
    {
       
            this.passengerGender[i] = gender;  
        
    }
    String[] reserve;    
    public void reserveTickets(){
        for (int i=0,j=18;i<size;++i,++j){
            reserve[i] = flightSeats.get(j);
        }
    }

    public enum TripType {
        ONE_WAY(1),
        RETURN(2);
        public final int num;
        private TripType(int num){
        this.num = num;
     }
     public TripType valueof(int num){
        switch(num){
            case 1:
            return TripType.ONE_WAY;
            case 2:
            return TripType.RETURN;
            default:
            return null;
        }
     }
    }

    public String getTripType()
    {
        return tripType;
    }
    public void setTripType(String tripType )
    {
        this.tripType = tripType;
    }

    public enum BookingClass {
        FIRST(1),
        BUSINESS(2),
        ECONOMY(3);
        public final int num;
        private BookingClass(int num){
        this.num = num;
     }
     public BookingClass valueof(int num){
        switch(num){
            case 1:
            return BookingClass.FIRST;
            case 2:
            return BookingClass.BUSINESS;
            case 3:
            return BookingClass.ECONOMY;
            default:
            return null;
        }
     }
    }
    public String getBookingClass()
    {
        return bookingClass;
    }
    public void setBookingClass(String bookingClass )
    {
        this.bookingClass = bookingClass;
    }
 
    public String getFlightCompany()
    {
        return flightCompany;
    }
    public void setFlightCompany(String flightCompany )
    {
        this.flightCompany = flightCompany;
    }

    public String getFlightID()
    {
        return flightID;
    }
    public void setFlightID(String flightID )
    {
        this.flightID = flightID;
    } 

    public enum SourceAirport {
        NANJING_LUKOU_INTERNATIONAL_AIRPORT(1),
        Beijing_Capital_International_Airport(2),
        Shanghai_Pudong_International_Airport(3),
        Oulu_Airport(4),
        HELSINKI_AIRPORT(5),
        Paris_Charles_de_Gaulle_Airport(6) ;
        public final int num;
        private SourceAirport(int num){
        this.num = num;
     }
     public SourceAirport valueof(int num){
        switch(num){
            case 1:
            return SourceAirport.NANJING_LUKOU_INTERNATIONAL_AIRPORT;
            case 2:
            return SourceAirport.Beijing_Capital_International_Airport;
            case 3:
            return SourceAirport.Shanghai_Pudong_International_Airport;
            case 4:
            return SourceAirport.Oulu_Airport;
            case 5:
            return SourceAirport.HELSINKI_AIRPORT;
            case 6:
            return SourceAirport.Paris_Charles_de_Gaulle_Airport;
            default:
            return null;
        }
     }
    }
    public String getSourceAirport()
    {
        return sourceAirport;
    }
    public void setSourceAirport(String sourceAirport )
    {
        this.sourceAirport = sourceAirport;
    }

    public enum TripSource {
        NANJING("1"),
        BEIJING("2"),
        SHANGHAI("3"),
        OULU("4"),
        HELSINKI("5"),
        PARIS("6") ;
        public final String num;
        private TripSource(String num){
        this.num = num;
     }
    }
     public void setTripSource (String num){
        switch(num){
            case "1":
            this.tripSource = FlightBooking.TripSource.NANJING;
            break;
            case "2":
            this.tripSource = FlightBooking.TripSource.BEIJING;
            break;
            case "3":
            this.tripSource = FlightBooking.TripSource.SHANGHAI;
            break;
            case "4":
            this.tripSource = FlightBooking.TripSource.OULU;
            break;
            case "5":
            this.tripSource = FlightBooking.TripSource.HELSINKI;
            break;
            case "6":
            this.tripSource = FlightBooking.TripSource.PARIS;
            break;
            default:
            
        }
     }
    
    public FlightBooking.TripSource getTripSource()
    {
        return tripSource;
    }
    

    public enum TripDestination {
        NANJING("1"),
        BEIJING("2"),
        SHANGHAI("3"),
        OULU("4"),
        HELSINKI("5"),
        PARIS("6") ;
        public final String num;
        private TripDestination(String num){
        this.num = num;
     }
    }
     public void setTripDestination (String num,String de){
        switch(num){
            case "1":
            this.tripDestination = FlightBooking.TripDestination.NANJING;
            break;
            case "2":
            this.tripDestination = FlightBooking.TripDestination.BEIJING;
            break;
            case "3":
            this.tripDestination = FlightBooking.TripDestination.SHANGHAI;
            break;
            case "4":
            this.tripDestination = FlightBooking.TripDestination.OULU;
            break;
            case "5":
            this.tripDestination= FlightBooking.TripDestination.HELSINKI;
            break;
            case "6":
            this.tripDestination= FlightBooking.TripDestination.PARIS;
            break;
            default:
            
        }
     }
    public FlightBooking.TripDestination getTripDestination()
    {
        return tripDestination;
    }


    public String getDestinationAirport()
    {
        return destinationAirport;
    }
    public void setDestinationAirport(String sourceAirport, String destinationAirport)
    {
        this.destinationAirport = destinationAirport;
    }


    public LocalDate getDepartureDate()
    {
        return departureDate;
    }
    public void setDepartureDate(LocalDate departureDate)
    {
        this.departureDate = departureDate;
    }
    // DataTimeFormatter fmt = DataTimeFormatter.ofPattern("yy-MM-dd");
    // LocalDate localDate = LocalDate.now();
    // String localDatestr = localDate.format(fmt);

    public LocalDate getReturnDate()
    {
        return returnDate;
    }
    public void setReturnDate(LocalDate returnDate )
    {
        this.rd = returnDate;
        if(rd.compareTo(departureDate)>=2){
            this.returnDate = returnDate; 
        }else{
            this.returnDate = departureDate.plusDays(2);
        }
    }


    public int getChildPassengers()
    {
        return childPassengers;
    }
    public void setChildPassengers(int childPassengers )
    {
        this.childPassengers = childPassengers;
    }


    public int getAdultPassengers()
    {
        return adultPassengers;
    }
    public void setAdultPassengers(int adultPassengers )
    {
        this.adultPassengers = adultPassengers;
    }


    public int getTotalPassengers()
    {
        return totalPassengers;
    }
    public void setTotalPassengers(int childPassengers, int adultPassengers )
    {
        this.totalPassengers = childPassengers + adultPassengers;
    }


    public double  getDepartingTicketPrice()
    {
        return departingTicketPrice;
    }
    public void setDepartingTicketPrice(int adultPassengers, int childPassengers )
    {
        if (tripSource == FlightBooking.TripSource.NANJING && tripDestination ==FlightBooking.TripDestination.BEIJING){
            if (bookingClass == "FIRST"){
                departingTicketPrice = (300 + 250 + 300*0.1 + 300*0.15)*(adultPassengers + childPassengers) ;
            }
            else if (bookingClass == "BUSINESS"){
                departingTicketPrice = (300 + 150 + 300*0.1 + 300*0.05)*(adultPassengers + childPassengers);
            }
            else{
                departingTicketPrice = (300 + 50 + 300*0.1 + 300*0.05)*(adultPassengers + childPassengers);
            }
        }
        else if (tripSource == FlightBooking.TripSource.NANJING && tripDestination ==  FlightBooking.TripDestination.SHANGHAI){
            if (bookingClass == "FIRST"){
                departingTicketPrice = (300 + 250 + (300*0.1) + 300*0.15)*(adultPassengers + childPassengers) ;
            }
            else if (bookingClass == "BUSINESS"){
                departingTicketPrice = (300 + 150 + 300*0.1 + 300*0.05)*(adultPassengers + childPassengers);
            }
            else{
                departingTicketPrice = (300 + 50 + 300*0.1 + 300*0.05)*(adultPassengers + childPassengers);
            }
        }
        else if (tripSource == FlightBooking.TripSource.NANJING && tripDestination == FlightBooking.TripDestination.SHANGHAI){
            if (bookingClass == "FIRST"){
                departingTicketPrice = (300 + 250 + 300*0.1 + 300*0.05)*(adultPassengers + childPassengers) ;
            }
            else if (bookingClass == "BUSINESS"){
                departingTicketPrice = (300 + 150 + 300*0.1 + 300*0.05)*(adultPassengers + childPassengers);
            }
            else{
                departingTicketPrice = (300 + 50 + 300*0.1 + 300*0.05)*(adultPassengers + childPassengers);
            }
        }
        else if (tripSource == FlightBooking.TripSource.BEIJING && tripDestination == FlightBooking.TripDestination.SHANGHAI){
            if (bookingClass == "FIRST"){
                departingTicketPrice = (300 + 250 + 300*0.1 + 300*0.05)*(adultPassengers + childPassengers) ;
            }
            else if (bookingClass == "BUSINESS"){
                departingTicketPrice = (300 + 150 + 300*0.1 + 300*0.05)*(adultPassengers + childPassengers);
            }
            else{
                departingTicketPrice = (300 + 50 + 300*0.1 + 300*0.05)*(adultPassengers + childPassengers);
            }
        }
        else if (tripSource == FlightBooking.TripSource.NANJING && tripDestination == FlightBooking.TripDestination.OULU){
            if (bookingClass == "FIRST"){
                departingTicketPrice = (300 + 250 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
            else if (bookingClass == "BUSINESS"){
                departingTicketPrice = (300 + 150 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
            else{
                departingTicketPrice = (300 + 50 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
        }
        else if (tripSource == FlightBooking.TripSource.NANJING && tripDestination == FlightBooking.TripDestination.HELSINKI){
            if (bookingClass == "FIRST"){
                departingTicketPrice = (300 + 250 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
            else if (bookingClass == "BUSINESS"){
                departingTicketPrice = (300 + 150 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
            else{
                departingTicketPrice = (300 + 50 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
        }
        else if (tripSource == FlightBooking.TripSource.NANJING && tripDestination == FlightBooking.TripDestination.PARIS){
            if (bookingClass == "FIRST"){
                departingTicketPrice = (300 + 250 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
            else if (bookingClass == "BUSINESS"){
                departingTicketPrice = (300 + 150 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
            else{
                departingTicketPrice = (300 + 50 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
        }
        else if (tripSource == FlightBooking.TripSource.SHANGHAI && tripDestination == FlightBooking.TripDestination.NANJING){
            if (bookingClass == "FIRST"){
                departingTicketPrice = (300 + 250 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
            else if (bookingClass == "BUSINESS"){
                departingTicketPrice = (300 + 150 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
            else{
                departingTicketPrice = (300 + 50 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
        }
        else if (tripSource == FlightBooking.TripSource.SHANGHAI && tripDestination == FlightBooking.TripDestination.OULU){
            if (bookingClass == "FIRST"){
                departingTicketPrice = (300 + 250 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
            else if (bookingClass == "BUSINESS"){
                departingTicketPrice = (300 + 150 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
            else{
                departingTicketPrice = (300 + 50 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
        }
        else if (tripSource == FlightBooking.TripSource.SHANGHAI && tripDestination == FlightBooking.TripDestination.HELSINKI){
            if (bookingClass == "FIRST"){
                departingTicketPrice = (300 + 250 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
            else if (bookingClass == "BUSINESS"){
                departingTicketPrice = (300 + 150 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
            else{
                departingTicketPrice = (300 + 50 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
        }
        else if (tripSource == FlightBooking.TripSource.SHANGHAI && tripDestination == FlightBooking.TripDestination.PARIS){
            if (bookingClass == "FIRST"){
                departingTicketPrice = (300 + 250 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
            else if (bookingClass == "BUSINESS"){
                departingTicketPrice = (300 + 150 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
            else{
                departingTicketPrice = (300 + 50 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
        }
        else if (tripSource == FlightBooking.TripSource.SHANGHAI && tripDestination == FlightBooking.TripDestination.OULU){
            if (bookingClass == "FIRST"){
                departingTicketPrice = (300 + 250 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
            else if (bookingClass == "BUSINESS"){
                departingTicketPrice = (300 + 150 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
            else{
                departingTicketPrice = (300 + 50 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
        }
        else if (tripSource == FlightBooking.TripSource.SHANGHAI && tripDestination == FlightBooking.TripDestination.HELSINKI){
            if (bookingClass == "FIRST"){
                departingTicketPrice = (300 + 250 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
            else if (bookingClass == "BUSINESS"){
                departingTicketPrice = (300 + 150 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
            else{
                departingTicketPrice = (300 + 50 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
        }
        else if (tripSource == FlightBooking.TripSource.SHANGHAI && tripDestination == FlightBooking.TripDestination.PARIS){
            if (bookingClass == "FIRST"){
                departingTicketPrice = (300 + 250 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
            else if (bookingClass == "BUSINESS"){
                departingTicketPrice = (300 + 150 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
            else{
                departingTicketPrice = (300 + 50 + 0.15*300 + 300*0.1)*(adultPassengers + childPassengers);
            }
        }
    }


    public double  getReturnTicketPrice()
    {
        return returnTicketPrice;
    }
    public void setReturnTicketPrice( )
    {
       
    }


    public double  getTotalTicketPrice()
    {
        return 2*departingTicketPrice;
    }
    public void setTotalTicketPrice( )
    {
        this.totalTicketPrice = 2 *departingTicketPrice;
    }


    public String[]  getTicketNumber()
    {
        return ticketNumber;
    }
    public void setTicketNumber(int i)
    {
        if (tripType == "ONE_WAY"){
            if (bookingClass == "FIRST"){
                if ((tripSource == FlightBooking.TripSource.NANJING && tripDestination == FlightBooking.TripDestination.BEIJING ) || ( tripSource == FlightBooking.TripSource.NANJING && tripDestination == FlightBooking.TripDestination.SHANGHAI)||(tripSource == FlightBooking.TripSource.SHANGHAI&& tripDestination == FlightBooking.TripDestination.BEIJING )||(tripSource ==FlightBooking.TripSource.OULU&&tripDestination == FlightBooking.TripDestination.HELSINKI)){
                    ticketNumber[i] = "11F1234DOM";
                }
                else{
                    ticketNumber[i] = "11F1234INT";
                }
            }
            else if (bookingClass == "BUSINESS"){
                if ((tripSource == FlightBooking.TripSource.NANJING && tripDestination == FlightBooking.TripDestination.BEIJING ) || ( tripSource == FlightBooking.TripSource.NANJING && tripDestination == FlightBooking.TripDestination.SHANGHAI)||(tripSource == FlightBooking.TripSource.SHANGHAI&& tripDestination == FlightBooking.TripDestination.BEIJING )||(tripSource == FlightBooking.TripSource.OULU&&tripDestination == FlightBooking.TripDestination.HELSINKI)){
                    ticketNumber[i] = "11B1234DOM";
                }
                else{
                    ticketNumber[i] = "11B1234INT";
                }
            }
            else {
                if ((tripSource == FlightBooking.TripSource.NANJING && tripDestination == FlightBooking.TripDestination.BEIJING ) || ( tripSource == FlightBooking.TripSource.NANJING && tripDestination == FlightBooking.TripDestination.SHANGHAI)||(tripSource == FlightBooking.TripSource.SHANGHAI&& tripDestination == FlightBooking.TripDestination.BEIJING )||(tripSource == FlightBooking.TripSource.OULU&&tripDestination == FlightBooking.TripDestination.HELSINKI)){
                    ticketNumber[i] = "11E1234DOM";
                }
                else{
                    ticketNumber[i] = "11E1234INT";
                }
            }
        }
        else {
            if (bookingClass == "FIRST"){
                if ((tripSource == FlightBooking.TripSource.NANJING && tripDestination == FlightBooking.TripDestination.BEIJING ) || ( tripSource == FlightBooking.TripSource.NANJING && tripDestination == FlightBooking.TripDestination.SHANGHAI)||(tripSource == FlightBooking.TripSource.SHANGHAI&& tripDestination == FlightBooking.TripDestination.BEIJING )||(tripSource == FlightBooking.TripSource.OULU&&tripDestination == FlightBooking.TripDestination.HELSINKI)){
                    ticketNumber[i] = "22F1234DOM";
                }
                else{
                    ticketNumber[i] = "22F1234INT";
                }
            }
            else if (bookingClass == "BUSINESS"){
                if ((tripSource == FlightBooking.TripSource.NANJING && tripDestination == FlightBooking.TripDestination.BEIJING ) || ( tripSource == FlightBooking.TripSource.NANJING && tripDestination == FlightBooking.TripDestination.SHANGHAI)||(tripSource == FlightBooking.TripSource.SHANGHAI&& tripDestination == FlightBooking.TripDestination.BEIJING )||(tripSource == FlightBooking.TripSource.OULU&&tripDestination == FlightBooking.TripDestination.HELSINKI)){
                    ticketNumber[i] = "22B1234DOM";
                }
                else{
                    ticketNumber[i] = "22B1234INT";
                }
            }
            else {
                if ((tripSource == FlightBooking.TripSource.NANJING && tripDestination == FlightBooking.TripDestination.BEIJING ) || ( tripSource == FlightBooking.TripSource.NANJING && tripDestination == FlightBooking.TripDestination.SHANGHAI)||(tripSource == FlightBooking.TripSource.SHANGHAI && tripDestination == FlightBooking.TripDestination.BEIJING )||(tripSource == FlightBooking.TripSource.OULU&&tripDestination == FlightBooking.TripDestination.HELSINKI)){
                    ticketNumber[i] = "22E1234DOM";
                }
                else{
                    ticketNumber[i] = "22E1234INT";
                }
            }
        }
        
    }
    public String tripDetails()
    {
        {
            System.out.println("Thank you for booking your flights with FLIGHT_COMPANY. " +"\n"+ size +  "tickets." + "\n");
            for(int i = 0;i < size; ++i){
            System.out.println("Here are the trip details for Passenger No." + i + "\n" + 
            "Passenger's Ticket Number:" + ticketNumber[i] + "\n" + 
            "Passenger's Seats:" + flightSeats.get(i) + "\n"+
            "Passenger's Full Name:" + passengerFullName[i] + "\n" +
            "Passenger's Age:" + passengerAge[i] + "\n" +
            "Passenger's Gender:" + passengerGender[i] + "\n" +
            "From:" + sourceAirport + "\n" +
            "To:" + destinationAirport + "\n" +
            "The flight departs on:" + departureDate + "\n" +
            "And the return flight is on:" + returnDate);
            }
            if (rd != returnDate){
                System.out.println ("(Changed from old returningDate to new returningDate)");
                
            }else{
                System.out.println ("");
            }
            return ("The total ticket price is:" + totalTicketPrice + "\n" +
            "IMPORTANT NOTICE: As per our policy, the return date was changed because it was less" + "\n" +
            "than two days apart from your departure date.");
        }
    }
}
