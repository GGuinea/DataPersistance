package proj.platformy.dane.configuration;

import com.datastax.oss.driver.api.core.CqlSession;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.SessionFactory;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.CassandraEntityClassScanner;
import org.springframework.data.cassandra.config.CassandraSessionFactoryBean;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.SessionFactoryFactoryBean;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.convert.CassandraConverter;
import org.springframework.data.cassandra.core.convert.MappingCassandraConverter;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DataCenterReplication;
import org.springframework.data.cassandra.core.mapping.CassandraMappingContext;
import org.springframework.data.cassandra.core.mapping.SimpleUserTypeResolver;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@Configuration
@EnableReactiveCassandraRepositories(
)
@ConfigurationProperties("spring.data.cassandra")
public class CassandraDataSourceConfiguration extends AbstractCassandraConfiguration {
  @Value("${spring.data.cassandra.contactpoints}")
  private String contactPoints;

  @Value("${spring.data.cassandra.port}")
  private int port;

  @Value("${spring.data.cassandra.keyspace-name}")
  private String keySpace;

  @Value("${spring.data.cassandra.basePackages}")
  private String basePackages;

  @Override
  protected String getKeyspaceName() {
    return keySpace;
  }

  @Override
  protected String getContactPoints() {
    return contactPoints;
  }

  @Override
  protected int getPort() {
    return port;
  }

  @Override
  public SchemaAction getSchemaAction() {
    return SchemaAction.RECREATE_DROP_UNUSED;
  }

  @Override
  public String[] getEntityBasePackages() {
    return new String[] {basePackages};
  }
@Override
protected Set<Class<?>> getInitialEntitySet() throws ClassNotFoundException {
    return CassandraEntityClassScanner.scan(getEntityBasePackages());
}
@Override
protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
    return Arrays.asList(
            CreateKeyspaceSpecification.createKeyspace(keySpace)
                    .ifNotExists());
}

}
