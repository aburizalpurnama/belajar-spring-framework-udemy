import com.rizal.spring.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Before run the test below, update properly url (database name/ schema) on hibernate.cfg.xml file first.
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
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
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
    public void addingCoursesToInstructor(){
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
    public void deleteCourseObjectFromDatabase(){
        try {
            int courseId = 10;

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

    @Test
    public void solveLazyLoadProblemUsingHQL(){
        /**
         * Relation dengan lazy loading biasanya akan menemui masalah jika me-load data dalam posisi session
         * sudah close, maka dari itu cara mengatasinya bisa dengan menjalankan method get pada posisi session
         * masih berjalan, atau dengan memanggil data menggunakan HQL (Hibernate Query Language)
         */
        try {
            int instructorId = 1;

            // begin transaction
            session.beginTransaction();

            // retrieve object from db
            System.out.println("Retrieving object using HQL..");
            Query<Instructor> query =
                    session.createQuery("select i from Instructor i " +
                                        "JOIN FETCH i.courses " +
                                        "where i.id=:theInstructorId", Instructor.class);
            // set query parameter
            query.setParameter("theInstructorId", instructorId);

            Instructor instructor = query.getSingleResult();

            System.out.println("Retrieved Instructor : " + instructor);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Success retrieve the object..");

            // session closed
            session.close();
            System.out.println("Session Closed..");

            // show instructor courses
            System.out.println("Instructor Courses : " + instructor.getCourses());
        } catch (Exception e){

            // add a clean up connection code
            session.close();
            sessionFactory.close();
            e.printStackTrace();
        }
    }

    @Test
    public void solveLazyLoadProblemWithCreatinNewSession(){
        /**
         * Relation dengan lazy loading biasanya akan menemui masalah jika me-load data dalam posisi session
         * sudah close, maka dari itu cara mengatasinya bisa dengan menjalankan method get pada posisi session
         * masih berjalan, atau dengan memanggil data menggunakan HQL (Hibernate Query Language), dan bisa jugan
         * membuat session baru setelah session yang pertama closed
         */
        try {
            int instructorId = 1;

            // begin transaction
            session.beginTransaction();

            // retrieve object from db
            System.out.println("Retrieving object..");
            Instructor instructor =  session.get(Instructor.class, instructorId);

            //commit transaction
            session.getTransaction().commit();
            System.out.println("Success retrieve the object..");
            System.out.println("Retrieved Instructor : " + instructor);

            // session closed
            session.close();
            System.out.println("Session Closed..");

            // create new session and begin transaction
            session = sessionFactory.getCurrentSession();
            System.out.println("New Session started..");
            session.beginTransaction();

            Query<Course> query =
                    session.createQuery("select c from Course c " +
                            "where c.instructor.id=:theInstructorId", Course.class);
            // set query parameter
            query.setParameter("theInstructorId", instructorId);

            // excecute query
            List<Course> courses = query.getResultList();

            // show instructor courses
            System.out.println("Instructor Courses : " + courses);

            session.getTransaction().commit();
        } catch (Exception e){

            // add a clean up connection code
            session.close();
            sessionFactory.close();
            e.printStackTrace();
        }
    }

    @Test
    public void addReviewsToCourseObjectWithUniDirectional(){
        try {
            int courseId = 12;

            // creating reviews objects
            Review review1 = new Review("Great course, very recommended !");
            Review review2 = new Review("easy to understand, nice");
            Review review3 = new Review("Rich of example with detail explaination, love it..");
            Review review4 = new Review("Best spring framework course ever..");

            // begin transaction
            session.beginTransaction();

            // get course object
            Course course = session.get(Course.class, courseId);

            // associate the object
            course.addReview(review1);
            course.addReview(review2);
            course.addReview(review3);
            course.addReview(review4);


            // save the objects
            System.out.println("Saving object : " + course);
            System.out.println("Reviews : " + course.getReviews());
            session.save(review1);
            session.save(review2);
            session.save(review3);
            session.save(review4);

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
    public void retrieveReviewsObjectFromDatabase(){
        try {
            int instructorId = 1;

            // begin transaction
            session.beginTransaction();

            // retrieve object from db
            System.out.println("Retrieving object..");
            Instructor instructor = session.get(Instructor.class, instructorId);

            // show instructor courses
            System.out.println("Instructor :");
            System.out.println(instructor.getFirstName());
            System.out.println("\tCourses :");
            instructor.getCourses().forEach(course -> {
                System.out.println("\t"+course.getTitle());
                System.out.println("\t\tReviews :");
                course.getReviews().forEach(review -> {
                    System.out.println("\t\t" + review.getComment());
                });
            });

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
