import kotlin.random.Random

fun main() {
    val n = 4


    val distance = Array(n, {IntArray(n)})
    val visited = IntArray(n)
    val shortest = IntArray(2)

    for (i in visited){
        visited[i] = 0
    }
    visited[0] = 1

    for (i in shortest){
        shortest[i] = 0
    }

    einlesen (distance, n)

    // Ausgabe des Arrays distance
    for (array in distance) {
        for (value in array) {
            print("$value ")
        }
        println()
    }

    for (i in 0..n-1) {
        if (i == n-1) {
            shortest[0] = distance[shortest[1]][0]
            print("${shortest[0]}")
        } else {
            line(distance, visited, shortest, n, shortest[1])
            print("${shortest[0]} -> ")
        }
    }
}

// Funktion, die immer nur eine Zeile im Array durchläuft und überprüft, welche "Distanz" die kürzeste ist
// Parameter: distance-Array / visited-Array / groesse des Arrays / welche Zeile
fun line(a: Array<IntArray>, b : IntArray, c: IntArray, n : Int, line : Int){
    var nn :Int = 1000 // Nearest-Neighbor

    // Überprüfen für den kleinsten Wert, ob der erste Wert in einer Zeile vom Array gleich Null ist, da er nicht auf Null gesetzt werden darf. (Ist eigentlich nur für die erste Zeile, da dort immer der erste wert 0 ist)
//    for (i in 0..n-1) {
//        if(a[i][line] != 0 && b[i] != 1) {
//          nn = a[i][line]
//            break
//        }
//    }

    for (i in 0..n-1) {
        if(a[i][line]<nn && i  !=line && b[i] == 0) {
            nn = a[i][line]
            c[0] = nn
            c[1] = i
        }
    }
        b[c[1]] = 1
}

fun einlesen(distance : Array<IntArray>, tsp_range : Int) {
    for (i in 0..tsp_range-1) {
        for (j in 0..tsp_range-1) {
            var r = Random.nextInt(10,100)
            distance[i][j] = r
            distance[j][i] = r
            distance[i][i]=0
        }
    }
}