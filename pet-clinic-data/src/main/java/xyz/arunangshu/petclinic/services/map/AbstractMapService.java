package xyz.arunangshu.petclinic.services.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import xyz.arunangshu.petclinic.model.BaseEntity;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

  protected Map<Long, T> map = new HashMap<>();

  Set<T> findAll() {
    return new HashSet<>(map.values());
  }

  T findById(ID id) {
    return map.get(id);
  }

  T save(T object) {

    if (Objects.nonNull(object)) {
      if (Objects.isNull(object.getId())) {
        object.setId(this.getNextId());
      }

      map.put(object.getId(), object);
    } else {
      throw new RuntimeException("Object cannot be null");
    }

    return object;
  }

  void delete(T object) {
    map.entrySet().removeIf(idtEntry -> idtEntry.getValue().equals(object));
  }

  void deleteById(ID id) {
    map.remove(id);
  }

  private Long getNextId() {

    Long nextId;

    try {
      nextId = Collections.max(map.keySet()) + 1;
    } catch (NoSuchElementException e) {
      nextId = 1L;
    }

    return nextId;
  };
}
