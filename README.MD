Run the following:

From the directory that contains the POM file:

mvn clean package docker:build

Then run:

docker run --name movie-mysql -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=movie -e MYSQL_USER=movie_user -e MYSQL_PASSWORD=movie_pass -d mysql:5.6

docker logs movie-mysql (ensure mysql server is up)

docker run -p 8080:8080 --name movie-app --link movie-mysql:mysql -d qacinema/movie

docker logs movie-app (ensure app is up by accessing http://localhost:8080)
