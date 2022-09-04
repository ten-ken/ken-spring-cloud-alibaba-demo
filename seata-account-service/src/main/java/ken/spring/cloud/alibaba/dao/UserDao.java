package ken.spring.cloud.alibaba.dao;
import ken.spring.cloud.alibaba.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface UserDao {

    boolean deduction(@Param("userNo") long userNo, @Param("money") int money);

}
