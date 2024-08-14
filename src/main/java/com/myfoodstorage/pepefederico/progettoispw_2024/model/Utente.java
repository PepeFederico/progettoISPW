package com.myfoodstorage.pepefederico.progettoispw_2024.Model;

public abstract class Utente {
    private String tipoUtente;
    private String email;
    private String password;
    private String nome;
    private String cognome;
    private String partitaIVA;
    private String viaAttivita;
    private int numeroCivico;
    private String citta;
    private String CAP;
    private String nomeAttivita;
    private String numeroTelefono;

    protected Utente(String email, String password, String nome, String cognome, String partitaIVA, String viaAttivita, int numeroCivico, String citta, String CAP, String nomeAttivita, String numeroTelefono) {
        this.email = email;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.partitaIVA = partitaIVA;
        this.viaAttivita = viaAttivita;
        this.numeroCivico = numeroCivico;
        this.citta = citta;
        this.CAP = CAP;
        this.nomeAttivita = nomeAttivita;
        this.numeroTelefono = numeroTelefono;
    }
    public String getTipoUtente() {
        return tipoUtente;
    }

    public void setTipoUtente(String tipoUtente) {
        this.tipoUtente = tipoUtente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getPartitaIVA() {
        return partitaIVA;
    }

    public void setPartitaIVA(String partitaIVA) {
        this.partitaIVA = partitaIVA;
    }

    public String getViaAttivita() {
        return viaAttivita;
    }

    public void setViaAttivita(String viaAttivita) {
        this.viaAttivita = viaAttivita;
    }

    public int getNumeroCivico() {
        return numeroCivico;
    }

    public void setNumeroCivico(int numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getCAP() {
        return CAP;
    }

    public void setCAP(String CAP) {
        this.CAP = CAP;
    }

    public String getNomeAttivita() {
        return nomeAttivita;
    }

    public void setNomeAttivita(String nomeAttivita) {
        this.nomeAttivita = nomeAttivita;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }
}
