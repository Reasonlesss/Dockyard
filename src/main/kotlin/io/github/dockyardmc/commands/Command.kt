package io.github.dockyardmc.commands

import io.github.dockyardmc.player.Player
import io.github.dockyardmc.utils.Console
import java.util.UUID
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
class Command(): Cloneable {
    lateinit var internalExecutorDoNotUse: (CommandExecutor) -> Unit
    var arguments: MutableMap<String, CommandArgumentData> = mutableMapOf()
    var permission = ""
    var aliases = mutableListOf<String>()

    fun <T> get(argumentName: String): T {
        if(arguments[argumentName] == null) throw Exception("Argument with name $argumentName does not exist")

        return arguments[argumentName]!!.returnedValue as T
    }

    inline fun <reified T : Enum<T>> getEnum(argumentName: String): T {
        val value = get<String>(argumentName)
        return T::class.java.enumConstants.firstOrNull { it.name == value.uppercase() } ?: throw Exception("Enum ${T::class.simpleName} does not contain \"${value.uppercase()}\"")
    }

    fun <T> getOrNull(argumentName: String): T? {
        if(arguments[argumentName] == null) return null
        return arguments[argumentName]!!.returnedValue as T
    }

    fun addArgument(name: String, argument: CommandArgument) {
        arguments[name] = CommandArgumentData(argument, false, expectedReturnValueType = argument.expectedType)
    }

    fun addOptionalArgument(name: String, argument: CommandArgument) {
        arguments[name] = CommandArgumentData(argument, true, expectedReturnValueType = argument.expectedType)
    }

    fun execute(function: (CommandExecutor) -> Unit) {
        internalExecutorDoNotUse = function
    }

    fun build(): Command {
        return this
    }
}

interface CommandArgument {
    var expectedType: KClass<*>
}

class StringArgument(
    val staticCompletions: MutableList<String> = mutableListOf(),
    override var expectedType: KClass<*> = String::class,
): CommandArgument

class PlayerArgument(
    override var expectedType: KClass<*> = Player::class,
): CommandArgument

class IntArgument(
    var staticCompletions: MutableList<Int> = mutableListOf(),
    override var expectedType: KClass<*> = Int::class,
): CommandArgument

class DoubleArgument(
    val staticCompletions: MutableList<Double> = mutableListOf(),
    override var expectedType: KClass<*> = Double::class,
): CommandArgument

class LongArgument(
    val staticCompletions: MutableList<Long> = mutableListOf(),
    override var expectedType: KClass<*> = Long::class,
): CommandArgument

class UUIDArgument(
    override var expectedType: KClass<*> = UUID::class,
): CommandArgument

class EnumArgument(
    val enumType: KClass<*>,
    override var expectedType: KClass<*> = String::class,
): CommandArgument


class CommandArgumentData(
    val argument: CommandArgument,
    val optional: Boolean = false,
    var returnedValue: Any? = null,
    var expectedReturnValueType: KClass<*>
)

data class CommandExecutor(
    val player: Player? = null,
    val console: Console,
    val isPlayer: Boolean = player != null,
) {
    fun sendMessage(message: String) {
        if(this.isPlayer) this.player!!.sendMessage(message) else this.console.sendMessage(message)
    }
}