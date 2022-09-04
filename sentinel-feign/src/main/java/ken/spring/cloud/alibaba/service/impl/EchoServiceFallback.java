package ken.spring.cloud.alibaba.service.impl;

import ken.spring.cloud.alibaba.po.User;
import ken.spring.cloud.alibaba.service.EchoService;

import java.util.List;

/**
 * <ul>
 * <li>Title: EchoServiceFallback</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author
 * @date 2022/8/13 19:33
 */
public class EchoServiceFallback implements EchoService {

    @Override
    public List<User> userList() {
        return null;
    }

}
