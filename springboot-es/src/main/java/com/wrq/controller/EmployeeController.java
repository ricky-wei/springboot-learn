package com.wrq.controller;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * es基本操作
 *
 * @author weiruiqi
 * @date 2020/6/25 18:15
 */
@RestController
public class EmployeeController {

    @Autowired
    TransportClient client;

    /**
     * 查询
     *
     * @param id
     * @return
     */
    @GetMapping("get/employee")
    public ResponseEntity get(@RequestParam(name = "id", defaultValue = "") String id) {
        if (id.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        GetResponse result = client.prepareGet("megacorp", "employee", id).get();
        if (!result.isExists()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(result.getSource(), HttpStatus.OK);
    }

    /**
     * 增加
     *
     * @param firstName
     * @param lastName
     * @param age
     * @return
     */
    @PostMapping("add/employee")
    public ResponseEntity add(@RequestParam(name = "first_name") String firstName,
                              @RequestParam(name = "last_name") String lastName,
                              @RequestParam(name = "age") String age) {
        try {
            XContentBuilder content = XContentFactory.jsonBuilder().startObject()
                    .field("first_name", firstName)
                    .field("last_name", lastName)
                    .field("age", age)
                    .endObject();
            IndexResponse response = client.prepareIndex("megacorp", "employee")
                    .setSource(content).get();
            return new ResponseEntity(response.getId(), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("delete/employee")
    public ResponseEntity delete(@RequestParam(name = "id") String id) {
        DeleteResponse deleteResponse = client.prepareDelete("", "", id).get();
        return new ResponseEntity(deleteResponse.getResult().toString(), HttpStatus.OK);
    }

    /**
     * 更新
     *
     * @param id
     * @param firstName
     * @return
     */
    @PostMapping("update/employee")
    public ResponseEntity update(
            @RequestParam(name = "id") String id,
            @RequestParam(name = "first_name", required = false) String firstName) {
        UpdateRequest request = new UpdateRequest("megacorp", "employee", id);
        try {
            XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
                    .startObject();
            if (firstName != null) {
                xContentBuilder.field("first_name", firstName);
            }
            xContentBuilder.endObject();
            request.doc(xContentBuilder);
        } catch (IOException e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {
            UpdateResponse updateResponse = client.update(request).get();
            return new ResponseEntity(updateResponse.getGetResult().toString(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 复合查询
     *
     * @param firstName
     * @return
     */
    @PostMapping("query/employee")
    public ResponseEntity query(@RequestParam(name = "first_name") String firstName) {
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        if (firstName != null) {
            boolQuery.must(QueryBuilders.matchQuery("first_name", firstName));
        }
        SearchRequestBuilder builder = client.prepareSearch("megacorp")
                .setTypes("employee")
                .setSearchType(SearchType.DFS_QUERY_THEN_FETCH).setQuery(boolQuery)
                .setFrom(0)
                .setSize(10);
        System.out.println(builder);
        SearchResponse response = builder.get();
        List<Map<String, Object>> result = new ArrayList<>();
        for (SearchHit hit : response.getHits()) {
            result.add(hit.getSourceAsMap());
        }
        return new ResponseEntity(result, HttpStatus.OK);
    }


}
