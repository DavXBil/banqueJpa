package entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "livret_a")
public class LivretA extends Compte{


    private double taux;

    public LivretA() {
    }

    public LivretA(double taux) {
        this.taux = taux;
    }

    public LivretA(double solde, Set<Operation> operations, double taux) {
        super(solde, operations);
        this.taux = taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
}
