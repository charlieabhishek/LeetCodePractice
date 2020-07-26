
// 7. Reverse Integer : Given a 32-bit signed integer, reverse digits of an integer.
func reverse(_ x: Int) -> Int {
    var num = Int(x < 0 ? (0-x) : x)
    var output = ""
    while(num != 0){
        let rem = num % 10
        output += "\(rem)"
        num = num / 10
    }
    if let numRev: Int32 = Int32(output) {
        if x < 0 {
           return Int(0 - numRev)
        }
        return Int(numRev)
    }
    return 0
}
print(reverse(-901))

