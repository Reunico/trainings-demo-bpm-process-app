package com.reunico.demo;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

public class ValidateTakeProfit implements ExecutionListener {

    @Override
    public void notify(DelegateExecution delegateExecution) {
        if (delegateExecution.getVariable("pl") == null) {
            delegateExecution.setVariable("invalidPl", true);
        } else {
            delegateExecution.setVariable("invalidPl", false);
        }
    }
}
