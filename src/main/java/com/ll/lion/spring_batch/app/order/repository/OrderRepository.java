package com.ll.lion.spring_batch.app.order.repository;

import com.ll.lion.spring_batch.app.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
