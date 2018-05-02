package com.taleadda.restapi.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "story")
public class Story {

    @Id private String id;
    private Long storyId;
    private String title;
    private String storyShortDescription;
    private String content;
}
