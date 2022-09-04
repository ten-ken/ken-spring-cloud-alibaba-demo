package ken.spring.cloud.alibaba.po;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * <ul>
 * <li>Title: User</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author
 * @date 2022/7/25 15:56
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class User {

    //用户编号
    private String userNo;

    private  String userName;

    private String dbSource;

    private BigDecimal money;
}
