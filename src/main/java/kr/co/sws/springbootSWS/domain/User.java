package kr.co.sws.springbootSWS.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User implements UserDetails { // UserDetails를 상속받아 인증 객체로 사용함
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "nickname", unique = true)
    private String nickname;

    @Builder
    public User(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }

    @Override // 권한 반환
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority("user"));
    }

    @Override // 사용자 id 반환
    public String getUsername() {
        return email;
    }

    @Override // 사용자 password 반환
    public String getPassword() {
        return password;
    }

    @Override // 계정 만료여부 반환
    public boolean isAccountNonExpired() {
        return true; // true = 만료되지 않음
    }

    @Override // 계정 잠김여부 반환
    public boolean isAccountNonLocked() {
        return true; // true = 잠기지 않음
    }

    @Override // password 만료여부 반환
    public boolean isCredentialsNonExpired() {
        return true; // true = 만료되지 않음
    }

    @Override // 계정 사용가능여부 반환
    public boolean isEnabled() {
        return true; // true = 사용 가능
    }

    // 사용자 이름 변경
    public User update(String nickname) {
        this.nickname = nickname;
        return this;
    }

}