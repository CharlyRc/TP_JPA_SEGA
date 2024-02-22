package fr.epsi.b32324c1;

import petstore.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        EntityManager em = emf.createEntityManager();
        System.out.println("La connexion est la BDD est réussie " + em);

        EntityTransaction transaction = em.getTransaction();

        PetStore testPetStore = new PetStore();
        testPetStore.setName("toto");
        testPetStore.setManagerName("manager pet");

        Address newAdresse =new Address();
        newAdresse.setCity("Nantes");
        newAdresse.setNumber("15");
        newAdresse.setStreet("jean rene");
        newAdresse.setZipCode("44000");
        newAdresse.setPetStore(testPetStore);
        testPetStore.setAddress(newAdresse);

        Product testProduct = new Product();
        testProduct.setCode("156487");
        testProduct.setLabel("label produit");
        testProduct.setPrice(18.99);
        testProduct.setProdType(ProdType.FOOD);

        Animal testAnimal = new Animal();
        testAnimal.setBirth(LocalDate.of(2014,04,21));
        testAnimal.setCouleur("rouge");
        testAnimal.setPetStore(testPetStore);

        try {
            transaction.begin();
            em.persist(testPetStore);
            em.persist(newAdresse);
            em.persist(testProduct);
            em.persist(testAnimal);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, "Une erreur s'est produite lors de l'exécution du programme", e);
        } finally {
            em.close();
            emf.close();
        }
    }
}