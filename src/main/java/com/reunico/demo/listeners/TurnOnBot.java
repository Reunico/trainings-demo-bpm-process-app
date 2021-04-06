package com.reunico.demo;

import com.reunico.demo.constants.MessageConstants;
import org.camunda.bpm.engine.delegate.*;

public class TurnOnBot implements TaskListener {

    @Override
    public void notify(DelegateTask delegateTask) {

        delegateTask.getProcessEngineServices().getRuntimeService()
                .createMessageCorrelation(MessageConstants.TURN_ON_BOT)
                .processInstanceBusinessKey("botProcess")
                .correlateStartMessage();

    }
}
