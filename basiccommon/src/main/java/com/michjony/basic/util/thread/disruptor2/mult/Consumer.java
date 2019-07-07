package com.michjony.basic.util.thread.disruptor2.mult;

import com.lmax.disruptor.WorkHandler;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * user:Cherie
 * datetime;2019/7/7 22:25
 */
@Data
public class Consumer implements WorkHandler<Order> {
    private String consumerId;

    private static AtomicInteger count = new AtomicInteger(0);

    public Consumer(String consumerId){
        this.consumerId = consumerId;
    }

    @Override
    public void onEvent(Order order) throws Exception {
        System.out.println("当前消费者: " + this.consumerId + "，消费信息：" + order.getId());
        count.incrementAndGet();
    }

    public int getCount(){
        return count.get();
    }
}
