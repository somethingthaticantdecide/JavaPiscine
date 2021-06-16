public class Program {

    public static class myThread extends Thread {
        private final String  _text;
        private final int     _count;

        public myThread(String text, int count) {
            this._text = text;
            this._count = count;
        }

        @Override
        public void run() {
            for (int i = 0; i < _count; i++) System.out.println(_text);
        }
    }

    public static void main(String[] args) throws InterruptedException {

        if (args.length != 1) {
            System.err.println("Usage: Program --count=");
            System.exit(-1);
        }
        String[] split = args[0].split("=");
        if (!split[0].equals("--count") || split.length != 2 || !split[1].matches("\\d+") ) {
            System.err.println("Usage: Program --count=");
            System.exit(-1);
        }

        int count = Integer.parseInt(split[1]);
        myThread eggThread = new myThread("Egg", count);
        myThread henThread = new myThread("Hen", count);
        eggThread.start();
        eggThread.join();
        henThread.start();
        henThread.join();
        for (int i = 0; i < count; i++)
            System.out.println("Human");
    }
}
