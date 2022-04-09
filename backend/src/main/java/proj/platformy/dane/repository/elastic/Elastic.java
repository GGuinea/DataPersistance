package proj.platformy.dane.repository.elastic;

import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import proj.platformy.dane.entity.sql.Todo;

public interface Elastic extends ElasticsearchRepository<Todo, Long> {

}
