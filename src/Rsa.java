import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;

public class Rsa {
    private BigInteger sk;
    private BigInteger[] pk;
    private SecureRandom rand;
    private BigInteger n;
    private BigInteger fin;
    private BigInteger e;
    private BigInteger q;
    private BigInteger p;
    ExtendedEuclidean ex=new ExtendedEuclidean();
    MillerRabin mr=new MillerRabin();

    public Rsa() {
        pk=new BigInteger[2];
        rand=new SecureRandom();
        //MR();
    }

    public void keyGen(){
        do {
            q=new BigInteger(100,rand);
        }while (!mr.miller(q));
        do {
            p=new BigInteger(100,rand);
        }while (!mr.miller(p));
        n=p.multiply(q);
        fin= (p.subtract(new BigInteger("1"))).multiply(q.subtract(new BigInteger("1")));
        System.out.println(fin);
        do {
            e=new BigInteger(50,rand);
        }while (!ex.ExtendedEuclidean(e,fin).equals(BigInteger.ONE));
        pk[0]=n;
        pk[1]=e;
        sk=ex.getX();
        if(sk.compareTo(BigInteger.ONE)<0){
            sk=sk.add(fin);
        }
    }

    public BigInteger encrypt(BigInteger msg){
        return msg.modPow(e,n);
    }

    public BigInteger decrypt(BigInteger msg){
        return msg.modPow(sk,n);
    }

    public BigInteger getSk() {
        return sk;
    }

    public BigInteger[] getPk() {
        return pk;
    }

    public SecureRandom getRand() {
        return rand;
    }

    public BigInteger getN() {
        return n;
    }

    public BigInteger getFin() {
        return fin;
    }

    public BigInteger getE() {
        return e;
    }

    public BigInteger getQ() {
        return q;
    }

    public BigInteger getP() {
        return p;
    }

}
