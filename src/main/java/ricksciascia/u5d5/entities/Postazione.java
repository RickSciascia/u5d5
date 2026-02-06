package ricksciascia.u5d5.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "postazioni")
@NoArgsConstructor
@Setter
@Getter
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    @Column(nullable = false)
    private String descrizione;
    @Column(name = "tipo_postazione", nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;
    @Column(name = "numero_occupanti_max",nullable = false)
    private int numeroOccupantiMax;
    @ManyToOne
    @JoinColumn(name = "id_edificio", nullable = false)
    private Edificio edificio;

    public Postazione(String descrizione, TipoPostazione tipo, int numeroOccupantiMax, Edificio edificio){
        this.descrizione = descrizione;
        this.tipo = tipo;
        this.numeroOccupantiMax = numeroOccupantiMax;
        this.edificio = edificio;
    }

    @Override
    public String toString() {
        return "Postazione: " +
                "id: " + id +
                ", descrizione: '" + descrizione + '\'' +
                ", tipo: " + tipo +
                ", numeroOccupantiMax: " + numeroOccupantiMax +
                ", edificio: " + edificio;
    }
}
