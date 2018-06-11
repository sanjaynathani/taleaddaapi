package com.taleadda.restapi.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "story")
public class Story {

    @Id private String id;
    private String title;
    private String storyShortDescription;
    private String content;
    private String searchTags;
    private Date modifiedDate;
    private String authorName;
    private Integer likes;
    private Integer disLikes;
    private String createdBy;
    private Date createdDate;
    private PublishStatus currentStatus;
    private String deniedReason;
    private StatusHistory[] statusHistory;
}

@Data
class StatusHistory{
    private PublishStatus statusChangedTo;
    private PublishStatus statusChangedFrom;
    private Date changedOn;
    private String changedBy;
}

enum PublishStatus {
    PENDING("PENDING"),
    DENIED("DENIED"),
    APPROVED("APPROVED");

    private String status;

    private PublishStatus(String status){
        this.status = status;
    }

    public String getValue(PublishStatus publishStatus){
        return publishStatus.status;
    }
}