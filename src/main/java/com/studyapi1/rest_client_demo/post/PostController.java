package com.studyapi1.rest_client_demo.post;

import com.studyapi1.rest_client_demo.client.JsonPlaceholderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final JsonPlaceholderService postService;

    public PostController(JsonPlaceholderService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    List<Post> findAll(){
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public Post findById(@PathVariable Integer id){
        return postService.findById(id);
    }

    @PostMapping
    public Post save(@RequestBody Post post){
        return postService.create(post);
    }

    @PutMapping("/{id}")
    public Post update(@PathVariable Integer id, @RequestBody Post post){
        return postService.update(post,id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        postService.delete(id);
    }

}
