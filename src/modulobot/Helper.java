/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulobot;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
}
