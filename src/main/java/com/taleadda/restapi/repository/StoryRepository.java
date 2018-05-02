package com.taleadda.restapi.repository;

import com.taleadda.restapi.domain.Story;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface StoryRepository extends MongoRepository<Story, String> {

    Story findStoryByStoryId(@Param("storyId") Long storyId);
}
