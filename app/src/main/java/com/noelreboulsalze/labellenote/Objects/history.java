package com.noelreboulsalze.labellenote.Objects;

/**
 * Created by ysiguman on 28/05/18.
 */

public class history {

    private String total_frais;
    private String id_demande;
    private String creation_note ;
    private String etat;

    public history() {
    }

    public history(String total_frais, String id_demande, String creation_note, String etat) {
        this.total_frais = total_frais;
        this.id_demande = id_demande;
        this.creation_note = creation_note;
        this.etat = etat;
    }

    public String getTotal_frais() {
        return total_frais;
    }

    public void setTotal_frais(String total_frais) {
        this.total_frais = total_frais;
    }

    public String getId_demande() {
        return id_demande;
    }

    public void setId_demande(String id_demande) {
        this.id_demande = id_demande;
    }

    public String getCreation_note() {
        return creation_note;
    }

    public void setCreation_note(String creation_note) {
        this.creation_note = creation_note;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
