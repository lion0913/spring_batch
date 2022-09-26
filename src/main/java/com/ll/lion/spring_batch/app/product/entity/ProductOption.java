package com.ll.lion.spring_batch.app.product.entity;

import com.ll.lion.spring_batch.app.base.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@Setter
@Getter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class ProductOption extends BaseEntity {
    private String color;

    private String displayColor; //고객에게 노출되는 색상
    private String size;

    private String displaySize; //고객에게 노출되는 사이즈

    private Integer price;

    private Integer wholeSalePrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    private Product product;
    private boolean isSoldOut; //품절여부

    private int stock; //쇼핑몰에서 보유한 상품 개수


    public ProductOption(String color, String size) {
        this.color = color;
        this.displayColor = color;
        this.size = size;
        this.displaySize = size;
    }

    public boolean isOrderable(int quantity) {
        if(isSoldOut == false) return true;
        return getStock() >= quantity;
    }
}
