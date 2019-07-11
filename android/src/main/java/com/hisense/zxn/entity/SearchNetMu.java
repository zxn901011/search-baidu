package com.hisense.hibeans.search.searchnet;

import com.google.gson.annotations.SerializedName;

/**
 * Created by liudunjian on 2017/11/30.
 */

public class SearchNetMu {

    @SerializedName("fm")
    private String fm;
    private String ensrcid;
    private String order;
    private String mu;

    public String getEnsrcid() {
        return ensrcid;
    }

    public String getFm() {
        return fm;
    }

    public String getMu() {
        return mu;
    }

    public String getOrder() {
        return order;
    }

    public void setEnsrcid(String ensrcid) {
        this.ensrcid = ensrcid;
    }

    public void setFm(String fm) {
        this.fm = fm;
    }

    public void setMu(String mu) {
        this.mu = mu;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
