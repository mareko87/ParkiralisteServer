/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package so.administrator.login;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Administrator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marko Milosevic
 */
public class SOLoginIIT {
        private SOLogin instance;
        private Administrator admin;
    
    public SOLoginIIT() {
    }
    
    @Before
    public void setUp() {
        instance = new SOLogin();
        admin = new Administrator();
    }
    
    @After
    public void tearDown() {
        instance = null;
        admin = null;
    }

    /**
     * Test of validate method, of class SOLogin.
     * @throws Exception expectedly
     */
    @Test (expected = Exception.class)
    public void testValidate() throws Exception {
        System.out.println("validate");

        instance.validate((AbstractDomainObject) new Object());
    }

    /**
     * Test of execute method, of class SOLogin.
     * @throws Exception is not expected
     */
    @Test
    public void testExecutePogresniKredencijali() throws Exception {
        System.out.println("executePogresniKredencijali");

        admin.setKorisnickoIme("nepostoji");
        admin.setLozinka("nepostoji123");
        
        System.out.println("Korisnicko ime: " + admin.getKorisnickoIme() + ", Lozinka: " + admin.getLozinka());

        instance.execute(admin);
        
        Administrator ulogovani = instance.getAdministrator();
        assertNull(ulogovani);
    }
    
     /**
     * Test of execute method, of class SOLogin.
     * @throws Exception is not expected
     */
    @Test
    public void testExecuteTacniKredencijali() throws Exception {
        System.out.println("executeTacniKredencijali");

        admin.setKorisnickoIme("mareko");
        admin.setLozinka("mareko123");
        
        System.out.println("Korisnicko ime: " + admin.getKorisnickoIme() + ", Lozinka: " + admin.getLozinka());
        
        instance.execute(admin);

        Administrator ulogovani = instance.getAdministrator();
        assertNotNull(ulogovani);
        assertEquals(admin.getKorisnickoIme(), ulogovani.getKorisnickoIme());
        assertEquals(admin.getLozinka(), ulogovani.getLozinka());
    }
    
}
