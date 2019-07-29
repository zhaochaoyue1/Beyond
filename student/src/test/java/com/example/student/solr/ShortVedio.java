package com.example.student.solr;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

import java.io.Serializable;

/**
 * @program: student
 * @Date: 2019/7/23 23:39
 * @Author: Mr.Zhao
 * @Description:
 */
@Data
@SolrDocument(solrCoreName="mysolr")
public class ShortVedio implements Serializable {
    private Long id;
    @Field(value = "name")
    private String name;
    @Field(value = "channelName")
    private String channelName;
    @Field(value = "authorName")
    private String authorName;
    /*@Field(value = "label")
    private List<String> label;*/
    @Field(value = "title")
    private String title;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    /*public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }*/

    /*public List<String> getLabel() {
        return label;
    }

    public void setLabel(List<String> label) {
        this.label = label;
    }*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
