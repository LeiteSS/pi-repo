package br.edu.fateczl.radar.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Foto {

    private String urlFoto;

    private String altTxtFoto;
}
