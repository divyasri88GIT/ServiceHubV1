package com.servicehub.authservice.service;

import com.servicehub.authservice.entity.User;
import com.servicehub.authservice.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User sync(Jwt jwt) {

        String auth0Id = jwt.getSubject();

        return userRepository
                .findByAuth0Id(auth0Id)
                .orElseGet(() -> createUser(jwt));
    }

    private User createUser(Jwt jwt) {

        User user = new User();

        user.setAuth0Id(jwt.getSubject());

        user.setEmail(
                jwt.getClaimAsString("email")
        );

        user.setActive(true);

        user.setEmailVerified(
                Boolean.TRUE.equals(
                        jwt.getClaim("email_verified")
                )
        );

        return userRepository.save(user);
    }
}
