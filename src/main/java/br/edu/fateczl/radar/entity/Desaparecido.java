package br.edu.fateczl.radar.entity;

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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "nome_completo")
    private String nomeCompletoDesaparecido;

    @Column(name = "desaparecimento")
    private String dataEHoraDesaparecimento;

    @Column(name = "data_de_nascimento")
    private String dataDeNascimento;

    @Column(name = "recompensa")
    private String recompensa;

    @Column(name = "url_foto_principal")
    private String urlFotoPrincipal;

    @Column(name = "alt_txt_foto_principal")
    private String altTxtFotoPrincipal;

    @Column(name = "descricao_desaparecimento")
    private String descricaoDesaparecimento;

    @Column(name = "doenca")
    private String doenca;

    @Column(name = "sexo")
    private String sexo;

    @Column(name = "cor_de_pele")
    private String corDePele;

    @JsonIgnore
    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "fotos_desaparecidos", joinColumns = @JoinColumn(name = "desaparecido_id"))
    @Column(name = "fotos_id")
    private List<String> fotos;

    @JsonIgnore
    @ManyToOne(cascade = { CascadeType.MERGE })
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    //private Long desaparecidoId;
}
