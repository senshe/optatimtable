/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import beans.Room;
import static dao.Dao.session;
import java.util.List;

/**
 *
 * @author ElBastamy
 */
public class RoomDao   extends Dao<Room>{

    @Override
    public boolean save(Room obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Room obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(Room obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Room getByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Room> getAll() {

        try {
        
        initSession();
           session.getNamedQuery("Room.findAll").list();
  
        return session.getNamedQuery("Room.findAll").list();
        } catch (Exception e) {
            e.printStackTrace();
           // log.fatal(e.getMessage());
            return null;
        } finally {
            session.close();
           // log.debug("********** Fin getPersonne PersonneDAO **********");
        }  
                
                }
    
}
