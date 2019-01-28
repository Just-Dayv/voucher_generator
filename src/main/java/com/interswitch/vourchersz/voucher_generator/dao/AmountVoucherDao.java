package com.interswitch.vourchersz.voucher_generator.dao;

import com.interswitch.vourchersz.voucher_generator.model.AmountVoucher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class AmountVoucherDao extends AbstractBaseDao {
    @Override
    public void setDataSource(@Qualifier(value = "dataSource") DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
        create = new SimpleJdbcCall(dataSource).withProcedureName("uspCreateAmountVoucher").withReturnValue();
        update = new SimpleJdbcCall(jdbcTemplate).withProcedureName("uspCreateAmountVoucher").withReturnValue();
        find = new SimpleJdbcCall(jdbcTemplate).withProcedureName("checkIfVoucherExists")
                .returningResultSet(SINGLE_RESULT, new BeanPropertyRowMapper<>(AmountVoucher.class));
     }


}
