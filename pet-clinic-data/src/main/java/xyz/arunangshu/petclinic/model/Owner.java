package xyz.arunangshu.petclinic.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "telephone")
    private String telephone;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>();

    @Builder
    public Owner(Long id, String firstName, String lastName, String address, String city, String telephone, Set<Pet> pets) {
        super(id, firstName, lastName);
        this.address = address;
        this.city = city;
        this.telephone = telephone;
        if (pets != null) {
            this.pets = pets;
        }
    }

    /**
     * Return the Pet with the given name, or null if none found for this owner.
     *
     * @param name the name of the Pet to find
     * @return the Pet with the given name, or null if none found for this owner
     */
    public Pet getPet(String name) {
        return getPet(name, false);
    }

    /**
     * Return the Pet with the given name, or null if none found for this owner.
     *
     * @param name the name of the Pet to find
     * @param ignoreNew whether to ignore the new pet
     * @return the Pet with the given name, or null if none found for this owner
     */
    public Pet getPet(String name, boolean ignoreNew) {
        return this.getPets()
                .stream()
                .filter(pet -> {
                    if (!(ignoreNew && pet.isNew())) {
                        return pet.getName().equalsIgnoreCase(name);
                    }
                    return false;
                })
                .findFirst()
                .orElse(null);
    }
}
