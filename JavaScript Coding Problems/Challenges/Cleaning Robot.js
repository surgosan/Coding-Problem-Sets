/*
    A room is represented by a 0-indexed 2D binary matrix room where a 0 represents an empty space and a 1 represents a space with an object.
    The top left corner of the room will be empty in all test cases.
    A cleaning robot starts in the top left corner of the room and is facing right.
    The robot will continue heading straight until it reaches the edge of the room, or it hits an object, after which it will turn 90 degrees clockwise and repeat this process.
    The starting space and all spaces that the robot visits are cleaned by it.
    Return the number of clean spaces in the room if the robot runs indefinitely.
*/

//-------------------------------------------------------- SOLUTION --------------------------------------------------------
const numberOfCleanRooms = (room) => {
    const visited = new Set()
    const cleaned = new Set()
    const traverse = (y, x, dy, dx) => {
        if (visited.has(`${[y, x, dy, dx]}`))
            return cleaned.size
        visited.add(`${[y, x, dy, dx]}`)
        cleaned.add(`${[y, x]}`)
        return room[y + dy]?.[x + dx] === 0
            ? traverse(y + dy, x + dx, dy, dx)
            : traverse(y, x, dx, -dy)
    }
    return traverse(0, 0, 0, 1)
}



//----------------------------------------------------- MAIN METHODS -----------------------------------------------------
const roomOne = [[0,0,0],[1,1,0],[0,0,0]];
const roomTwo = [[0,1,0],[1,0,0],[0,0,0]];
const roomThree = [[0,0,0],[0,0,0],[0,0,0]];

console.log(numberOfCleanRooms(roomOne));
console.log(numberOfCleanRooms(roomTwo));
console.log(numberOfCleanRooms(roomThree));