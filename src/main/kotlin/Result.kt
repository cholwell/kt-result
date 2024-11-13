package cholwell.dev.kotlin_result

sealed interface Result<out T, out E> {

    data class Ok<T>(val value: T) : Result<T, Nothing>

    data class Err<E>(val error: E) : Result<Nothing, E>
}

fun <T> Ok(value: T) = Result.Ok(value)

fun <T> Result<T, *>.isOk() = this is Result.Ok<T>

fun <T> Result<T, *>.ok() = (this as Result.Ok<T>).value

fun <T> Result<T, *>.okOrNull() = (this as? Result.Ok<T>)?.value

fun <E> Err(error: E) = Result.Err(error)

fun <E> Result<*, E>.isErr() = this is Result.Err<E>

fun <E> Result<*, E>.err() = (this as Result.Err<E>).error

fun <E> Result<*, E>.errOrNull() = (this as? Result.Err<E>)?.error

data object None
