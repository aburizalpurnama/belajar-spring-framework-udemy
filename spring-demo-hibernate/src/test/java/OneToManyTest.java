import com.rizal.spring.hibernate.entity.Course;
import com.rizal.spring.hibernate.entity.Instructor;
import com.rizal.spring.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Before run test below, update properly url (database name/ schema) on hibernate.cfg.xml file first.
 */
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

    @Test
    public void saveInstructorAndCourseObjectToDatabase(){
        try {
            int instructorId = 1;

            // creating objects
            Course course1 = new Course("Mastering Spring Framework In 30 Days");
            Course course2 = new Course("Web Development Bootcamp 2022");
            Course course3 = new Course("Artificial Intelligent From Scratch");
            Course course4 = new Course("Data Science Zero To Hero");

            // get instructor from database
            session.beginTransaction();
            Instructor instructor = session.get(Instructor.class, instructorId);

            // associate the object
            instructor.add(course1);
            instructor.add(course2);
            instructor.add(course3);
            instructor.add(course4);

            // save the objects
            System.out.println("Saving object : " + instructor.getCourses());
            session.save(course1);
            session.save(course2);
            session.save(course3);
            session.save(course4);

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

    @Test
    public void retrieveObjectFromDatabase(){
        try {
            int instructorId = 1;

            // begin transaction
            session.beginTransaction();

            // retrieve object from db
            System.out.println("Retrieving object..");
            Instructor instructor = session.get(Instructor.class, instructorId);

            // show instructor courses
            System.out.println("Instructor : " + instructor);
            System.out.println("Courses : " + instructor.getCourses());

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Success retrieve the object..");

        } catch (Exception e){

            // add a clean up connection code
            session.close();
            sessionFactory.close();
            e.printStackTrace();
        }
    }

    @Test
    public void deteleObjectOnDatabase(){
        try {
            int courseId = 13;

            // begin transaction
            session.beginTransaction();

            // get the course from database
            Course course = session.get(Course.class, courseId);

            // delete the course
            System.out.println("Deleting object : " + course);
            session.delete(course);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Success delete the object..");
        } catch (Exception e){

            // add a clean up connection code
            session.close();
            sessionFactory.close();
            e.printStackTrace();
        }
    }

    @Test
    public void fetchTypeDemo(){
        // override fetchType value in @OneToMany annotation with FetchType.EAGER
        try {
            int instructorId = 1;

            // begin transaction
            session.beginTransaction();

            // retrieve object from db
            System.out.println("Retrieving object..");
            Instructor instructor = session.get(Instructor.class, instructorId);

            // show instructor courses
            System.out.println("Instructor : " + instructor);
            System.out.println("Courses : " + instructor.getCourses());

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Success retrieve the object..");

        } catch (Exception e){

            // add a clean up connection code
            session.close();
            sessionFactory.close();
            e.printStackTrace();
        }
    }

}
