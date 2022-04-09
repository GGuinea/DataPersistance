package proj.platformy.dane.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import proj.platformy.dane.entity.sql.Todo;
import proj.platformy.dane.repository.elastic.Elastic;

@Configuration
@Slf4j
public class ElasticSearchService {
  @Autowired
  private RestHighLevelClient client;

  @Autowired
  private Elastic elastic;
  public List<Todo> searchData(String request) {
    SearchRequest searchRequest = new SearchRequest("testing");
    SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

    QueryBuilder query =  QueryBuilders.boolQuery().should(new WildcardQueryBuilder("description", "*" + request + "*"));
    searchSourceBuilder.query(query);
    searchRequest.source(searchSourceBuilder);

    SearchResponse searchResponse = null;
    searchResponse = getSearchResponse(searchRequest, searchResponse);

    log.info(query.toString());
    List<Todo> resultTodoCollection = new ArrayList<>();
    SearchHit[] hits = searchResponse.getHits().getHits();
    if(hits.length == 0) {
      return Collections.emptyList();
    }
    Arrays.stream(hits).forEach(todoItem -> {
      Todo tmp = new Todo(
      Integer.parseInt(todoItem.getSourceAsMap().get("id").toString()), todoItem.getSourceAsMap().get("description").toString());
      resultTodoCollection.add(tmp);
    });

    log.info(query.toString());
    log.info(searchResponse.toString());

    return resultTodoCollection;
  }

  private SearchResponse getSearchResponse(SearchRequest searchRequest, SearchResponse searchResponse) {
    try {
      searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return searchResponse;
  }
}
