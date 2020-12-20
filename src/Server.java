import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server extends UnicastRemoteObject implements IOperationBancaire {

    public Server() throws RemoteException {}

    // making some accounts
    Compte [] c = {new Compte("Mohsen", 1050),
            new Compte("Amir", 8400)};

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Server server = new Server();
        java.rmi.registry.LocateRegistry.createRegistry(1250);

        Naming.rebind("rmi://127.0.0.1:1250/server", server);
    }

    @Override
    public boolean debiter(String nomprop, double somme) throws RemoteException {
        for (Compte compte: c) {
            if ((nomprop.equalsIgnoreCase(compte.getProprietaire())) && (compte.getCredit()>-500)){
                compte.setCredit(compte.getCredit() - somme);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean crediter(String nomprop, double somme) throws RemoteException {
        for (Compte compte: c) {
            if (nomprop.equalsIgnoreCase(compte.getProprietaire())){
                compte.setCredit(compte.getCredit() + somme);
                return true;
            }
        }
        return false;
    }

    @Override
    public Double lireSolde(String nomprop) throws RemoteException {
        for (Compte compte: c) {
            if (nomprop.equalsIgnoreCase(compte.getProprietaire())){
                return compte.getCredit();
            }
        }
        return null;
    }
}
