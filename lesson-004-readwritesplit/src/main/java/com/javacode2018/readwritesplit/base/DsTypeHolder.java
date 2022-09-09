package com.javacode2018.readwritesplit.base;

public class DsTypeHolder {
    private static ThreadLocal<DsType> dsTypeThreadLocal = new ThreadLocal<>();

    public static void setDsType(DsType dsType) {
        dsTypeThreadLocal.set(dsType);
    }

    public static void master() {
        setDsType(DsType.MASTER);
    }

    public static void slave() {
        setDsType(DsType.SLAVE);
    }

    public static DsType getDsType() {
        return dsTypeThreadLocal.get();
    }

}