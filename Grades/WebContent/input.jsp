<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Grade Form</title>

<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</head>
<body>

	<ul class="nav nav-tabs">
		<li role="presentation" class="active"><a data-toggle="tab"
			href="#form">form</a></li>
		<li role="presentation"><a data-toggle="tab" href="#menu1">Grades
				List </a></li>
		<li role="presentation"><a data-toggle="tab" href="#menu2">Grades
				Average</a></li>
	</ul>
	<div class="tab-content">
		<div id="form" class="tab-pane fade in active">
			<div class="container">
				<br /> <br />

				<div class="jumbotron">
					<center>
						<h1>Grade Form</h1>
					</center>
					<form class="form-horizontal" action="FormGrade" method="post">
						<div class="form-group">
							<input type="text" class="form-control" id="Assignmet"
								name="Assignmet" placeholder="Assignmet" required>
						</div>
						<div class="form-group">
							<input type="text" class="form-control" id="Grade" name="Grade"
								placeholder="Grade" required>
						</div>
						<div class="form-group">
							<input type="submit" class="btn btn-primary btn-lg btn-block"
								value="add grade">
						</div>
					</form>
				</div>
			</div>
		</div>
		<div id="menu1" class="tab-pane fade">
			<div class="container">
				<br /> <br />

				<div class="jumbotron">
					<center>

						<h1>Grades List</h1>
					</center>
					<form action="FormGrade" method="get">
						<div class="form-group">
							<input type="submit" class="btn btn-primary btn-lg btn-block"
								value="get grade list"></div>
					</form>
					<div class="list-group">${gradeList}</div>
					
				</div>
			</div>
		</div>
		<div id="menu2" class="tab-pane fade" action="FormGrade" method="get">
			<div class="container">
				<br /> <br />

				<div class="jumbotron">
					<center>
						<h1>Grades Average</h1>
					</center>
					<form action="FormGrade" method="get">
						<div class="form-group">
							<input type="submit" class="btn btn-primary btn-lg btn-block"
								value="get Average"></div>
					</form>
					<div class="list-group">${gradeAvg}</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>

</body>
</html>