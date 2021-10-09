package xyz.arunangshu.petclinic.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import xyz.arunangshu.petclinic.model.Owner;
import xyz.arunangshu.petclinic.model.Pet;
import xyz.arunangshu.petclinic.model.PetType;
import xyz.arunangshu.petclinic.model.Vet;
import xyz.arunangshu.petclinic.services.OwnerService;
import xyz.arunangshu.petclinic.services.PetTypeService;
import xyz.arunangshu.petclinic.services.VetService;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Michael");
        owner1.setLastName("De Santa");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setTelephone("1234567890");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogPetType);
        mikesPet.setOwner(owner1);
        mikesPet.setName("Rosco");
        mikesPet.setBirthDate(LocalDate.now());
        owner1.getPets().add(mikesPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Franklin");
        owner2.setLastName("Clinton");
        owner2.setAddress("123 Brickerel");
        owner2.setCity("Miami");
        owner2.setTelephone("1234567890");

        Pet franksPet = new Pet();
        franksPet.setPetType(savedCatPetType);
        franksPet.setOwner(owner2);
        franksPet.setName("Tom");
        franksPet.setBirthDate(LocalDate.now());
        owner2.getPets().add(franksPet);

        ownerService.save(owner2);

        System.out.println("Loaded Owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Trevor");
        vet1.setLastName("Phillips");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Lester");
        vet2.setLastName("Crest");

        vetService.save(vet2);

        System.out.println("Loaded Vets...");

    }
}
