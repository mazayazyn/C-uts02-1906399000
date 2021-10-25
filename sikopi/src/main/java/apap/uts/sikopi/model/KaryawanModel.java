package apap.uts.sikopi.model;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Setter @Getter
@Table(name = "karyawan")
@EqualsAndHashCode

public class KaryawanModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 16)
    @Column(name = "nip",nullable = false, unique = true)
    private String nip;

    @NotNull
    @Size(max = 50)
    @Column(name = "nama",nullable = false)
    private String nama;

    @NotNull
    @Column(name = "jenis_kelamin",nullable = false)
    private Integer jenisKelamin;

    @NotNull
    @Column(name = "tanggal_lahir",nullable = false)
    @DateTimeFormat(pattern ="yyyy-MM-dd")
    private LocalDate tanggalLahir;

    @Size(max = 100)
    @Column(name = "alamat", nullable = true)
    private String alamat;

    @Size(max = 20)
    @Column(name = "no_hp", nullable = true)
    private String noHp;

    @Size(max = 50)
    @Column(name = "spesialisasi", nullable = true)
    private String spesialisasi;

    @Column(name = "status",nullable = false)
    private Integer status;

}


