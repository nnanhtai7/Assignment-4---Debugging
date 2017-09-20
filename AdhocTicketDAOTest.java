
import bcccp.tickets.adhoc.AdhocTicket;
import bcccp.tickets.adhoc.AdhocTicketDAO;
import bcccp.tickets.adhoc.AdhocTicketFactory;
import bcccp.tickets.adhoc.IAdhocTicket;
import bcccp.tickets.adhoc.IAdhocTicketFactory;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdhocTicketDAOTest {

    AdhocTicket aht;
    AdhocTicketDAO adtd;
    
    @Before
    public void setUp() {
        aht = new AdhocTicket("C112", 1, "RF34112");
        adtd = new AdhocTicketDAO(new AdhocTicketFactory());
    }

    @After
    public void tearDown() {
        aht = null;
        adtd = null;
    }

    @Test
    public void createticket() {
        int expected=1;
        IAdhocTicket iatc= adtd.createTicket(aht.getCarparkId());
        int actual = iatc.getTicketNo();
        assertEquals(expected, actual);
    }
    
    @Test
    public void findticket_ByBarcode() {
        String expected="A1";
        IAdhocTicket iatb= adtd.createTicket(aht.getCarparkId());
        String actual = iatb.getBarcode();
        assertEquals(expected, actual);
    }
    
}
