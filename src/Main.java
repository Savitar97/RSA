import java.math.BigInteger;
import java.security.SecureRandom;

public class Main {

    public static void main(String[] args) {
        if(args.length<1){
            System.out.println("Usage java Main.java massage e/d");
        }
        else {
            Rsa rs = new Rsa();
            rs.keyGen();
            BigInteger  ret;
            for (BigInteger i : rs.getPk()) {
                System.out.println("publikus kulcsok(n,e):" + i);
            }
            BigInteger temp= new BigInteger(args[0]);
            ret = rs.encrypt(temp);
            System.out.println("Titkosítandó szöveg:"+temp);
            System.out.println("Titkosított szöveg:"+ret);
            System.out.println("Visszafejtett szöveg:"+rs.decrypt(ret));
            System.out.println("P:"+rs.getP());
            System.out.println("Q:"+rs.getQ());
            System.out.println("N:"+rs.getN());
            System.out.println("Phi:"+rs.getFin());
            System.out.println("E:"+rs.getE());
            System.out.println("D:"+rs.getSk());


            System.out.println("Privát kulcs:" + rs.getSk());
        }
    }

}
