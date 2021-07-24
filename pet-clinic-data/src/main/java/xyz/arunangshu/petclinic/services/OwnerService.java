package xyz.arunangshu.petclinic.services;

import xyz.arunangshu.petclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
