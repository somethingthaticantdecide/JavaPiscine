class Program {

    public static void main(String[] args) {
        int res = 0;
        int n = 479598;

        res += n % 10;
        n /= 10;
        res += n % 10;
        n /= 10;
        res += n % 10;
        n /= 10;
        res += n % 10;
        n /= 10;
        res += n % 10;
        n /= 10;
        res += n % 10;
        n /= 10;
        System.out.println(res);
    }
}
