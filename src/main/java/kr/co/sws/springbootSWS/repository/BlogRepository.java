package kr.co.sws.springbootSWS.repository;

import kr.co.sws.springbootSWS.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Article, Long> {
}
