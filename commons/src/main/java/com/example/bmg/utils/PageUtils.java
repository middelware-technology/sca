package com.example.bmg.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 分页工具类
 *
 * @param <T>
 */
public class PageUtils<T> {

    private Long currPage;//当前页面
    private Long pageSize; //页面大小
    private Long totalPage;//总页数
    private Long totalCount; //总条数
    private List<T> list; //查询的数据

    private Long numStart=1L;
    private Long numEnd;

    private List<Long> numbers = new ArrayList<Long>(); //存储序号

    public PageUtils() {
    }

    public PageUtils(Long page, Long limit, Long pageCount, Long totalCount, List<T> datas) {
        this.currPage = page;
        this.pageSize = limit;
        this.totalPage = pageCount;
        this.totalCount = totalCount;
        this.list = datas;

        //初始值
        // 一共显示10个页面 动态伸缩
        if (this.totalPage <= 10) {
            this.numStart = 1L;
            this.numEnd = pageCount;
        } else {
            this.numStart = page - 4;
            this.numEnd = page + 5;
            if (numStart < 1) {
                this.numStart = 1L;
                this.numEnd = 10L;
            } else if (numEnd > pageCount) {
                this.numEnd = pageCount;
                this.numStart = pageCount - 9;
            }
        }
        // 一共显示10个页面 动态伸缩
        for (long i = numStart; i <= numEnd; i++) {
            numbers.add(i);
        }
    }

    public List<Long> getNumbers() {
        return numbers;
    }

    public void setNumbers(List<Long> numbers) {
        this.numbers = numbers;
    }


    public Long getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Long currPage) {
        this.currPage = currPage;
    }

    public Long getPageSize() {
        return pageSize;
    }

    public void setPageSize(Long pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Long getNumStart() {
        return numStart;
    }

    public void setNumStart(Long numStart) {
        this.numStart = numStart;
    }

    public Long getNumEnd() {
        return numEnd;
    }

    public void setNumEnd(Long numEnd) {
        this.numEnd = numEnd;
    }

    @Override
    public String toString() {
        return "PageUtils{" +
                "currPage=" + currPage +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", list=" + list +
                ", numStart=" + numStart +
                ", numEnd=" + numEnd +
                ", numbers=" + numbers +
                '}';
    }
}
