package ma.data.rest.tp11.beans;

import org.springframework.data.rest.core.config.Projection;

/**
 * @author radouane
 **/
@Projection(name = "solde", types = Compte.class)
public interface CompteProjection1 {

    double getSolde();
}
