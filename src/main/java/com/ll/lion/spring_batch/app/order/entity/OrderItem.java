package com.ll.lion.spring_batch.app.order.entity;

import com.ll.lion.spring_batch.app.base.entity.BaseEntity;
import com.ll.lion.spring_batch.app.product.entity.ProductOption;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class OrderItem extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY)
    private ProductOption productOption;

    private int quantity;

    public OrderItem(ProductOption productOption, int quantity) {
        this.productOption = productOption;
        this.quantity = quantity;
    }

}
