public class Compte {
    private String proprietaire;
    private double credit;
    private static int cpt;
    private int num;

    Compte(String p, double c){
        this.proprietaire = p;
        this.credit = c;
        this.num = ++cpt;
    }

    public double getCredit() {
        return credit;
    }

    public static int getCpt() {
        return cpt;
    }

    public String getProprietaire() {
        return proprietaire;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public void setProprietaire(String proprietaire) {
        this.proprietaire = proprietaire;
    }
}
