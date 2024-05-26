package uem.tfg.tfg_tpv_backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

@Entity
@Table(name = "productos")
public class Producto {
    @Id
    @Column(name = "codigo_barra")
    private String codigoBarra;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "precio_venta")
    private double precioVenta;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "stock")
    private int stock;

    @Column(name = "precio_suministrador")
    private double precioSuministrador;

    @Column(name = "suministrador")
    private String suministrador;

    @Column(name = "ganancia")
    private double ganancia;

    @Column(name = "fecha_stock")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Europe/Madrid")
    private Date fechaStock;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "localizacion_id")
    @JsonIgnore
    private Localizacion localizacion;

    // Método para establecer la fecha automáticamente antes de persistir
    @PrePersist
    protected void onCreateOrUpdate() {
        if (this.fechaStock == null || this.ganancia == 0.0) {
            this.fechaStock = Date.from(ZonedDateTime.now(ZoneId.of("Europe/Madrid")).toInstant());
            this.ganancia = this.precioVenta - this.precioSuministrador;
        }
    }



    // Getters y Setters
    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecioSuministrador() {
        return precioSuministrador;
    }

    public void setPrecioSuministrador(double precioSuministrador) {
        this.precioSuministrador = precioSuministrador;
    }

    public String getSuministrador() {
        return suministrador;
    }

    public void setSuministrador(String suministrador) {
        this.suministrador = suministrador;
    }

    public double getGanancia() {
        return ganancia;
    }

    public void setGanancia(double ganancia) {
        this.ganancia = ganancia;
    }

    public Date getFechaStock() {
        return fechaStock;
    }

    public void setFechaStock(Date fechaStock) {
        this.fechaStock = fechaStock;
    }

    public Localizacion getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(Localizacion localizacion) {
        this.localizacion = localizacion;
    }
}
