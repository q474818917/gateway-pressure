package com.qiekang.service;

import com.qiekang.facade.OrderService;
import com.qiekang.mapper.OrderMapper;
import com.qiekang.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void testTransaction() {
        Order order = new Order();
        order.setId(1);
        order.setTotalAmount(new BigDecimal(100.00));
        orderMapper.updateById(order);

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        order.setTotalAmount(new BigDecimal(1000.00));
        orderMapper.updateById(order);
    }

    @Override
    public boolean createOrder() {
        return false;
    }

    @Override
    public boolean calcelOrder() {
        return false;
    }
}
