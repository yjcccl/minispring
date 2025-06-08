package com.minis.context;

import java.util.EventObject;

/**
 * @author yjc
 */
public class ApplicationEvent extends EventObject {

    private static final long serialVersionUID = 1L;


    protected String msg = null;

    /**
     * Constructs a prototypical Event.
     *
     * @param arg0 The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object arg0) {
        super(arg0);
        this.msg = arg0.toString();
    }
}
