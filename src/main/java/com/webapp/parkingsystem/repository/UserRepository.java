package com.webapp.parkingsystem.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.webapp.parkingsystem.domain.User;

@Repository
public class UserRepository {
    @Autowired
    private MongoTemplate mongoTemplate;

//    @Override
//    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//        Query query = new Query(Criteria.where(User.USER_NAME).is(userName));
//        final Optional<User> optionalUser =  mongoTemplate.findOne(query, User.class);;
//        return optionalUser.map(CustomUserDetails::new).orElseThrow(
//              () -> new UsernameNotFoundException(String.format("User = %s does not exists", userName)));
//    }

    public void save(User details) {
        mongoTemplate.save(details);
    }

    public User getByUsername(String userName) {
        Query query = new Query(Criteria.where(User.USER_NAME).is(userName));
        return mongoTemplate.findOne(query, User.class);
    }
}
