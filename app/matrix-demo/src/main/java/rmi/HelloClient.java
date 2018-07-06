package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import zhangyuyao.matrixsb.rmi.Hello;

public class HelloClient {
    public static void main(String[] args) {
        try {
            Hello h = (Hello) Naming.lookup("rmi://10.101.50.37:12313/Hello");
            System.out.println(h.sayHello("matrix"));
        } catch (MalformedURLException e) {
            System.out.println("url格式异常");
        } catch (RemoteException e) {
            System.out.println("创建对象异常");
            e.printStackTrace();
        } catch (NotBoundException e) {
            System.out.println("对象未绑定");
        }
    }
}