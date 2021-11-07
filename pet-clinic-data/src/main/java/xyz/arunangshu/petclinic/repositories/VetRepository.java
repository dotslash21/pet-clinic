package xyz.arunangshu.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xyz.arunangshu.petclinic.model.Vet;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
