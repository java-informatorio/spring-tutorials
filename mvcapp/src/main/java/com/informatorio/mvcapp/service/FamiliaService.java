package com.informatorio.mvcapp.service;

import com.informatorio.mvcapp.model.Familia;
import com.informatorio.mvcapp.repository.FamiliaRepository;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamiliaService {

  private FamiliaRepository familiaRepository;

  @Autowired
  public FamiliaService(FamiliaRepository familiaRepository) {
    this.familiaRepository = familiaRepository;
  }

  public Familia buscarPorNombre(String familiaString) {
    Familia familia = familiaRepository.findFamiliaByNombre(familiaString);
    if(Objects.isNull(familia)) {
      return null;
    }
    return familia;
  }
}
