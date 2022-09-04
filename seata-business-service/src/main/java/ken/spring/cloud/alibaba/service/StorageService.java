package ken.spring.cloud.alibaba.service;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * <ul>
 * <li>Title: StorageService</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author swc
 * @date 2022-07-11 14:27
 */
@FeignClient(name = "seata-storage-service")
public interface StorageService {

    @GetMapping(path = "/storage/{commodityCode}/{count}")
    String storage(@PathVariable("commodityCode") String commodityCode,
                   @PathVariable("count") int count);

}
