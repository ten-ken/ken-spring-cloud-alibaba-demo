package ken.spring.cloud.alibaba.dao;

import ken.spring.cloud.alibaba.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <ul>
 * <li>Title: UserDao</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author
 * @date 2022/7/25 16:15
 */
@Repository
@Mapper
public interface UserDao {

    //增加用户
    boolean addUser(User user);

    User getUserById(Long userNo);

    List<User> findAll();

}
