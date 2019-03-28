package com.consumerPriceIndex.Models;


import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "STAGING_AREA")
@Table(name = "STAGING_AREA ", schema="PUBLIC")
public class StagingArea  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(nullable = true, length = 255)
    private String Fecha;
    @Column(nullable = true, length = 255)
    private String Granularidad ;
    @Column(nullable = true, length = 255)
    private String Tipo ;
    @Column(nullable = true, length = 255)
    private String Detalle ;
    @Column(nullable = true, length = 255)
    private String Unidad ;
    @Column(nullable = true, length = 255)
    private String Valor ;
    @Column(nullable = true, length = 255)
    private String Url ;



    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getGranularidad() {
        return Granularidad;
    }

    public void setGranularidad(String granularidad) {
        Granularidad = granularidad;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public String getDetalle() {
        return Detalle;
    }

    public void setDetalle(String detalle) {
        Detalle = detalle;
    }

    public String getUnidad() {
        return Unidad;
    }

    public void setUnidad(String unidad) {
        Unidad = unidad;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }


}
