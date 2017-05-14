/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulobot.modules;

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

    public Module() {
        LOGGER = Logger.getLogger(this.getClass().getName());
        boolean handlerExisting = false;
        for (Handler handler : LOGGER.getHandlers()) {
            if (handler instanceof FileHandler) {
                handlerExisting = true;
                break;
            }
        }
        if(!handlerExisting){
            try {
                Handler handler = new FileHandler(Constantes.MODULES_LOGS_FOLDER + getClass().getName() + ".log");
                handler.setFormatter(new SimpleFormatter());
                LOGGER.addHandler(handler);
            } catch (IOException | SecurityException ex) {
                Logger.getGlobal().log(Level.SEVERE, "Can't handle FileLogger for " + getClass().getName(), ex);
            }
        }
    }

    /**
     * This method is called one time on the module loading.
     *
     * @param moduleCtrl the controller your module is allowed to interact with
     */
    public abstract void preload(ModuleHelper moduleCtrl);

    /**
     * Called when a message beggining with the bot's prefix is received
     *
     * @param event
     */
    public abstract void onPrefixedMessageReceived(PrefixedMessageReceivedEvent event);

    /**
     * Called when another event than a PrefixedMessageReceivedEvent is
     * triggered.
     *
     * @param event
     */
    public abstract void onEvent(Event event);

    /**
     * Called when the module is stopping.
     */
    public abstract void stop();

    public abstract IModuleCtrl getModuleCtrl();

    public abstract String getName();

    public abstract String getDescription();

    public abstract String getHelp();

    @Override
    public boolean equals(Object obj) {
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
}
