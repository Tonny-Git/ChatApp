package com.example.demo.repositories;

import com.example.demo.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo  extends CrudRepository<User, Integer> {
    public User findById(int id);

    public User findAllByUsernameAndPassword(String username, String password);
}
