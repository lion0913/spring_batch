package com.ll.lion.spring_batch.app.cash.repository;

import com.ll.lion.spring_batch.app.cash.CashLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CashLogRepository extends JpaRepository<CashLog, Long> {
}
