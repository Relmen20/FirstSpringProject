package com.study.oksk.repository;

import com.study.oksk.entity.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository extends JpaRepository <SessionEntity, Integer> {
}
