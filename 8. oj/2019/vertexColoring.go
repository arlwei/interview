package main

// PAT 1154 Vertex Coloring

import (
	"fmt"
	"strconv"
)

type vertex struct {
	begin, end int
}

func main() {
	var n, m, k int
	fmt.Scan(&n, &m)

	vertexVec := make([]vertex, m)
	for i, _ := range vertexVec {
		fmt.Scan(&vertexVec[i].begin, &vertexVec[i].end)
	}

	fmt.Scan(&k)
	colorArray := make([]int, n)
	result := make([]string, k)
	c := k
	for {
		if c == 0 {
			break
		}
		colorMap := make(map[int]bool)
		for i := 0; i < n; i++ {
			fmt.Scan(&colorArray[i])
			colorMap[colorArray[i]] = true
		}

		isSameFlag := true
		for i := 0; i < m; i++ {
			if colorArray[vertexVec[i].begin] == colorArray[vertexVec[i].end] {
				isSameFlag = false
				break
			}
		}
		if isSameFlag {
			result[k-c] = strconv.Itoa(len(colorMap)) + "-coloring"
		} else {
			result[k-c] = "No"
		}
		c--
	}
	for _, value := range result {
		fmt.Println(value)
	}
}
