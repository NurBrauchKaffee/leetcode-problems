package solutions.ArrayOrString

class RandomizedSet() {
    // todo(): remake with map and list without using set
    private val values = mutableSetOf<Int>()

    fun insert(`val`: Int): Boolean {
        return values.add(`val`)
    }

    fun remove(`val`: Int): Boolean {
        return values.remove(`val`)
    }

    fun getRandom(): Int {
        return values.random()
    }
}

fun main() {

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * var obj = RandomizedSet()
 * var param_1 = obj.insert(`val`)
 * var param_2 = obj.remove(`val`)
 * var param_3 = obj.getRandom()
 */