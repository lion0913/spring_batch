package com.ll.lion.spring_batch.app.cash.service;

import com.ll.lion.spring_batch.app.cash.CashLog;
import com.ll.lion.spring_batch.app.cash.repository.CashLogRepository;
import com.ll.lion.spring_batch.app.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CashService {

    private final CashLogRepository cashLogRepository;
    public CashLog addCash(Member member, long amount, String eventType) {
        CashLog cashLog = CashLog.builder()
                .member(member)
                .price(amount)
                .eventType(eventType)
                .build();
        cashLogRepository.save(cashLog);

        return cashLog;
    }
}
