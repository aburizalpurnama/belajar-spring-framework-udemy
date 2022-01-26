import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.rizal.json.demo.entity.Course;
import com.rizal.json.demo.entity.Instructor;
import com.rizal.json.demo.entity.Student;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JsonDataBindingTest {

    private ObjectMapper objectMapper;

    @Before
    public void setUp() throws Exception {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void testWriteValue() throws IOException {

        String[] friends = {"Edi", "Sudar", "Jaka"};
        Instructor instructor = new Instructor("1", "Bambang", "Utomo");
        List<Course> courses = List.of(
                new Course("1", "Java Spring"),
                new Course("2", "Expert Data Science"),
                new Course("3", "Mastering Hibernate")
        );
        Student student = new Student("1", "Rizal", "Ganteng", true, friends, instructor, courses);

        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.writeValue(new File("data/output.json"), student);
    }

    @Test
    public void testReadValue() throws IOException {
        final Student student = objectMapper.readValue(new File("data/output.json"), Student.class);

        System.out.println(student);
    }
}
