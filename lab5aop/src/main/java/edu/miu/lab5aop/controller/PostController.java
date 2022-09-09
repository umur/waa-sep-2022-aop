package edu.miu.lab5aop.controller;

import edu.miu.lab5aop.entity.Post;
import edu.miu.lab5aop.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @GetMapping
    public List<Post> getAll() {
        return postService.getPosts();
    }

}
