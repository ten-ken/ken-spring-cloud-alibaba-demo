package ken.spring.cloud.alibaba.service;

import ken.spring.cloud.alibaba.po.Order;

/**
 * <ul>
 * <li>Title: OrderService</li>
 * </ul>
 *
 * @author swc
 * @date 2022-07-11 11:29
 */
public interface OrderService {

    int order(Order order);
}
