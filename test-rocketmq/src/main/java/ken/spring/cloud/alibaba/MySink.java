package ken.spring.cloud.alibaba;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.SubscribableChannel;

/**
 * <ul>
 * <li>Title: MySink</li>
 * </ul>
 *
 * @author 程序员ken
 * @date 2022/8/27 12:30
 */
public interface MySink {

    @Input(Sink.INPUT)
    SubscribableChannel input();

    @Input("tagInput")
    SubscribableChannel tagInput();

    @Input("transInput")
    SubscribableChannel transInput();
}
