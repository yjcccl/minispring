package com.minis.beans;

/**
 * @author yjc
 */
public interface PropertyEditor {

    void setAsText(String text);

    void setValue(Object value);

    Object getValue();

    String getAsText();

}
