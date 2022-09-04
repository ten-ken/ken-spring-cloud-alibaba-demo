package ken.spring.cloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <ul>
 * <li>Title: NacosConsumerApplication</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author
 * @date 2022/7/24 17:50
 */
@SpringBootApplication
@EnableDiscoveryClient(autoRegister = false)
public class NacosConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerApplication.class,args);
    }
    //Instantiate RestTemplate Instance
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
