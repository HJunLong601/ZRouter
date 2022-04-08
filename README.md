## ZRouter

- ZRouter是仿造Arouter实现的一个轻量级路由框架，主要实现了路由查找与发现功能，用于组件化模块解耦，Arouter框架分析以及ZRouter实现参考 [组件化解耦 | 浅析ARouter路由发现原理与简单实践](https://blog.csdn.net/weixin_41802023/article/details/122204388?spm=1001.2014.3001.5501)

- 此项目剔除了其他所有业务功能，只关注了路由的发现和查找，demo实现了简单的一个渠道插件分发和登录
- 如果对您有帮助，可以点击右上角的“Star” 支持一下！感谢 ^_^
- ASM插桩模块可以参考ARouter的源码以及上面文章的实现，这里不做重复实现

## 使用

用法与Arouter基本一致，在各模块添加路由注解后,尽可能早的调用`ZRouter.getInstance().init(context)`初始化路由表，之后可以通过 `ZRouter.getInstance().getRouteMetaList()` 获取到所有信息，根据业务具体进行实现，其中Demo演示了获取渠道信息进行初始化等

### 配置模块名

- java模块

```groovy
android {
    ...
    javaCompileOptions {
            annotationProcessorOptions {
                arguments = [ZROUTER_MODULE_NAME: project.getName()]
            }
    }
}

dependencies {
    implementation project(':zrouter:zrouter-api')
    annotationProcessor project(':zrouter:zrouter-compiler')
}
```

- kotlin模块

```groovy
apply plugin: 'kotlin-kapt'

kapt {
    arguments {
        arg("ZROUTER_MODULE_NAME", project.getName())
    }
}

dependencies {
    implementation project(':zrouter:zrouter-api')
    kapt project(':zrouter:zrouter-compiler')
}
```

- 路由注解

```java
@Route(path = "/test/java")
public class TestJavaChannelAdapter implements IChannelAdapter {
   ...
}
```


## Demo

Demo实现了一个基于ZRouter简单的渠道登查找和分发，主要用于演示，实际使用可以根据业务具体实现，由于比较简单这里不做描述

## 感谢

感谢 [ARouter](https://github.com/alibaba/ARouter) 项目的启发和帮助

