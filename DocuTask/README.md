Duco - Alan the Apple Robot
=======================

## Task Description

>You can try the problem in any language you like and should send back the source code and any tests you write. They'd like to be able to run the program so instructions to do so should be provided. A good candidate should get some kind of solution in an hour or two - and they're still interested to see partial solutions.

>When apples fall off the tree, they very quickly go bad. Therefore it is important to gather these apples as quickly as possible. The local orchard has a very busy apple-collecting robot named Alan. Your goal is to write a computer program that helps Alan collect the apples as quickly as possible. Your program is given a map, with '1's representing the positions of apples that have fallen in the orchard. In one second, Alan can move one square up, down, left or right. Alan starts in the top-left corner of the grid. Your program must help Alan by telling him the length of the optimal (shortest) route that will pass through every square that contains an apple. Alan may retrace his steps if necessary. The first line of input will describe the size of the map: W H (width and height). The next H lines will contain W characters: 0=empty ground, 1=apple 1 < H < W <= 20 

### Example

Input: 

```
5 4 
00100 
01101 
01000 
00100
```

Result: 

```
11
```

## How it works

It firstly searches for all the apples in on the ground and makes a rough path using the greedy method.
Then it swaps each of the apples around trying to find a more optimal route. After all is swapped, the shortest path is chosen.