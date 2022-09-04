package ken.spring.cloud.alibaba.controller;
import io.seata.core.context.RootContext;
import ken.spring.cloud.alibaba.constants.SysConstant;
import ken.spring.cloud.alibaba.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * <ul>
 * <li>Title: DeptController</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author swc
 * @date 2022-06-27 16:11
 */
@RestController
public class AccountController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

    @Autowired
    private UserService userService;

    //用户扣费
    @GetMapping(value = "/account/deduction", produces = "application/json")
    public String deduction(long userNo, int money) {
        LOGGER.info("用户服务... xid: " + RootContext.getXID());
       /* Random random =new Random();
        if (random.nextBoolean()) {
            throw new RuntimeException("用户服务出现异常");
        }*/
        boolean result = userService.deduction(userNo,money);
        return result?SysConstant.SUCCESS :SysConstant.FAIL;
    }

}
