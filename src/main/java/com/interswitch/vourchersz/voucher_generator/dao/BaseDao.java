package com.interswitch.vourchersz.voucher_generator.dao;

import java.util.List;

public interface BaseDao <T>{

    public T create (T model);

    public  boolean update (T model);

    public T find(String code);

    public List<T> findAll();

    public boolean isDisabled(T model);

}
