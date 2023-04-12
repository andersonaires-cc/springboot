package br.com.first.system.Repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import org.springframework.stereotype.Component;

import br.com.first.system.Models.Convite;

@Component
public class ConvitesRepository {

    public Collection<Convite> convites = new ArrayList<Convite>();

    public void addConvite(final Convite convite){
        convites.add(convite);
    }

    public Optional<Convite> GetConviteById(int id){
        for(Convite c:convites){
            if(c.getId() == id){
                return Optional.of(c);
            }
        }

        return Optional.empty();
    }

}
