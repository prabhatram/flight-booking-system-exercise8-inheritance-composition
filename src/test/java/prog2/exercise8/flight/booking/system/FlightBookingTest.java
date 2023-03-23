package prog2.exercise8.flight.booking.system;

import static org.junit.Assert.assertEquals;
import java.time.LocalDate;
import org.junit.Test;



public class FlightBookingTest 
{  
    
    @Test
    public void testing_Charter_Seat_Booking_Method(){
        int size = 3;
        CharterFlightBooking charter = new CharterFlightBooking(size);

        String [] fullName = {"Matt Jive", "Sally Fields", "Posh Quattro"};
        String [] gender = {"Male", "Female", "Other"};
        int [] age = {43, 32, 21};
        String [] seatsBooked = new String[size];

        for(int i=0; i<size; ++i){
            charter.setPassengerFullName(i, fullName[i]);
            charter.setPassengerGender(i, gender[i]);
            charter.setPassengerAge(i, age[i]);
        }

        charter.setTripSource("1");
        charter.setSourceAirport("1");

        charter.setTripDestination("1", "4");
        charter.setDestinationAirport("1", "4");

        charter.setTripType("2");

        for(int i=0; i<size; ++i){
            charter.setFlightSeats(i);
        }

        String sdepart = "2023-04-18";
        LocalDate departingOn = LocalDate.parse(sdepart);

        String returnD = "2023-05-21";
        LocalDate returningOn = LocalDate.parse(returnD);

        charter.setDepartureDate(departingOn);
        charter.setReturnDate(returningOn);

        charter.setDepartingTicketPrice(0, 3);
        
        charter.setReturnTicketPrice();

        charter.setTotalTicketPrice();

        for(int j=0, k=18; j<size; ++j, ++k){
            charter.setTicketNumber(j);
            seatsBooked[j]=charter.getFlightSeats(k);
        }
        
        if(seatsBooked[0].equals("19CH-Booked") &&
        seatsBooked[1].equals("20CH-Booked") &&
        seatsBooked[2].equals("21CH-Booked")){
            assertEquals(1, 1);
        }
        else{
            assertEquals(1, 2);
        }
        
    }

    @Test
    public void testing_Government_Seat_Booking_Method(){
        int size = 3;
        GovernmentFlightBooking gov = new GovernmentFlightBooking(new FlightBooking(size), size);

        String [] fullName = {"Matt Jive", "Sally Fields", "Posh Quattro"};
        String [] gender = {"Male", "Female", "Other"};
        int [] age = {43, 32, 21};
        String [] seatsBooked = new String[size];

        for(int i=0; i<size; ++i){
            gov.setPassengerFullName(i, fullName[i]);
            gov.setPassengerGender(i, gender[i]);
            gov.setPassengerAge(i, age[i]);
        }

        gov.setTripSource("1");
        gov.setSourceAirport("1");

        gov.setTripDestination("1", "4");
        gov.setDestinationAirport("1", "4");

        gov.setTripType("2");

        for(int i=0; i<size; ++i){
            gov.setFlightSeats(i);
        }

        String sdepart = "2023-04-18";
        LocalDate departingOn = LocalDate.parse(sdepart);

        String returnD = "2023-05-21";
        LocalDate returningOn = LocalDate.parse(returnD);

        gov.setDepartureDate(departingOn);
        gov.setReturnDate(returningOn);

        gov.setDepartingTicketPrice(3);
        
        gov.setReturnTicketPrice();

        gov.setTotalTicketPrice();

        for(int j=0; j<size; ++j){
            gov.setTicketNumber(j);
            seatsBooked[j]=gov.getFlightSeats(j);
        }
        
        if(seatsBooked[0].equals("1GOV-Booked") &&
        seatsBooked[1].equals("2GOV-Booked") &&
        seatsBooked[2].equals("3GOV-Booked")){
            assertEquals(1, 1);
        }
        else{
            assertEquals(1, 2);
        }
        
    }
    
    
    @Test
    public void testing_Charter_Ticket_Details_Method(){
        
        int size = 3;
        
        CharterFlightBooking charter = new CharterFlightBooking(size);

        String [] fullName = {"Matt Jive", "Sally Fields", "Posh Quattro"};
        String [] gender = {"Male", "Female", "Other"};
        int [] age = {43, 32, 21};
        String [] seatsBooked = new String[size];

        for(int i=0; i<size; ++i){
            charter.setPassengerFullName(i, fullName[i]);
            charter.setPassengerGender(i, gender[i]);
            charter.setPassengerAge(i, age[i]);
        }

        charter.setTripSource("1");
        charter.setSourceAirport("1");

        charter.setTripDestination("1", "4");
        charter.setDestinationAirport("1", "4");

        charter.setTripType("1");

        for(int i=0; i<size; ++i){
            charter.setFlightSeats(i);
        }

        String sdepart = "2023-04-18";
        LocalDate departingOn = LocalDate.parse(sdepart);

        String returnD = "2023-05-21";
        LocalDate returningOn = LocalDate.parse(returnD);

        charter.setDepartureDate(departingOn);
        charter.setReturnDate(returningOn);

        charter.setDepartingTicketPrice(0, 3);
        
        charter.setReturnTicketPrice();

        charter.setTotalTicketPrice();

        for(int j=0, k=18; j<size; ++j, ++k){
            charter.setTicketNumber(j);
            seatsBooked[j]=charter.getFlightSeats(k);
        }

        charter.displayTripDetails(size);

        for(int k = 0; k<size; ++k){

            
            String details = charter.getTicketDetails(seatsBooked[k].replace("-Booked", ""));
            String result = details.toLowerCase().trim().replace(" ", "");
            
            
            String expected = "Passenger Name: " + charter.getPassengerFullName(k) + 
            "\n" + "Source: BEIJING (BEIJING_CAPITAL_INTERNATIONAL_AIRPORT)" + "\n" + 
            "Destination: PARIS (PARIS_CHARLES_DE_GAULLE_AIRPORT)" + "\n" + 
            "Departure: 2023-04-18" + "\n" + "Return: 2023-05-21" + "\n" + 
            "Trip's Total Cost: " + charter.getTotalTicketPrice();

            String expectedResult = expected.toLowerCase().trim().replace(" ", "");

            assertEquals(expectedResult, result);
            
        }
        
    }

    @Test
    public void testing_Government_Ticket_Details_Method(){
        
        int size = 3;
        GovernmentFlightBooking gov = new GovernmentFlightBooking(new FlightBooking(size), size);

        String [] fullName = {"Matt Jive", "Sally Fields", "Posh Quattro"};
        String [] gender = {"Male", "Female", "Other"};
        int [] age = {43, 32, 21};
        String [] seatsBooked = new String[size];

        for(int i=0; i<size; ++i){
            gov.setPassengerFullName(i, fullName[i]);
            gov.setPassengerGender(i, gender[i]);
            gov.setPassengerAge(i, age[i]);
        }

        gov.setTripSource("1");
        gov.setSourceAirport("1");

        gov.setTripDestination("1", "4");
        gov.setDestinationAirport("1", "4");

        gov.setTripType("1");

        for(int i=0; i<size; ++i){
            gov.setFlightSeats(i);
        }

        String sdepart = "2023-04-18";
        LocalDate departingOn = LocalDate.parse(sdepart);

        String returnD = "2023-05-21";
        LocalDate returningOn = LocalDate.parse(returnD);

        gov.setDepartureDate(departingOn);
        gov.setReturnDate(returningOn);

        gov.setDepartingTicketPrice(3);
        
        gov.setReturnTicketPrice();

        gov.setTotalTicketPrice();

        for(int j=0; j<size; ++j){
            gov.setTicketNumber(j);
            seatsBooked[j]=gov.getFlightSeats(j);
        }

        gov.displayTripDetails(size);

        for(int k = 0; k<size; ++k){

            
            String details = gov.getTicketDetails(seatsBooked[k].replace("-Booked", ""));
            String result = details.toLowerCase().trim().replace(" ", "");
            
            
            String expected = "Passenger Name: " + gov.getPassengerFullName(k) + 
            "\n" + "Source: BEIJING (BEIJING_CAPITAL_INTERNATIONAL_AIRPORT)" + "\n" + 
            "Destination: PARIS (PARIS_CHARLES_DE_GAULLE_AIRPORT)" + "\n" + 
            "Departure: 2023-04-18" + "\n" + "Return: 2023-05-21" + "\n" + 
            "Trip's Total Cost: " + gov.getTotalTicketPrice();

            String expectedResult = expected.toLowerCase().trim().replace(" ", "");

            assertEquals(expectedResult, result);
            
        }
        
    }

      
}
