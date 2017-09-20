import bcccp.tickets.adhoc.AdhocTicketFactory;
import bcccp.tickets.adhoc.IAdhocTicket;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdhocTicketfactoryTest {

    AdhocTicketFactory att;

    @Before
    public void setUp() {
        att = new AdhocTicketFactory();
    }

    @After
    public void tearDown() {
        att = null;
    }

    @Test
    public void checkmake() {
        String expectedcarparkid="C112";
        int expectedtkt=1;
        IAdhocTicket ahtt=att.make(expectedcarparkid,expectedtkt);
        String actualcarparkid=ahtt.getCarparkId();
        int actualticketno=ahtt.getTicketNo();
        
        //check carparkid
        assertEquals(expectedcarparkid, actualcarparkid);
        //check ticket
        assertEquals(expectedtkt, actualticketno);
        //check barcode
        assertEquals("A"+expectedtkt,ahtt.getBarcode());
    }
}
