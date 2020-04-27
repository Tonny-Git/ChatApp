package com.example.demo.services;

import com.example.demo.entities.Channel;
import com.example.demo.entities.UserChannelRel;
import com.example.demo.repositories.ChannelRepo;
import com.example.demo.repositories.UserChannelRelRepo;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelService {

    @Autowired
    private UserChannelRelRepo userChannelRelRepo;

    @Autowired
    private ChannelRepo channelRepo;

    @Autowired
    private SocketService socketService;

    public List<Channel> findAllChannels() {
        List<Channel> channels = (List<Channel>) channelRepo.findAll();

        /*
        users.forEach(user -> {
            List<Channel> channels = channelRepo.findAllByUser(user.getId());
            user.setChannels(channels);
        });
        */

        return channels;
    }

    public Channel findOneChannel(int id) {
        Channel channel = channelRepo.findById(id);
        if (channel == null) return null;


        return channel;
    }

    public Channel createNewChannel(Channel newChannel) {
        Channel dbChannel = null;
        try {
            dbChannel = channelRepo.save(newChannel);

           dbChannel.action = "new-channel";


            UserChannelRel newRelation = new UserChannelRel();
            newRelation.setUserId(newChannel.getAdmin_id());
            newRelation.setChannelId(newChannel.getId());
            userChannelRelRepo.save(newRelation);

            socketService.sendToAll(dbChannel, Channel.class);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return dbChannel;
    }

    @Autowired
    private EntityManager entityManager;

    private Session getSession() {
        return entityManager.unwrap(Session.class);
    }

    public List<Channel> getUserOtherChannel (int user_id){

        List<Channel> otherChannels = new ArrayList<>();

        SQLQuery query = this.getSession()
                .createSQLQuery("select id, title, admin_id from channels where not exists (Select 'm' from user_channel_rel where user_channel_rel.channel_id = channels.id and user_channel_rel.user_id = ?)")
                .setParameter(1, user_id);

        List<Object[]> rows = query.list();

        for(Object[] row : rows){
            Channel newChannel = new Channel();
            newChannel.setId(Integer.parseInt(row[0].toString()));
            newChannel.setTitle(row[1].toString());
            newChannel.setAdmin_id(Integer.parseInt(row[2].toString()));

            otherChannels.add(newChannel);
        }

        return otherChannels;
    }

}

