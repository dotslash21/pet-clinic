package xyz.arunangshu.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xyz.arunangshu.petclinic.model.Specialty;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
}
