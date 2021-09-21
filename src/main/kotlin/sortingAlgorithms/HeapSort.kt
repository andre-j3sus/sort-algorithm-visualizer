package sortingAlgorithms

import exchange
import kotlinx.coroutines.delay


/**
 * Sorting Algorithm Heap Sort
 */
object HeapSort {

    /**
     * Heap Sort of an IntArray.
     *
     * Time Complexity: O(nlog₂n)
     * @param heap array
     */
    suspend fun sort(heap: IntArray, delay: Long) {
        buildMaxHeap(heap)
        for (i in heap.size - 1 downTo 1) {
            exchange(heap, 0, i)

            delay(delay)
            ArrayPanel.repaint()

            maxHeapify(heap, 0, i)
        }
    }


    private fun left(i: Int) = i * 2 + 1
    private fun right(i: Int) = i * 2 + 2
    private fun parent(i: Int) = (i - 1) / 2


    /**
     * BuildMaxHeap algorithm in IntArray.
     *
     * Time Complexity: O(n)
     */
    private fun buildMaxHeap(a: IntArray) {
        var parent = parent(a.lastIndex)
        while (parent >= 0) {
            maxHeapify(a, parent, a.size)
            parent--
        }
    }


    /**
     * MaxHeapify algorithm in IntArray.
     *
     * Time Complexity: O(log₂n)
     */
    private fun maxHeapify(a: IntArray, rootIdx: Int, n: Int) {
        val l = left(rootIdx)
        val r = right(rootIdx)
        var largest = rootIdx

        if (l < n && a[l] > a[largest]) largest = l
        if (r < n && a[r] > a[largest]) largest = r

        if (largest == rootIdx) return
        exchange(a, rootIdx, largest)
        maxHeapify(a, largest, n)
    }

}
