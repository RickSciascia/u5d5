package ricksciascia.u5d5.entities;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "utenti")
@NoArgsConstructor
@Setter
@Getter
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private long id;
    @Column(nullable = false , unique = true)
    private String username;
    @Column(nullable = false)
    private String nomeComp;
    @Column(nullable = false, unique = true)
    private String email;

    public Utente (String user, String nomeCompleto, String email){
        this.username = user;
        this.nomeComp = nomeCompleto;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Utente: " +
                "id: " + id +
                ", username: '" + username + '\'' +
                ", nomeCompleto: '" + nomeComp + '\'' +
                ", email: '" + email + '\'' ;
    }
}
