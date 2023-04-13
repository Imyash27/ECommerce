<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <title>aranoz</title>
    <link rel="icon" href="img/favicon.png" />
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <!-- animate CSS -->
    <link rel="stylesheet" href="css/animate.css" />
    <!-- owl carousel CSS -->
    <link rel="stylesheet" href="css/owl.carousel.min.css" />
    <!-- font awesome CSS -->
    <link rel="stylesheet" href="css/all.css" />
    <!-- flaticon CSS -->
    <link rel="stylesheet" href="css/flaticon.css" />
    <link rel="stylesheet" href="css/themify-icons.css" />
    <!-- font awesome CSS -->
    <link rel="stylesheet" href="css/magnific-popup.css" />
    <!-- swiper CSS -->
    <link rel="stylesheet" href="css/slick.css" />
    <!-- style CSS -->
    <link rel="stylesheet" href="css/style.css" />
    
    <script type="text/javascript">
		var citiesByState = {
		Gujarat: ["Ahmedabad","Amreli","Anand","Aravalli","Banaskantha","Bharuch","Bhavnagar","Botad","Chhota Udaipur","Dahod","Dang","Devbhoomi Dwarka","Gandhinagar","Gir Somnath","Jamnagar","Junagadh","Kheda","Kutch","Mahisagar","Mehsana","Morbi","Narmada","Navsari","Panchmahal","Patan","Porbandar","Rajkot","Sabarkantha","Surat","Surendranagar","Tapi","Vadodara","Valsad"],
		Maharashtra: ["Mumbai","Pune","Nagpur"],
		
		}
		function makeSubmenu(value) {
		if(value.length==0) document.getElementById("citySelect").innerHTML = "<option></option>";
		else {
		var citiesOptions = "";
		for(cityId in citiesByState[value]) {
		citiesOptions+="<option>"+citiesByState[value][cityId]+"</option>";
		}
		document.getElementById("citySelect").innerHTML = citiesOptions;
		}
		}		
</script>  
  </head>
<body>
	<%@ include file="header.jsp" %>
	
	 <section class="login_part padding_top">
        <div class="container"> 
        		<h3><b>Create An Account </b></h3> <br>
        	<form action="CustomerController" method="post">
        	
	        <div class="row">
	        
	 	 		<div class="col mb-2">
	 	 		
	 	 			<input type="text" class="single-input mb-3"  name="firstname" placeholder="Firstname" > <br>
	 	 			<div class="row mb-2">
	 	 			<div class="col"><input type="radio" class="mb-3"  name="gender" value="male" > Male </div>
	 	 			<div class="col"><input type="radio" class="mb-3"  name="gender" value="female"> Female </div>
	 	 			</div> <br>	
	 	 			<input type="email" class="single-input mb-3"  name="emailid" placeholder="Email Id" > <br>
	 	 			<input type="text" class="single-input mb-3"  name="username" placeholder="Username" > <br>
	 	 			
	 	 			<!--  <select class="form-control ">
				        <option selected value="-1">Select State...</option>
				        <option>Gujrat</option>
				    </select> -->
				    
				    <select class="form-control" id="countrySelect" size="1" onchange="makeSubmenu(this.value)" name="state">
				       <option value="" disabled selected>Choose State</option>
				        <option>Gujarat</option>
						<option>Maharashtra</option>
				    </select>
				    
				     <br>						 
					<textarea class="single-input" name="address" placeholder="Address"></textarea> <br>	
							
                </div>
                
	  			<div class="col mb-2">
	  			
	  				 <input type="text" class="single-input mb-3"  name="lastname" placeholder="Lastname" > <br>
	  				 <input type="text" name="pincode" placeholder="Pincode" class="single-input"><br>	
	  				 <input type="text" class="single-input mb-3"  name="mobileno" placeholder="Mobile No" > <br>
	  				 <input type="text" class="single-input mb-3"  name="password" placeholder="Password" > <br>
	  				 
				    <select class="form-control " id="citySelect" size="1" name="city">
				        <option value="" disabled selected>Choose City</option>
						<option></option>
					</select>
				    
				     <br>
				    <input type="file" class="single-input mb-3"  name="image" >
	    
                </div>	
                
	  		</div>	
	  		  		
			<div class="row">
			 	<div class="col">
                	<center><input type="submit" value="register" name="action" class="btn_3"></center>
                </div>
			</div>  
			${msg }
			</form>                            
        </div>          
    </section>


	<%@ include file="footer.jsp" %>

	 <!-- jquery plugins here-->
    <script src="js/jquery-1.12.1.min.js"></script>
    <!-- popper js -->
    <script src="js/popper.min.js"></script>
    <!-- bootstrap js -->
    <script src="js/bootstrap.min.js"></script>
    <!-- easing js -->
    <script src="js/jquery.magnific-popup.js"></script>
    <!-- swiper js -->
    <script src="js/swiper.min.js"></script>
    <!-- swiper js -->
    <script src="js/masonry.pkgd.js"></script>
    <!-- particles js -->
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/jquery.nice-select.min.js"></script>
    <!-- slick js -->
    <script src="js/slick.min.js"></script>
    <script src="js/jquery.counterup.min.js"></script>
    <script src="js/waypoints.min.js"></script>
    <script src="js/contact.js"></script>
    <script src="js/jquery.ajaxchimp.min.js"></script>
    <script src="js/jquery.form.js"></script>
    <script src="js/jquery.validate.min.js"></script>
    <script src="js/mail-script.js"></script>
    <!-- custom js -->
    <script src="js/custom.js"></script>
</body>
</html>