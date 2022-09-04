package ken.spring.cloud.alibaba.controller;

import io.seata.core.context.RootContext;
import ken.spring.cloud.alibaba.constants.SysConstant;
import ken.spring.cloud.alibaba.po.Storage;
import ken.spring.cloud.alibaba.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
public class StorageController {

    @Autowired
    private  RestTemplate restTemplate;

    private static final Logger LOGGER = LoggerFactory.getLogger(StorageController.class);

    @Autowired
    private StorageService storageService;

    //扣除库存
    @GetMapping(value = "/storage/{commodityCode}/{count}", produces = "application/json")
    public String echo(@PathVariable String commodityCode, @PathVariable int count) {
        LOGGER.info("仓储服务 xid: " + RootContext.getXID());
        Storage storage =new Storage();
        storage.commodityCode =commodityCode;
        storage.count =count;
        boolean result = storageService.storage(storage);

        LOGGER.info("仓储服务 结束 ... ");

        return result?SysConstant.SUCCESS:SysConstant.FAIL;
    }

}
