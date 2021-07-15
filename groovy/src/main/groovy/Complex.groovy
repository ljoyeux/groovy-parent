class Complex {
    Number re;
    Number im;

    Complex(Number re, Number im) {
        this.re = re
        this.im = im
    }

    Complex plus(Complex b) {
        return new Complex(re.plus(b.re), im.plus(b.im))
    }

    Complex minus(Complex b) {
        return new Complex(re.minus(b.re), im.minus(b.im))
    }

    Complex negative() {
        return c(re.negative(), im.negative());
    }

    Complex div(Complex b) {
        // a/b = a*b/b^2

        def re1 = re.multiply(b.re).minus(im.multiply(b.im))
        def im1 = re.multiply(b.im).plus(im.multiply(b.re))

        def r2 = b.re.multiply(b.re).plus(b.im.multiply(b.im))
        def inv = ((Integer)1).div(r2)

        return c(re1.multiply(inv), im1.multiply(inv))
    }

    static Complex log(Complex c) {
        assert !(c.im instanceof BigDecimal || c.im instanceof BigInteger || c.re instanceof BigDecimal || c.re instanceof BigInteger) : "Big Integer/Decimal or not supported"

        def r2 = c.re.multiply(c.re).plus(c.im.multiply(c.im))
        def phi = Math.atan2(c.im.doubleValue(), c.re.doubleValue())
        return new Complex(Math.log(Math.sqrt(r2.doubleValue())), phi)
    }

    static Complex exp(Complex c) {
        assert !(c.im instanceof BigDecimal || c.im instanceof BigInteger || c.re instanceof BigDecimal || c.re instanceof BigInteger) : "Big Integer/Decimal or not supported"

        def a = (Number) Math.exp(c.re.doubleValue())
        double phi = c.im.doubleValue()
        return new Complex(a.multiply(Math.cos(phi)), a.multiply(Math.sin(phi)))
    }

    Complex power(Complex c) {
        def l = log(this)
        def m = l.multiply(c)
        return exp(m)
    }

    Complex power(Number n) {
        return power(c(n))
    }

    Complex multiply(Complex b) {
        return new Complex(re.multiply(b.re).minus(im.multiply(b.im)), re.multiply(b.im).plus(im.multiply(b.re)))
    }

    @Override
    String toString() {
        return "(${re}, ${im})"
    }

    static Complex c(Number re, Number im = (Integer) 0) {
        return new Complex(re, im);
    }
}
