package davidemancini.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {

    //ATTRIBUTI
    @Id
    @GeneratedValue
    UUID partecipazioneId;

    @OneToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @Enumerated(EnumType.STRING)
    private Stato stato;

    public Partecipazione (){}
     public Partecipazione(Persona persona, Evento evento, Stato stato){
        this.persona=persona;
        this.evento=evento;
        this.stato=stato;
     }

    public UUID getPartecipazioneId() {
        return partecipazioneId;
    }

    public void setPartecipazioneId(UUID partecipazioneId) {
        this.partecipazioneId = partecipazioneId;
    }

    public Stato getStato() {
        return stato;
    }

    public void setStato(Stato stato) {
        this.stato = stato;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Partecipazione{" +
                "partecipazioneId=" + partecipazioneId +
                ", persona=" + persona +
                ", evento=" + evento +
                ", stato=" + stato +
                '}';
    }
}
