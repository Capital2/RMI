import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MyInterface extends Remote {

    String sayHello()throws RemoteException;
}
