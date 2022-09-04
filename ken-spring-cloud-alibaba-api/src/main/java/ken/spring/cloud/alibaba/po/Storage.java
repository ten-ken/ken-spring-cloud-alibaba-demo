package ken.spring.cloud.alibaba.po;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <ul>
 * <li>Title: Storage</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author swc
 * @date 2022-07-11 14:06
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Storage implements Serializable {

    /**
     * id.
     */
    public Long id;

    /**
     * 商品编码
     */
    public String commodityCode;

    /**
     * 商品库存数量
     */
    public Integer count;
}
