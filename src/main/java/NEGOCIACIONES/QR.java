/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package NEGOCIACIONES;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Cris
 */
public class QR {
    public void createQR(String data, String path,
                                String charset, Map hashMap,
                                int height, int width)
        throws WriterException, IOException
    {
 
        BitMatrix matrix = new MultiFormatWriter().encode(
            new String(data.getBytes(charset), charset),
            BarcodeFormat.QR_CODE, width, height, hashMap);
 
        MatrixToImageWriter.writeToFile(
            matrix,
            path.substring(path.lastIndexOf('.') + 1),
            new File(path));
    }
   
    // Driver code
    public File DFCRQR(String img)
        throws WriterException, IOException,
               NotFoundException
    {
 
        // The data that the QR code will contain
        String data = img;
 
        // The path where the image will get saved
        String path = "QR.png";
 
        // Encoding charset
        String charset = "UTF-8";
 
        Map<EncodeHintType, ErrorCorrectionLevel> hashMap
            = new HashMap<EncodeHintType,
                          ErrorCorrectionLevel>();
 
        hashMap.put(EncodeHintType.ERROR_CORRECTION,
                    ErrorCorrectionLevel.L);
 
        // Create the QR code and save
        // in the specified folder
        // as a jpg file
        
        System.out.println("QR Code Generated!!! ");
        createQR(data, path, charset, hashMap, 500, 500);
        
        File outputfile = new File(path);
        return outputfile;
    }
}
