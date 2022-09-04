package ken.spring.cloud.alibaba.service;

import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

/**
 * <ul>
 * <li>Title: MyTransactionListener</li>
 * <li>Description: TODO </li>
 * </ul>
 *
 * @author 程序员ken
 * @date 2022/8/27 14:10
 */
@Component("myTransListener")
public class MyTransactionListener implements TransactionListener {


    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object o) {
        System.out.println("---");
        //if(message.getBody())
        String tags = message.getTags();
        if("001".equals(tags)){
            return LocalTransactionState.UNKNOW;
        }
        else if("002".equals(tags)){
            return LocalTransactionState.ROLLBACK_MESSAGE;
        }
        return LocalTransactionState.COMMIT_MESSAGE;
    }

    //如果事务是未知的 最终还会进入check方法里面 如果是其他状态 并不需要check
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        String tags = messageExt.getTags();
        if("001".equals(tags)){
            return LocalTransactionState.UNKNOW;
        }
        else if("002".equals(tags)){
            return LocalTransactionState.ROLLBACK_MESSAGE;
        }
        return LocalTransactionState.COMMIT_MESSAGE;
        //null;
    }
}
