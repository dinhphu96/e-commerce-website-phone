<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<head>
  <title>How to use and customize SweetAlert2</title>
  <!-- jQuery -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <!-- SweetAlert2 -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.2.0/sweetalert2.all.min.js"></script>
  <style type="text/css">
  		body {
  background-color: aliceblue;
  font-family: sans-serif;
  text-align: center;
}
button {
  background-color: cadetblue;
  color: whitesmoke;
  border: 0;
  -webkit-box-shadow: none;
  box-shadow: none;
  font-size: 18px;
  font-weight: 500;
  border-radius: 7px;
  padding: 15px 35px;
  cursor: pointer;
  white-space: nowrap;
  margin: 10px;
}
img {
  width: 200px;
}
input[type="text"] {
  padding: 12px 20px;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 10px;
  box-sizing: border-box;
}
h1 {
  border-bottom: solid 2px grey;
}
#success {
  background: green;
}
#error {
  background: red;
}
#warning {
  background: coral;
}
#info {
  background: cornflowerblue;
}
#question {
  background: grey;
}
  </style>
</head>

<body>
  <div>
    <h1>How to use and customize <img src="https://sweetalert2.github.io/images/swal2-logo.png"></h1>
    <div>
      <h4>Modal Type</h4>
      <p>Sweet alert with modal type and customize message alert with html and css</p>
      <button id="success">Success</button>
      <button id="error">Error</button>     
    </div>
    <br>
    <div>
      <h4>Custom image and alert size</h4>
      <p>Alert with custom icon and background icon</p>
      <button id="icon">Custom Icon</button>
      <button id="image">Custom Background Image</button>
    </div>
    <br>
    <div>
      <h4>Alert with input type</h4>
      <p>Sweet Alert with Input and loading button</p>
      <button id="subscribe">Subscribe</button>
    </div>
    <br>
    <div>
      <h4>Redirect to visit another site</h4>
      <p>Alert to visit a link to another site</p>
      <button id="link">Redirect to Utopian</button>
    </div>
  </div>
  <script type="text/javascript">
//Alert Modal Type
  $(document).on('click', '#success', function(e) {
    swal(
      'Success',
      'You clicked the <b style="color:green;">Success</b> button!',
      'success'
    )
  });

  $(document).on('click', '#error', function(e) {
    swal(
      'Error!',
      'You clicked the <b style="color:red;">error</b> button!',
      'error'
    )
  });
  </script>
</body>
</html>