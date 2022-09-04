package ken.spring.cloud.alibaba.dao;

import ken.spring.cloud.alibaba.po.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * <ul>
 * <li>Title: OrderDao</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author swc
 * @date 2022-07-11 11:31
 */
@Repository
@Mapper
public interface OrderDao {

    int insert(Order order);
}
