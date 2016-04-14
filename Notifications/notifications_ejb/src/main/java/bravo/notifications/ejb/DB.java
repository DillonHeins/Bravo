package bravo.notifications.ejb;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;


@Path("notifications_jpa")
public class DB {

    @Path("{notifications}")
    @GET
    //Returns boolean if username and password match
    public boolean logIn(String email, String password) {
        try {
            Class.forName("org.postgresql.Driver");
          } catch (ClassNotFoundException cnfe) {
            System.err.println("Couldn't find driver class:");
            cnfe.printStackTrace();
          }
       EntityManager entityManager = Persistence.createEntityManagerFactory("bravonotifDB").createEntityManager();
       
       List<Tbl_users> list  = null;
       try {
         TypedQuery<Tbl_users> nq = entityManager.createNamedQuery("listUsers", Tbl_users.class);
         list = nq.getResultList();
       } catch (Exception e) {

         System.out.println("Error: " + e.toString());
       } finally {
         entityManager.clear();
         entityManager.close();
       }
       
       boolean success = false;

       for (Tbl_users db : list) {
           if (db.getEmail().equals(email) && db.getPassword().equals(password)){
               success = true;
           }
       }
       
       return success;
    }
    
    
    @Path("{notifications}")
    @GET
    //Returns String, the fullname of the email user. Returns empty if not found
    public String getFullName(@PathParam("notifications") String email) {
        try {
            Class.forName("org.postgresql.Driver");
          } catch (ClassNotFoundException cnfe) {
            System.err.println("Couldn't find driver class:");
            cnfe.printStackTrace();
          }
       EntityManager entityManager = Persistence.createEntityManagerFactory("bravonotifDB").createEntityManager();
       
       List<Tbl_users> list  = null;
       try {
         TypedQuery<Tbl_users> nq = entityManager.createNamedQuery("listUsers", Tbl_users.class);
         list = nq.getResultList();
       } catch (Exception e) {

         System.out.println("Error: " + e.toString());
       } finally {
         entityManager.clear();
         entityManager.close();
       }
       
       String fullname = "";

       for (Tbl_users db : list) {
           if (db.getEmail().equals(email)){
               fullname = db.getFirstName() + " " + db.getLastName();
           }
       }
       
       return fullname;
    }
    
    @Path("{notifications}")
    @GET
    //Inserts a log entry into db
    public void insertLogEntry(String userEmail, String errorLocation, String errorDescription, java.sql.Timestamp errorDateTime ) {
        try {
            Class.forName("org.postgresql.Driver");
          } catch (ClassNotFoundException cnfe) {
            System.err.println("Couldn't find driver class:");
            cnfe.printStackTrace();
          }
       EntityManager entityManager = Persistence.createEntityManagerFactory("bravonotifDB").createEntityManager();
       EntityTransaction transaction = entityManager.getTransaction();
       
       try {
         transaction.begin();

         
         int userID = getUserID(userEmail);
    
         Tbl_log entity = new Tbl_log();
         entity.setFKUserID(userID);
         entity.setErrorLocation(errorLocation);
         entity.setDescription(errorDescription);
         entity.setErrorDateTime(errorDateTime);
    
    
    
         entityManager.persist(entity);

         transaction.commit();
       } catch (Exception e) {

         transaction.rollback();
         System.out.println("Error: " + e.toString());
       } finally {
         entityManager.clear();
         entityManager.close();
       }
    }
    
    
    @Path("{notifications}")
    @GET
    //Get reminder details from db where emails match
    public Tbl_reminders getReminder(String email) {
        try {
            Class.forName("org.postgresql.Driver");
          } catch (ClassNotFoundException cnfe) {
            System.err.println("Couldn't find driver class:");
            cnfe.printStackTrace();
          }
       EntityManager entityManager = Persistence.createEntityManagerFactory("bravonotifDB").createEntityManager();
       
       List<Tbl_reminders> list  = null;
       try {
         TypedQuery<Tbl_reminders> nq = entityManager.createNamedQuery("listReminders", Tbl_reminders.class);
         list = nq.getResultList();
       } catch (Exception e) {

         System.out.println("Error: " + e.toString());
       } finally {
         entityManager.clear();
         entityManager.close();
       }
       
       int userID = getUserID(email);
       Tbl_reminders reminder = null;

       for (Tbl_reminders db : list) {
           if (db.getFKUserID() == userID){
               reminder = db;
           }
       }
       
       return reminder;
    }
    
    @Path("{notifications}")
    @GET
    //gets the user's ID from email. Primarly made for foreign key
    public int getUserID(String email) {
        try {
            Class.forName("org.postgresql.Driver");
          } catch (ClassNotFoundException cnfe) {
            System.err.println("Couldn't find driver class:");
            cnfe.printStackTrace();
          }
       EntityManager entityManager = Persistence.createEntityManagerFactory("bravonotifDB").createEntityManager();
       
       List<Tbl_users> list  = null;
       try {
         TypedQuery<Tbl_users> nq = entityManager.createNamedQuery("listUsers", Tbl_users.class);
         list = nq.getResultList();
       } catch (Exception e) {

         System.out.println("Error: " + e.toString());
       } finally {
         entityManager.clear();
         entityManager.close();
       }
       
       int userID = -1;
       
       for (Tbl_users db : list) {
           if (db.getEmail().equals(email)){
               userID = db.getID();
           }
       }
       
       return userID;
    }
    
    /*
    //TO INSERT SOMETHING TO THE DB
    @Path("{notifications}")
    @GET
    public void insert(@PathParam("notifications") String example) {
        try {
            Class.forName("org.postgresql.Driver");
          } catch (ClassNotFoundException cnfe) {
            System.err.println("Couldn't find driver class:");
            cnfe.printStackTrace();
          }
       EntityManager entityManager = Persistence.createEntityManagerFactory("bravonotifDB").createEntityManager();
       EntityTransaction transaction = entityManager.getTransaction();
       
       try {
         transaction.begin();

         
         //********************************
         //THIS IS THE CODE YOU WANT TO EDIT
         //********************************
         
    
         Tbl_users entity = new Tbl_users();
         entity.setFirstName("Phili");
         entity.setLastName("CheeseSteak");
         entity.setEmail("phili@gmail.com");
         entity.setPassword("3wp");
    
    
         //********************************
    
    
    
         entityManager.persist(entity);
         
         TypedQuery<Tbl_users> nq = entityManager.createNamedQuery("listUsers", Tbl_users.class);

         transaction.commit();
       } catch (Exception e) {

         transaction.rollback();
         System.out.println("Error: " + e.toString());
       } finally {
         entityManager.clear();
         entityManager.close();
       }
    }
    
    //ONLY TO GET SOMETHING
    @Path("{notifications}")
    @GET
    public void get(@PathParam("notifications") String email) {
        try {
            Class.forName("org.postgresql.Driver");
          } catch (ClassNotFoundException cnfe) {
            System.err.println("Couldn't find driver class:");
            cnfe.printStackTrace();
          }
       EntityManager entityManager = Persistence.createEntityManagerFactory("bravonotifDB").createEntityManager();
       
       List<Tbl_users> list  = null;
       try {
         TypedQuery<Tbl_users> nq = entityManager.createNamedQuery("listUsers", Tbl_users.class);
         list = nq.getResultList();
       } catch (Exception e) {

         System.out.println("Error: " + e.toString());
       } finally {
         entityManager.clear();
         entityManager.close();
       }

    
       for (Tbl_users db : list) {
    
         //********************************
         //THIS IS THE CODE YOU WANT TO EDIT
         //********************************
    
    
           if (db.getEmail().equals(email)){
               System.out.println(db.getFirstName() + " " + db.getLastName());
           }
    
    
         //********************************
    
       }
    }
    
    
    //TO INSERT SOMETHING WITH A DATE
    @Path("{notifications}")
    @GET
    public void insertReminder() {
        try {
            Class.forName("org.postgresql.Driver");
          } catch (ClassNotFoundException cnfe) {
            System.err.println("Couldn't find driver class:");
            cnfe.printStackTrace();
          }
       EntityManager entityManager = Persistence.createEntityManagerFactory("bravonotifDB").createEntityManager();
       EntityTransaction transaction = entityManager.getTransaction(); // Not useful here, but useful to see
       
       try {
         transaction.begin();
         
    
    
         //********************************
         //THIS IS THE CODE YOU WANT TO EDIT
         //********************************
    
    
         java.sql.Timestamp ts = null;
         Calendar cal = Calendar.getInstance();
         cal.add(Calendar.DAY_OF_WEEK, 14);
         ts = new Timestamp(cal.getTime().getTime());
         
         Tbl_reminders entity = new Tbl_reminders();
         entity.setFKUserID(1);
         entity.setReminderDateTime(ts);
         entity.setMessage("Aweee Test Message");
         entity.setDueDate(ts);
    
    
         //********************************
                 
         entityManager.persist(entity);
         
         transaction.commit();
       } catch (Exception e) {
         transaction.rollback();
         System.out.println("Error: " + e.toString());

       } finally {
         entityManager.clear();
         entityManager.close();
       }
    }
    */
}