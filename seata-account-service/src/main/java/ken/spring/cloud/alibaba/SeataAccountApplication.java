package ken.spring.cloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * <ul>
 * <li>Title: NacosProviderApplication</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author swc
 * @date 2022-06-20 20:40
 */
@SpringBootApplication
@EnableDiscoveryClient
//@EnableCircuitBreaker//支持断路器
public class SeataAccountApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeataAccountApplication.class, args);
    }
}
