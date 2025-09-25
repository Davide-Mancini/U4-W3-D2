package davidemancini.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

@Entity
public class Concerto extends Evento {
    //ATTRIBUTI

    @Enumerated(EnumType.STRING)
    private Genere genere;
    private boolean inStreaming;

    //COSTRUTTORI

    public Concerto(){}

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, Genere genre, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genere = genre;
        this.inStreaming = inStreaming;
    }

    //METODI


    public Genere getGenre() {
        return genere;
    }

    public void setGenre(Genere genre) {
        this.genere = genre;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return "Concerto{" +
                "genre=" + genere +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
