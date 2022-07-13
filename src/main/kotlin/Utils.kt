// ktlint-disable filename
/**
 * Exchanges the values in the indexes in the IntArray.
 * @param a array
 * @param idx1 first index
 * @param idx2 second index
 */
fun exchange(a: Array<Element>, idx1: Int, idx2: Int) {
    val temp = a[idx1]
    a[idx1] = a[idx2]
    a[idx2] = temp
}
