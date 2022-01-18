import com.rizal.spring.hibernate.entity.Course;
import com.rizal.spring.hibernate.entity.Instructor;
import com.rizal.spring.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OneToManyTest {
    SessionFactory sessionFactory;
    Session session;

    @Before
    public void setUp(){
        // create object session factory
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        // create session object
        session = sessionFactory.getCurrentSession();
    }

    @After
    public void tearDown(){
        sessionFactory.close();
    }

    @Test
    public void addInstructorObjectToDatabase(){
        try {

            // creating objects
            Instructor instructor =
                    new Instructor("Rizal", "Purnama", "rizal@mail.com");

            InstructorDetail instructorDetail =
                    new InstructorDetail("http://www.rizal.com/youtube", "Music");

            // associate the object
            instructor.setInstructorDetail(instructorDetail);

            // begin transaction
            session.beginTransaction();

            // save the objects
            System.out.println("Saving object : " + instructor);
            session.save(instructor);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Success save the object..");
        } catch (Exception e){

            // add a clean up connection code
            session.close();
            sessionFactory.close();
            e.printStackTrace();
        }
    }

}
