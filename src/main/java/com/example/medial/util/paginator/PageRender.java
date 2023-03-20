package com.example.medial.util.paginator;

import org.springframework.data.domain.Page;

import java.util.ArrayList;
import java.util.List;

public class PageRender <T> {

    private String url;
    private Page<T> page;
    private int numTotalPaginas;
    private int numElemPaginas;
    private int pagActual;

    private List<PageItem> paginas;

    public PageRender(String url, Page<T> page) {
        this.url = url;
        this.page = page;
        this.paginas = new ArrayList<PageItem>();

        numElemPaginas = page.getSize();
        numTotalPaginas = page.getTotalPages();
        pagActual = page.getNumber() + 1;


        int desde, hasta;

        if(numTotalPaginas <= numElemPaginas){
            desde = 1;
            hasta = numTotalPaginas;

        }else {
            if(pagActual < numElemPaginas / 2){
                desde = 1;
                hasta = numElemPaginas;

            } else if(pagActual > numTotalPaginas - numElemPaginas / 2){
                desde = numTotalPaginas - numElemPaginas + 1;
                hasta = numTotalPaginas;
            }else{
                desde = pagActual - numTotalPaginas / 2;
                hasta = numElemPaginas;
            }
        }
        for (int i = 0; i < hasta; i++){
            paginas.add(new PageItem(desde + i, pagActual == desde + i));
        }
    }


    public String getUrl() {
        return url;
    }



    public int getNumTotalPaginas() {
        return numTotalPaginas;
    }


    public List<PageItem> getPaginas() {
        return paginas;
    }



    public int getPagActual() {
        return pagActual;
    }


    public boolean isHasNext(){
        return page.hasNext();
    }


    public boolean isHasPrevious(){
        return page.hasPrevious();
    }

    public boolean isFirst(){
        return page.isFirst();
    }

    public boolean isLast(){
        return page.isLast();
    }
}
