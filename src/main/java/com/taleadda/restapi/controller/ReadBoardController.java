package com.taleadda.restapi.controller;

import com.taleadda.restapi.domain.Story;
import com.taleadda.restapi.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReadBoardController {

    @Autowired
    private StoryRepository storyRepository;

    @GetMapping(value = "/stories")
    public List<Story> getAllStories(){
        return storyRepository.findAll();
    }

    @GetMapping(value = "/pagedstories")
    public List<Story> getPagedStories(@RequestParam int start, @RequestParam int limit, @RequestParam String sort, @RequestParam String fieldName){
        return storyRepository.findAll(PageRequest.of(start, limit, new Sort(Sort.Direction.fromOptionalString(sort).orElse(Sort.Direction.ASC), fieldName))).getContent();
    }

    @GetMapping(value = "/story/{id}")
    public Story getStoryById(@PathVariable String id){
        return storyRepository.findStoryById(id);
    }

    @DeleteMapping(value = "/deleteStory/{id}")
    public void deleteStoryById(@PathVariable String id){
        storyRepository.deleteById(id);
    }
}
