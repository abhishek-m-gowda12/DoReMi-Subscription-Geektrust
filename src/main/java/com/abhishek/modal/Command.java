package com.abhishek.modal;

import com.abhishek.enums.CommandOperator;

import java.util.List;

/**
 * @author abhishek-m-gowda12
 */
public class Command {
    private final CommandOperator inputCommand;
    private final List<String> commandParams;

    public Command(CommandOperator inputCommand, List<String> commandParams){
        this.inputCommand = inputCommand;
        this.commandParams = commandParams;
    }

    public CommandOperator getInputCommand() {
        return inputCommand;
    }

    public List<String> getCommandParams() {
        return commandParams;
    }
}
