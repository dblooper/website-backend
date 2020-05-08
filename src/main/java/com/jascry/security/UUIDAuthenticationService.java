package com.jascry.security;

import com.jascry.db_model.Author;
import com.jascry.db_model.User;
import com.jascry.exception.AuthorNotFoundException;
import com.jascry.exception.WrongPasswordException;
import com.jascry.repository.AuthorRepository;
import com.jascry.repository.UserRepository;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

@Service
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class UUIDAuthenticationService implements UserAuthenticationService{
    @NonNull
    UserRepository userRepository;
    @NonNull AuthorRepository authorRepository;

    @Override
    public Optional<String> login(final String username, final String password) throws UsernameNotFoundException, WrongPasswordException {
        Author author = authorRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("Author does not exists, Login failed!"));
        if(!author.getPassword().equals(password)) {
            throw new WrongPasswordException("Wrong password");
        }

        final String uuid = UUID.randomUUID().toString();
        final User user = User
                .builder()
                .id(uuid)
                .username(username)
                .password(password)
                .build();

        userRepository.save(user);
        return Optional.of(uuid);
    }

    @Override
    public Optional<User> findByToken(final String token) {
        return userRepository.findById(token);
    }

    @Override
    public void logout(final User user) {
        userRepository.delete(user);
    }
}
