import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;

public class Hash {

    public static String calculateHash(String index, ZonedDateTime timestamp, Data data, int nonce){
        String string = index + timestamp.toString() + data.toString() + String.valueOf(nonce);

        return Hashing.sha256()
                .hashString(string, StandardCharsets.UTF_8)
                .toString();
    }
}
