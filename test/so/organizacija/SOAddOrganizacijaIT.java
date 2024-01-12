/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package so.organizacija;

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
public class SOAddOrganizacijaIT {
    SOAddOrganizacija instance;
    Organizacija organizacija;
    
    public SOAddOrganizacijaIT() {
    }
    
    @Before
    public void setUp() {
        instance = new SOAddOrganizacija();
        
        organizacija = new Organizacija(-1L, "BancaIntesa", "Milutina Milankovica 45", null);
        
        ArrayList<Vozilo> vozila = new ArrayList<>();
        vozila.add(new Vozilo(organizacija, "BG-3578-HH", "Nissan Qashqai"));
        vozila.add(new Vozilo(organizacija, "BG-3578-JJ", "Nissan Micra"));
        vozila.add(new Vozilo(organizacija, "BG-3578-KK", "Toyota Corolla"));
        
        organizacija.setVozila(vozila);

    }
    
    @After
    public void tearDown() {
        instance = null;
        organizacija = null;
    }

    /**
     * Test of validate method, of class SOAddAdministrator.
     * @throws Exception is expected
     */
    @Test (expected = Exception.class)
    public void testValidate() throws Exception {
        System.out.println("validate");
        
        instance.validate((AbstractDomainObject) new Object());
    }

    /**
     * Test of execute method, of class SOAddOrganizacija.
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        System.out.println(organizacija);
        
        instance.execute(organizacija);
        
        ArrayList<Organizacija> lista = (ArrayList<Organizacija>)(ArrayList<?>)DBBroker.getInstance().select(new Organizacija());
        Organizacija o = null;
        for (Organizacija org : lista) {
            if (organizacija.equals(org)) {
                o = org;
                break;
            }
        }
        assertNotNull(o);
        assertEquals(organizacija.getNaziv(), o.getNaziv());
        assertEquals(organizacija.getAdresa(), o.getAdresa());
    }
    
}
