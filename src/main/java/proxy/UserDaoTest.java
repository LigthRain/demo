package proxy;

import net.sf.cglib.proxy.Enhancer;

public class UserDaoTest {

    public static void main(String[] args) {
        LogInterceptor logInterceptor = new LogInterceptor();
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserDao.class);
        enhancer.setCallback(logInterceptor);
        UserDao dao = (UserDao)enhancer.create();
        dao.select();
        dao.update();
    }

}
