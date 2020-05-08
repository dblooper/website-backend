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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    @NonNull
    AuthorRepository authorRepository;
    @NonNull
    PasswordEncoder passwordEncoder;

    @Override
    public Optional<String> login(final String username, final String password) throws UsernameNotFoundException, WrongPasswordException {
        Author author = authorRepository.findById(username).orElseThrow(() -> new UsernameNotFoundException("Author does not exists, Login failed!"));
        if(!passwordEncoder.matches(password, author.getPassword())) {
            throw new WrongPasswordException("Wrong password");
        }

        String uuid = UUID.randomUUID().toString();

        if(author.isAdmin()) {
            uuid = getSpecialUUID(uuid, "leinaD");
        } else {
            uuid = getSpecialUUID(uuid, "UsrOrd");
        }

        final User user = new User(uuid, author.getLogin());
        userRepository.save(user);
        author.setToken(uuid);
        authorRepository.save(author);
        return Optional.of(uuid);
    }

    @Override
    public Optional<Author> findByToken(final String token) {
        User user = userRepository.findById(token).orElseThrow(() -> new UsernameNotFoundException("Cannot find user with authentication token =" + token));
        return authorRepository.findById(user.getAuthor());
    }

    @Override
    public void logout(final Author author) {
        User user = userRepository.findById(author.getToken()).orElseThrow(() -> new UsernameNotFoundException("Cannot find user with authentication token =" + author.getToken()));
        author.setToken("");
        authorRepository.save(author);
        user.setExpired();
        userRepository.save(user);
    }

    private String getSpecialUUID(String uuid, String implementedString) {
        if(implementedString.length() > 6) {
            implementedString = implementedString.substring(0,6);
        }
        StringBuilder stringBuilder = new StringBuilder(uuid);
        char[] implString = implementedString.toCharArray();
        byte j = 0;
        for(int i = 0; i < uuid.length(); i += 6) {
            stringBuilder.replace(i,i+1,"" + implementedString.charAt(j));
            j++;
        }
        return stringBuilder.toString();
    }
}
