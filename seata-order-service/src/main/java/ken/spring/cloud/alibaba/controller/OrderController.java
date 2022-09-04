package ken.spring.cloud.alibaba.controller;

import io.seata.core.context.RootContext;
import ken.spring.cloud.alibaba.constants.SysConstant;
import ken.spring.cloud.alibaba.po.Order;
import ken.spring.cloud.alibaba.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

/**
 * <ul>
 * <li>Title: OrderController</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author swc
 * @date 2022-07-11 11:21
 */
@RestController
public class OrderController {

    @Autowired
    private  RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderService orderService;

    //生成订单
    @GetMapping(value = "/order", produces = "application/json")
    public String order(Long userNo, String commodityCode, int orderCount) {
        LOGGER.info("订单服务 xid " + RootContext.getXID());
        int price =10;//单价10元/份
        final Order order = new Order();
        order.userId = userNo;
        order.commodityCode = commodityCode;
        order.count = orderCount;
        order.money = orderCount*price;

        //调用用户服务(扣费)-start
        String url = "http://127.0.0.1:8982/account/deduction?userNo="+SysConstant.USER_NO+"&money="+order.money;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        //调用用户服务(扣费)-end

        int primaryKey = orderService.order(order);

       /* Random random =new Random();
        if (random.nextBoolean()) {
            throw new RuntimeException("订单服务发生异常");
        }*/

        //LOGGER.info("Order Service End ... Created " + order);
        if (primaryKey>0) {
            return SysConstant.SUCCESS;
        }
        return SysConstant.FAIL;
    }
}
