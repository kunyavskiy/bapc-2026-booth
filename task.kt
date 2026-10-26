const val INF= Int.MAX_VALUE / 2

fun main() {
    val lines = List(6) {
        readln()
    }
    val cost = listOf(0, 1, 1, 1, 1, 2)

    val dp = List(17) { IntArray(26) }
    for (i in 15 downTo 0) {
        for (prev in dp[i].indices) {
            dp[i][prev] = lines.zip(cost)
                .filter { (line, _) -> prev <= line[i] - 'A' }
                .minOfOrNull { (line, cost) ->
                    val next = if (line[i] == 'Q') 'U' else line[i]
                    dp[i + 1][next - 'A'] + cost
                } ?: INF
        }
    }

    println(if (dp[0][0] == INF) "impossible" else dp[0][0])
}

