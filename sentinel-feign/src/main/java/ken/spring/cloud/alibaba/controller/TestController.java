package ken.spring.cloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import ken.spring.cloud.alibaba.po.User;
import ken.spring.cloud.alibaba.service.EchoService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private EchoService echoService;


    @GetMapping("/user/list")
    public List<User> userList()
    {
        return echoService.userList();
    }



}
