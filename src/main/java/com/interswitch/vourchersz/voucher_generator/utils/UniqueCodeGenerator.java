package com.interswitch.vourchersz.voucher_generator.utils;

import java.util.UUID;

public class UniqueCodeGenerator {

    public static String idGenerate() {
        UUID applicationKey = UUID.randomUUID();
        return applicationKey.toString();
    }

}
