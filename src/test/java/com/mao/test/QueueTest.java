package com.mao.test;/*
    消息队列测试类
    @author Administrator
 */

import com.mao.ApplicationTopicProvider;
import com.mao.OrderSender;
import com.mao.ProductSender;
import com.mao.UserSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTopicProvider.class)
public class QueueTest {
    @Autowired
    private UserSender usersender;

    @Autowired
    private ProductSender productSender;

    @Autowired
    private OrderSender orderSender;
    /*
    测试消息队列
     */
    @Test
    public void test1(){
        this.productSender.send("ProductSender...");
        this.usersender.send("UserSender...");
        this.orderSender.send("OrderSender...");
    }
}
