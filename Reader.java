import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Reader {
    public List<String> readWords(String filePath) throws FileNotFoundException, IOException {
        List<String> lines = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filePath));) {
            String line;

            while((line = br.readLine()) != null)
                lines.add(line);
        }

        return lines;
    }
}
