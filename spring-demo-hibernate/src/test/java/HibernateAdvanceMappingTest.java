import com.rizal.spring.hibernate.entity.Employee;
import com.rizal.spring.hibernate.entity.Instructor;
import com.rizal.spring.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HibernateAdvanceMappingTest {
    SessionFactory sessionFactory;
    Session session;

    @Before
    public void setUp(){
        // create object session factory
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        // create session object
        session = sessionFactory.getCurrentSession();
    }

    @After
    public void tearDown(){
        sessionFactory.close();
    }

    @Test
    public void saveObjectOneToOne(){
        // create the object
        Instructor instructor =
                new Instructor("Moh", "Fadly", "fadly@mail.com");

        InstructorDetail instructorDetail =
                new InstructorDetail(
                        "http://www.fadly.com/youtube",
                        "praying");

        // associate the object
        instructor.setInstructorDetail(instructorDetail);

        // start transaction
        session.beginTransaction();

        // save object
        //
        // NOTE : this will also save instructor detail object
        // because of CascadeType.ALL
        System.out.println("Saving instructor : " + instructor);
        session.save(instructor);

        // commit transaction
        session.getTransaction().commit();
        System.out.println("Done!");
    }
    
}
