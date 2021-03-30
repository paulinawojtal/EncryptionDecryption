Encryption-Decryption project was made according to guidelines on https://hyperskill.org/projects/46?track=1
The program's task is to encrypt or decrypt the message given as one of several arguments at program startup.
Arguments which can be given to the program:
<-mode> <enc/dec>
<-key> <integer value>
<-data> <String in quotes>
<-in> <file name>
<-out> <file name>
<-alg> <shift/unicode>


1. If there is no -mode, the program should work in enc mode.
2. If there is no -key, the program should consider that key = 0.
3. If there is no -data, and there is no -in the program should assume that the data is an empty string.
4. If there is no -out argument, the program must print data to the standard output.
5. If there are both -data and -in arguments, your program should prefer -data over -in.
6. If there is no -alg, program should choose shift algorithm.

Examples of arguments:
1. java Main -mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode
2. java Main -mode enc -key 5 -data "Welcome to hyperskill!" -alg unicode --> \jqhtrj%yt%m~ujwxpnqq&
3. java Main -key 5 -alg unicode -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec --> Welcome to hyperskill!
4. java Main -key 5 -alg shift -data "Welcome to hyperskill!" -mode enc --> Bjqhtrj yt mdujwxpnqq!
5. java Main -key 5 -alg shift -data "Bjqhtrj yt mdujwxpnqq!" -mode dec --> Welcome to hyperskill!
