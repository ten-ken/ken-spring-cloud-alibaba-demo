package ken.spring.cloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * <ul>
 * <li>Title: SentinelFeignApplication</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author
 * @date 2022/8/13 19:30
 */
@SpringBootApplication
@EnableFeignClients
public class SentinelFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinelFeignApplication.class,args);
    }
}
