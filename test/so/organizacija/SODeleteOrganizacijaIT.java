/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package so.organizacija;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Organizacija;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marko Milosevic
 */
public class SODeleteOrganizacijaIT {
        SODeleteOrganizacija instance;
        Organizacija organizacija;
    
    public SODeleteOrganizacijaIT() {
    }
    
    @Before
    public void setUp() {
        instance = new SODeleteOrganizacija();
        organizacija = new Organizacija(5L, "FPN", "Jove Ilica 165", null);
    }
    
    @After
    public void tearDown() {
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
     * Test of execute method, of class SODeleteOrganizacija.
     * @throws Exception is not expected
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
        assertNull(o);
    }
    
}
