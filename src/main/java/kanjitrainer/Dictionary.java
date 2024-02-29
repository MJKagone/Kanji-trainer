package kanjitrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Dictionary {

    private HashMap<String, String> translations;
    private HashMap<String, String> readings;

    public Dictionary(String filename) {
        translations = new HashMap<>();
        readings = new HashMap<>();
        readFromFile(filename);
    }

    public void readFromFile(String filename) {
        try {
            InputStream is = getClass().getResourceAsStream("/kanji.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                translations.put(parts[0], parts[1]);
                readings.put(parts[0], parts[2]);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e);
        }
    }

    public String getKanji() {
        Object[] kanjis = translations.keySet().toArray();
        int randomIndex = (int) (Math.random() * kanjis.length);
        return (String) kanjis[randomIndex];
    }

    public String getTranslation(String kanji) {
        return translations.get(kanji);
    }

    public String getReading(String kanji) {
        return readings.get(kanji);
    }


}