package ma.data.rest.tp11.beans;


import org.springframework.data.rest.core.config.Projection;

@Projection(name = "clientDetails", types = Client.class)

public interface ClientProjection {

    public String getNom();

    public String getEmail();

}
