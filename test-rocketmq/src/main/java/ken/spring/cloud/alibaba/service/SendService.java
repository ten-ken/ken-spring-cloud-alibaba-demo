package ken.spring.cloud.alibaba.service;

import com.alibaba.cloud.stream.binder.rocketmq.constant.RocketMQConst;
import ken.spring.cloud.alibaba.MySource;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * <ul>
 * <li>Title: SendService</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author 程序员ken
 * @date 2022/8/27 12:25
 */
@Service
public class SendService {

   /* @Autowired
    private MessageChannel output; // 获取name为output的binding*/

   @Autowired
   private MySource mySource;

    /**
     * output 发送消息
     *
     * @param msg
     */
   public void sendMsg(String msg){
       Map<String, Object> headers = new HashMap<>();
       //headers.put(MessageConst.PROPERTY_TAGS, "tagStr");
       Message message = MessageBuilder.createMessage(msg, new MessageHeaders(headers));
       mySource.output().send(message);
   }


    /**
     * tagOutput 发送tags消息
     *
     * @param msg
     */
    public void sendMsg(String msg,String tags){
        Map<String, Object> headers = new HashMap<>();
        headers.put(MessageConst.PROPERTY_TAGS, tags);
        Message message = MessageBuilder.createMessage(msg, new MessageHeaders(headers));
        mySource.tagOutput().send(message);
    }


    /**
     * tagOutput 发送事务消息
     *
     * @param msg
     * @param tag
     */
    public void sendTransationalMsg(String msg, String tag){
        Map<String, Object> headers = new HashMap<>();
        headers.put(RocketMQConst.USER_TRANSACTIONAL_ARGS, "binder");
        headers.put(MessageConst.PROPERTY_TAGS, tag);
        Message message = MessageBuilder.createMessage(msg, new MessageHeaders(headers));
        mySource.transOutput().send(message);
    }
}
