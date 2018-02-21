package ph.edu.dlsu.securde.SECURDE_MP.controller;

import com.sun.media.sound.ModelMappedInstrument;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class URLController {

    @RequestMapping("/home")
    public String home(ModelMap model) {
        return "index";
    }
}
