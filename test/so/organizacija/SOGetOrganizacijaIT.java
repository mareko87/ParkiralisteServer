/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package so.organizacija;

import domain.AbstractDomainObject;
import domain.Organizacija;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marko Milosevic
 */
public class SOGetOrganizacijaIT {
    private SOGetOrganizacija instance;
    
    public SOGetOrganizacijaIT() {
    }
    
    @Before
    public void setUp() {
        instance = new SOGetOrganizacija();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of validate method, of class SOGetOrganizacija.
     * @throws Exception expectedly
     */
    @Test (expected = Exception.class)
    public void testValidate() throws Exception {
        System.out.println("validate");

        instance.validate((AbstractDomainObject) new Object());
    }

    /**
     * Test of execute method, of class SOGetOrganizacija.
     * @throws Exception is not expected
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");
        
        Organizacija o = new Organizacija();
        o.setNaziv("Gigatron");
        o.setAdresa("Kraljice Marije 20");
        
        instance.execute(o);
        
        assertEquals(o.getNaziv(), instance.getOrganizacija().getNaziv());
        assertEquals(o.getAdresa(), instance.getOrganizacija().getAdresa());
    }
 
}
