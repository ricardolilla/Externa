package com.example.ricardo.externa;

import se.emilsjolander.sprinkles.Model;
import se.emilsjolander.sprinkles.annotations.AutoIncrement;
import se.emilsjolander.sprinkles.annotations.Column;
import se.emilsjolander.sprinkles.annotations.Key;
import se.emilsjolander.sprinkles.annotations.Table;

/**
 * Created by ricardo on 09/03/16.
 */
@Table("Externas")
public class Dados extends Model{
    @Key
    @Column("id")
    @AutoIncrement
    private long id;
    @Column("Cliente")
    private String Cliente;
    @Column("KmIni")
    private String KmIni;
    @Column("KmFinal")
    private String KmFinal;
    @Column("HoraIni")
    private String HoraIni;
    @Column("HoraSaida")
    private String HoraSaida;
    @Column("Data")
    private String Data;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String cliente) {
        Cliente = cliente;
    }

    public String getKmIni() {
        return KmIni;
    }

    public void setKmIni(String kmIni) {
        KmIni = kmIni;
    }

    public String getKmFinal() {
        return KmFinal;
    }

    public void setKmFinal(String kmFinal) {
        KmFinal = kmFinal;
    }

    public String getHoraIni() {
        return HoraIni;
    }

    public void setHoraIni(String horaIni) {
        HoraIni = horaIni;
    }

    public String getHoraSaida() {
        return HoraSaida;
    }

    public void setHoraSaida(String horaSaida) {
        HoraSaida = horaSaida;
    }

    public String getData() {
        return Data;
    }

    public void setData(String data) {
        Data = data;
    }
}
