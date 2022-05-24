package br.edu.fateczl.radar.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ElementCollection;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Desaparecido")
public class Desaparecido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_desaparecido")
    private Long id;

    @Column(name = "desaparecimento")
    private String dataEHoraDesaparecimento;

    @Column(name = "url_foto_principal")
    private String urlFotoPrincipal;

    @Column(name = "alt_txt_foto_principal")
    private String altTxtFotoPrincipal;

    @Column(name = "descricao_desaparecimento")
    private String descricaoDesaparecimento;

    @OneToMany(mappedBy = "desaparecido", fetch = FetchType.LAZY, cascade = CascadeType.MERGE, orphanRemoval = true)
    private List<Foto> fotos;

    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    private Long desaparecidoId;
}
