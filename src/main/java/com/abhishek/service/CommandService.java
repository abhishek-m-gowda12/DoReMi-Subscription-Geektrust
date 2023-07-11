package com.abhishek.service;

import com.abhishek.enums.CommandOperator;
import com.abhishek.modal.Command;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author abhishek-m-gowda12
 */
public class CommandService {
    static CommandService commandService = null;

    public static CommandService getInstance() {
        if (commandService == null) {
            commandService = new CommandService();
        }
        return commandService;
    }

    public Command getCommandFromString(String input) throws RuntimeException {
        try {
            String[] commandWithArguments = input.split(" ");
            CommandOperator operator = CommandOperator.valueOf(commandWithArguments[0]);
            List<String> commandParams = Arrays.stream(commandWithArguments)
                    .skip(1)
                    .collect(Collectors.toList());

            Command command = new Command(operator, commandParams);
            this.validateInputCommand(operator, command);
            return command;
        } catch (Exception e) {
            throw new RuntimeException("INPUT_DATA_ERROR");
        }
    }

    private void validateInputCommand(CommandOperator inputCommand, Command command) throws RuntimeException {
        if (inputCommand.getNumberOfArguments() != command.getCommandParams().size()) {
            throw new RuntimeException("INPUT_DATA_ERROR");
        }
    }
}
