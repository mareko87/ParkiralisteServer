/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package so.administrator;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Administrator;
import domain.Parkiraliste;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marko Milosevic
 */
public class SOAddAdministratorIT {
    private SOAddAdministrator instance;
    private Administrator admin;

    public SOAddAdministratorIT() {
    }
    
    @Before
    public void setUp() {
        instance = new SOAddAdministrator();
        Parkiraliste p = new Parkiraliste(1L, "Kneza Milosa 65", 200);
        admin = new Administrator(-1, "Janko", "Jankovic", "janko", "janko123", false, p);
    }
    
    @After
    public void tearDown() {
        instance = null;
        admin = null;
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
     * Test of execute method, of class SOAddAdministrator.
     * @throws Exception is not expected
     */
    @Test 
    public void testExecute() throws Exception {
        System.out.println("execute");
        System.out.println(admin);
        
        instance.execute(admin);
        
        ArrayList<Administrator> lista = (ArrayList<Administrator>)(ArrayList<?>)DBBroker.getInstance().select(new Administrator());
        Administrator a = null;
        for (Administrator administrator : lista) {
            if (admin.equals(administrator)) {
                a = administrator;
                break;
            }
        }
        assertNotNull(a);
        assertEquals(admin.getKorisnickoIme(), a.getKorisnickoIme());
    }
    
}
