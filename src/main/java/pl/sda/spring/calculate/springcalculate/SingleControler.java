package pl.sda.spring.calculate.springcalculate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller//singleton
public class SingleControler {

    @Autowired
    private Calculator calculator;

//    @RequestMapping(value = "/", method = RequestMethod.GET)
    @GetMapping(value = "/calculate")
    public String getCalculation(Model model){
        model.addAttribute("info","Cześć :P");
        return "calculatorForm";
    }
}

