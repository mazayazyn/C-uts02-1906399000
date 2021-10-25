package apap.uts.sikopi.controller;

import apap.uts.sikopi.model.KaryawanModel;
import apap.uts.sikopi.service.KaryawanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class KaryawanController {
    @Qualifier("karyawanServiceImpl")
    @Autowired
    private KaryawanService karyawanService;

    @GetMapping("/")
    public String getListKaryawan(Model model) {
        List<KaryawanModel> listKaryawan = karyawanService.getListKaryawan();
        model.addAttribute("listKaryawan", listKaryawan);
        return "home";
    }

    @GetMapping("/karyawan/{nip}")
    private String viewKaryawan(
            @PathVariable String nip,
            Model model
    ){
        KaryawanModel karyawanModel = karyawanService.getKaryawanByNip(nip);
        model.addAttribute("karyawan", karyawanModel);
        return "view-karyawan";
    }

    @GetMapping("/karyawan/add")
    public String addKaryawanForm(Model model) {
        model.addAttribute("karyawan", new KaryawanModel());
        return "form-add-karyawan";
    }

    @PostMapping("/karyawan/{nip}")
    private String addKaryawanSubmit(
            @ModelAttribute KaryawanModel karyawan,
            Model model
    ) {
        karyawanService.addKaryawan(karyawan);
        model.addAttribute("karyawan", karyawan);
        model.addAttribute("nip", karyawan.getNip());
        return "add-karyawan";
    }

    @GetMapping("/karyawan/update/{nip}")
    public String updateKaryawanForm(
            @PathVariable String nip,
            Model model
    ) {
        KaryawanModel karyawan = karyawanService.getKaryawanByNip(nip);
        model.addAttribute("karyawan", karyawan);
        model.addAttribute("nip", karyawan.getNip());
        return "form-update-karyawan";
    }

    @PostMapping("/karyawan/update")
    public String updateKaryawanSubmit(
            @ModelAttribute KaryawanModel karyawan,
            Model model
    ) {
        karyawanService.updateKaryawan(karyawan);
        model.addAttribute("nip", karyawan.getNip());
        model.addAttribute("karyawan", karyawan);
        return "update-karyawan";
    }
}


