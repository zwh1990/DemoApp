package com.zwh.demoapp.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 压缩工具类
 *
 * @author: zhaowh
 * @date: 2022/7/11
 */
public class ZipUtils {

    public static final String GZIP_ENCODE_ISO = "ISO-8859-1";
    private static final String TAG = ZipUtils.class.getSimpleName();

    // 压缩
    public static String compress(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = null;
        try {
            gzip = new GZIPOutputStream(out);
            gzip.write(str.getBytes());
            gzip.close();
            return out.toString(GZIP_ENCODE_ISO);
        } catch (IOException exception) {
            LOGUtils.w(TAG,"message--->" + exception.getMessage());
        }
        return null;
    }

    // 解压缩
    public static String uncompress(String str){
        if (str == null || str.length() == 0) {
            return str;
        }
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ByteArrayInputStream in = new ByteArrayInputStream(str
                    .getBytes(GZIP_ENCODE_ISO));
            GZIPInputStream gunZip = new GZIPInputStream(in);
            byte[] buffer = new byte[256];
            int n;
            while ((n = gunZip.read(buffer)) >= 0) {
                out.write(buffer, 0, n);
            }
            return out.toString();
        } catch (IOException exception) {
           LOGUtils.w(TAG,"message--->" + exception.getMessage());
        }
        return null;
    }

}





