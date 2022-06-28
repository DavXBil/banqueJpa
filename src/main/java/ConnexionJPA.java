import entity.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class ConnexionJPA {

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("banque-jpa");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Banque banque = new Banque();
        banque.setNom("TestCorp");

        Adresse adresse = new Adresse();

        adresse.setNumero(2);
        adresse.setRue("rue du test");
        adresse.setCodePostal(44685);
        adresse.setVille("Test-sur-mer");

        Adresse adresse2 = new Adresse();

        adresse2.setNumero(3);
        adresse2.setRue("rue du test2");
        adresse2.setCodePostal(44685);
        adresse2.setVille("Test-sur-Loire");

        HashSet clients = new HashSet<>();

        Client client = new Client();
        client.setNom("Smith");
        client.setPrenom("John");
        client.setDateNaissance(LocalDateTime.now());
        client.setAdresse(adresse);
        client.setBanque(banque);

        Client client2 = new Client();
        client2.setNom("Doe");
        client2.setPrenom("Jane");
        client2.setDateNaissance(LocalDateTime.now());
        client2.setAdresse(adresse2);
        client2.setBanque(banque);

        clients.add(client);
        clients.add(client2);

        Compte compte1 = new Compte();
        compte1.setSolde(500);

        Compte compte2 = new Compte();
        compte2.setSolde(1000);

        LivretA compte = new LivretA();
        compte.setSolde(100000);
        compte.setTaux(10);

        AssuranceVIe compte3 = new AssuranceVIe();
        compte3.setSolde(100000);
        compte3.setTaux(3);
        compte3.setDateFin((LocalDateTime.now()));

        Operation operation = new Operation();
        operation.setMontant(100);
        operation.setDate(LocalDateTime.now());
        operation.setMotif("Depot");
        operation.setCompte(compte1);

        Virement virement = new Virement();
        virement.setMontant(1200);
        virement.setDate(LocalDateTime.now());
        virement.setMotif("Depot");
        virement.setCompte(compte1);
        virement.setBeneficiaire("John Smith");

        Set<Compte> comptesClient = new HashSet<>();
        comptesClient.add(compte1);
        comptesClient.add(compte2);
        comptesClient.add(compte3);
        client.setComptes(comptesClient);

        client2.setComptes(comptesClient);

        em.persist(client);
        em.persist(client2);
        em.persist(banque);
        em.persist(compte1);
        em.persist(compte2);
        em.persist(compte3);

        em.getTransaction().commit();

    }

}
