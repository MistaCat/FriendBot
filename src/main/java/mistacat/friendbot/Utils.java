package mistacat.friendbot;

import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Utils {

    /**
     * Returns a Json string from a URL.
     * This lets you create a json object from websites so you can get information.
     * @param urlString
     * @return
     * @throws Exception
     */
    public static String readJsonURL(String urlString) {
        try {
            URL url = new URL(urlString);
            URLConnection con = url.openConnection();
            InputStream in = con.getInputStream();
            String encoding = con.getContentEncoding();
            encoding = encoding == null ? "UTF-8" : encoding;
            String body = IOUtils.toString(in, encoding);

            return body;
        } catch (Exception ex) {
            ex.printStackTrace();
            return "";
        }
    }
}
