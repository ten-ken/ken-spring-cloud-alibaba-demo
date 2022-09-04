package ken.spring.cloud.alibaba.service;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

/**
 * <ul>
 * <li>Title: ReceiveService</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author 程序员ken
 * @date 2022/8/27 12:21
 */
@Service
public class ReceiveService {

    @StreamListener("input")
    public void receiveInput(String receiveMsg) {
        System.out.println("input 接收: " + receiveMsg);
    }

    @StreamListener("tagInput")
    public void receivetagInput(String receiveMsg) {
        System.out.println("tagInput 接收: " + receiveMsg);
    }

    @StreamListener("transInput")
    public void transInput(String receiveMsg) {
        System.out.println("transInput 事务消息接收: " + receiveMsg);
    }


}
