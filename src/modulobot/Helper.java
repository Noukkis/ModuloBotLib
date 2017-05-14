/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulobot;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jordan
 */
public class Helper {

    public static String readFile(File f) {
        String res = "";
        if (f.isFile()) {
            BufferedReader br = null;
            try {
                br = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(f), "UTF-8"));
                String ligne;
                while ((ligne = br.readLine()) != null) {
                    res += ligne + "\n";
                }

                br.close();
                br = null;
            } catch (Exception e) {
                res = "";
                Logger.getGlobal().log(Level.SEVERE, "Cannot access log", e );
            } finally {
                if (br != null) {
                    try {
                        br.close();
                        br = null;
                    } catch (IOException ioe2) {
                        Logger.getGlobal().log(Level.SEVERE, "Cannot access log", ioe2 );
                    }
                }
            }
        }
        return res;
    }
    
    public static boolean serialiseObjet( File file, Object obj ) throws IOException {
        boolean bResult = false;
        if ( obj != null ) {
            ObjectOutputStream out = null;
            try {
                out = new ObjectOutputStream( new BufferedOutputStream( new FileOutputStream(file)));
                out.writeObject( obj );
                out.flush();
                out.close();
                out = null;
                bResult = true;
            }
            finally {
                if ( out != null ) {
                    try {
                        out.close();
                        out = null;
                    }
                    catch ( IOException ex ) {
                    }
                }
                if ( !bResult ) {
                    try {
                        file.delete();
                    }
                    catch ( Exception e ) {
                    }
                }
            }
        }
        return bResult;
    }
    
    public static Object deserialiseObjet( File file ) throws IOException, ClassNotFoundException {
        Object result = null;
        ObjectInputStream in = null;
        try {
            in = new ObjectInputStream( new BufferedInputStream( new FileInputStream( file ) ) );
            result = in.readObject();
            in.close();
            in = null;
        } finally {
            if ( in != null ) {
                try {
                    in.close();
                    in = null;
                }
                catch ( IOException ex ) {
                }
            }
        }
        return result;
    }
}

