/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.zapateria.gestionzapateria;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
//import javax.persistence.OneToOne;
import javax.persistence.Table;
//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author matinal
 */
@Entity
@Table(name = "empleado_direccion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmpleadoDireccion.findAll", query = "SELECT e FROM EmpleadoDireccion e")
    , @NamedQuery(name = "EmpleadoDireccion.findByIdDireccion", query = "SELECT e FROM EmpleadoDireccion e WHERE e.idDireccion = :idDireccion")
    , @NamedQuery(name = "EmpleadoDireccion.findByNombre", query = "SELECT e FROM EmpleadoDireccion e WHERE e.nombre = :nombre")
    , @NamedQuery(name = "EmpleadoDireccion.findByIdEmpleado", query = "SELECT e FROM EmpleadoDireccion e WHERE e.idEmpleado = :idEmpleado")
    , @NamedQuery(name = "EmpleadoDireccion.findByNombreVia", query = "SELECT e FROM EmpleadoDireccion e WHERE e.nombreVia = :nombreVia")
    , @NamedQuery(name = "EmpleadoDireccion.findByCp", query = "SELECT e FROM EmpleadoDireccion e WHERE e.cp = :cp")})
public class EmpleadoDireccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_direccion")
    private Integer idDireccion;
    @Column(name = "nombre")
    private String nombre;
    //@Column(name = "id_empleado")
   
    @Basic(optional = false)
    //@Size(min = 1, max = 150)
    @Column(name = "nombre_via")
    private String nombreVia;
    //@Column(name = "cp")
    
    
    @JoinColumn(name = "cp", referencedColumnName = "cp", nullable = false)
    @JsonBackReference
    @ManyToOne(optional = false)
    private CodPos cp;
    
    @JoinColumn(name = "id_empleado", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    @JsonBackReference
    private Empleado idEmpleado;

    public EmpleadoDireccion() {
    }

    public EmpleadoDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public EmpleadoDireccion(Integer idDireccion, String nombreVia) {
        this.idDireccion = idDireccion;
        this.nombreVia = nombreVia;
    }

    public Integer getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Integer idDireccion) {
        this.idDireccion = idDireccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Empleado getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Empleado idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreVia() {
        return nombreVia;
    }

    public void setNombreVia(String nombreVia) {
        this.nombreVia = nombreVia;
    }

    public CodPos getCp() {
        return cp;
    }

    public void setCp(CodPos cp) {
        this.cp = cp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDireccion != null ? idDireccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmpleadoDireccion)) {
            return false;
        }
        EmpleadoDireccion other = (EmpleadoDireccion) object;
        if ((this.idDireccion == null && other.idDireccion != null) || (this.idDireccion != null && !this.idDireccion.equals(other.idDireccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.iesvdc.acceso.zapateria.gestionzapateria.EmpleadoDireccion[ idDireccion=" + idDireccion + " ]";
    }
    
}
