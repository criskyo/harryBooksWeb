package co.com.harrybooksweb.model;
// Generated 16/09/2017 02:12:55 PM by Hibernate Tools 4.3.1


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Venta generated by hbm2java
 */
@Entity
@Table(name="venta"
    ,catalog="harrybooksbd"
)
public class Venta  implements java.io.Serializable {


     private Integer idVenta;
     private Integer idUsuario;
     private Integer idLibro;
     private Date fechaVenta;
     private String cantidadLibro;
     private Double totalLibro;

    public Venta() {
    }

	
    public Venta(Integer idVenta) {
        this.idVenta = idVenta;
    }
    public Venta(Integer idVenta, Integer idUsuario, Integer idLibro, Date fechaVenta, String cantidadLibro, Double totalLibro) {
       this.idVenta = idVenta;
       this.idUsuario = idUsuario;
       this.idLibro = idLibro;
       this.fechaVenta = fechaVenta;
       this.cantidadLibro = cantidadLibro;
       this.totalLibro = totalLibro;
    }
   
     @Id 

    
    @Column(name="id_venta", unique=true, nullable=false)
    public Integer getIdVenta() {
        return this.idVenta;
    }
    
    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    
    @Column(name="id_usuario")
    public Integer getIdUsuario() {
        return this.idUsuario;
    }
    
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    
    @Column(name="id_libro")
    public Integer getIdLibro() {
        return this.idLibro;
    }
    
    public void setIdLibro(Integer idLibro) {
        this.idLibro = idLibro;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_venta", length=19)
    public Date getFechaVenta() {
        return this.fechaVenta;
    }
    
    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    
    @Column(name="cantidad_libro", length=45)
    public String getCantidadLibro() {
        return this.cantidadLibro;
    }
    
    public void setCantidadLibro(String cantidadLibro) {
        this.cantidadLibro = cantidadLibro;
    }

    
    @Column(name="total_libro", precision=22, scale=0)
    public Double getTotalLibro() {
        return this.totalLibro;
    }
    
    public void setTotalLibro(Double totalLibro) {
        this.totalLibro = totalLibro;
    }




}


