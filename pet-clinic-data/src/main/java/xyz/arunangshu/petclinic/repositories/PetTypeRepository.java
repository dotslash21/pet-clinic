package xyz.arunangshu.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xyz.arunangshu.petclinic.model.PetType;

public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
