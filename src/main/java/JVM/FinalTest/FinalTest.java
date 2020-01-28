package JVM.FinalTest;

/**
 * @author： wushuangxiaoyu
 * @date： 2019/7/20 上午11:37
 */
public class FinalTest {

    // 以下代码来源于【参考 1】
    final int x;
    int y;
    static Global global = new Global();
    // 错误的构造函数
    public FinalTest() {
        x = 3;
        y = 4;
        // 此处就是讲 this 逸出，
        global.obj = this;
    }

    public static void main(String[] args) {
        System.out.println(global.obj.x);
    }

}
