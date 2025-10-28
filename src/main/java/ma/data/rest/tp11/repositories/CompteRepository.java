package ma.data.rest.tp11.repositories;

import ma.data.rest.tp11.beans.Compte;
import ma.data.rest.tp11.beans.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * @author radouane
 **/
@RepositoryRestResource(path = "comptes", collectionResourceRel = "comptes", itemResourceRel = "compte")
public interface CompteRepository extends JpaRepository<Compte, Long> {

    @RestResource(path = "/byType")
    List<Compte> findByType(@Param("t") TypeCompte type);
}
