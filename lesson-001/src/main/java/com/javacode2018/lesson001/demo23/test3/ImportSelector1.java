package com.javacode2018.lesson001.demo23.test3;


import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class ImportSelector1 implements DeferredImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{ConfigBean3.class.getName()};
    }
}
