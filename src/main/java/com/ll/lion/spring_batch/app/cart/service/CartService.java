package com.ll.lion.spring_batch.app.cart.service;


import com.ll.lion.spring_batch.app.cart.entity.CartItem;
import com.ll.lion.spring_batch.app.cart.repository.CartItemRepository;
import com.ll.lion.spring_batch.app.member.entity.Member;
import com.ll.lion.spring_batch.product.entity.ProductOption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartItemRepository cartItemRepository;

    public CartItem addItem(Member member, ProductOption productOption, int quantity) {

        CartItem oldCartItem = cartItemRepository.findByMemberIdAndProductOptionId(member.getId(), productOption.getId());

        if(oldCartItem != null) {
            oldCartItem.setQuantity(oldCartItem.getQuantity() + quantity);
            cartItemRepository.save(oldCartItem);

            return oldCartItem;
        }

        CartItem cartItem = CartItem.builder()
                .member(member)
                .productOption(productOption)
                .quantity(quantity)
                .build();

        cartItemRepository.save(cartItem);
        return cartItem;
    }
}
