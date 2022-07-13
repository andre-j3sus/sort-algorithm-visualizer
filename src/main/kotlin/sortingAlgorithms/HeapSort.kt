package sortingAlgorithms // ktlint-disable filename

import ArrayPanel
import Element
import ElementType
import exchange
import kotlinx.coroutines.delay

/**
 * Heap Sort of an Array.
 *
 * Time Complexity: O(nlog₂n)
 * @param heap array
 * @param delay algorithm delay
 */
suspend fun heapSort(heap: Array<Element>, delay: Long) {
    buildMaxHeap(heap)
    for (i in heap.size - 1 downTo 0) {
        exchange(heap, 0, i)
        maxHeapify(heap, 0, i)

        delay(delay)
        heap[i].type = ElementType.SORTED
        ArrayPanel.repaint()
    }
}

private fun left(i: Int) = i * 2 + 1
private fun right(i: Int) = i * 2 + 2
private fun parent(i: Int) = (i - 1) / 2

/**
 * BuildMaxHeap algorithm in Array.
 *
 * Time Complexity: O(n)
 */
private fun buildMaxHeap(a: Array<Element>) {
    var parent = parent(a.lastIndex)
    while (parent >= 0) {
        maxHeapify(a, parent, a.size)
        parent--
    }
}

/**
 * MaxHeapify algorithm in Array.
 *
 * Time Complexity: O(log₂n)
 */
private fun maxHeapify(a: Array<Element>, rootIdx: Int, n: Int) {
    val l = left(rootIdx)
    val r = right(rootIdx)
    var largest = rootIdx

    if (l < n && a[l].num > a[largest].num) largest = l
    if (r < n && a[r].num > a[largest].num) largest = r

    if (largest == rootIdx) return
    exchange(a, rootIdx, largest)
    maxHeapify(a, largest, n)
}
