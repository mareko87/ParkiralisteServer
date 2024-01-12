/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ServerController;
import domain.Administrator;
import domain.Organizacija;
import domain.Racun;
import domain.Vozilo;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author marek
 */
public class ThreadClient extends Thread {

    private Socket socket;

    ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!socket.isClosed()) {
                // primi zahtev
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request req = (Request) in.readObject();
                // obradi zahtev
                Response res = handleRequest(req);
                // posalji odgovor
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request req) {
        Response res = new Response(null, null, ResponseStatus.Success);
        try {
            switch (req.getOperation()) {
                case Operation.LOGIN:
                    res.setData(ServerController.getInstance().login((Administrator) req.getData()));
                    if (res.getData() == null) {
                        throw new Exception("Ne postoji administrator sa tim kredencijalima.");
                    } else {
                        break;
                    }
                case Operation.GET_ADMINISTRATOR:
                    res.setData(ServerController.getInstance().getAdministrator((Administrator) req.getData()));
                    if (res.getData() == null) {
                        throw new Exception("Nije pronadjen administrator u bazi.");
                    } else {
                        break;
                    }
                case Operation.GET_ORGANIZACIJA:
                    res.setData(ServerController.getInstance().getOrganizacija((Organizacija) req.getData()));
                    if (res.getData() == null) {
                        throw new Exception("Nije pronadjena organizacija u bazi.");
                    } else {
                        break;
                    }
                case Operation.ADD_ADMINISTRATOR:
                    ServerController.getInstance().addAdministrator((Administrator) req.getData());
                    break;
                case Operation.ADD_ORGANIZACIJA:
                    ServerController.getInstance().addOrganizacija((Organizacija) req.getData());
                    break;
                case Operation.ADD_RACUN:
                    ServerController.getInstance().addRacun((Racun) req.getData());
                    break;
                case Operation.ADD_VOZILO:
                    ServerController.getInstance().addVozilo((Vozilo) req.getData());
                    break;
                case Operation.DELETE_ADMINISTRATOR:
                    ServerController.getInstance().deleteAdministrator((Administrator) req.getData());
                    break;
                case Operation.DELETE_ORGANIZACIJA:
                    ServerController.getInstance().deleteOrganizacija((Organizacija) req.getData());
                    break;
                case Operation.DELETE_VOZILO:
                    ServerController.getInstance().deleteVozilo((Vozilo) req.getData());
                    break;
                case Operation.EDIT_ADMINISTRATOR:
                    ServerController.getInstance().editAdministrator((Administrator) req.getData());
                    break;
                case Operation.EDIT_ORGANIZACIJA:
                    ServerController.getInstance().editOrganizacija((Organizacija) req.getData());
                    break;
                case Operation.GET_ALL_ADMINISTRATOR:
                    res.setData(ServerController.getInstance().getAllAdministrator());
                    break;
                case Operation.GET_ALL_ORGANIZACIJA:
                    res.setData(ServerController.getInstance().getAllOrganizacija());
                    break;
                case Operation.GET_ALL_PARKIRALISTE:
                    res.setData(ServerController.getInstance().getAllParkiraliste());
                    break;
                case Operation.GET_ALL_RACUN:
                    res.setData(ServerController.getInstance().getAllRacun());
                    break;
                case Operation.GET_ALL_VOZILO:
                    res.setData(ServerController.getInstance().getAllVozilo());
                    break;
                default:
                    return null;
            }
        } catch (Exception e) {
            res.setError(e);
            res.setResponseStatus(ResponseStatus.Error);
        }
        return res;
    }

}
