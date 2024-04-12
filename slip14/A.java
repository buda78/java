
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class A {
    private static final String SEARCH_STRING = "search";
    private static final String FILE_EXTENSION = ".txt";

    public static void main(String[] args) {
        File folder = new File(".");
        File[] files = folder.listFiles();

        List<SearchThread> searchThreads = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(FILE_EXTENSION)) {
                    SearchThread searchThread = new SearchThread(file, SEARCH_STRING);
                    searchThreads.add(searchThread);
                    searchThread.start();
                }
            }
        }

        for (SearchThread thread : searchThreads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class SearchThread extends Thread {
        private File file;
        private String searchString;

        public SearchThread(File file, String searchString) {
            this.file = file;
            this.searchString = searchString;
        }

        @Override
        public void run() {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                int lineNumber = 1;

                while ((line = reader.readLine()) != null) {
                    if (line.contains(searchString)) {
                        System.out.println("Found in file: " + file.getName() + ", Line: " + lineNumber + ": " + line);
                    }
                    lineNumber++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

