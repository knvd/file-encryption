# Private Key File Encryption and Decryption in Java

1. NOTE>>THIS IS A SAMPLE PROGRAM FOR TEACHING PURPOSES <<NEVER EVER USE IT FOR REAL LIFE CRYPTOGRAPHY>>, TECHNICALLY IT IS VULNERABLE TO ATTACKS LIKE BRUTEFORCE.

2. This is a simple Private key Encryption and Decryption Program that Uses XOR and Shuffling written in Java.
It works on files. Opens a file to be encrypted(may be image,text etc). Asks user to provide a key which will be used for encryption. After accepting the key it XORs it with the contents of file and the Shuffles the Xored contents, thus rendering it useless. On decryption Side it uses the same logic, asks for key to decrypt(must be same as encryption key) ,XORs it with file, Shuffles back Contents. 

3. You can improve this program by taking extra steps like using different shuffling techniques. You may also use many no. of rounds as well to make it strong,or you may make use of functions or objects as you wish ,etc.HOWEVER PRESENTLY MY INTENTION IS TO EXPLAIN THE  * SIMPLE PROCESS OF ENCRYPTION AND DECRYPTION * USING A PRIVATE KEY.

4. TESTED ON <<JPG,PNG,TXT,MP3,MP4 AND PDF FILES>>. PLEASE REPORT IF FAILING ON ANY FORMAT.

