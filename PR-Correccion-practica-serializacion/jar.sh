rm test.jar
cd bin 
zip ../test.jar $(find . | grep Test)
cd ..
