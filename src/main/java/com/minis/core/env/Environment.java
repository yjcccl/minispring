package com.minis.core.env;

/**
 * @author yjc
 */
public interface Environment {

    String[] getActiveProfiles();

    String[] getDefaultProfiles();

    boolean acceptsProfiles(String ...profiles);

}
