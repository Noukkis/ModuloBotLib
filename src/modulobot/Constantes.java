/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulobot;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jordan
 */
public class Constantes {
    public final static String LOGS_FOLDER = "logs\\"+ new SimpleDateFormat("yyyy.MM.dd'\\'HH.mm.ss").format(new Date()) + "\\";
    public final static String MODULES_LOGS_FOLDER = LOGS_FOLDER + "modules\\";
    public final static String MODULES_WORK_FOLDER = "work\\modules\\";
}
