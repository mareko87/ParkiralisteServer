/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package so.vozilo;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Organizacija;
import domain.Vozilo;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marko Milosevic
 */
public class SODeleteVoziloIT {
    private SODeleteVozilo instance;
    private Vozilo voz;
    
    public SODeleteVoziloIT() {
    }
    
    @Before
    public void setUp() {
        instance = new SODeleteVozilo();
        ArrayList<Vozilo> vozila = new ArrayList<>();
        try {
            vozila = (ArrayList<Vozilo>)(ArrayList<?>)DBBroker.getInstance().select(new Vozilo());
        } catch (SQLException ex) {
            System.err.println("Greska prilikom ucitavanja vozila: " + ex.getMessage());
        }
        Organizacija organizacija = new Organizacija(2L, "Gigatron", "Kraljice Marije 20", vozila);
        voz = new Vozilo(organizacija, "NS-123-AA", "Renault Kangoo");
    }
    
    @After
    public void tearDown() {
        instance = null;
        voz = null;
    }

    /**
     * Test of validate method, of class SODeleteVozilo.
     * @throws Exception expectedly
     */
    @Test (expected = Exception.class)
    public void testValidate() throws Exception {
        System.out.println("validate");
        
        instance.validate((AbstractDomainObject) new Object());
    }

    /**
     * Test of execute method, of class SODeleteVozilo.
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
        assertNull(v);
    }
}
