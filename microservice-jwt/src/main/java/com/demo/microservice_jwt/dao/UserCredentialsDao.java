package com.demo.microservice_jwt.dao;

import com.demo.microservice_jwt.dao.entity.UserCredentialsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserCredentialsDao extends JpaRepository<UserCredentialsEntity, Integer> {
    public Optional<UserCredentialsEntity> findByName(String name);
}

