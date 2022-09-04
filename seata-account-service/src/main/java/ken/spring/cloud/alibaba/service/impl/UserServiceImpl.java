package ken.spring.cloud.alibaba.service.impl;

import ken.spring.cloud.alibaba.dao.UserDao;
import ken.spring.cloud.alibaba.po.User;
import ken.spring.cloud.alibaba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <ul>
 * <li>Title: DeptServiceImpl</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author swc
 * @date 2022-06-27 16:16
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public boolean deduction(long userNo, int money) {
        return userDao.deduction(userNo,money);
    }
}
