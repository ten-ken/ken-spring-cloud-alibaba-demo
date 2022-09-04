package ken.spring.cloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import ken.spring.cloud.alibaba.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * <ul>
 * <li>Title: TestController</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author
 * @date 2022/7/29 15:48
 */
@RestController
public class TestController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping(value = "/hello")
    @SentinelResource(value = "hello")
    public String hello() {
        return "Hello Sentinel";
    }

    @GetMapping("/user/list")
    public List<User> userList() {
        return restTemplate.getForObject("http://localhost:8081/user/list", List.class);
    }



}
