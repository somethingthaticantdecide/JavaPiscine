package com.company;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;

public class Main {
//    private static ArrayList<String> urls;

    public static class UrlsArrayList {

        private ArrayList<String> urls;

        public UrlsArrayList() {
            urls = new ArrayList<String>();
        }

        public int getSize() {
            return urls.size();
        }

        public synchronized String get() {
            if (this.urls.size() > 0) {
                String url = this.urls.get(0);
                return (url);
            }
            return (null);
        }
        public synchronized void remove() {
            if (this.urls.size() > 0) {
                this.urls.remove(0);
            }
        }
    }

    static class myThread extends Thread {
        String  _url;
        String  _filename;
        int     _file_number;
        int     _thread_number;
        public  UrlsArrayList _urls;

        public myThread(int thread_number, UrlsArrayList urls) {
            this._thread_number = thread_number;
            this._urls = urls;
            if (_urls.getSize() > 0)
            {
                this._url = _urls.get().split(" ")[1];
                this._file_number = Integer.parseInt(_urls.get().split(" ")[0]);
                String[] splitedFilename = _url.split("/");
                int i = splitedFilename.length;
                this._filename = splitedFilename[i - 1];
                _urls.remove();
            }
        }

        @Override
        public void run() {
            while (_urls.getSize() > 0)
            {
                System.out.println("Thread-" + _thread_number +  " start download file number " + _file_number);
                try (
                        BufferedInputStream in = new BufferedInputStream(new URL(_url).openStream());
                        FileOutputStream fileOutputStream = new FileOutputStream(_filename)) {
                        byte[] dataBuffer = new byte[4096];
                        int bytesRead;
                        while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                            fileOutputStream.write(dataBuffer, 0, bytesRead);
                        }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread-" + _thread_number +  " finish download file number " + _file_number);
                if (_urls.getSize() > 0)
                {
                    this._url = _urls.get().split(" ")[1];
                    this._file_number = Integer.parseInt(_urls.get().split(" ")[0]);
                    String[] splitedFilename = _url.split("/");
                    int i = splitedFilename.length;
                    this._filename = splitedFilename[i - 1];
                    _urls.remove();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        String[] split;
        int threadsCount;
        if (args.length != 1) {
            System.err.println("Usage: Program --threadsCount=");
            System.exit(-1);
        }
        split = args[0].split("=");
        if (!split[0].equals("--threadsCount") || !split[1].matches("\\d+") || split.length != 2) {
            System.err.println("Usage: Program --threadsCount=");
            System.exit(-1);
        }
        threadsCount = Integer.parseInt(split[1]);

        UrlsArrayList urlslist = new UrlsArrayList();

        try (BufferedReader br = new BufferedReader(new FileReader("files_urls.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                urlslist.urls.add(line);
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            System.exit(-1);
        }

        for (int i = 0; i < threadsCount; i++)
        {
            myThread Thread = new myThread(i  + 1, urlslist);
            Thread.start();
        }
    }
}
