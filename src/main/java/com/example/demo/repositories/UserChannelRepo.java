package com.example.demo.repositories;

import com.example.demo.entities.UserChannel;
import com.example.demo.entities.UserChannelKey;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserChannelRepo  extends CrudRepository<UserChannel, UserChannelKey> {
    public Optional<UserChannel> findById(UserChannelKey id);
    public List<UserChannel> findByUserId(int User_id);
}
