package xyz.arunangshu.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xyz.arunangshu.petclinic.model.Pet;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
