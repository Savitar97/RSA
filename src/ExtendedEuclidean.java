import java.math.BigInteger;

public class ExtendedEuclidean {
    private BigInteger x;

    public BigInteger ExtendedEuclidean(BigInteger a,BigInteger b){
        BigInteger x0 = BigInteger.ZERO;
        BigInteger x1 = BigInteger.ONE;
        BigInteger y0 = BigInteger.ONE;
        BigInteger y1 = BigInteger.ZERO;
        BigInteger temp;
        while (!b.equals(BigInteger.ZERO))
        {
            BigInteger q = a.divide(b);

            temp=a;
            a = b;
            b = temp.remainder(b);
            temp = x0;
            x0 = x1.subtract(q.multiply(x0));
            x1 = temp;
            temp = y0;
            y0 = y1.subtract(q.multiply(y0));
            y1 = temp;
            System.out.println("x értéke:"+x0);
            x=x1;
        }
        return a;

    }


    public static BigInteger gcd(BigInteger a, BigInteger b)
    {
        if (a.equals(BigInteger.ZERO)) {
            return b;
        }
        else {
            return gcd(b.remainder(a), a);
        }
    }

    public BigInteger getX() {
        return x;
    }

    public static void main(String[] args) {
        ExtendedEuclidean ex=new ExtendedEuclidean();
        BigInteger a=BigInteger.valueOf(10);
        BigInteger b=BigInteger.valueOf(24);
        BigInteger remainder= ex.ExtendedEuclidean(a,b);
        BigInteger remainder1=gcd(a,b);
    }
}
