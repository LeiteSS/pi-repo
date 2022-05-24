package br.edu.fateczl.radar.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "Foto")
public class Foto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long fotoId;

    private String urlFoto;

    private String altTxtFoto;

    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "desaparecido_id", nullable = false)
    private Desaparecido desaparecido;
}
