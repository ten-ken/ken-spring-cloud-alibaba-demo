package ken.spring.cloud.alibaba.service.impl;
import ken.spring.cloud.alibaba.dao.StorageDao;
import ken.spring.cloud.alibaba.po.Storage;
import ken.spring.cloud.alibaba.service.StorageService;
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
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageDao storageDao;


    @Override
    public boolean storage(Storage storage) {
        return storageDao.storage(storage);
    }
}
