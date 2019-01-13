fun String.isNumeric(): Boolean {
    val pattern = Regex("[0-9]")
    return pattern.matches(this)
}

fun Int.isEven() : Boolean {
    return this % 2 == 0
}
