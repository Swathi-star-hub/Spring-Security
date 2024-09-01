package com.example.BackendCrud.VO;

public class Response {
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMebId() {
        return mebId;
    }

    public void setMebId(Integer mebId) {
        this.mebId = mebId;
    }

    private Integer mebId;
    private String status;

}
