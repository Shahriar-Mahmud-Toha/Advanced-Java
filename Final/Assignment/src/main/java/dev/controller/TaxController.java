package dev.controller;

import dev.domain.Cost;
import dev.service.TaxService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.SQLException;

@Controller
public class TaxController {

    private TaxService taxService;

    public TaxController(TaxService taxService) {
        this.taxService = taxService;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder, HttpServletRequest request) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @RequestMapping("/tax/calculate")
    public String CalculateTax(@Valid @ModelAttribute("cost") Cost cost, BindingResult bindingResult, Model model) throws SQLException {
        if (bindingResult.hasErrors()) {
            return "Input";
        }
        else {
            int tax = taxService.totalTax(cost);
            model.addAttribute("tax", tax);
            return "viewTax";
        }
    }
    @RequestMapping("/tax")
    public String ViewInputForm(Model model) throws SQLException {
        model.addAttribute("cost", new Cost());
        return "Input";
    }
}
