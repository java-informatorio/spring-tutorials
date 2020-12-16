package com.informatorio.myblog.controller;

import com.informatorio.myblog.model.Post;
import com.informatorio.myblog.model.User;
import com.informatorio.myblog.repository.PostRepository;
import com.informatorio.myblog.repository.UserRepository;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @PostMapping
  public ResponseEntity<?> createUser(@RequestBody User user) {
    return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
  }

  @PostMapping("/{id_user}/post")
  public ResponseEntity<?> createPostGivenUser(@PathVariable Long id_user, @RequestBody Post post) {
    User user = userRepository.getOne(id_user);
    user.addPost(post);
    return new ResponseEntity<>(postRepository.save(post), HttpStatus.CREATED);
  }

  //GET Todos los user creados despues de cierta fecha
  @GetMapping // ~ /api/v1/post
  public ResponseEntity<?> buscarUsuariosCreadosDespuesDeFecha(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
    List<User> users = userRepository.findByCreationDateIsAfter(date);
    System.out.println("POR FIN ENTRO EN EL CONTROLLER!!!!!!");
    System.out.println(users.get(0).getNombre());
    return new ResponseEntity<>(users, HttpStatus.OK);
  }
}
