import java.rmi.Naming;


public class Client {

    public static void main(String[] args) {
        try {
            IOperationBancaire service1 = (IOperationBancaire) Naming.lookup("rmi://127.0.0.1:1250/server");

            System.out.println("Solde de amir: " + service1.lireSolde("amir"));
            System.out.println("Solde de mohsen: " + service1.lireSolde("mohsen"));

            service1.crediter("mohsen", 5000);
            service1.debiter("amir", 1000);

            System.out.println("Solde de amir apres operation: " + service1.lireSolde("amir"));
            System.out.println("Solde de mohsen apres operation: " + service1.lireSolde("mohsen"));

        } catch (Exception e) {
            System.out.println("Error");
            System.out.println(e.toString());
        }
    }

}