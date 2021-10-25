package apap.uts.sikopi.repository;

import apap.uts.sikopi.model.KaryawanModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface KaryawanRepository extends JpaRepository<KaryawanModel, Integer>{
    Optional<KaryawanModel> findKaryawanByNip(String nip);
}