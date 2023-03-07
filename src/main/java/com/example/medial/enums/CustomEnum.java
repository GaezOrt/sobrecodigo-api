package com.example.medial.enums;

public interface CustomEnum {

    int getIntId();

    default Long getLongId() {
        return (long) getIntId();
    }

    default int getIndexId(){
        return getIntId()-1;
    }
}
