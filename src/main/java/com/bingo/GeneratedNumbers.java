package com.bingo;

import java.util.List;

public class GeneratedNumbers {
    private List<Integer> generated;
    private Integer total;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Integer> getGenerated() {
        return generated;
    }

    public void setGenerated(List<Integer> generated) {
        this.generated = generated;
        this.total = generated.size();
    }
}
