package duarte.wesley.banda.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString

@Entity
@Table(name= "musicos")
public class BandaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_musicos")
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "instrumento")
    private String instrumento;
}