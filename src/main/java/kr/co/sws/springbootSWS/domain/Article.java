package kr.co.sws.springbootSWS.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Article {
    // getter
    @Id // 기본키 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AutoIncreased
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false) // NotNull
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "author", nullable = false)
    private String author;

    @Builder // 빌더 패턴으로 객체 생성
    public Article(String author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @CreatedDate // 엔티티가 생성될 때의 시간 저장
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @LastModifiedDate // 엔티티가 수정될 때의 시간 저장
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
