package com.actas.ems.DTO.Elvlrt;

import java.util.ArrayList;
import java.util.List;

public class PagingResponse<T> {
    private List<T> list = new ArrayList<>();
    private Pagination pagination;

    public PagingResponse(List<T> list, Pagination pagination) {
        this.list = list;
        this.pagination = pagination;
    }
}
