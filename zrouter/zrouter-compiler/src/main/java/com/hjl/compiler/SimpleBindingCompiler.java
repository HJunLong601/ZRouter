package com.hjl.compiler;

import com.google.auto.service.AutoService;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

/**
 * author: long
 * description please add a description here
 * Date: 2021/7/2
 */
//@AutoService(Processor.class)
public class SimpleBindingCompiler extends AbstractProcessor {

    /**
     * 节点工具类（类、函数、属性都是节点）
     */
    private Elements mElementUtils;

    /**
     * 类信息工具类
     */
    private Types mTypeUtils;

    /**
     * 文件生成器
     */
    private Filer mFiler;

    /**
     * 日志信息打印器
     */
    private Messager mMessager;


    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        mElementUtils = processingEnv.getElementUtils();
        mTypeUtils = processingEnv.getTypeUtils();
        mFiler = processingEnv.getFiler();
        mMessager = processingEnv.getMessager();

        //通过 key 获取 build.gradle 中对应的 value
//        processingEnv.getOptions().get("KeyValue");

    }


    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {


        Map<TypeElement, List<Element>> bindClassMap = new LinkedHashMap<>();



//            TypeSpec file = bindingClassBuilder.build();
//            try {
//                JavaFile.builder("com.hjl.simpleBinding",file)
//                        .addFileComment("Generate by Simple Binding do not Motify")
//                        .build().writeTo(mFiler);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }



        return true;
    }

    /**
     * 接收外来传入的参数，最常用的形式就是在 build.gradle 脚本文件里的 javaCompileOptions 的配置
     *
     * @return 属性的 Key 集合
     */
    @Override
    public Set<String> getSupportedOptions() {
//        Set<String> hashSet = new LinkedHashSet<>();
//        hashSet.add("MODULE_NAME");
        return super.getSupportedOptions();
    }

    /**
     * 当前注解处理器支持的注解集合，如果支持，就会调用 process 方法
     *
     * @return 支持的注解集合
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> hashSet = new LinkedHashSet<>();
//        hashSet.add(BindView.class.getCanonicalName());
//        hashSet.add(BindClick.class.getCanonicalName());
        return hashSet;
    }

    /**
     * 编译当前注解处理器的 JDK 版本
     *
     * @return JDK 版本
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.RELEASE_8;
    }
}
