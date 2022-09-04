package ken.spring.cloud.alibaba.service;

import ken.spring.cloud.alibaba.po.User;

import java.util.List;

/**
 * <ul>
 * <li>Title: UserService</li>
 * </ul>
 *
 * @author swc
 * @date 2022/7/25 16:14
 */
public interface UserService {

    boolean addUser(User user);


    User findUserById(Long userNo);

    List<User> findAll();
}
