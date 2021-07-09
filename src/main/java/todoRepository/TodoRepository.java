package todoRepository;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import domain.Todo;

@Repository
public interface TodoRepository extends PagingAndSortingRepository<Todo, Long>, JpaSpecificationExecutor<Todo> {

}