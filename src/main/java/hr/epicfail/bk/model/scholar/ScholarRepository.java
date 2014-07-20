package hr.epicfail.bk.model.scholar;

import hr.epicfail.bk.model.Word;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * Created by Tomo on 20.7.2014
 */
public interface ScholarRepository extends JpaRepository<Scholar, Long>, QueryDslPredicateExecutor<Scholar> {
}

