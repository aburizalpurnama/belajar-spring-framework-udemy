import com.rizal.spring.hibernate.entity.Instructor;
import com.rizal.spring.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OneToOneTest {
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
                new Instructor("Zacky", "Fuady", "zacky@mail.com");

        InstructorDetail instructorDetail =
                new InstructorDetail(
                        "http://www.zacky.com/youtube",
                        "Lego");

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

    @Test
    public void deleteObjectOneToOne(){
        int id = 3;

        // start transaction
        session.beginTransaction();

        // get instructor by ID
        Instructor instructor = session.get(Instructor.class, id);

        // delete the instructor
        if (instructor != null){
            System.out.println("deleting : " + instructor);

            // NOTE : it will ALSO delete associate "detail" object
            // because of CasecadeType=All
            session.delete(instructor);
        }

        // commit transaction
        session.getTransaction().commit();
        System.out.println("Done!");
    }

    @Test
    public void oneToOneBiDiretion(){
        int id = 256;

        try {
            session.beginTransaction();
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            // print retrieved instructor detail object
            System.out.println(instructorDetail);

            // print associated instructor object
            System.out.println(instructorDetail.getInstructor());

            session.getTransaction().commit();
        }catch (Exception e){
            session.close();
            sessionFactory.close();
            e.printStackTrace();
        }
    }

    @Test
    public void deleteOneToOneBiDiretion(){
        int id = 2;

        try {
            session.beginTransaction();
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            // print retrieved instructor detail object
            System.out.println(instructorDetail);

            // print associated instructor object
            System.out.println(instructorDetail.getInstructor());

            // delete instructor detail
            session.delete(instructorDetail);

            session.getTransaction().commit();
        }catch (Exception e){
            session.close();
            sessionFactory.close();
            e.printStackTrace();
        }
    }

    @Test
    public void cescadeChanging(){
        int id = 3;

        try {
            session.beginTransaction();
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, id);

            // print retrieved instructor detail object
            System.out.println(instructorDetail);

            // print associated instructor object
            System.out.println(instructorDetail.getInstructor());

            // remove the associated object reference
            // break bi-directional link
            instructorDetail.getInstructor().setInstructorDetail(null);

            // delete instructor detail
            session.delete(instructorDetail);

            session.getTransaction().commit();
        }catch (Exception e){
            session.close();
            sessionFactory.close();
            e.printStackTrace();
        }
    }
}
