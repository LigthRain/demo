package proxy;

import sun.misc.ProxyGenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author： wushuangxiaoyu
 * @date： 2019/6/24 下午11:28
 */
public class CodeUtil {

    public static void main(String[]args)throws IOException {

        byte[]classFile = ProxyGenerator.generateProxyClass("Proxy0",NumberOperationImp.class.getInterfaces());

        File file =new File("../Proxy0.class");

        FileOutputStream fos =new FileOutputStream(file);

        fos.write(classFile);

        fos.flush();

        fos.close();

    }


}
