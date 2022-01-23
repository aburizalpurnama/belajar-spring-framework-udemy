import com.rizal.spring.aop.config.AppConfig;
import com.rizal.spring.aop.dao.AccountDao;
import com.rizal.spring.aop.entity.Account;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class AfterThrowingAdviceTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        AccountDao accountDao = context.getBean("accountDao", AccountDao.class);

        Account account1 = new Account("Rizal", "Platinum");
        Account account2 = new Account("Wafik", "Titanium");
        Account account3 = new Account("Taufik", "Silfer");

        accountDao.addAccount(account1);
        accountDao.addAccount(account2);
        accountDao.addAccount(account3);

        List<Account> accounts = null;

        try {
            boolean tripWire = true;

            accounts = accountDao.findAccounts(tripWire);
        } catch (Exception exc){
            System.out.println("\n\nMain Method ... caught exception : " + exc);
        }

        System.out.println("\n\nMain Method : After throwing advice test");

        System.out.println("Main Method : " + accounts);

        context.close();
    }
}
