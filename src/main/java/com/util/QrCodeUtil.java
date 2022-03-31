package com.util;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
/**
 *二维码生成工具
 */
public class QrCodeUtil {

	
	 
	 
	 
	   private static final int BLACK = 0xFF000000;
	   private static final int WHITE = 0xFFFFFFFF;
	 
	 
	   
	   public static BufferedImage toBufferedImage(BitMatrix matrix) {
	     int width = matrix.getWidth();
	     int height = matrix.getHeight();
	     BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	     for (int x = 0; x < width; x++) {
	       for (int y = 0; y < height; y++) {
	         image.setRGB(x, y, matrix.get(x, y) ? BLACK : WHITE);
	       }
	     }
	     return image;
	   }
	 
	   
	   public static void writeToFile(BitMatrix matrix, String format, File file)
	       throws IOException {
	     BufferedImage image = toBufferedImage(matrix);
	     if (!ImageIO.write(image, format, file)) {
	       throw new IOException("Could not write an image of format " + format + " to " + file);
	     }
	   }
	 
	   
	   public static void writeToStream(BitMatrix matrix, String format, OutputStream stream)
	       throws IOException {
	     BufferedImage image = toBufferedImage(matrix);
	     if (!ImageIO.write(image, format, stream)) {
	       throw new IOException("Could not write an image of format " + format);
	     }
	 
	 }
	   /**
	    * 生成二维码
	    * @param content
	    * @param height
	    * @param weight
	    * @param outPath
	    */
 
	  public static void generatorQrCode(String content,int height,int weight,String fileName,String outPath){
		  
		     MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
		     Map hints = new HashMap();
		     hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
		     BitMatrix bitMatrix = null;
			try {
				bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, height, weight,hints);
			} catch (WriterException e) {
				e.printStackTrace();
			}
		     File file1 = new File(outPath,fileName);
		     try {
				QrCodeUtil.writeToFile(bitMatrix, "jpg", file1);
			} catch (IOException e) {
				e.printStackTrace();
			}  
		  
	  }
	   public static void main(String[] args) {
		
		   String message = "https://www.baidu.com/";//微信测试二维码
		   
		   QrCodeUtil.generatorQrCode(message, 400, 400, "永爱.png", "D:/test");
		   
		   
	}
	
}
