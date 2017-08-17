package ru.mail.mina.service.modelDTO;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.mail.mina.repository.model.Role;
import ru.mail.mina.repository.model.User;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by Администратор on 17.08.2017.
 */
public class AppUserPrincipal implements UserDetails {

    private User user;
    private Collection<SimpleGrantedAuthority> grantedAuthorities;

    public AppUserPrincipal(User user) {
        this.user = user;
        grantedAuthorities = Collections.singletonList(
                new SimpleGrantedAuthority(user.getRole().name())
        );
    }

    public Integer getUserId() {
        return user.getId();
    }

    public Role getRole() {
        return user.getRole();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getLogin();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
