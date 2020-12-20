import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IOperationBancaire extends Remote {

    boolean debiter(String nomprop, double somme)throws RemoteException;
    boolean crediter(String nomprop, double somme)throws RemoteException;
    Double lireSolde(String nomprop)throws RemoteException;
}
