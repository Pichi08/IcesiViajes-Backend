package co.edu.icesi.viajes.domain;
import co.edu.icesi.viajes.dto.DestinoDTO;
import co.edu.icesi.viajes.dto.PlanDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Plan.consultarTodosPlanesImagenes",
                query = "",
                resultSetMapping = "Plan.consultarTodosPlanesImagenes"
        ),

        @NamedNativeQuery(
                name = "Plan.consultaPlanPorCriterios",
                query = "",
                resultSetMapping = "Plan.consultaPlanPorCriterios"
        )
})
@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "Plan.consultarTodosPlanesImagenes",
                classes = {
                        @ConstructorResult(
                                targetClass = PlanDTO.class,
                                columns = {
                                        @ColumnResult(name = "nombre", type = String.class),
                                        @ColumnResult(name = "url", type = String.class),
                                        @ColumnResult(name = "id_plan", type = Integer.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "Plan.consultarPlanesBusqueda",
                classes = {
                        @ConstructorResult(
                                targetClass = PlanDTO.class,
                                columns = {
                                        @ColumnResult(name = "idPlan", type = Integer.class),
                                        @ColumnResult(name = "nombre_plan", type = String.class),
                                        @ColumnResult(name = "nombre_destino", type = String.class),
                                        @ColumnResult(name = "fecha_inicio_viaje", type = Date.class),
                                        @ColumnResult(name = "fecha_fin_viaje", type = Date.class),
                                        @ColumnResult(name = "cantidad_personas", type = Integer.class),
                                        @ColumnResult(name = "valor_total", type = Double.class),
                                        @ColumnResult(name = "url_img", type = String.class)
                                }
                        )
                }

        ),
        @SqlResultSetMapping(
                name = "Plan.consultarPlanesFechasBusqueda",
                classes = {
                        @ConstructorResult(
                                targetClass = PlanDTO.class,
                                columns = {
                                        @ColumnResult(name = "idPlan", type = Integer.class),
                                        @ColumnResult(name = "nombre_plan", type = String.class),
                                        @ColumnResult(name = "nombre_destino", type = String.class),
                                        @ColumnResult(name = "fecha_inicio_viaje", type = Date.class),
                                        @ColumnResult(name = "fecha_fin_viaje", type = Date.class),
                                        @ColumnResult(name = "cantidad_personas", type = Integer.class),
                                        @ColumnResult(name = "valor_total", type = Double.class),
                                        @ColumnResult(name = "url_img", type = String.class)
                                }
                        )
                }

        ),
        @SqlResultSetMapping(
                name = "Plan.consultarPlanesYPersonasBusqueda",
                classes = {
                        @ConstructorResult(
                                targetClass = PlanDTO.class,
                                columns = {
                                        @ColumnResult(name = "idPlan", type = Integer.class),
                                        @ColumnResult(name = "nombre_plan", type = String.class),
                                        @ColumnResult(name = "nombre_destino", type = String.class),
                                        @ColumnResult(name = "fecha_inicio_viaje", type = Date.class),
                                        @ColumnResult(name = "fecha_fin_viaje", type = Date.class),
                                        @ColumnResult(name = "cantidad_personas", type = Integer.class),
                                        @ColumnResult(name = "valor_total", type = Double.class),
                                        @ColumnResult(name = "url_img", type = String.class)
                                }
                        )
                }

        ),
        @SqlResultSetMapping(
                name = "Plan.consultarPlanesYFechasYPersonasBusqueda",
                classes = {
                        @ConstructorResult(
                                targetClass = PlanDTO.class,
                                columns = {
                                        @ColumnResult(name = "idPlan", type = Integer.class),
                                        @ColumnResult(name = "nombre_plan", type = String.class),
                                        @ColumnResult(name = "nombre_destino", type = String.class),
                                        @ColumnResult(name = "fecha_inicio_viaje", type = Date.class),
                                        @ColumnResult(name = "fecha_fin_viaje", type = Date.class),
                                        @ColumnResult(name = "cantidad_personas", type = Integer.class),
                                        @ColumnResult(name = "valor_total", type = Double.class),
                                        @ColumnResult(name = "url_img", type = String.class)
                                }
                        )
                }

        ),
        @SqlResultSetMapping(
                name = "Plan.consultarPotencialAsesores",
                classes = {
                        @ConstructorResult(
                                targetClass = PlanDTO.class,
                                columns = {
                                        @ColumnResult(name = "usu_creador",type = String.class),
                                        @ColumnResult(name = "cantidad_planes",type = Integer.class),
                                        @ColumnResult(name = "potencial_ventas",type = Long.class),


                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "Plan.consultarTotalVentas",
                classes = {
                        @ConstructorResult(
                                targetClass = PlanDTO.class,
                                columns = {
                                        @ColumnResult(name = "total_ventas",type = Long.class)
                                }
                        )
                }
        ),
        @SqlResultSetMapping(
                name = "Plan.consultarVentasReales",
                classes = {
                        @ConstructorResult(
                                targetClass = PlanDTO.class,
                                columns = {
                                        @ColumnResult(name = "total_ventas", type = Long.class)
                                }
                        )
                }
        )

})


@Data
@Entity
@Table(name="plan")
@JsonIgnoreProperties(value = {"usuario"}, allowSetters = true)
public class Plan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plan")
    private Integer idPlan;

    @Column(name = "codigo")
    @NotBlank(message = "Código es obligatorio")
    private String codigo;

    @Column(name = "descripcion_solicitud")
    @NotBlank(message = "Descripción de la solicitud es obligatoria")
    private String descripcionSolicitud;

    @Column(name = "nombre")
    @NotBlank(message = "Nombre es obligatorio")
    private String nombre;

    @Column(name = "cantidad_personas")
    @NotNull(message = "Cantidad de personas es obligatoria")
    private Integer cantidadPersonas;

    @Column(name = "fecha_solicitud")
    @NotNull(message = "Fecha de solicitud es obligatoria")
    private Date fechaSolicitud;

    @Column(name = "fecha_inicio_viaje")
    private Date fechaInicioViaje;

    @Column(name = "fecha_fin_viaje")
    private Date fechaFinViaje;

    @Column(name = "valor_total", columnDefinition = "numeric(19,2) default 0.00")
    @NotNull(message = "Valor total es obligatorio")
    private Double valorTotal;

    @Column(name = "fecha_creacion")
    @NotNull(message = "Fecha de creación es obligatoria")
    private Date fechaCreacion;

    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;

    @Column(name = "usu_creador")
    @NotBlank(message = "Usuario creador es obligatorio")
    private String usuCreador;

    @Column(name = "usu_modificador")
    private String usuModificador;

    @Column(name = "estado")
    @NotNull(message = "Estado es obligatorio")
    private String estado;

    /*
    @Column(name = "id_usua")
    @NotNull(message = "ID del usuario es obligatorio")
    private Integer idUsua;
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usua")
    @NotNull
    private Usuario usuario;
}
