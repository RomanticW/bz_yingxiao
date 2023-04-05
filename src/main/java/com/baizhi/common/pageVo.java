package com.baizhi.common;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author dongHua
 * @create 2022/12/27 17:19
 * FileName: Result
 */
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class pageVo {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Integer total;
    private Object list;

    public Integer getPageNum() {
        return pageNum;
    }

    public pageVo setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public pageVo setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public pageVo setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
        return this;
    }

    public Integer getTotal() {
        return total;
    }

    public pageVo setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Object getList() {
        return list;
    }

    public pageVo setList(Object list) {
        this.list = list;
        return this;
    }
}
