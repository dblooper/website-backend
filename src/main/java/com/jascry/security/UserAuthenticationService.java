package com.jascry.security;

import com.jascry.db_model.Author;
import com.jascry.db_model.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface UserAuthenticationService {

    /**
     * Logs in with the given {@code username} and {@code password}.
     *
     * @param username
     * @param password
     * @return an {@link Optional} of a user when login succeeds
     */
    Optional<String> login(String username, String password) throws UsernameNotFoundException;

    /**
     * Finds a user by its dao-key.
     *
     * @param token user dao key
     * @return
     */
    Optional<Author> findByToken(String token);

    /**
     * Logs out the given input {@code user}.
     *
     * @param user the user to logout
     */
    void logout(Author user);
}
