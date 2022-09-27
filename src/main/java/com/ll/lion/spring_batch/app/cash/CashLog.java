package com.ll.lion.spring_batch.app.cash;


import com.ll.lion.spring_batch.app.base.entity.BaseEntity;
import com.ll.lion.spring_batch.app.member.entity.Member;
import lombok.*;
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
public class CashLog extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    private long price;

    private String eventType;
}
