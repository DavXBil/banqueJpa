package entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class AssuranceVIe extends Compte{

    @Column(name = "taux")
    private double taux;


    @Column(name= "date_fin", columnDefinition = "TIMESTAMP")
    private LocalDateTime dateFin;

    public AssuranceVIe() {
    }

    public AssuranceVIe(double solde, Set<Operation> operations, double taux, LocalDateTime dateFin) {
        super(solde, operations);
        this.taux = taux;
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }


}
