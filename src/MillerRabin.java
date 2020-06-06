import java.math.BigInteger;
import java.security.SecureRandom;

public class MillerRabin {
    /**
     * Return true if the argument is a prime.
     * @param n
     * @return negate isComposite
     */
    public boolean miller(BigInteger n){
        boolean isComposite=true;
        if (n.compareTo(BigInteger.ONE) == 0) {
            return isComposite=false;
        }
        if (n.compareTo(new BigInteger("3")) < 0){
            return isComposite=true;
        }

        BigInteger d=n.subtract(BigInteger.ONE);
        int s=0;
        while (d.mod(BigInteger.TWO).equals(BigInteger.ZERO)){
            s++;
            d=d.divide(BigInteger.TWO);
        }
        System.out.println("D értéke:"+d);

        System.out.println("S értéke:"+s);

        for (int i = 0; i < 40; i++) {
            BigInteger a=uniformRandom(BigInteger.TWO,n.subtract(BigInteger.ONE));
            System.out.println("A értéke:"+a);
            System.out.println(FME.modPow(a,d,n));
            if (FME.modPow(a,d,n).equals(BigInteger.ONE)||FME.modPow(a,d,n).equals(n.subtract(BigInteger.ONE))){
                 isComposite=false;
            }
            else {
                for (int r = 0; r < s; r++) {
                    System.out.println(d.multiply(BigInteger.TWO.pow(r)));
                    if (FME.modPow(a, d.multiply(BigInteger.TWO.pow(r)), n).equals(n.subtract(BigInteger.ONE))) {
                        isComposite=false;
                    }
                }
            }
        }
        return !isComposite;

    }

    private static BigInteger uniformRandom(BigInteger bottom, BigInteger top) {
        SecureRandom rand=new SecureRandom();
        BigInteger res;
        do {
            res = new BigInteger(top.bitLength(), rand);
        } while (res.compareTo(bottom) < 0 || res.compareTo(top) > 0);
        return res;
    }

    public static void main(String[] args) {
        SecureRandom rand=new SecureRandom();
        MillerRabin mr=new MillerRabin();
        boolean res=mr.miller(new BigInteger("17"));
        System.out.println(res);
        BigInteger i=new BigInteger("17");
        System.out.println(i.isProbablePrime(1));

    }
}
