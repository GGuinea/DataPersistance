package proj.platformy.dane.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "testing")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class TodoElasticResult {
  int id;
  String description;
}
