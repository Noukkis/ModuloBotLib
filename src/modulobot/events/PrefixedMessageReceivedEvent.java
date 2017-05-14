/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulobot.events;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

/**
 *
 * @author Jordan
 */
public class PrefixedMessageReceivedEvent extends MessageReceivedEvent{
    
    private final String unprefixedMessageContent;
    
    public PrefixedMessageReceivedEvent(MessageReceivedEvent OriginalEvent, String prefix) {
        super(OriginalEvent.getJDA(), OriginalEvent.getResponseNumber(), OriginalEvent.getMessage());
        unprefixedMessageContent = OriginalEvent.getMessage().getContent().replaceFirst(prefix, "");
    }

    public String getUnprefixedMessageContent() {
        return unprefixedMessageContent;
    }
}
