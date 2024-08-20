package cholwell.dev.kotlin_result

sealed interface Result<out T, out E> {

    data class Ok<T>(val value: T) : Result<T, Nothing>

    data class Err<E>(val error: E) : Result<Nothing, E>
}

fun <T> Ok(value: T) = Result.Ok(value)

fun <T> Result<T, *>.isOk() = this is Result.Ok<T>

fun <E> Err(error: E) = Result.Err(error)

fun <E> Result<*, E>.isErr() = this is Result.Err<E>
