package davidemancini.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;


@Entity

public class PartitaDiCalcio extends Evento {

    //ATTRIBUTI
    private String squadraDiCasa;
    private String squadraOspite;
    private String vincente;
    private int golSquadraCasa;
    private int golSquadraTrasferta;

    //COSTRUTTORI

    public PartitaDiCalcio(){}

    public PartitaDiCalcio(String titolo, LocalDate dataEvento, String descrizione, TipoEvento tipoEvento, int numeroMassimoPartecipanti, Location location, String squadraDiCasa, String squadraOspite, String vincente, int golSquadraCasa, int golSquadraTrasferta) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.vincente = vincente;
        this.golSquadraCasa = golSquadraCasa;
        this.golSquadraTrasferta = golSquadraTrasferta;
    }


    //METODI


    public int getGolSquadraTrasferta() {
        return golSquadraTrasferta;
    }

    public void setGolSquadraTrasferta(int golSquadraTrasferta) {
        this.golSquadraTrasferta = golSquadraTrasferta;
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getVincente() {
        return vincente;
    }

    public void setVincente(String vincente) {
        this.vincente = vincente;
    }

    public int getGolSquadraCasa() {
        return golSquadraCasa;
    }

    public void setGolSquadraCasa(int golSquadraCasa) {
        this.golSquadraCasa = golSquadraCasa;
    }

    @Override
    public String toString() {
        return "PartitaDiCalcio{" +
                "squadraDiCasa='" + squadraDiCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", vincente='" + vincente + '\'' +
                ", golSquadraCasa=" + golSquadraCasa +
                ", golSquadraTrasferta=" + golSquadraTrasferta +
                '}';
    }
}
