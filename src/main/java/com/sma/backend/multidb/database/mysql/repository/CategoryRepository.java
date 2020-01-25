package com.sma.backend.multidb.database.mysql.repository;

import com.sma.backend.multidb.database.mysql.domain.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {


}