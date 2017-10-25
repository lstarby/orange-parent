package com.zzsong.study.orange.common.util;

import java.io.*;

/**
 * Created by zzsong on 17/1/12.
 */
public class IOUtils {

    public static String inputStream2String(InputStream inputStream)
            throws IOException {
        InputStreamReader ir = new InputStreamReader(inputStream);
        BufferedReader br = new BufferedReader(ir);
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        ir.close();
        return sb.toString();
    }

    public static byte[] inputStream2Bytes(InputStream inputStream)
            throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int n;
        while ((n = inputStream.read(buffer, 0, 4096)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }

}
