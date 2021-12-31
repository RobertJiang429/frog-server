package com.frog.utils;

/**
 * 
 * @author Robert.Jiang
 * @date 2019年5月21日 下午6:11:02
 */
public class PageContext {
    private static ThreadLocal<Integer> pageSize = new ThreadLocal<>();
    private static ThreadLocal<Integer> pageIndex = new ThreadLocal<>();

    public static void setPageSize(int requestPageSize){
        pageSize.set(requestPageSize);
    }

    public static int getPageSize(){
        if(pageSize.get() == null) {
            return 10;
        }
        else {
            return pageSize.get();
        }
    }

    public static void setPageIndex(int requestPageIndex){
        pageIndex.set(requestPageIndex);
    }

    public static int getPageIndex(){
        if(pageIndex.get() == null){
            return 1;
        } else {
            return pageIndex.get();
        }
    }
}
