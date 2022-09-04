package ken.spring.cloud.alibaba.controller;
import io.seata.spring.annotation.GlobalTransactional;
import ken.spring.cloud.alibaba.constants.SysConstant;
import ken.spring.cloud.alibaba.service.OrderService;
import ken.spring.cloud.alibaba.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <ul>
 * <li>Title: BusinessController</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author swc
 * @date 2022-07-11 14:27
 */
@RestController
public class BusinessController {

    @Autowired
    private StorageService storageService;

    @Autowired
    private OrderService orderService;

    @GlobalTransactional(timeoutMills = 300000, name = "spring-cloud-seata-demo")
    @GetMapping(value = "/seata/order", produces = "application/json")
    public String feign() {

        String result = storageService.storage(SysConstant.COMMODITY_CODE, 20);

        if (!SysConstant.SUCCESS.equals(result)) {
            throw new RuntimeException();
        }

        result = orderService.order(SysConstant.USER_NO, SysConstant.COMMODITY_CODE, 20);

        if (!SysConstant.SUCCESS.equals(result)) {
            throw new RuntimeException();
        }
        return SysConstant.SUCCESS;
    }

}
