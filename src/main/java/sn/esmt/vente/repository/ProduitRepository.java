package sn.esmt.vente.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sn.esmt.vente.entity.ProduitEntity;

import java.util.Optional;

@Repository

public interface ProduitRepository extends JpaRepository<ProduitEntity,String> {
  @Query("Select p from ProduitEntity p where p.ref=?1")
  public Optional<ProduitEntity > findByref(String ref );
  @Query("Select p from ProduitEntity p where p.ref= :r")
  public Optional<ProduitEntity > findref(@Param("r") String ref  );

}

