package me.junghaein.rollingpaperproject.user.entity;

import jakarta.persistence.*;
import lombok.*;
import me.junghaein.rollingpaperproject.Letter.entity.Letter;
import me.junghaein.rollingpaperproject.RollingPaper.entity.RollingPaper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

//@Builder
//@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
//@Setter
@Table(name = "UserTable")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name = "user_id", nullable = false)  //, unique = true
    private String userId;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email")  //, unique = true
    private String email;

//    @OneToMany(mappedBy = "rollingPaper", orphanRemoval = true)
//    private List<RollingPaper> myRollingPapers;
//
//    @OneToMany(mappedBy = "message", orphanRemoval = true)
//    private List<Letter> sentMessages;

    @Builder
    public User(String nickname, String userId, String password, String email, String auth){
        this.nickname = nickname;
        this.userId = userId;
        this.password = password;
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override
    public String getUsername(){
        return userId;
    }

    @Override
    public String getPassword(){
        return password;
    }

    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    @Override
    public boolean isEnabled(){
        return true;
    }
}
