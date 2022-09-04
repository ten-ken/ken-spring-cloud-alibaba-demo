package ken.spring.cloud.alibaba.service.impl;


import ken.spring.cloud.alibaba.dao.OrderDao;
import ken.spring.cloud.alibaba.po.Order;
import ken.spring.cloud.alibaba.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <ul>
 * <li>Title: OrderServiceImpl</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author swc
 * @date 2022-07-11 11:29
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Override
    public int order(Order order) {
        return orderDao.insert(order);
    }
}
