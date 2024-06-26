package co.edu.icesi.viajes.domain;
import co.edu.icesi.viajes.dto.ClienteDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.Date;
@NamedNativeQueries({
        @NamedNativeQuery( name = "Cliente.consultarClientesPorNombre",
                query = "",
                resultSetMapping = "Cliente.consultarClientesPorNombre"
        ),
        @NamedNativeQuery( name = "Cliente.consultarPorTipoID",
                query = "",
                resultSetMapping = "Cliente.consultarPorTipoID"
        )
})

@SqlResultSetMappings({
        @SqlResultSetMapping(
                name = "Cliente.consultarClientesPorNombre",
                classes = { @ConstructorResult(targetClass = ClienteDTO.class,
                        columns = {
                                @ColumnResult(name = "numero_identificacion", type = String.class),
                                @ColumnResult(name = "primer_apellido", type = String.class),
                                @ColumnResult(name = "segundo_apellido", type = String.class),
                                @ColumnResult(name = "nombre", type = String.class),
                                @ColumnResult(name = "estado", type = String.class),
                                @ColumnResult(name = "id_tiid", type = Integer.class),
                        })

                }
        ),
        @SqlResultSetMapping(
                name = "Cliente.consultarPorTipoID",
                classes = { @ConstructorResult(targetClass = ClienteDTO.class,
                        columns = {
                                @ColumnResult(name = "id_clie", type = Integer.class),
                                @ColumnResult(name = "numero_identificacion", type = String.class),
                                @ColumnResult(name = "nombreClie", type = String.class),
                                @ColumnResult(name = "primer_apellido", type = String.class),
                                @ColumnResult(name = "nombreID", type = String.class),
                        })

                }
        ),
        @SqlResultSetMapping(
                name = "Cliente.consultarPlanYDetallePlan",
                classes = { @ConstructorResult(targetClass = ClienteDTO.class,
                        columns = {
                                @ColumnResult(name = "cliente_nombre", type = String.class),
                                @ColumnResult(name = "alimentacion", type = String.class),
                                @ColumnResult(name = "hospedaje", type = String.class),
                                @ColumnResult(name = "transporte", type = String.class),
                                @ColumnResult(name = "plan_codigo", type = String.class),
                                @ColumnResult(name = "plan_descripcion", type = String.class),
                        })

                }
        )

})

@Data
@Entity
@Table(name = "cliente")
public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_clie")
    private Integer idClie;

    @Column(name = "numero_identificacion")
    @NotBlank(message = "Numero de identificación es obligatorio")
    private String numeroIdentificacion;

    @Column(name = "primer_apellido")
    @NotBlank(message = "Primer apellido es obligatorio")
    private String primerApellido;

    @Column(name = "segundo_apellido")
    private String segundoApellido;

    @Column(name = "nombre")
    @NotBlank(message = "Nombre es obligatorio")
    private String nombre;

    @Column(name = "telefono1")
    private String telefono1;

    @Column(name = "telefono2")
    private String telefono2;

    @Column(name = "correo")
    @Email(message = "Correo debe ser un correo electrónico válido")
    private String correo;

    @Column(name = "sexo")
    @NotNull(message = "Sexo es obligatorio")
    private String sexo;

    @Column(name = "fecha_nacimiento")
    @NotNull(message = "Fecha de nacimiento es obligatoria")
    private Date fechaNacimiento;

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

    @Column(name = "id_tiid")
    @NotNull(message = "ID de tipo de identificación es obligatorio")
    private Integer idTiid;


}
