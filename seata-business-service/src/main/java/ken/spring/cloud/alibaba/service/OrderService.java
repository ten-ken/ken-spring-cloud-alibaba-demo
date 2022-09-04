package ken.spring.cloud.alibaba.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * <ul>
 * <li>Title: OrderService</li>
 * </ul>
 *
 * @author swc
 * @date 2022-07-11 14:29
 */
@FeignClient(name = "seata-order-service")
public interface OrderService {

    @GetMapping(value = "/order", produces = "application/json")
    String order(@RequestParam("userNo") Long userNo,
                 @RequestParam("commodityCode") String commodityCode,
                 @RequestParam("orderCount") int orderCount);
}
