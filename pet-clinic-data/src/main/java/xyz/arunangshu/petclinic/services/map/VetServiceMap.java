package xyz.arunangshu.petclinic.services.map;

import java.util.Set;
import org.springframework.stereotype.Service;
import xyz.arunangshu.petclinic.model.Specialty;
import xyz.arunangshu.petclinic.model.Vet;
import xyz.arunangshu.petclinic.services.SpecialtyService;
import xyz.arunangshu.petclinic.services.VetService;

@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

  private final SpecialtyService specialtyService;

  public VetServiceMap(SpecialtyService specialtyService) {
    this.specialtyService = specialtyService;
  }

  @Override
  public Set<Vet> findAll() {
    return super.findAll();
  }

  @Override
  public Vet findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Vet save(Vet object) {

    if (object.getSpecialties().size() > 0) {
      object.getSpecialties().forEach(specialty -> {
        if (specialty.getId() == null) {
          Specialty savedSpecialty = specialtyService.save(specialty);
          specialty.setId(savedSpecialty.getId());
        }
      });
    }

    return super.save(object);
  }

  @Override
  public void delete(Vet object) {
    super.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }
}
