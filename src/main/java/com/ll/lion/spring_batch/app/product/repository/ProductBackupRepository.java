package com.ll.lion.spring_batch.app.product.repository;

import com.ll.lion.spring_batch.app.product.entity.ProductBackup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductBackupRepository extends JpaRepository<ProductBackup, Long> {
}
