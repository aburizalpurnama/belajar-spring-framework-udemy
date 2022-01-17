import com.rizal.spring.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Practive activity #8 - Hibernate Developement
 */
public class PracticeActivity8 {

    SessionFactory sessionFactory;
    Session session;

    @Before
    public void setUp(){
        // create object session factory
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        // create session object
        session = sessionFactory.getCurrentSession();
    }

    @After
    public void tearDown(){
        sessionFactory.close();
    }

    @Test
    public void saveObject(){
        try{
            //create object
            Employee employee = new Employee("kumal", "purnama", "atria");

            //begin transaction and save object
            session.beginTransaction();
            session.save(employee);

            //test and commit transaction
            Assert.assertNotNull(employee.getId());
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void retrieveObject(){
        try {
            String employeeId = "2";

            session.beginTransaction();
            Employee employee = session.get(Employee.class, employeeId);

            System.out.println(employee);
            Assert.assertNotNull(employee);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void queryObjects(){
        try {
            String companyName = "atria";

            session.beginTransaction();
            List<Employee> employees = session.createQuery("from Employee s where s.company='"+companyName+"'").getResultList();
            employees.forEach(System.out::println);
            session.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void deleteObject(){
        try{
            String employeeId = "2";

            session.beginTransaction();
            session.createQuery("delete from Employee where id=" + employeeId).executeUpdate();

            Assert.assertNull(session.get(Employee.class, employeeId));
            session.getTransaction().commit();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
