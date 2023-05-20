/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.RenameMeDTO;
import dtos.UserDTO;
import entities.Location;
import entities.RenameMe;
import javax.persistence.EntityManagerFactory;

import entities.User;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        //FacadeExample fe = FacadeExample.getFacadeExample(emf);
        //fe.create(new RenameMeDTO(new RenameMe("First 1", "Last 1")));
        //fe.create(new RenameMeDTO(new RenameMe("First 2", "Last 2")));
        //fe.create(new RenameMeDTO(new RenameMe("First 3", "Last 3")));
        User user = new User("user", "test123");
        UserFacade userFacade = UserFacade.getUserFacade(emf);
        userFacade.create(new UserDTO(user));
        Location location = new Location("ipaddress", "country");
        LocationFacade locationFacade = LocationFacade.getLocationFacade(emf);
    }
    
    public static void main(String[] args) {
        populate();
    }
}
