package com.jascry.db_model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.hibernate.annotations.NamedQuery;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;

import static java.util.Objects.requireNonNull;

@NamedQuery(
        name = "User.isUserTokenValid",
        query = "FROM User WHERE login = :PROVIDEDLOGIN and expired = 0"
)

@Entity
@NoArgsConstructor
public class User  {
    private static final long serialVersionUID = 2396654715019746670L;

    @Id
    private String id;

    private String login;

    private LocalDateTime creationDate;

    private Boolean expired = false;

    @JsonCreator
    public User(@JsonProperty("id") final String id, String login) {
        this.id = requireNonNull(id);
        this.login = login;
    }

    public User(String id, String login, Boolean expired) {
        this.id = id;
        this.login = login;
        this.expired = expired;
    }

    @PrePersist
    protected void fillInCreationDate() {
        if(this.creationDate == null) {
            this.creationDate = LocalDateTime.now();
        }
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return login;
    }

    public void setExpired() {
        this.expired = true;
    }

    public Boolean getExpired() {
        return expired;
    }
}
