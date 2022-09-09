package edu.miu.lab5aop.service;

import edu.miu.lab5aop.entity.Post;
import edu.miu.lab5aop.exception.NotFoundException;
import edu.miu.lab5aop.repo.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    public List<Post> getPosts() {
        return (List<Post>) postRepository.findAll();
    }

    public Post getById(int id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cannot find post with id: " + id));
        return post;
    }

}
