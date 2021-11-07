package xyz.arunangshu.petclinic.repositories;

import org.springframework.data.repository.CrudRepository;
import xyz.arunangshu.petclinic.model.Visit;

public interface VisitRepository extends CrudRepository<Visit, Long> {
}
