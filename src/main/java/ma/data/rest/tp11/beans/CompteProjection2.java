package ma.data.rest.tp11.beans;

import org.springframework.data.rest.core.config.Projection;

/**
 * @author radouane
 **/
@Projection(name = "mobile", types = Compte.class)
public interface CompteProjection2 {

    double getSolde();

    String getType();
}
