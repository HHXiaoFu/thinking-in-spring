package com.alascanfu.spring.aop.overview;

/**
 * <p>
 * 类加载示例
 * </p>
 *
 * @author Fu JIAWEI
 * @since 2022/12/21 22:32
 **/
public class ClassLoadingDemo {
    public static void main(String[] args) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader); //sun.misc.Launcher$AppClassLoader@18b4aac2
        
        // 可以观察到在 sun.misc.Launcher 中一个静态类
        // static class AppClassLoader extends URLClassLoader {}
        // 继承了 URLClassLoader
        // 同时设置了 final String var1 = System.getProperty("java.class.path"); 路径
        
        // 双亲委派理解
        // 输出结果：
        // sun.misc.Launcher$AppClassLoader@18b4aac2
        // sun.misc.Launcher$ExtClassLoader@1b6d3586
        ClassLoader parentClassLoader = classLoader;
        while (true){
            parentClassLoader = parentClassLoader.getParent();
            if (parentClassLoader == null){
                break;
            }
            System.out.println(parentClassLoader);
        }
        // 当然我们反射 Class.java 中的 getDeclaredMethods 这个方法
        // 以及 Spring-core 中的 ClassVisitor
    }
}
