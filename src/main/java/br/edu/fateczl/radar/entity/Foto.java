package br.edu.fateczl.radar.entity;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Foto {

    private String urlFoto;

    private String altTxtFoto;
}
