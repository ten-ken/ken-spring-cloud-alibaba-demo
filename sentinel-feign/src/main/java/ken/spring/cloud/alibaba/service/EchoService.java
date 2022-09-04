package ken.spring.cloud.alibaba.service;

import ken.spring.cloud.alibaba.config.FeignConfiguration;
import ken.spring.cloud.alibaba.service.impl.EchoServiceFallback;
import ken.spring.cloud.alibaba.po.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * <ul>
 * <li>Title: EchoService</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author
 * @date 2022/8/13 19:31
 */
@FeignClient(name = "nacos-provider", fallback = EchoServiceFallback.class, configuration = FeignConfiguration.class)
public interface EchoService {

    @GetMapping("/user/list")
    public List<User> userList();
}
