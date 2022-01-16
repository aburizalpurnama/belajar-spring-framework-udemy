import com.rizal.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

public class HibernateTest {

    /**
     *'truncate table_name' for empty and reset the database table
     * 'alter table table_name auto_increment=1000' set the starting index of auto increment value
     */
    @Test
    public void testChangingStartingIndex(){
        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();

        // do some database operation using creted session
        try{
            // use the session object to map and save java object into database
            // create student object
            System.out.println("Creating 3 student object ..");
            Student student1 = new Student("Aziz", "njen", "ajis@mail.com");
            Student student2 = new Student("Iwan", "makita", "iwan@mail.com");
            Student student3 = new Student("Jubaedah", "tekka", "jubaedah@mail.com");

            // start begin transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the students..");
            session.save(student1);
            session.save(student2);
            session.save(student3);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }

    @Test
    public void testReadDataFromDatabase(){
        // create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // create session
        Session session = sessionFactory.getCurrentSession();

        // do some database operation using creted session
        try{
            // use the session object to map and save java object into database
            // create student object
            System.out.println("Creating a student object ..");
            Student student1 = new Student("Zaki", "hendra", "zaki@mail.com");

            // start begin transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student..");
            session.save(student1);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Sucessfully saving data");

            // get a new session and start transaction
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // retrieve data from database
            System.out.println("\nGetting student with id : " + student1.getId());

            Student newStudent = session.get(Student.class, student1.getId());

            // commit the transaction
            session.getTransaction().commit();

            System.out.println("Retrieving data complete, data : " + newStudent);

            System.out.println("Done!");

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            sessionFactory.close();
        }
    }
}
