package com.chenqian.task;

import com.chenqian.service.IOrderService;
import com.chenqian.util.PropertiesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: 陈谦
 * @Date: 2018/5/27 17:01
 * <p>
 * 定时任务关闭订单
 */

@Component
@Slf4j
public class CloseOrderTask {
    @Autowired
    private IOrderService iOrderService;

    /**
     * 每一分钟执行一次, 关闭从当前时间开始之前两个小时下单但并为付款的订单
     */
    //    @Scheduled(cron="0 */1 * * * ?")//每1分钟(每个1分钟的整数倍)
    public void closeOrderTaskV1(){
        log.info("关闭订单定时任务启动");
        int hour = Integer.parseInt(PropertiesUtil.getProperty("close.order.task.time.hour","2"));
        //iOrderService.closeOrder(hour);
        log.info("关闭订单定时任务结束");
    }


}
