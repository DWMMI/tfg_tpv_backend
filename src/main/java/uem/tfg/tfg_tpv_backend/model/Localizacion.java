package uem.tfg.tfg_tpv_backend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "localizacion")
public class Localizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_localizacion")
    private Long idLocalizacion;

    @Column(name = "pasillo_tienda")
    private String pasilloTienda;

    @Column(name = "estanteria_tienda")
    private String estanteriaTienda;

    @Column(name = "pasillo_almacen")
    private String pasilloAlmacen;

    @Column(name = "estanteria_almacen")
    private String estanteriaAlmacen;

    @OneToMany(mappedBy = "localizacion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Producto> productos = new ArrayList<>();

    // Getters y Setters

    public Long getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(Long idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public String getPasilloTienda() {
        return pasilloTienda;
    }

    public void setPasilloTienda(String pasilloTienda) {
        this.pasilloTienda = pasilloTienda;
    }

    public String getEstanteriaTienda() {
        return estanteriaTienda;
    }

    public void setEstanteriaTienda(String estanteriaTienda) {
        this.estanteriaTienda = estanteriaTienda;
    }

    public String getPasilloAlmacen() {
        return pasilloAlmacen;
    }

    public void setPasilloAlmacen(String pasilloAlmacen) {
        this.pasilloAlmacen = pasilloAlmacen;
    }

    public String getEstanteriaAlmacen() {
        return estanteriaAlmacen;
    }

    public void setEstanteriaAlmacen(String estanteriaAlmacen) {
        this.estanteriaAlmacen = estanteriaAlmacen;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
    // ...
}