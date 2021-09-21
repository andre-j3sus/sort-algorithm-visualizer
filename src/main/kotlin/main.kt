
val ARRAY_RANGE = 1..500
const val DEFAULT_SIZE = 50

var mainArray = intArrayOf()
var size = DEFAULT_SIZE

fun resetArray() {
    mainArray = IntArray(size) { ARRAY_RANGE.random() }
}


/**
 * Main function of the Sorting Algorithm Visualizer.
 * @author André Jesus.
 */
fun main() {
    resetArray()
    Frame.init()
}
