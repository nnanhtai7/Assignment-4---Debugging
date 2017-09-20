
import bcccp.tickets.adhoc.AdhocTicket;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdHocTicketTest {

    private AdhocTicket adt;

    @Before
    public void setUp() {
        adt = new AdhocTicket("C112", 1, "RF34112");
    }

    @After
    public void tearDown() {
        adt = null;
    }

    @Test
    public void checkEntrydatetime() {
        long actual = 0402120620;
        adt.enter(actual);
        long expected = adt.getEntryDateTime();
        assertEquals(expected, actual);
    }
    
    @Test
     public void checkpaidstatus() {
         adt.pay(1204140630, 40);
         assertFalse(adt.isCurrent());
         assertTrue(adt.isPaid());
     }
     
     @Test
     public void isExited()
     {
         long expected=1204140630;
         adt.exit(1204140630);
         assertEquals(expected, adt.getExitDateTime());
         assertTrue(adt.hasExited());
     }
}
