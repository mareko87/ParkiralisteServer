/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package so.administrator;

import domain.AbstractDomainObject;
import domain.Administrator;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marko Milosevic
 */
public class SOGetAllAdministratorIT {
    private SOGetAllAdministrator instance;
    
    public SOGetAllAdministratorIT() {
    }
    
    @Before
    public void setUp() {
        instance = new SOGetAllAdministrator();
    }
    
    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of validate method, of class SOGetAllAdministrator.
     * @throws Exception expectedly
     */
    @Test (expected = Exception.class)
    public void testValidate() throws Exception {
        System.out.println("validate");
        
        instance.validate((AbstractDomainObject) new Object());
    }

    /**
     * Test of execute method, of class SOGetAllAdministrator.
     * @throws Exception is not expected
     */
    @Test
    public void testExecute() throws Exception {
        System.out.println("execute");

        instance.execute(new Administrator());
        ArrayList<Administrator> lista = instance.getLista();
        
        assertEquals(true, lista.size() > 0);
    }
    
}
