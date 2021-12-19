package com.webapp.parkingsystem.service;

import java.util.Random;

import org.apache.commons.codec.digest.Sha2Crypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.webapp.parkingsystem.domain.User;
import com.webapp.parkingsystem.repository.UserRepository;

public class UserService {
    private static final String SHA512_PREFIX = "$6$";
    @Autowired
    private UserRepository userRepository;

    public void signUp(User userDetails) {
        User details = new User();
        details.setUserName(userDetails.getUserName());
        details.setSalt(generateRandomSalt());
        details.setPassword(crypt(userDetails.getPassword(), details.getSalt()));
        userRepository.save(details);
    }

    public void login(User userDetails) {
        User user = userRepository.getByUsername(userDetails.getUserName());
        if (!isPasswordValid(user, userDetails.getPassword())) {
            throw new RuntimeException("Username or password is invalid");
        }
    }

    private static String generateRandomSalt() {
        StringBuilder saltString = new StringBuilder();
        saltString.append(SHA512_PREFIX);

        for (int i = 1; i <= 8; ++i) {
            saltString.append("./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".charAt(
                  (new Random()).nextInt("./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".length())));
        }

        return saltString.toString();
    }

    public boolean isPasswordValid(User user, String password) {
        String encrypted = crypt(password, user.getSalt());
        return user.getPassword().equals(encrypted);
    }

    public static String crypt(String password, String salt) {
        if (StringUtils.isEmpty(password)) {
            throw new IllegalArgumentException("password to encrypt cannot be empty or null");
        } else {
            return Sha2Crypt.sha512Crypt(password.getBytes(), salt);
        }
    }
}
