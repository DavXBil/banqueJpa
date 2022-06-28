package entity;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "CLIENT")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOM", length = 50)
    private String nom;

    @Column(name = "PRENOM", length = 50)
    private String prenom;


    @Column(name="DATENAISSANCE")
    private LocalDateTime dateNaissance;

    @Embedded
    private Adresse adresse;

}
