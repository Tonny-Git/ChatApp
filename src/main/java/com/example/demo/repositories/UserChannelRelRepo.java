package com.example.demo.repositories;

import com.example.demo.entities.UserChannelRel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserChannelRelRepo extends CrudRepository<UserChannelRel, Integer> {
    public List<UserChannelRel> findByUserId(int userId);
    public void deleteByUserIdAndChannelId(@Param("userId") int userId, @Param("channelId") int channelId);
}
