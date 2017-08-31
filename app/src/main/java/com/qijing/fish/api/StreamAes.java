package com.qijing.fish.api;


import java.security.AlgorithmParameters;
import java.security.Key;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

//import java.security.Security;


public class StreamAes {

    //算法名
    public static final String KEY_ALGORITHM = "AES";
    //加解密算法/模式/填充方式  
    //可以任意选择，为了方便后面与iOS端的加密解密，采用与其相同的模式与填充方式  
    //ECB模式只用密钥即可对数据进行加密解密，CBC模式需要添加一个参数iv  
    public static final String CIPHER_ALGORITHM = "AES/ECB/NoPadding";

    /**
     * 加密
     *
     * @param content 需要加密的内容
     * @return
     */
    public static String encrypt(String content) {
        try {
            Key key = genKey();
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            //设置为加密模式
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] byteContent = content.getBytes("utf-8");
            int paded_length = 16 * (byteContent.length / 16);
            paded_length += ((byteContent.length % 16) != 0) ? 16 : 0;
            byte[] padedContent = new byte[paded_length];
            System.arraycopy(byteContent, 0, padedContent, 0, byteContent.length);
            byte[] result = cipher.doFinal(padedContent);

            return encodeByte2Base64Str(result); // 加密
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;

    }

    /**
     * 解密
     *
     * @param content 待解密内容
     * @return
     */
    public static String decrypt(String content) {

        try {
            Key key = genKey();
            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
            //设置为解密模式
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptFrom = parseBase64Str2Byte(content);
            byte[] result = cipher.doFinal(decryptFrom);

            String resultStr = new String(result);
            resultStr = resultStr.replaceAll("\0", "");
            return resultStr; // 解密
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content;
    }

//	    /**
//	     * 加密
//	     *
//	     * @param content
//	     *            需要加密的内容
//	     * @return
//	     */
//	    public static String encrypt_hex(String content) {
//
//	        try {
//	        	Key key = genKey();
//		        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
//		        //设置为加密模式
//		        cipher.init(Cipher.ENCRYPT_MODE, key);
//		        byte[] byteContent = content.getBytes("utf-8");
//		        int paded_length = 16 * (byteContent.length / 16);
//		        paded_length += ((byteContent.length % 16) !=0) ? 16 : 0;
//		        byte[] padedContent = new byte[paded_length];
//		        System.arraycopy(byteContent, 0, padedContent,0, byteContent.length);
//		        byte[] result =  cipher.doFinal(padedContent);
//
//	            return parseByte2HexStr(result); // 加密
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	        return null;
//
//	    }
//	    /**
//	     * 解密
//	     *
//	     * @param content
//	     *            待解密内容
//	     * @return
//	     */
//	    public static String decrypt_hex(String content) {
//
//	        try {
//	            Key key = genKey();
//	            Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
//		        //设置为加密模式
//		        cipher.init(Cipher.DECRYPT_MODE, key);
//		        byte[] decryptFrom = parseHexStr2Byte(content);
//		        byte[] result =  cipher.doFinal(decryptFrom);
//
//	            return new String(result); // 加密
//	        } catch (Exception e) {
//	            e.printStackTrace();
//	        }
//	        return null;
//	    }


    private static SecretKeySpec genKey() {
        String strKey = "f2d1e553f9c2338e";// 加密解密密钥
        return new SecretKeySpec(strKey.getBytes(), "AES");
    }

    //生成iv
    public static AlgorithmParameters generateIV() throws Exception {
        //iv 为一个 16 字节的数组，这里采用和 iOS 端一样的构造方法，数据全为0
        byte[] iv = new byte[16];
        Arrays.fill(iv, (byte) 0x00);
        AlgorithmParameters params = AlgorithmParameters.getInstance(KEY_ALGORITHM);
        params.init(new IvParameterSpec(iv));
        return params;
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    private static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toLowerCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    private static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1)
            return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2),
                    16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }


    /**
     * 将二进制转换成base64
     *
     * @param buf
     * @return
     */
    private static String encodeByte2Base64Str(byte buf[]) {
        Base64 encoder = new Base64();
        return encoder.encode(buf);
    }

    /**
     * 将base64进制转换为二进制
     *
     * @param base64Str
     * @return
     */
    private static byte[] parseBase64Str2Byte(String base64Str) {
        Base64 decoder = new Base64();
        return decoder.decode(base64Str);
    }

//	    public static void main(String[] args) {
//
//	        Scanner s = new Scanner(System.in);
//	        System.out.println("Please input the encode content (input 'exit' to exit)!");
//	        System.out.print("content:");
//
//	        while(s.hasNext()){
//	            String content = s.next();
//	            if(content.equalsIgnoreCase("exit")){
//	                System.exit(0);
//	            }
//	            System.out.println("Generate password success!");
//	            System.out.print("encode:");
//	            String content_encode = StreamAes.encrypt(content);
//	            System.out.println(content_encode+"\n");
//	            System.out.println("content_decode:" + StreamAes.decrypt(content_encode) +"\n");
//
//
//	            System.out.println("content_decode:" + StreamAes.decrypt_hex("ce4e53cb7e75e0e3b7c47d0a29e754678063e123c9e7cf50c26586fc8da47ee312c0e19ac8f1d51f194cc34f47082fb2") +"\n");
//
//	            System.out.println("content_decode:" + StreamAes.decrypt("zk5Ty3514OO3xH0KKedUZ4Bj4SPJ589QwmWG/I2kfuMSwOGayPHVHxlMw09HCC+y") +"\n");
//
//
//
//	        }
//
//	    }

}
