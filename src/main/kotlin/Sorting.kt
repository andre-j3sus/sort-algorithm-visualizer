import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import sortingAlgorithms.bubbleSort
import sortingAlgorithms.heapSort
import sortingAlgorithms.insertionSort
import sortingAlgorithms.mergeSort
import sortingAlgorithms.quickSort
import sortingAlgorithms.selectionSort

/**
 * Sorting object that controls the sorting algorithms.
 */
object Sorting {

    // Sorting Constants
    val sortAlgorithmsNames = arrayOf(
        "Bubble Sort",
        "Selection Sort",
        "Insertion Sort",
        "Merge Sort",
        "Quick Sort",
        "Heap Sort"
    )
    private const val SORTING_DELAY = 30L

    /**
     * Types of sort algorithms.
     */
    enum class SortAlgorithm {
        BUBBLE_SORT,
        SELECTION_SORT,
        INSERTION_SORT,
        MERGE_SORT,
        QUICK_SORT,
        HEAP_SORT
    }

    /**
     * Sorts the array calling the sort algorithm currently selected.
     */
    @OptIn(DelicateCoroutinesApi::class)
    fun sortArray() {
        GlobalScope.launch {
            when (Frame.getSelectedSortAlgo() ?: return@launch) {
                SortAlgorithm.BUBBLE_SORT -> bubbleSort(mainArray, SORTING_DELAY)
                SortAlgorithm.SELECTION_SORT -> selectionSort(mainArray, SORTING_DELAY)
                SortAlgorithm.INSERTION_SORT -> insertionSort(mainArray, SORTING_DELAY)
                SortAlgorithm.MERGE_SORT -> mergeSort(mainArray, 0, mainArray.lastIndex, SORTING_DELAY)
                SortAlgorithm.QUICK_SORT -> quickSort(mainArray, 0, mainArray.lastIndex, SORTING_DELAY)
                SortAlgorithm.HEAP_SORT -> heapSort(mainArray, SORTING_DELAY)
            }
        }
    }
}
