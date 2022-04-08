package com.hjl.compiler;

import com.google.auto.service.AutoService;
import com.hjl.zrouter.annotation.Route;
import com.hjl.zrouter.annotation.RouteMeta;
import com.squareup.javapoet.ClassName;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
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
import javax.tools.Diagnostic;

import static com.hjl.compiler.Constant.*;
import static javax.lang.model.element.Modifier.PUBLIC;


/**
 * author: long
 * description please add a description here
 * Date: 2021/12/21
 */
@AutoService(Processor.class)
public class ZRouterCompiler extends AbstractProcessor {

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

    // Module name, maybe its 'app' or others
    String moduleName = null;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        mElementUtils = processingEnv.getElementUtils();
        mTypeUtils = processingEnv.getTypeUtils();
        mFiler = processingEnv.getFiler();
        mMessager = processingEnv.getMessager();


        //通过 key 获取 build.gradle 中对应的 value
//        processingEnv.getOptions().get("KeyValue");

        // Attempt to get user configuration [moduleName]
        Map<String, String> options = processingEnv.getOptions();
        if (MapUtils.isNotEmpty(options)) {
            moduleName = options.get(KEY_MODULE_NAME);
        }

        if (StringUtils.isNotEmpty(moduleName)) {
            moduleName = moduleName.replaceAll("[^0-9a-zA-Z_]+", "");

            mMessager.printMessage(Diagnostic.Kind.NOTE,"The user has configuration the module name, it was [" + moduleName + "]");
        } else {
            mMessager.printMessage(Diagnostic.Kind.ERROR,"NO_MODULE_NAME");
            throw new RuntimeException("ZRouter::Compiler >>> No module name, for more information, look at gradle log.");
        }

    }


    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        if (CollectionUtils.isEmpty(annotations)) {
            return false;
        }

        List<Element> elementList = new ArrayList<>(roundEnv.getElementsAnnotatedWith(Route.class));
        Map<Element,RouteMeta> metaMap = new HashMap<>();


       try {
           // build RouteMeta
           for (Element element : elementList){
               System.out.println("ele:" + element.getSimpleName());
               RouteMeta routeMeta = new RouteMeta();
               Route annotation = element.getAnnotation(Route.class);
               routeMeta.setPath(annotation.path());
               routeMeta.setExtra(annotation.extras());
               routeMeta.setPriority(annotation.priority());
               metaMap.put(element,routeMeta);
           }

           MethodSpec.Builder loadPluginMethodBuilder = Utils.getLoadPluginMethodBuilder();

           for (Map.Entry<Element,RouteMeta> entry : metaMap.entrySet()){
               RouteMeta routeMeta = entry.getValue();
               Element element = entry.getKey();

               loadPluginMethodBuilder.addStatement("data.add(new $T($T.class,$S,$S," +
                       routeMeta.getPriority()+ "," + routeMeta.getExtra()+ "))",
                       CLS_ROUTE_META,
                       ClassName.get((TypeElement) element),
                       routeMeta.getPath(),
                       routeMeta.getGroup()
               );

           }


           String fileName = PREFIX_CLASS_NAME + moduleName;
           System.out.println("ready to generate file:" + fileName);
           JavaFile.builder(PACKAGE_OF_GENERATE_FILE,
                   TypeSpec.classBuilder(fileName)
                           .addJavadoc(FILE_TIP)
                           .addSuperinterface(CLS_ROUTER_ACQUIRER)
                           .addModifiers(PUBLIC)
                           .addMethod(loadPluginMethodBuilder.build())
                           .build()
           ).addFileComment(FILE_TIP).build().writeTo(mFiler);




       }catch (Exception e){
           e.printStackTrace();
           System.out.println("=====build route error =====");
       }

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
        hashSet.add(Route.class.getCanonicalName());
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
