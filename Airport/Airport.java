import java.util.*;
public class Airport {
    /*
    Konstruera  en  klass Airport.  
    För  varje  objekt  av  klassen  ska  det  finnas  tre  instans-variabler: 
    flygplatsens  namn,  en  mängd departures med  alla  flighter  som  avgår  från  den  aktuella flygplatsen 
    samt en avbildningstabell flightsTo. 
    Mängden departures ska vara sorterad i första hand  på  avgångstid  och  i  andra  hand  på  destinationens  namn.  

    I  tabellen flightsTo ska söknycklarna vara namnen på destinationerna och värdena mängder innehållande flighter.

    Man ska alltså i tabellen flightsTo kunna slå upp vilka flighter som avgår till en viss destination.
    Varje värdemängd i flightsTo ska vara sorterad på avgångstid. 

    En konsekvens av att det finns både en mängd med alla avgångar och en tabell med avgångar till varje  destination
    är  att  vissflight  kommer  att  ingå  i  två  mängder.  
    Men  detta  är  inget  konstigt eftersom det som du vet i själva verket är referenserna till flighterna som ligger i mängderna. 
    
    Klassen Airportska ha en konstruktor som får flygplatsens namn som parameter. 

    Dessutom ska följande metoder finnas:getName, ger flyplatsens namn,getDepartures(), 

    ger en sorterad mängd innehållande alla flighter som avgår från en aktuella flygplatsen,
    getDepartures(dest), ger en sorterad mängd innehållande alla flighter som avgår till destfrån den aktuella flygplatsen 
    (dest är en String),
    addFlight(f), lägger till flighten f både till mängden departures och till aktuell mängd i tabellen flightsTo,removeFlight(f),
    tar bort flighten fbåde från mängden departuresoch från aktuell mängd i tabellen flightsTo.  
    Om  detta  innebär  att  en  viss  avbildning  i  tabellen flightsTo kommer att innehålla en tom mängd så ska
    denna avbildning tas bort.När du konstruerar metoderna getDepartures behöver du för enkelhets skull inte ta hänsyn
    till att det kan vara farligt att returnera referenser.
    */
    private String name; 
    private List<Flight> departures;
    private HashMap<String, Flight> flightsTo;
    
    public Airport(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }
    public List<Flight> getDepartures() {
        return departures;
    }
    
    public void addFlight(Flight flight) {
        departures.add(flight);
        flightsTo.put(flight.getDestination(), flight);
    }
    public void removeFlight(Flight flight) {
        departures.remove(flight);
    }
}