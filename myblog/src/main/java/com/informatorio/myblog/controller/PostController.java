package com.informatorio.myblog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    private Map<Integer, String> postRepository = inicializarRepo();

    //GET Todos los POST
    @GetMapping // ~ /api/v1/post
    public ResponseEntity<?> getPosts() {
        return new ResponseEntity<>(postRepository, HttpStatus.OK);
    }

    //POST Crear un POST
    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody String nombrePost) {
        postRepository.put(3, nombrePost);
        return new ResponseEntity<>(postRepository, HttpStatus.CREATED);
    }

    //PUT para modificar un POST segun ID
    @PutMapping("/{postId}")


    //DELETE Borrar un Post segun el ID
    @DeleteMapping("/{postId}")

    private Map<Integer, String> inicializarRepo() {
        Map<Integer, String> posts = new HashMap<>();
        posts.put(1, "Java");
        posts.put(2, "React");
        return posts;
    }
}
