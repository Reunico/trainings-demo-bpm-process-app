package com.reunico.demo;

import com.reunico.demo.constants.MessageConstants;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.DelegateTask;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendBotMessage implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        Double takeProfitPrice = null;
        if (delegateExecution.getVariable("pl") != null) {
            takeProfitPrice = Double.parseDouble((String) delegateExecution.getVariable("pl"));
        }

        delegateExecution.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation(MessageConstants.NEW_TRADE)
                .processInstanceBusinessKey("trade")
                .setVariable("pl", takeProfitPrice)
                .correlateWithResult();
    }
}
