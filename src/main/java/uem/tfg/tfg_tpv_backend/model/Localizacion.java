package uem.tfg.tfg_tpv_backend.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Localizacion")
public class Localizacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Localizacion")
    private Long ID_Localizacion;
    @Column(name = "PasilloTienda")
    private String PasilloTienda;
    @Column(name = "EstanteriaTienda")
    private String EstanteriaTienda;
    @Column(name = "PasilloAlmacen")
    private String PasilloAlmacen;
    @Column(name = "EstanteriaAlmacen")
    private String EstanteriaAlmacen;

    @OneToMany(mappedBy = "localizacion", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Producto> productos;

    public Long getID_Localizacion() {
        return ID_Localizacion;
    }

    public void setID_Localizacion(Long idLocalizacion) {
        this.ID_Localizacion = idLocalizacion;
    }

    public String getPasilloTienda() {
        return PasilloTienda;
    }

    public void setPasilloTienda(String pasilloTienda) {
        this.PasilloTienda = pasilloTienda;
    }

    public String getEstanteriaTienda() {
        return EstanteriaTienda;
    }

    public void setEstanteriaTienda(String estanteriaTienda) {
        this.EstanteriaTienda = estanteriaTienda;
    }

    public String getPasilloAlmacen() {
        return PasilloAlmacen;
    }

    public void setPasilloAlmacen(String pasilloAlmacen) {
        this.PasilloAlmacen = pasilloAlmacen;
    }

    public String getEstanteriaAlmacen() {
        return EstanteriaAlmacen;
    }

    public void setEstanteriaAlmacen(String estanteriaAlmacen) {
        this.EstanteriaAlmacen = estanteriaAlmacen;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }
}
