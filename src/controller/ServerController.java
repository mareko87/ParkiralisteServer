/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Administrator;
import domain.Organizacija;
import domain.Parkiraliste;
import domain.Racun;
import domain.Vozilo;
import java.util.ArrayList;
import so.AbstractSO;
import so.administrator.SOAddAdministrator;
import so.administrator.SODeleteAdministrator;
import so.administrator.SOEditAdministrator;
import so.administrator.SOGetAdministrator;
import so.administrator.SOGetAllAdministrator;
import so.administrator.login.SOLogin;
import so.organizacija.SOAddOrganizacija;
import so.organizacija.SODeleteOrganizacija;
import so.organizacija.SOEditOrganizacija;
import so.organizacija.SOGetAllOrganizacija;
import so.organizacija.SOGetOrganizacija;
import so.parkiraliste.SOGetAllParkiraliste;
import so.racun.SOAddRacun;
import so.racun.SOGetAllRacun;
import so.vozilo.SOAddVozilo;
import so.vozilo.SODeleteVozilo;
import so.vozilo.SOGetAllVozilo;

/**
 *
 * @author Marko Milosevic
 */
public class ServerController {

    private static ServerController instance;

    public ServerController() {
    }

    public static ServerController getInstance() {
        if (instance == null) {
            instance = new ServerController();
        }
        return instance;
    }
    
    public Administrator login(Administrator administrator) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(administrator);
        return so.getAdministrator();
    }
    
    public Administrator getAdministrator(Administrator administrator) throws Exception {
        SOGetAdministrator so = new SOGetAdministrator();
        so.templateExecute(administrator);
        return so.getAdministrator();
    }

    public Organizacija getOrganizacija(Organizacija organizacija) throws Exception {
        SOGetOrganizacija so = new SOGetOrganizacija();
        so.templateExecute(organizacija);
        return so.getOrganizacija();
    }
    
    public void addAdministrator(Administrator administrator) throws Exception {
        AbstractSO aso = new SOAddAdministrator();
        aso.templateExecute(administrator);
    }

    public void addOrganizacija(Organizacija organizacija) throws Exception{
        AbstractSO aso = new SOAddOrganizacija();
        aso.templateExecute(organizacija);
    }

    public void addRacun(Racun racun) throws Exception{
        AbstractSO aso = new SOAddRacun();
        aso.templateExecute(racun);
    }

    public void addVozilo(Vozilo vozilo) throws Exception{
        AbstractSO aso = new SOAddVozilo();
        aso.templateExecute(vozilo);
    }

    public void deleteAdministrator(Administrator administrator) throws Exception {
        AbstractSO aso = new SODeleteAdministrator();
        aso.templateExecute(administrator);
    }

    public void deleteOrganizacija(Organizacija organizacija) throws Exception{
        AbstractSO aso = new SODeleteOrganizacija();
        aso.templateExecute(organizacija);
    }

    public void deleteVozilo(Vozilo vozilo) throws Exception{
        AbstractSO aso = new SODeleteVozilo();
        aso.templateExecute(vozilo);
    }

    public void editAdministrator(Administrator administrator) throws Exception {
        AbstractSO aso = new SOEditAdministrator();
        aso.templateExecute(administrator);
    }

    public void editOrganizacija(Organizacija organizacija) throws Exception{
        AbstractSO aso = new SOEditOrganizacija();
        aso.templateExecute(organizacija);
    }
    
    public ArrayList<Administrator> getAllAdministrator() throws Exception {
        SOGetAllAdministrator so = new SOGetAllAdministrator();
        so.templateExecute(new Administrator());
        return so.getLista();
    }

    public ArrayList<Organizacija> getAllOrganizacija() throws Exception{
        SOGetAllOrganizacija so = new SOGetAllOrganizacija();
        so.templateExecute(new Organizacija());
        return so.getLista();
    }

    public ArrayList<Parkiraliste> getAllParkiraliste() throws Exception{
        SOGetAllParkiraliste so = new SOGetAllParkiraliste();
        so.templateExecute(new Parkiraliste());
        return so.getLista();
    }

    public ArrayList<Racun> getAllRacun() throws Exception{
        SOGetAllRacun so = new SOGetAllRacun();
        so.templateExecute(new Racun());
        return so.getLista();
    }

    public ArrayList<Vozilo> getAllVozilo() throws Exception{
        SOGetAllVozilo so = new SOGetAllVozilo();
        so.templateExecute(new Vozilo());
        return so.getLista();
    }




}
