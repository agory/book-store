package com.example.bookstore.repositories;

import com.example.bookstore.entities.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {

    User findByUsername(String username);

    User findById(Long id);

    User save(User user);
}
