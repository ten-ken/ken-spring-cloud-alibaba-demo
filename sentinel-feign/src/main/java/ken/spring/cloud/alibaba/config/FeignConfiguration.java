package ken.spring.cloud.alibaba.config;

import ken.spring.cloud.alibaba.service.impl.EchoServiceFallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * <ul>
 * <li>Title: FeignConfiguration</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author
 * @date 2022/8/13 19:32
 */
@Configuration
public class FeignConfiguration {
    @Bean
    public EchoServiceFallback echoServiceFallback() {
        return new EchoServiceFallback();
    }
}
