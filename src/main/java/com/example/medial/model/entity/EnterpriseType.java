package com.example.medial.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "EnterpriseTypes")
public class EnterpriseType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "rubro")
    private String rubro;
    @Column(name = "cantidad_registros")
    private Long cantidadRegistros;

    public EnterpriseType() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public Long getCantidadRegistros() {
        return cantidadRegistros;
    }

    public void setCantidadRegistros(Long cantidadRegistros){
        this.cantidadRegistros = cantidadRegistros;
    }

}


