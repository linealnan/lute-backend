package com.github.linealnan.lutebackend.userservice.repository;

import com.github.linealnan.lutebackend.userservice.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveMongoRepository<User, String> {
}