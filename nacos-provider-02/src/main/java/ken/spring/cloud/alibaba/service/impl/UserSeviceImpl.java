package ken.spring.cloud.alibaba.service.impl;

import ken.spring.cloud.alibaba.dao.UserDao;
import ken.spring.cloud.alibaba.po.User;
import ken.spring.cloud.alibaba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <ul>
 * <li>Title: UserSeviceImpl</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author
 * @date 2022/7/25 16:14
 */
@Service
public class UserSeviceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User findUserById(Long userNo) {
        return userDao.getUserById(userNo);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
