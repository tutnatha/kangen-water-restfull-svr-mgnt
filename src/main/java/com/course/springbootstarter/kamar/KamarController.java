package com.course.springbootstarter.kamar;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("user")		//auth login user:mukesh/m123
public class KamarController {

    @Autowired
    private KamarService kamarService;

    @RequestMapping("/kamars")	//ok
    public List<Kamar> getAllKamars() {
        return kamarService.getAllKamars();
    }

    @RequestMapping("/kamars/{no}")	//ok
    public Kamar getKamar(@PathVariable String no) {
        return kamarService.getKamar(no);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/kamars")
    public void addKamar(@RequestBody Kamar kamar) {
        kamarService.addKamar(kamar);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateKamar/{no}")
    public void updateKamar(@RequestBody Kamar kamar, @PathVariable String no) {
        kamarService.updateKamar(no, kamar);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteKamar/{no}")
    public void deleteKamar(@PathVariable String no) {
        kamarService.deleteKamar(no);
    }

}
