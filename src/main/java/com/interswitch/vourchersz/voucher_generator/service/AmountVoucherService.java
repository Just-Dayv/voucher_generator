package com.interswitch.vourchersz.voucher_generator.service;

import com.interswitch.vourchersz.voucher_generator.Exception.RequestRejectedException;
import com.interswitch.vourchersz.voucher_generator.dao.AmountVoucherDao;
import com.interswitch.vourchersz.voucher_generator.model.AmountVoucher;
import com.interswitch.vourchersz.voucher_generator.utils.UniqueCodeGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AmountVoucherService {

@Autowired
    private AmountVoucherDao amountVoucherDao;

    public AmountVoucher createVoucher (AmountVoucher voucher) {
        if (amountVoucherDao.find(voucher.getVoucherCode())== null) {

            voucher.setVoucherCode(UniqueCodeGenerator.idGenerate());
            return (AmountVoucher) amountVoucherDao.create(voucher);

        }
        throw new RequestRejectedException("Voucher Already Exists");
    }


}
