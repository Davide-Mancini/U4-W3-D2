package davidemancini.entities;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Concerto extends Evento {
    //ATTRIBUTI

    private Genere genre;
    private boolean inStreaming;

    //COSTRUTTORI

    public Concerto(){}

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, Genere genre, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.genre = genre;
        this.inStreaming = inStreaming;
    }

    //METODI


    public Genere getGenre() {
        return genre;
    }

    public void setGenre(Genere genre) {
        this.genre = genre;
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
                "genre=" + genre +
                ", inStreaming=" + inStreaming +
                '}';
    }
}
