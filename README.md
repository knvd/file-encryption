# fileEncryption
This is a simple Private key Encryption and Decryption Program that Uses XOR and Shuffling written in Java.
It works on files. Opens a file to be encrypted(may be image,text etc). Asks user to provide a key which will be used for encryption. After accepting the key it XORs it with the contents of file and the Shuffles the Xored contents, thus rendering it useless. On decryption Side it uses the same logic, asks for key to decrypt(must be same as encryption key) ,Xors it with file, Shuffles back Contents. 
You can improve this program by taking extra steps like deleting the original file after decrypting or useing different shuffling technique. You may use a no. of rounds as well to make it strong. However my intention here is to explain the basic logic of encryption usinf files. 

