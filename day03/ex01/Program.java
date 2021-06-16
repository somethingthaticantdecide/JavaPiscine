public class Program {

    static class SynchronizedTalk {
        public String _turn = "Han";

        public synchronized void Say(String _text) {
            while (_turn.equals(_text)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(_text);
            _turn = _text;
            notify();
        }
    }

    static class myThread extends Thread {
        private final int   _count;
        SynchronizedTalk    _sync;
        String              _text;

        public myThread(String text, int count, SynchronizedTalk sync) {
            this._sync = sync;
            this._count = count;
            this._text = text;
        }

        @Override
        public void run() {
            for (int i = 0; i < _count; i++)
                _sync.Say(_text);
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: Program --count=");
            System.exit(-1);
        }
        String[] split = args[0].split("=");
        if (!split[0].equals("--count") || split.length != 2 || !split[1].matches("\\d+")) {
            System.err.println("Usage: Program --count=");
            System.exit(-1);
        }
        int count = Integer.parseInt(split[1]);

        SynchronizedTalk sync = new SynchronizedTalk();
        myThread eggThread = new myThread("Hen", count, sync);
        myThread henThread = new myThread("Egg", count, sync);
        eggThread.start();
        henThread.start();
    }
}
