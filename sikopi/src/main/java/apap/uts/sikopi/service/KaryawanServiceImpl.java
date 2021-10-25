package apap.uts.sikopi.service;

import apap.uts.sikopi.model.KaryawanModel;
import apap.uts.sikopi.repository.KaryawanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class KaryawanServiceImpl implements KaryawanService{

    @Autowired
    KaryawanRepository karyawanRepository;

    @Override
    public List<KaryawanModel> getListKaryawan() { return karyawanRepository.findAll(); }

    @Override
    public void addKaryawan(KaryawanModel karyawan) {
        karyawanRepository.save(karyawan);
    }

    @Override
    public KaryawanModel getKaryawanByNip(String nip) {
        Optional<KaryawanModel> karyawan = karyawanRepository.findKaryawanByNip(nip);
        if (karyawan.isPresent()) {
            return karyawan.get();
        }
        return null;
    }

    @Override
    public void updateKaryawan(KaryawanModel karyawan) {
        karyawanRepository.save(karyawan);
    }
}

