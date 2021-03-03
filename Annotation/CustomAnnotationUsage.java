package com.mphasis.com.annotation;
@CustomAnnotation(duration = 2,name = "class",version = {1.1,1.2,1.3})
public class CustomAnnotationUsage {
    @CustomAnnotation(duration = 2,name = "variable",version = {1.1,1.2,1.3})
    int var;

    @CustomAnnotation(duration = 1,name = "constructor",version = {1.1,1.2,1.3})
    public CustomAnnotationUsage(){

    }
    @CustomAnnotation(duration = 2,name = "Method",version = {1.1,1.2,1.3})
    public void test(){
        @CustomAnnotation(name = "local variable",version = {1.1,1.2,1.3})

        int var;

    }
}
