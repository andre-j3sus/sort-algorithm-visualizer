import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sortingAlgorithms.BubbleSort
import sortingAlgorithms.MergeSort


/**
 * Sorting object that controls the sorting algorithms.
 */
object Sorting {

    // Sorting Constants
    val sortAlgorithmsNames = arrayOf("Bubble Sort", "Merge Sort")
    private const val SORTING_DELAY = 1L


    /**
     * Types of sort algorithms.
     */
    enum class SortAlgorithm { BUBBLE_SORT, MERGE_SORT }


    /**
     * Sorts the array calling the sort algorithm currently selected.
     */
    @OptIn(DelicateCoroutinesApi::class)
    fun sortArray() {
        GlobalScope.launch {
            when (Frame.getSelectedSortAlgo()) {
                SortAlgorithm.BUBBLE_SORT -> BubbleSort.sort(mainArray, SORTING_DELAY)
                SortAlgorithm.MERGE_SORT -> MergeSort.sort(mainArray, 0, mainArray.lastIndex, SORTING_DELAY)
            }
        }
    }

}
