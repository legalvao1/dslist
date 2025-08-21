package com.devsuperior.dslist.dto;

public class ReplacementDTO {
    private Integer sourceIndex;
    private Integer destIndex;

    public ReplacementDTO() {
    }

    public ReplacementDTO(Integer sourceIndex, Integer destIndex) {
        this.sourceIndex = sourceIndex;
        this.destIndex = destIndex;
    }

    public Integer getSourceIndex() {
        return sourceIndex;
    }

    public void setSourceIndex(Integer sourceIndex) {
        this.sourceIndex = sourceIndex;
    }

    public Integer getDestIndex() {
        return destIndex;
    }

    public void setDestIndex(Integer destIndex) {
        this.destIndex = destIndex;
    }
}
