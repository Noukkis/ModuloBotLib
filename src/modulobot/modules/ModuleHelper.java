/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulobot.modules;

import java.io.File;
import net.dv8tion.jda.core.JDA;

/**
 *
 * @author Jordan
 */
public class ModuleHelper {

    private JDA jda;
    private String prefix;

    public ModuleHelper(JDA jda) {
        this.jda = jda;
        this.prefix = "!";
    }

    public JDA getJda() {
        return jda;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

}
