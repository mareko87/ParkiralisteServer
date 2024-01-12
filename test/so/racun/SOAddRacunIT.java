/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package so.racun;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Administrator;
import domain.Organizacija;
import domain.Parkiraliste;
import domain.Racun;
import domain.Vozilo;
import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marko Milosevic
 */
public class SOAddRacunIT {
    private SOAddRacun instance;
    private Racun rac;
    
    public SOAddRacunIT() {
    }
    
    @Before
    public void setUp() {
        instance = new SOAddRacun();
        Parkiraliste parkiraliste = new Parkiraliste(1L, "Kneza Milosa 65", 200);
        Administrator administrator = new Administrator(1L, "Marko", "Milosevic", "mareko", "mareko123", true, parkiraliste);
        ArrayList<Vozilo> vozila = new ArrayList<>();
        Organizacija organizacija = new Organizacija(2L, "Gigatron", "Kraljice Marije 20", vozila);
        rac = new Racun(-1L, new Date(), 4, 2000, 10, 1800, administrator, organizacija);
    }
    
    @After
    public void tearDown() {
        instance = null;
        rac = null;
    }

    /**
     * Test of validate method, of class SOAddRacun.
     * @throws Exception is expected
     */
   @Test (expected = Exception.class)
    public void testValidate() throws Exception {
        System.out.println("validate");
        
        instance.validate((AbstractDomainObject) new Object());
    }

    /**
     * Test of execute method, of class SOAddRacun.
     * @throws Exception is not expected
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        System.out.println(rac);
        
        instance.execute(rac);
        
        ArrayList<Racun> lista = (ArrayList<Racun>)(ArrayList<?>)DBBroker.getInstance().select(new Racun());
        Racun r = new Racun();
        for (Racun racun : lista) {
            if (rac.equals(racun)) {
                r = racun;
                break;
            }
        }
        assertNotNull(r);
        assertEquals(true, (rac.getDatum().getDay() == r.getDatum().getDay()) &&
                (rac.getDatum().getMonth() == r.getDatum().getMonth()) &&
                (rac.getDatum().getYear() == r.getDatum().getYear()));
        assertEquals(rac.getOrganizacija().getNaziv(), r.getOrganizacija().getNaziv());
        assertEquals(rac.getOrganizacija().getAdresa(), r.getOrganizacija().getAdresa());
    }
    
}
