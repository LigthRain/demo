package byteCode;

import javassist.*;

import java.io.IOException;


public class JavassistTest {
    public static void main(String[] args) throws NotFoundException,
            CannotCompileException, IllegalAccessException, InstantiationException, IOException {
        ClassPool cp = ClassPool.getDefault();
//        cp.insertClassPath(new ClassClassPath(Base.getClass()));
        CtClass cc = cp.get("byteCode.Base");
        CtMethod m = cc.getDeclaredMethod("process");
        m.insertBefore("{ System.out.println(\"start\"); }");
        m.insertAfter("{ System.out.println(\"end\"); }");
        Class c = cc.toClass();
        cc.writeFile("/Users/wushuangxiaoyu/temp/demo/src/main/java/");
        Base h = (Base)c.newInstance();
        h.process();
    } }