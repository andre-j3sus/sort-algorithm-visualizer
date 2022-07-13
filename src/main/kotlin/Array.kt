// Main Array Constants
val ARRAY_RANGE = 1..600
const val DEFAULT_SIZE = 50

// Main Array Variables
var mainArray = arrayOf<Element>()
var size = DEFAULT_SIZE

/**
 * Element of the Array with num and type
 */
data class Element(val num: Int, var type: ElementType)
enum class ElementType { UNSORTED, SORTED }

/**
 * Generates another array randomly and updates the panel.
 */
fun generateNewArray() {
    mainArray = Array(size) { Element(ARRAY_RANGE.random(), ElementType.UNSORTED) }
    ArrayPanel.repaint()
}
