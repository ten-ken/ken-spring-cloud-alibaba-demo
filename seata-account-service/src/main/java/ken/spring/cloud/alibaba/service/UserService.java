package ken.spring.cloud.alibaba.service;


import ken.spring.cloud.alibaba.po.User;

import java.util.List;

/**
 * <ul>
 * <li>Title: UserService</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author swc
 * @date 2022-06-27 16:15
 */
public interface UserService {

    boolean deduction(long userNo, int money);

}
