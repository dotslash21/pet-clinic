package xyz.arunangshu.petclinic.services.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import xyz.arunangshu.petclinic.model.Pet;
import xyz.arunangshu.petclinic.services.PetService;

@Service
@Profile({"default", "map"})
public class PetMapService extends AbstractMapService<Pet, Long> implements PetService {

  @Override
  public Set<Pet> findAll() {
    return super.findAll();
  }

  @Override
  public Pet findById(Long id) {
    return super.findById(id);
  }

  @Override
  public Pet save(Pet object) {
    return super.save(object);
  }

  @Override
  public void delete(Pet object) {
    super.delete(object);
  }

  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
  }
}
