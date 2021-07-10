package todo.repository;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import todo.domain.Todo;

@Repository
public interface TodoRepository extends PagingAndSortingRepository<Todo, Long>, JpaSpecificationExecutor<Todo> {

}
