package ken.spring.cloud.alibaba;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <ul>
 * <li>Title: RandomBalance</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author
 * @date 2022/7/25 20:57
 */

@Configuration
public class RandomBalance {

    @Bean
    public IRule myRule(){
        return  new RandomRule();
    }
}
