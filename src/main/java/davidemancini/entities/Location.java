package davidemancini.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue
    UUID locationId;

    String nome;
    String citta;
    @OneToOne(mappedBy = "location")
    private Evento evento;

    public Location (){}

    public Location (String nome, String citta, Evento evento){
        this.nome=nome;
        this.citta=citta;
        this.evento=evento;
    }

    public UUID getLocationId() {
        return locationId;
    }

    public void setLocationId(UUID locationId) {
        this.locationId = locationId;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId=" + locationId +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +

                '}';
    }
}
