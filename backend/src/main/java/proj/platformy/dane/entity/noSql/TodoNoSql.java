package proj.platformy.dane.entity.noSql;

import java.util.UUID;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@NoArgsConstructor
@Data
@Table("TodoNoSql")
@Builder
@AllArgsConstructor
public class TodoNoSql {

  @PrimaryKey
  private UUID id;
  private String name;
  private String description;
  private String status;
}
