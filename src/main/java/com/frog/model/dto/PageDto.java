package com.frog.model.dto;

import java.util.List;

/**
 * 
 * @author Robert.Jiang
 * @date 2019年5月21日 下午6:14:44
 */
public class PageDto<E> {
    private Integer pageSize;
    private Integer pageIndex;
    private Long total;
    private List<E> eList;

    public PageDto(List<E> eList, int pageSize, int pageIndex, long total){
        this.eList = eList;
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<E> geteList() {
        return eList;
    }

    public void seteList(List<E> eList) {
        this.eList = eList;
    }
}