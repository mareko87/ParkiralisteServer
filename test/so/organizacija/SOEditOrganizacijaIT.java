/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package so.organizacija;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Organizacija;
import domain.Vozilo;
import java.sql.SQLException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marko Milosevic
 */
public class SOEditOrganizacijaIT {
    private SOEditOrganizacija instance;
    private Organizacija org;
    
    public SOEditOrganizacijaIT() {
    }
    
    @Before
    public void setUp() {
        instance = new SOEditOrganizacija();
        org = new Organizacija(2L, "Gigatron", "Kraljice Marije 20", null);
        org.setAdresa("Avalska 10");
    }
    
    @After
    public void tearDown() {
        instance = null;
        org = null;
    }

    /**
     * Test of validate method, of class SOEditOrganizacija.
     * @throws Exception expectedly
     */
    @Test (expected = Exception.class)
    public void testValidate() throws Exception {
        System.out.println("validate");

        instance.validate((AbstractDomainObject) new Object());
    }

    /**
     * Test of execute method, of class SOEditOrganizacija.
     * @throws Exception is not expected
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");

        System.out.println(org);
        
        instance.execute(org);
        
        ArrayList<Organizacija> lista = (ArrayList<Organizacija>)(ArrayList<?>)DBBroker.getInstance().select(new Organizacija());
        Organizacija o = null;
        for (Organizacija organizacija : lista) {
            if (org.equals(organizacija)) {
                o = organizacija;
                break;
            }
        }

        assertNotNull(o);
        assertEquals(org.getNaziv(), o.getNaziv());
        assertEquals(org.getAdresa(), o.getAdresa());
    }
}
