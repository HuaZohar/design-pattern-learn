package proxy.jdkproxy;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Proxy {
    public static Object newProxyInstance(Class interfac, InvocationHandler handler) {

        String methodStr = "";
        String rt = "\r\n";

        Method[] methods = interfac.getMethods();
        for (Method method : methods) {
            methodStr += "" +
                    "    @Override" + rt +
                    "    public void " + method.getName() + "() {" + rt +
                    "       try{" + rt +
                    "           Method m = " + interfac.getName() + ".class.getMethod(\"" + method.getName() + "\");" + rt +
                    "           handler.invoke(this,m);" + rt +
                    "       }catch(Exception ex){" + rt +
                    "           ex.printStackTrace();" + rt +
                    "       }" + rt +
                    "    }";
        }


        String src = "package cn.learn.jdkproxy;" + rt +
                "import java.lang.reflect.Method;" + rt +
                "public class TankTimeProxy implements " + interfac.getName() + " {" + rt +
                "    private cn.learn.jdkproxy.InvocationHandler handler;" + rt +
                "    public TankTimeProxy(cn.learn.jdkproxy.InvocationHandler handler) {" + rt +
                "        this.handler = handler;" + rt +
                "    }" + rt +
                methodStr + rt +
                "}";

        //需手动创建目录  JDK中可以生成二进制存在内存中
        String fileName = "d:/src/main/java/cn/learn/jdkproxy/TankTimeProxy.java";
        File file = new File(fileName);
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            fw.write(src);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fw.flush();
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //JAVA 的动态编译
        /**
         1、调用 ToolProvider的getSystemJavaCompiler()方法，返回JavaCompiler 
         2、使用JavaCompiler的getStandardFileManager(DiagnosticListener<? superJavaFileObject> diagnosticListener, Locale locale, Charset charset)方法，获取一个StandardJavaFileManager 
         3.把获取的StandardJavaFileManager传入 getTask(Writer out, JavaFileManager fileManager, DiagnosticListener<? super JavaFileObject> diagnosticListener, Iterable<String> options,Iterable<String> classes,Iterable<? extends JavaFileObject> compilationUnits) 方法获得 JavaCompiler.CompilationTask 
         4、激活task 即可 task.call();这样文件编译成功了，稍显麻烦。
         */
        StandardJavaFileManager fileManager = null;
        try {
            JavaCompiler javaCompiler = ToolProvider.getSystemJavaCompiler();
            fileManager = javaCompiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> iterable = fileManager.getJavaFileObjects(fileName);
            JavaCompiler.CompilationTask t = javaCompiler.getTask(null, fileManager, null, null, null, iterable);
            t.call();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileManager.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //load in memory and create an instance
        try {
            URL[] urls = new URL[]{new URL("file:/d:/src/main/java/")};
            //创建URL类加载器
            URLClassLoader urlClassLoader = new URLClassLoader(urls);
            //URL加载器加载指定的类（权限名）
            Class<?> aClass = urlClassLoader.loadClass("cn.learn.jdkproxy.TankTimeProxy");
            //通过Class获取构造函数 并指定构造参数类型
            Constructor<?> constructor = aClass.getConstructor(InvocationHandler.class);
            //调用构造函数对实例进行实例化
            Object o = constructor.newInstance(handler);
            return o;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }
}
