package com.michjony.basic.javapoet;

import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import java.io.IOException;

/**
 * user:Cherie
 * datetime;2019/7/16 15:42
 */
public class GeneratorJava {

    public static void main(String[] args) {
        getClassFile();
        getMethod();
        getIf();
    }


    public static void getClassFile() {
        //生成类
        TypeSpec helloWorld = TypeSpec.classBuilder("HelloWorld").build();
        //Java文件生成
        JavaFile javaFile = JavaFile.builder("com.michjony.basic.javapoet", helloWorld).build();
        try {
            //把文件内容写入到 窗口打印出来
            javaFile.writeTo(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getMethod() {
        //生成类构造器
        TypeSpec.Builder helloWorldBuilder = TypeSpec.classBuilder("HelloWorld");

        // 其中$T代表类的.class类，使用$T和adddStatement匹配能自动导入包，$S表示注入字符串，adddStatement的一种注入字符串格式的语法，会自动帮语句添加分号和换行符，另外还有$L表示数字类型。
        MethodSpec main = MethodSpec.methodBuilder("main")//方法的构造器
                .addParameter(String[].class, "args")//添加参数
                .returns(void.class)//添加返回值
                .addStatement("$T.out.println($S)", System.class, "helloWorld")//添加内容
                .addStatement("$T.out.println($L)", System.class, 100L)//显示字符
                .build();

        TypeSpec helloWorld = helloWorldBuilder.addMethod(main).build();

        //Java文件生成
        JavaFile javaFile = JavaFile.builder("com.michjony.basic.javapoet", helloWorld).build();

        try {
            //把文件内容写入到 窗口打印出来
            javaFile.writeTo(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void getIf() {
        //生成类构造器
        TypeSpec.Builder helloWorldBuilder = TypeSpec.classBuilder("HelloWorld");
        MethodSpec main = MethodSpec.methodBuilder("main")//方法的构造器
                .addParameter(String[].class, "args")//添加参数
                .returns(void.class)//添加返回值
                .addStatement("$T.out.println($S)", System.class, "helloWorld")//添加内容
                .addStatement("$T.out.println($L)", System.class, 100L)//显示字符
                .beginControlFlow("if(true)")//控制流开始
                .addStatement("$T.out.println($S)", System.class, "ok")
                .endControlFlow()//控制流结束
                .build();
        TypeSpec helloWorld = helloWorldBuilder.addMethod(main).build();

        //Java文件生成
        JavaFile javaFile = JavaFile.builder("com.michjony.basic.javapoet", helloWorld).build();

        try {
            //把文件内容写入到 窗口打印出来
            javaFile.writeTo(System.out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
