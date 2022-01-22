import com.rizal.spring.aop.config.AppConfig;
import com.rizal.spring.aop.dao.AccountDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeforeAdviceTest {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

        accountDao.addAccount();
        
        accountDao.addAccount();

        context.close();

    }
}
