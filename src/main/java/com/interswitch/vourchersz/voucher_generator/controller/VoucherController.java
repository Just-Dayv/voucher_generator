package com.interswitch.vourchersz.voucher_generator.controller;


import com.interswitch.vourchersz.voucher_generator.controller.model.Response;
import com.interswitch.vourchersz.voucher_generator.service.AmountVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/")
public class VoucherController {

    @Autowired
    private AmountVoucherService amountVoucherService;


    public Response response (){

        return null;
    }
}
