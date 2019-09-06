package com.informatorio.mvcapp.controller;

import com.informatorio.mvcapp.model.Arbol;
import com.informatorio.mvcapp.model.Familia;
import com.informatorio.mvcapp.model.User;
import com.informatorio.mvcapp.repository.ArbolRepository;
import com.informatorio.mvcapp.service.FamiliaService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/arbol")
public class ArbolController {

  private ArbolRepository arbolRepository;
  private FamiliaService familiaService;

  @Autowired
  public ArbolController(ArbolRepository arbolRepository, FamiliaService familiaService) {
    this.arbolRepository = arbolRepository;
    this.familiaService = familiaService;
  }

  @GetMapping
  public String listArbol(Model model) {
    List<Arbol> arbolList = arbolRepository.findAll();
    model.addAttribute("arbolList", arbolList);

    return "home";
  }

  @GetMapping("/signup")
  public String showSignUpForm(Arbol arbol) {
    return "home2";
  }

  @PostMapping("/agregarArbol")
  public String addUser(@Valid Arbol arbol, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "home2";
    }
    String familiaString = arbol.getFamiliaString();
    Familia familia = familiaService.buscarPorNombre(familiaString);
    arbol.setFamilia(familia);

    arbolRepository.save(arbol);
    model.addAttribute("arbolList", arbolRepository.findAll());
    return "home";
  }
}
