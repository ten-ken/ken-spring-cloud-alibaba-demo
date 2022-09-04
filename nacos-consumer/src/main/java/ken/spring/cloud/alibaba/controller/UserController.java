package ken.spring.cloud.alibaba.controller;

import ken.spring.cloud.alibaba.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * <ul>
 * <li>Title: UserController</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author
 * @date 2022/7/25 16:36
 */
@RestController
public class UserController {


    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/echo/app-name")
    public String echoAppName(){
        //Access through the combination of LoadBalanceClient and RestTemplate
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
        String path = String.format("http://%s:%s/echo/%s",serviceInstance.getHost(),serviceInstance.getPort(),appName);
        System.out.println("request path:" +path);
        return restTemplate.getForObject(path,String.class);
    }

    @GetMapping("/user/list")
    public List<User> userList(){
        //Access through the combination of LoadBalanceClient and RestTemplate
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
        String path = String.format("http://%s:%s/user/list",serviceInstance.getHost(),serviceInstance.getPort());
        System.out.println("request path:" +path);
        return restTemplate.getForObject(path, List.class);
    }

    @GetMapping("/user/add")
    public boolean userAdd(User user){
        //Access through the combination of LoadBalanceClient and RestTemplate
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
        String url ="http://%s:%s/user/add?userName="+user.getUserName()+"&money=80000";
        String path = String.format(url,serviceInstance.getHost(),serviceInstance.getPort());
        System.out.println("request path:" +path);
        return restTemplate.getForObject(path, Boolean.class);
    }
}
