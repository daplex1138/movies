<!doctype html>
<html lang="en">
<head>
<%@include file="WEB-INF/pages/head.jsp" %>
<style>
img{
width: 100px;
display: inline;
}
h2{
display: inline;
}
</style>
</head>
<body>
<div class="container-fluid">
<img src="file:///C:/Users/Java%20User/git/movies/MoviesMVCMcCammon/src/main/webapp/WEB-INF/pages/img/faces.jpg">
<h2>McChongo Movie DB</h2>
<div class="row">
<div class="col-sm-6">
<div class="card text-center">
 <h5 class="card-title">Directors</h5>
<div class="card-body">
<a class="btn btn-primary btn-block" href="newDirector.mvc">New Director</a><br />
<a class="btn btn-primary btn-block" href="viewDirectors.mvc">View all Directors</a><br />
</div>
</div>
</div>
<div class="col-sm-6">
<div class="card text-center">
 <h5 class="card-title">Movies</h5>
<div class="card-body">
<a href="newMovie.mvc" class="btn btn-primary btn-block">New Movie</a><br />
<a href="viewMovies.mvc" class="btn btn-primary btn-block">View all Movies</a><br />
</div>
</div>
</div>
</div>
</div>
</body>
</html>
