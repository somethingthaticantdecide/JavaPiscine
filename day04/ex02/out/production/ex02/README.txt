Create folder:
cp -a src/resources target
Compile files:
javac -d target src/java/edu/school21/printer/app/Main.java src/java/edu/school21/printer/logic/PrintJPG.java
Create jar archive:
jar cvfm target/ImagesToChar.jar src/manifest.txt -C target .
Run jar archive:
java -jar target/ImagesToChar.jar --white=. --black=O src/resources/it.bmp
