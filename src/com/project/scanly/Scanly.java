package com.project.scanly;

import net.glxn.qrgen.QRCode;
import net.glxn.qrgen.image.ImageType;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Scanly
{
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the text or link that you want to create a QR_CODE");
        String details = sc.nextLine();
        ByteArrayOutputStream out = QRCode.from(details).to(ImageType.PNG).stream();
        System.out.println("Enter the path to store the QR_CODE in your Device [Don't Forget to Add the QR_CODE Image Name (example - C:\\QR-CODE\\scanly\\MyImage.png)]");
        String path = sc.next();
        File f = new File(path);
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(out.toByteArray());
        fos.flush();
        sc.close();
    }
}
