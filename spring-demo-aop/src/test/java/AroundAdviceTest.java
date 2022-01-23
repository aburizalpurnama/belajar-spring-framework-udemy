import com.rizal.spring.aop.config.AppConfig;
import com.rizal.spring.aop.dao.MemberDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AroundAdviceTest {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        MemberDao memberDao = context.getBean("memberDao", MemberDao.class);

        memberDao.addMember();

    }
}
