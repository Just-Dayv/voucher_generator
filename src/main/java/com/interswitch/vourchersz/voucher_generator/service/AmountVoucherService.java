package com.interswitch.vourchersz.voucher_generator.service;

import com.interswitch.vourchersz.voucher_generator.Exception.RequestRejectedException;
import com.interswitch.vourchersz.voucher_generator.dao.AmountVoucherDao;
import com.interswitch.vourchersz.voucher_generator.model.AmountVoucher;
import com.interswitch.vourchersz.voucher_generator.model.Voucher;
import com.interswitch.vourchersz.voucher_generator.utils.UniqueCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Service
public class AmountVoucherService {

@Autowired
    private AmountVoucherDao amountVoucherDao;

    public List <AmountVoucher> createVoucher(String campaignName, double Amount, String clientId, Date expiryDate, long number ) {
        List<AmountVoucher> vouchers = new ArrayList<>();
        for (long i = 0; i < number; i++) {

            AmountVoucher voucher = new AmountVoucher();
            voucher.setVoucherCode(UniqueCodeGenerator.idGenerate());
            voucher.setCampaignName(campaignName);
            voucher.setAmount(Amount);
            voucher.setClientId(clientId);
            voucher.setExpiryDate(expiryDate);


        }

        return vouchers;
    }

    public void createAmountVoucher(int amount, AmountVoucher amountVoucher){
        amountVoucher.setAmount(amount);
        amountVoucherDao.create(amountVoucher);
    }



}
