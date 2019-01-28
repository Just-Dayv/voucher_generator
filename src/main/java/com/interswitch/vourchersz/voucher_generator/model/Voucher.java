package com.interswitch.vourchersz.voucher_generator.model;

import java.sql.Date;

public abstract class Voucher {
    private long id;
    private String CampaignName;
    private String voucherCode;
    private boolean isDisabled;
    private String clientId;
    private Date expiryDate;


    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCampaignName() {
        return CampaignName;
    }

    public void setCampaignName(String campaignName) {
        this.CampaignName = campaignName;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public boolean isDisabled() {
        return isDisabled;
    }

    public void setDisabled(boolean disabled) {
        this.isDisabled = disabled;
    }
    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
