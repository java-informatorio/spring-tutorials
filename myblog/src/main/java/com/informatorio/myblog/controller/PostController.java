package com.informatorio.myblog.controller;

import com.informatorio.myblog.dto.CommentDTO;
import com.informatorio.myblog.model.Post;
import com.informatorio.myblog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

    //private Map<Integer, String> postRepository = inicializarRepo();
    @Autowired
    private PostRepository postRepository;

    //GET Todos los POST
    @GetMapping // ~ /api/v1/post
    public ResponseEntity<?> getPosts(@RequestParam String title) {

        return new ResponseEntity<>(postRepository.findAll(), HttpStatus.OK);
    }

    //POST Crear un POST
    @PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post post) {
        return new ResponseEntity<>(postRepository.save(post), HttpStatus.CREATED);
    }

    //POST Crear un COMMENT
    @PostMapping("/{id_post}/comment")
    public ResponseEntity<?> createComment(@PathVariable Long id_post, @RequestBody CommentDTO commentDTO) {
        //1 -Buscar el post a comentar
        //Post post = postRepository.getOne(id_post);

        //2- Buscar autor del comentari
        // Long autorComentarioId = commentDTO.getIdAutor()
        // User user = userRepository.getOne(autorComentarioId)

        //3 - Crear Comment y asociar
        // Comment comment = new Comentario(...
        // setter
        // post.agregarComentario(comennt)
        // user.agregarComentario(comment)
        //comentarioRepository.save(comment)

        return null;
    }

    //PUT para modificar un POST segun ID
    @PutMapping("/{postId}")
    public ResponseEntity<?> editPost(@PathVariable Long postId, @Valid @RequestBody Post post) {
        Post postEdit = postRepository.getOne(postId);
        postEdit.setTitle(post.getTitle());
        return new ResponseEntity<>(postRepository.save(postEdit), HttpStatus.OK);
    }



    //DELETE Borrar un Post segun el ID
    @DeleteMapping("/{postId}")
    public ResponseEntity<?> deletePost(@PathVariable Long postId) {
        Post postDelete = postRepository.getOne(postId);
        postRepository.delete(postDelete);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    private Map<Integer, String> inicializarRepo() {
        Map<Integer, String> posts = new HashMap<>();
        posts.put(1, "Java");
        posts.put(2, "React");
        return posts;
    }
}
