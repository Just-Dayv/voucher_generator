package com.interswitch.vourchersz.voucher_generator.controller;


import com.interswitch.vourchersz.voucher_generator.controller.model.Response;
import com.interswitch.vourchersz.voucher_generator.controller.model.VoucherRequest;
import com.interswitch.vourchersz.voucher_generator.service.AmountVoucherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/")
public class VoucherController {

    @Autowired
    private AmountVoucherService amountVoucherService;


    @PostMapping("createAmountVoucher")
    @ResponseStatus(HttpStatus.CREATED)
    public Response createAmountVoucher (@RequestBody @Validated final VoucherRequest request){

        amountVoucherService.createVoucher(request.getCampaignName(),request.getAmount(),request.getClientId(),
                request.getExpiryDate(),request.getNumber());
        Response response = new Response("201","created",null);
        return response;
    }
}
