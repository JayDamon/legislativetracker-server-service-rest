package com.protean.legislativetracker.legislativetrackerserverservicerest.controllers;

import com.protean.legislativetracker.legislativetrackerserverservicerest.repositories.BillRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/bills")
@Controller
public class BillController {

    private final BillRepository billRepository;

    public BillController(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    @RequestMapping("")
    public String getBillPage(Model model) {
        model.addAttribute("bills", billRepository.findAll());
        return "bills/bills";
    }
}
