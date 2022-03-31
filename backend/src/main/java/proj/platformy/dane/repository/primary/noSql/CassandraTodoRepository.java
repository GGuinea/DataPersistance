package proj.platformy.dane.repository.primary.noSql;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;
import proj.platformy.dane.entity.noSql.TodoNoSql;

@Repository
public interface CassandraTodoRepository extends CassandraRepository<TodoNoSql, Long> {

}
