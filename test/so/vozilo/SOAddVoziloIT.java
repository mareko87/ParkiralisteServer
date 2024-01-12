/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package so.vozilo;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Organizacija;
import domain.Vozilo;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marko Milosevic
 */
public class SOAddVoziloIT {
    private SOAddVozilo instance;
    private Vozilo voz;
    
    public SOAddVoziloIT() {
    }
    
    @Before
    public void setUp() {
        instance = new SOAddVozilo();
        ArrayList<Vozilo> vozila = new ArrayList<>();
        Organizacija organizacija = new Organizacija(2L, "Gigatron", "Kraljice Marije 20", vozila);
        voz = new Vozilo(organizacija, "BG-4444-LL", "Honda Civic");
    }
    
    @After
    public void tearDown() {
        instance = null;
        voz = null;
    }

    /**
     * Test of validate method, of class SOAddVozilo.
     * @throws Exception is expected
     */
    @Test (expected = Exception.class)
    public void testValidate() throws Exception {
        System.out.println("validate");
        
        instance.validate((AbstractDomainObject) new Object());
    }

    /**
     * Test of execute method, of class SOAddVozilo.
     * @throws Exception is not expected
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        System.out.println(voz);
        
        instance.execute(voz);
        
        ArrayList<Vozilo> lista = (ArrayList<Vozilo>)(ArrayList<?>)DBBroker.getInstance().select(new Vozilo());
        Vozilo v = null;
        for (Vozilo vozilo : lista) {
            if (voz.equals(vozilo)) {
                v = vozilo;
                break;
            }
        }
        assertNotNull(v);
        assertEquals(voz.getRegistarskiBroj(), v.getRegistarskiBroj());
    }
    
}
