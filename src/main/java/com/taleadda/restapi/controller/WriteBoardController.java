package com.taleadda.restapi.controller;

import com.taleadda.restapi.domain.Story;
import com.taleadda.restapi.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WriteBoardController {

    @Autowired
    private StoryRepository storyRepository;

    @PostMapping("/story/submit")
    public Story submitStory(@RequestBody Story story){
        return storyRepository.insert(story);
    }
}
