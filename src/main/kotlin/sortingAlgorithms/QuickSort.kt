package sortingAlgorithms


import Element
import exchange
import kotlinx.coroutines.delay


/**
 * Sorting Algorithm Quick Sort
 */
object QuickSort {

    /**
     * Hoare Partition Scheme.
     *
     * Time Complexity: Θ(n)
     * @param a array
     * @param left left index
     * @param right right index
     */
    private suspend fun partition(a: Array<Element>, left: Int, right: Int, delay: Long): Int {
        var i = left - 1
        var j = right
        val pivot = a[right]
        while (true) {
            while (i < right && a[++i].num <= pivot.num);
            while (j > left && a[--j].num >= pivot.num);
            if (j == left || i >= j) break
            exchange(a, i, j)
            delay(delay)
            ArrayPanel.repaint()
        }
        exchange(a, i, right)

        return i
    }


    /**
     * Quick Sort of an Array.
     *
     * Time Complexity: O(nlog₂n)
     * @param a array
     * @param left left index
     * @param right right index
     * @param delay algorithm delay
     */
    suspend fun sort(a: Array<Element>, left: Int, right: Int, delay: Long) {
        if (left > right) return

        val i = partition(a, left, right, delay)
        a[i].type = ElementType.SORTED

        sort(a, left, i - 1, delay)
        sort(a, i + 1, right, delay)
    }

}
