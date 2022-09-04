package ken.spring.cloud.alibaba.po;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * <ul>
 * <li>Title: Order</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author swc
 * @date 2022-07-11 11:23
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Order implements Serializable {
    /**
     * id.
     */
    public Long id;

    /**
     * user id.
     */
    public Long userId;

    /**
     * commodity code.
     */
    public String commodityCode;

    /**
     * count.
     */
    public Integer count;

    /**
     * money.
     */
    public Integer money;
}
