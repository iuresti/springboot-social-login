package com.learning.login.controller;

import java.security.Principal;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/user")
    public Principal user(OAuth2Authentication principal) {

        Map<String, String> userInfo = (Map<String, String>) principal.getUserAuthentication().getDetails();

        logger.info("User info requested: {}", userInfo);

        return principal;
    }
}
