/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public abstract class Dao<T>{
        protected static SessionFactory sessionFactory =null;
        protected static StandardServiceRegistry serviceRegistry =null;
        protected static  Configuration cof =null;
        protected static Session session= null; 
        
        public abstract  boolean save(T obj);
        public abstract  boolean update(T obj);
        public abstract  boolean delete(T obj);
        public abstract  T getByID(int id);
         public abstract  List<T> getAll();
        
 protected void initSession(){
     try {
         cof = new Configuration().configure();
        serviceRegistry = new StandardServiceRegistryBuilder().applySettings(cof.getProperties()).build();
        sessionFactory = cof.configure().buildSessionFactory(serviceRegistry);
        session=sessionFactory.openSession();
        
        } catch (Exception e) {
            e.printStackTrace();
           // log.fatal(e.getMessage());
           
        } 
    }
        
        	
}
