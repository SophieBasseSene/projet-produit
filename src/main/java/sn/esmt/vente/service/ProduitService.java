package sn.esmt.vente.service;



import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sn.esmt.vente.entity.ProduitEntity;
import sn.esmt.vente.repository.ProduitRepository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service

public class ProduitService implements IProduitService{
  private ProduitRepository produitRepository;


  @Override
  public ProduitEntity save(ProduitEntity produitEntity) {
    return produitRepository.save(produitEntity);
  }

  @Override
  public ProduitEntity update(String ref, ProduitEntity produitEntity) {
    Optional<ProduitEntity> produitEntity1 = this.get(ref);
    if (produitEntity1.isPresent()) {
      produitEntity1.get().setNom(produitEntity.getNom());
      produitEntity1.get().setRef(produitEntity.getRef());
      //TODO pour tous les autre champs
      return produitRepository.save(produitEntity1.get());
    }
    return   produitEntity;
  }

  @Override
  public Optional<ProduitEntity> get(String ref) {
    return produitRepository.findByref(ref);
  }

  @Override
  public Optional<List<ProduitEntity>> getALL() {
    return Optional.of(produitRepository.findAll());
  }

  @Override
  public void delete(String ref) {
    Optional<ProduitEntity>produitOptional = this.get(ref);
    if (produitOptional.isPresent()) {
      produitRepository.delete(produitOptional.get());
    } else {

      System.out.println("Le produit  avec la référence" + ref + " n'existe pas. ");
    }
  }

}




























