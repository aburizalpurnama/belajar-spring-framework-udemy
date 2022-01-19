import com.rizal.spring.hibernate.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.hibernate.cfg.Configuration;
import org.jboss.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class ManyToManyTest {
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
    public void tearDown() {
        sessionFactory.close();
    }

    @Test
    public void addingStudentAndFetchTheCourses(){
        try {
            final Logger log = LoggerFactory.logger(ManyToManyTest.class);

            // creating objects
            log.info("Creating object of students");
            Student student1 = new Student("Azis", "harahap", "aziz@mail.com");
            Student student2 = new Student("Abil", "kabil", "abnl@mail.com");
            Student student3 = new Student("Jawir", "Icikiwie", "aziz@mail.com");
            Student student4 = new Student("Navia", "saliha", "navia@mail.com");

            session.beginTransaction();

            // associate the object
            log.info("Associate student objects with courses");
            student1.addCourse(session.get(Course.class, 10));
            student1.addCourse(session.get(Course.class, 11));
            student1.addCourse(session.get(Course.class, 12));

            student2.addCourse(session.get(Course.class, 12));
            student2.addCourse(session.get(Course.class, 13));

            student3.addCourse(session.get(Course.class, 13));
            student3.addCourse(session.get(Course.class, 10));
            student3.addCourse(session.get(Course.class, 11));

            student4.addCourse(session.get(Course.class, 11));
            student4.addCourse(session.get(Course.class, 12));

            log.info("Save object student");
            session.save(student1);
            session.save(student2);
            session.save(student3);
            session.save(student4);

            session.getTransaction().commit();
            log.info("Done!");
        }catch (Exception e){
            session.close();
            sessionFactory.close();
            e.printStackTrace();
        }
    }


}
