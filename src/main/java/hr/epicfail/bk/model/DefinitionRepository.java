package hr.epicfail.bk.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

/**
 * @author tdubravcevic
 */
public interface DefinitionRepository extends JpaRepository<Definition, Long>, QueryDslPredicateExecutor<Definition> {
}