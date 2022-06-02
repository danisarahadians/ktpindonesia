/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praktikum.ktp;

import dummy.Dummy;
import dummy.DummyJpaController;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.view.RedirectView;
import praktikum.ktp.exceptions.NonexistentEntityException;

/**
 *
 * @author danisarahadians
 */
@Controller
public class DataController {

    DataJpaController datactrl = new DataJpaController();
    List<Data> newdata = new ArrayList<>();
    DummyJpaController dummyCtrl = new DummyJpaController();
    List<Dummy> data = new ArrayList<>();

    @RequestMapping("/read")
    public String getDummy(Model m) {
        try {
            data = dummyCtrl.findDummyEntities();

        } catch (Exception e) {

        }
        m.addAttribute("data", data);
        return "dummy";
    }

    @GetMapping("/data")
    //@ResponseBody
    public String getDataKTP(Model model) {
        int record = datactrl.getDataCount();
        String result = "";
        try {
            newdata = datactrl.findDataEntities().subList(0, record);
        } catch (Exception e) {
            result = e.getMessage();
        }
        model.addAttribute("goData", newdata);
        model.addAttribute("record", record);

        return "db";
    }

    @RequestMapping("/detail")
    public String getDetail() {
        return "detail";
    }

    @RequestMapping("/main")
    public String getMain() {
        return "menu";
    }

    @GetMapping("/hapus/{id}")
    //@ResponseBody
    public String delete(@PathVariable(value = "id") long id) throws NonexistentEntityException {
//        this.datacts.deleteById(id);
        datactrl.destroy(id);
        return "redirect:/data";
    }

    @RequestMapping("/buat")
    public String create() {
        return "buat";
    }

    @PostMapping(value = "/buatdata", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public RedirectView newDummyData(@RequestParam("gambar") MultipartFile f, Model m, HttpServletRequest r)
            throws ParseException, Exception {
        Data d = new Data();

        long id = Integer.parseInt(r.getParameter("id"));
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(r.getParameter("tgllahir"));
        byte[] img = f.getBytes();

        String noktp = r.getParameter("noktp");
        String nama = r.getParameter("nama");
        String jk = r.getParameter("jeniskelamin");
        String alamat = r.getParameter("alamat");
        String agama = r.getParameter("agama");
        String status = r.getParameter("status");
        String pekerjaan = r.getParameter("pekerjaan");
        String warganegara = r.getParameter("warganegara");
        String berlaku = r.getParameter("berlakuhingga");

        d.setId(id);
        d.setNoktp(noktp);
        d.setNama(nama);
        d.setTgllahir(date);
        d.setJeniskelamin(jk);
        d.setAlamat(alamat);
        d.setAgama(agama);
        d.setStatus(status);
        d.setPekerjaan(pekerjaan);
        d.setWarganegara(warganegara);
        d.setBerlakuhingga(berlaku);
        d.setFoto(img);

        datactrl.create(d);
        return new RedirectView("/data");
    }

    @RequestMapping(value = "/img", method = RequestMethod.GET, produces = {
        MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE
    })
    public ResponseEntity<byte[]> getImg(@RequestParam("id") long id) throws Exception {
        Data d = datactrl.findData(id);
        byte[] img = d.getFoto();
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(img);
    }
//    @Bean(name = "multipartResolver")
//    public CommonsMultipartResolver multipartResolver() {
//        CommonsMultipartResolver multipartResolver = new 
//        CommonsMultipartResolver();
//        multipartResolver.setMaxUploadSize(1000000000);
//        return multipartResolver;
//      }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public String deleteDummy(@PathVariable("id") int id) throws Exception {
        dummyCtrl.destroy(id);
        return "deleted";
    }

    @RequestMapping("/edit/{id}")
    public String updateDummy(@PathVariable("id") int id, Model m) throws Exception {
        Dummy d = dummyCtrl.findDummy(id);
        m.addAttribute("data", d);
        return "dummy/update";
    }

    @PostMapping(value = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @ResponseBody
    public String updateDummyData(@RequestParam("gambar") MultipartFile f, HttpServletRequest r)
            throws ParseException, Exception {
        Dummy d = new Dummy();

        int id = Integer.parseInt(r.getParameter("id"));
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(r.getParameter("tanggal"));
        byte[] img = f.getBytes();
        d.setId(id);
        d.setTanggal(date);
        d.setGambar(img);

        dummyCtrl.edit(d);
        return "updated";

    }
}
