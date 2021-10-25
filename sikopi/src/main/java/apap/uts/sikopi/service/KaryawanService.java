package apap.uts.sikopi.service;

import apap.uts.sikopi.model.KaryawanModel;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface KaryawanService {
    List<KaryawanModel> getListKaryawan();
    void addKaryawan(KaryawanModel karyawan);
    KaryawanModel getKaryawanByNip(String nip);
    void updateKaryawan(KaryawanModel karyawan);
}