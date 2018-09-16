Running dockerized service
------------------------------
1- Open terminal and go into the magicnumber directory of project
2- run "./docker_run.sh" . It may need permission, run with sudo if necessary.
All the steps are written in this bash script and Dockerfile.


PS: Docker container is not able connect with Mongodb which is installed on the host itself. 
I could not redirect the 27017 port to 127.0.0.1:27017. 
When i try to run the container with  -p 127.0.0.1:27017:27017, i am getting port already binded error.
That is normal because i should not try to open the 27017 port on the host again from the container. 
I should only forward the 27017 of container to host only but i could not.

PS: You may need Lombok plugin for your IDE.

PS: You should create user in the mongoDB with readWrite permission. username and password is written in application.properties