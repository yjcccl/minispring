package com.test.aop.service;

/**
 * @author yjc
 */
public class Action1 implements IAction{
    @Override
    public String doAction() {
        System.out.println("Action1 really do action");
        return "Action1 do action1";
    }

    @Override
    public String doAction2() {
        System.out.println("Action2 really do action2");
        return "Action1 do action2";
    }
}
