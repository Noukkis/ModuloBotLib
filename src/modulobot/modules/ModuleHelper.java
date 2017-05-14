/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulobot.modules;

import net.dv8tion.jda.core.JDA;

/**
 *
 * @author Jordan
 */
public class ModuleHelper {

    private JDA jda;

    public ModuleHelper(JDA jda) {
        this.jda = jda;
    }

    public JDA getJda() {
        return jda;
    }
 
    public String getPrefix() {
        return "!";
    }
}
