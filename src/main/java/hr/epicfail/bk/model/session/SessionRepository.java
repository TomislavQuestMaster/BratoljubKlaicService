package hr.epicfail.bk.model.session;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Tomo on 20.7.2014
 */
public interface SessionRepository extends JpaRepository<Session, Long>, QueryDslPredicateExecutor<Session> {
}

