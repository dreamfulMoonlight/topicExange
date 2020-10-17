package com.mao;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserSender {

    @Autowired
    private AmqpTemplate rabbitAmqpTemplate;

    //exchange 交换器名称
    @Value("${mq.config.exchange}")
    private String exchange;

    /*


    //routingkey 路由量
    @Value("${mq.config.queue.error.routing.key}")
    private String routingkey;

    */

    /*发送消息的方法*/
    public void send(String msg)
    {
        //向消息队列发送消息
        //参数一 交换器名称
        //参数二 路由器
        //参数三 消息
        this.rabbitAmqpTemplate.convertAndSend(this.exchange,"user.log.debug","user.log.debug.."+msg);
        this.rabbitAmqpTemplate.convertAndSend(this.exchange,"user.log.info","user.log.info.."+msg);
        this.rabbitAmqpTemplate.convertAndSend(this.exchange,"user.log.warn","user.log.warn.."+msg);
        this.rabbitAmqpTemplate.convertAndSend(this.exchange,"user.log.error","user.log.error.."+msg);

    }
}
