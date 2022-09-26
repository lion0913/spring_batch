package com.ll.lion.spring_batch.app.order.service;

import com.ll.lion.spring_batch.app.cart.entity.CartItem;
import com.ll.lion.spring_batch.app.cart.service.CartService;
import com.ll.lion.spring_batch.app.member.entity.Member;
import com.ll.lion.spring_batch.app.order.entity.Order;
import com.ll.lion.spring_batch.app.order.entity.OrderItem;
import com.ll.lion.spring_batch.app.order.repository.OrderRepository;
import com.ll.lion.spring_batch.app.product.entity.ProductOption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final CartService cartService;

    private final OrderRepository orderRepository;

    @Transactional
    public Order createFromCart(Member member) {
        List<CartItem> cartItemList = cartService.listByMember(member);
        List<OrderItem> orderItems = new ArrayList<>();

        for(CartItem cartItem : cartItemList) {
            ProductOption productOption = cartItem.getProductOption();

            if(productOption.isOrderable(cartItem.getQuantity())) {
                orderItems.add(new OrderItem(productOption, cartItem.getQuantity()));
            }
            cartService.deleteItem(cartItem);
        }
        return create(member, orderItems);
    }

    @Transactional
    public Order create(Member member, List<OrderItem> orderItems) {
        Order order = Order
                .builder()
                .member(member)
                .build();

        for(OrderItem orderItem : orderItems) {
            order.addOrderItem(orderItem);
        }

        orderRepository.save(order);

        return order;
    }
}
