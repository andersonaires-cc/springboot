package br.com.first.system.Repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

import br.com.first.system.Models.Convite;

public class ConvitesRepository {

    public static Collection<Convite> convites = new ArrayList<Convite>();

    public static void addConvite(final Convite convite){
        ConvitesRepository.convites.add(convite);
    }

    public static Optional<Convite> GetConviteById(int id){
        for(Convite c:ConvitesRepository.convites){
            if(c.getId() == id){
                return Optional.of(c);
            }
        }

        return Optional.empty();
    }

}
