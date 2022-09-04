package ken.spring.cloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * <ul>
 * <li>Title: NacosConfigApplication</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author
 * @date 2022/7/28 18:22
 */
@SpringBootApplication
public class NacosConfigApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =
                SpringApplication.run(NacosConfigApplication.class, args);
        while(true) {
            //When configurations are refreshed dynamically, they will be updated in the Enviroment, therefore here we retrieve configurations from Environment every other second.
            String userName = applicationContext.getEnvironment().getProperty("user.name");
            String userAge = applicationContext.getEnvironment().getProperty("user.age");
            String currentEnv = applicationContext.getEnvironment().getProperty("current.env");
            System.err.println("user name :" + userName + "; age: " + userAge);
            System.err.println("currentEnv :" + currentEnv);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
