package ken.spring.cloud.alibaba;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

/**
 * <ul>
 * <li>Title: MySource</li>
 * </ul>
 *
 * @author 程序员ken
 * @date 2022/8/27 12:30
 */
public interface MySource {

    @Output(Source.OUTPUT)
    MessageChannel output();

    @Output("tagOutput")
    MessageChannel tagOutput();

    @Output("transOutput")
    MessageChannel transOutput();
}
