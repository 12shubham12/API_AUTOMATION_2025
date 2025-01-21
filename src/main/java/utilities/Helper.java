package utilities;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Helper {

    public static String getLocalDateTime(){
        LocalDateTime dt = LocalDateTime.now();
        return dt.format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
    }

    public static void saveResponse(String folderName, String apiName, String responseBody) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(folderName+"/"+apiName+Helper.getLocalDateTime()+".json");
        pw.print(responseBody);
        pw.flush();
    }
}
