package com.docker.restelasticsearch.protocol;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "protocols")
public class Protocol {

  @Id
  private String id;

  @Field(type = FieldType.Text, name = "name")
  private String name;

  @Field(type = FieldType.Text, name = "author")
  private String author;

  @Field(type = FieldType.Text, name = "version")
  private String version;
}
