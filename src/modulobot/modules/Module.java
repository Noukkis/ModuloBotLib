/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulobot.modules;

import java.io.File;
import java.io.IOException;
import modulobot.events.PrefixedMessageReceivedEvent;
import java.util.EventListener;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import modulobot.Constantes;
import net.dv8tion.jda.core.events.Event;

/**
 *
 * @author Jordan
 */
public abstract class Module implements EventListener {

    protected final Logger LOGGER;
    protected final String WRK_FOLDER;

    public Module() {
        WRK_FOLDER = Constantes.MODULES_WORK_FOLDER + this.getClass().getName() + "\\";
        new File(WRK_FOLDER).mkdirs();
        LOGGER = Logger.getLogger(this.getClass().getName());
            try {
                Handler fileHandler = new FileHandler(Constantes.MODULES_LOGS_FOLDER + getClass().getName() + ".log");
                fileHandler.setFormatter(new SimpleFormatter());
                LOGGER.addHandler(fileHandler);
            } catch (IOException | SecurityException ex) {
                Logger.getGlobal().log(Level.SEVERE, "Can't handle FileLogger for " + getClass().getName(), ex);
            }
        
    }

    /**
     * This method is called one time on the module loading.
     *
     * @param helper the controller your module is allowed to interact with
     * @return true if the preload worked
     */
    public boolean preload(Helper helper) {
        return true;
    }

    /**
     * Called when a message beggining with the bot's prefix is received
     *
     * @param event
     */
    public void onPrefixedMessageReceived(PrefixedMessageReceivedEvent event) {
        
    }

    /**
     * Called when another event than a PrefixedMessageReceivedEvent is
     * triggered.
     *
     * @param event
     */
    public void onEvent(Event event) {
        
    }

    /**
     * Called when the module is stopping.
     */
    public void stop() {
        
    }

    public IModuleCtrl getModuleCtrl() {
        return null;
    }

    public abstract String getName();

    public String getDescription() {
        return "No description available for this module";
    }

    public String getHelp() {
        return "No help available for this module";
    }
    
    public DependencyBundle getDependencyBundle() {
        return null;
    }

    @Override
    public final boolean equals(Object obj) {
        boolean res = false;
        if (obj instanceof Module) {
            String objName = ((Module) obj).getName();
            if (objName != null && objName.equals(getName())) {
                res = true;
            }
        }
        return res;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    public final Logger getLOGGER() {
        return LOGGER;
    }
    
}
