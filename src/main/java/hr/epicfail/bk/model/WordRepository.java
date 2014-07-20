package hr.epicfail.bk.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Tomo.
 */
public interface WordRepository extends JpaRepository<Word, Long>, QueryDslPredicateExecutor<Word> {
}
