package net.kaupenjoe.mccourse.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import net.kaupenjoe.mccourse.item.ModItems;
import net.minecraft.commands.CommandBuildContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.commands.arguments.item.ItemArgument;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;

public class WantedCommand {
    public WantedCommand(CommandDispatcher<CommandSourceStack> dispatcher) {

        dispatcher.register(Commands.literal("Wanted")
                .requires(stack -> stack.hasPermission(0))
                .then(Commands.literal("Dead")
                    .then(Commands.argument("target", EntityArgument.players())
                            .executes(this::executeDead)))

                .then(Commands.literal("Alive")
                    .then(Commands.argument("target", EntityArgument.players())
                        .executes(this::executeAlive)))

                .then(Commands.literal("DeadOrAlive")
                .then(Commands.argument("target", EntityArgument.players())
                        .executes(this::executeDeadOrAlive))));

    }

    private int executeDead(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = context.getSource().getPlayer();

        String playerName = player.getName().getString();
        context.getSource().sendSuccess(() -> Component.literal(playerName + " is now Wanted dead!"), true);
        return 1;
    }

    private int executeAlive(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = context.getSource().getPlayer();

        String playerName = player.getName().getString();
        context.getSource().sendSuccess(() -> Component.literal(playerName + " is now Wanted alive!"), true);
        return 1;
    }

    private int executeDeadOrAlive(CommandContext<CommandSourceStack> context) {
        ServerPlayer player = context.getSource().getPlayer();

        String playerName = player.getName().getString();
        context.getSource().sendSuccess(() -> Component.literal(playerName + " is now Wanted Dead Or Alive!"), true);
        return 1;
    }
}
