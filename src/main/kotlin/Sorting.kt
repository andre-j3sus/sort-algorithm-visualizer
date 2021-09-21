import sortingAlgorithms.BubbleSort


object Sorting {
    val sortAlgorithmsNames = arrayOf("Bubble Sort")


    /**
     * Types of sort algorithms.
     */
    enum class SortAlgorithm { BUBBLE_SORT }


    /**
     * Sorts the array.
     */
    fun sortArray() {
        when (Frame.getSelectedSortAlgo()) {
            SortAlgorithm.BUBBLE_SORT -> BubbleSort.sort()
        }
    }

}
