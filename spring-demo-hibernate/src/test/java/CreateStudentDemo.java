import com.rizal.spring.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDemo {

    public static void main(String[] args) {

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
            System.out.println("Creating new student object ..");
            Student student = new Student("Rizal", "Purnama", "rizal@mail.com");

            // start begin transaction
            session.beginTransaction();

            // save the student object
            System.out.println("Saving the student..");
            session.save(student);

            // commit transaction
            session.getTransaction().commit();
            System.out.println("Done!");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
