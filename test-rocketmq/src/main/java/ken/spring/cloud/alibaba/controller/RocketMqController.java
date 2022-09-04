package ken.spring.cloud.alibaba.controller;

import ken.spring.cloud.alibaba.service.SendService;
import org.apache.rocketmq.common.message.MessageConst;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <ul>
 * <li>Title: RocketMqController</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author 程序员ken
 * @date 2022/8/27 12:19
 */
@RestController
public class RocketMqController {

    @Autowired
    private SendService sendService;

    @GetMapping("msg")
    public  void  sendMsg(String msg){
        sendService.sendMsg(msg);
    }


    @GetMapping("msg/tags")
    public  void  sendMsgByTags(String msg,String tags){
        sendService.sendMsg(msg,tags);
    }

    @GetMapping("msg/trans")
    public  void  sendMsgByTransational(String msg,String tag){
        sendService.sendTransationalMsg(msg,tag);

    }

}
