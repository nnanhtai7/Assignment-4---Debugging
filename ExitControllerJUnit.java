
import bcccp.carpark.CarSensor;
import bcccp.carpark.Carpark;
import bcccp.carpark.Gate;
import bcccp.carpark.ICarSensor;
import bcccp.carpark.IGate;
import bcccp.carpark.exit.ExitController;
import bcccp.carpark.exit.ExitUI;
import bcccp.carpark.exit.IExitUI;
import bcccp.tickets.adhoc.AdhocTicketDAO;
import bcccp.tickets.adhoc.AdhocTicketFactory;
import bcccp.tickets.adhoc.IAdhocTicketDAO;
import bcccp.tickets.season.ISeasonTicket;
import bcccp.tickets.season.ISeasonTicketDAO;
import bcccp.tickets.season.SeasonTicket;
import bcccp.tickets.season.SeasonTicketDAO;
import bcccp.tickets.season.UsageRecordFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExitControllerJUnit {

    private IAdhocTicketDAO adhocTicketDAO;
    private ISeasonTicketDAO seasonTicketDAO;
    private ExitController ec;
    private IGate ig;
    private ICarSensor incs;
    private ICarSensor oucs;
    private IExitUI ieu;
    private Carpark cp;
    private ISeasonTicket t1;

    @Before
    public void setUp() {
        adhocTicketDAO = new AdhocTicketDAO(new AdhocTicketFactory());
        seasonTicketDAO = new SeasonTicketDAO(new UsageRecordFactory());
        ig = new Gate(1330, 320);
        incs = new CarSensor("Entry Inside Sensor", 20, 440);
        oucs = new CarSensor("Entry Outside Sensor", 20, 100);
        ieu = new ExitUI(1000, 100);
        cp = new Carpark("BMW", 2, adhocTicketDAO, seasonTicketDAO);
        ec = new ExitController(cp, ig, incs, oucs, ieu);

        t1 = new SeasonTicket("S1111", "Bathurst Chase", 0L, 0L);
        cp.registerSeasonTicket(t1);
        cp.issueAdhocTicket();
        cp.recordAdhocTicketEntry();
        cp.recordSeasonTicketEntry(t1.getId());
    }

    @After
    public void tearDown() {
        adhocTicketDAO = null;
        seasonTicketDAO = null;
        ig = null;
        incs = null;
        oucs = null;
        ieu = null;
        cp = null;
        ec = null;
    }

    @Test
    public void issessioninus() {
        assertTrue(cp.isSeasonTicketValid("S1111"));
        assertFalse(cp.isSeasonTicketValid("S1211"));
    }

    @Test
    public void issessioninuse() {
        assertTrue(cp.isSeasonTicketInUse("S1111"));
    }
    
    @Test
    public void isfull() {
        assertTrue(cp.isFull());
    }

}
