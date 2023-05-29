<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Giỏ hàng</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet"> 

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Topbar Start -->
    <div class="container-fluid">
        <div class="row bg-secondary py-2 px-xl-5">
            <div class="col-lg-6 d-none d-lg-block">
                <div class="d-inline-flex align-items-center">
                    <a class="text-dark" href="">FAQs</a>
                    <span class="text-muted px-2">|</span>
                    <a class="text-dark" href="">Help</a>
                    <span class="text-muted px-2">|</span>
                    <a class="text-dark" href="">Support</a>
                </div>
            </div>
            <div class="col-lg-6 text-center text-lg-right">
                <div class="d-inline-flex align-items-center">
                    <a class="text-dark px-2" href="">
                        <i class="fab fa-facebook-f"></i>
                    </a>
                    <a class="text-dark px-2" href="">
                        <i class="fab fa-twitter"></i>
                    </a>
                    <a class="text-dark px-2" href="">
                        <i class="fab fa-linkedin-in"></i>
                    </a>
                    <a class="text-dark px-2" href="">
                        <i class="fab fa-instagram"></i>
                    </a>
                    <a class="text-dark pl-2" href="">
                        <i class="fab fa-youtube"></i>
                    </a>
                </div>
            </div>
        </div>
        <div class="row align-items-center py-3 px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a href="" class="text-decoration-none">
                    <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Elec-Pro</h1>
                </a>
            </div>
            <div class="col-lg-6 col-6 text-left">
                <form action="">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Tìm sản phẩm">
                        <div class="input-group-append">
                            <span class="input-group-text bg-transparent text-primary">
                                <i class="fa fa-search"></i>
                            </span>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-lg-3 col-6 text-right">
                
                <a href="<c:url value="/cart"></c:url>" class="btn border">
                    <i class="fas fa-shopping-cart text-primary"></i>
                    <span class="badge">${sl }</span>
                </a>
            </div>
        </div>
    </div>
    <!-- Topbar End -->


    <!-- Navbar Start -->
    <div class="container-fluid">
        <div class="row border-top px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a class="btn shadow-none d-flex align-items-center justify-content-between bg-primary text-white w-100" data-toggle="collapse" href="#navbar-vertical" style="height: 65px; margin-top: -1px; padding: 0 30px;">
                    <h6 class="m-0">Danh mục</h6>
                    <i class="fa fa-angle-down text-dark"></i>
                </a>
                <nav class="collapse position-absolute navbar navbar-vertical navbar-light align-items-start p-0 border border-top-0 border-bottom-0 bg-light" id="navbar-vertical" style="width: calc(100% - 30px); z-index: 1;">
                    <div class="navbar-nav w-100 overflow-hidden">
					
						<div class="nav-item dropdown">
							<a href="#" class="nav-link" data-toggle="dropdown">Điện thoại<i
								class="fa fa-angle-down float-right mt-1"></i></a>
							<div class="dropdown-menu position-absolute bg-secondary border-0 rounded-0 w-100 m-0">
								<a href="" class="dropdown-item">Iphone</a>
								<a href="" class="dropdown-item">Samsung</a>
								<a href="" class="dropdown-item">Oppo</a>
								<a href="" class="dropdown-item">Xiaomi</a>
								<a href="" class="dropdown-item">Realme</a>
								<a href="" class="dropdown-item">Vivo</a>
							</div>
						</div>
						
						<div class="nav-item dropdown">
							<a href="#" class="nav-link" data-toggle="dropdown">laptop<i
								class="fa fa-angle-down float-right mt-1"></i></a>
							<div class="dropdown-menu position-absolute bg-secondary border-0 rounded-0 w-100 m-0">
								<a href="" class="dropdown-item">Dell</a>
								<a href="" class="dropdown-item">Lenovo</a>
								<a href="" class="dropdown-item">Macbook</a>
								<a href="" class="dropdown-item">MSI</a>
								<a href="" class="dropdown-item">HP</a>
								<a href="" class="dropdown-item">Asus</a>
								<a href="" class="dropdown-item">Acer</a>
							</div>
						</div>
						
						<div class="nav-item dropdown">
							<a href="#" class="nav-link" data-toggle="dropdown">Smart Watch<i
								class="fa fa-angle-down float-right mt-1"></i></a>
							<div class="dropdown-menu position-absolute bg-secondary border-0 rounded-0 w-100 m-0">
								<a href="" class="dropdown-item">Apple</a>
								<a href="" class="dropdown-item">Samsung</a>
								<a href="" class="dropdown-item">Xiaomi</a>
								<a href="" class="dropdown-item">Oppo</a>
							</div>
						</div>


						<a href="" class="nav-item nav-link">Table</a> <a href=""
							class="nav-item nav-link">Phụ kiện</a>
					</div>
                </nav>
            </div>
            <div class="col-lg-9">
                <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                    <a href="" class="text-decoration-none d-block d-lg-none">
                        <h1 class="m-0 display-5 font-weight-semi-bold"><span class="text-primary font-weight-bold border px-3 mr-1">E</span>Elec-Pro</h1>
                    </a>
                    <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                        <span class="navbar-toggler-icon"></span>
                    </button>
               <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                        <div class="navbar-nav mr-auto py-0">
                            <a href="/jv4_asmf/index" class="nav-item nav-link">Trang chủ</a>
                            <a href="/jv4_asmf/product" class="nav-item nav-link">Sản phẩm</a>
                            <a href="#" class="nav-item nav-link">About</a>
                            <a href="/jv4_asmf/contact" class="nav-item nav-link">Liên hệ</a>
                        </div>
                        </div>
                        <div class="navbar-nav ml-auto py-0">
                           <c:choose>
								<c:when test="${user==null}">
									<a href="/jv4_asmf/sign-in" class="nav-item nav-link">Login</a>
									<a href="/jv4_asmf/sign-up" class="nav-item nav-link">Register</a>
									<br />
								</c:when>
								<c:otherwise>
									<li class="nav-item dropdown no-arrow"><a
										class="nav-link dropdown-toggle" href="#" id="userDropdown"
										role="button" data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false"> <span
											class="mr-2 d-none d-lg-inline text-gray-600 small">${user.fullName}</span>
											<img style="width: 2rem; height: 2rem"
											class="img-profile rounded-circle"
											src="img/undraw_profile.svg">
									</a> <!-- Dropdown - User Information -->
										<div
											class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
											aria-labelledby="userDropdown">
											<a class="dropdown-item" href="#"> <i
												class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
												Profile
											</a> <a class="dropdown-item" href="#"> <i
												class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
												Settings
											</a> <a class="dropdown-item" href="#"> <i
												class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
												Activity Log
											</a>
											<div class="dropdown-divider"></div>
											<a class="dropdown-item" href="/jv4_asmf/sign-out"> <i
												class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
												Logout
											</a>
										</div></li>
									<br />
								</c:otherwise>
							</c:choose>
                        </div>
                    </div>
                </nav>
            </div>
        </div>
    </div>
    <!-- Navbar End -->


    <!-- Page Header Start -->
    <div class="container-fluid bg-secondary mb-5">
        <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 300px">
            <h1 class="font-weight-semi-bold text-uppercase mb-3">Giỏ hàng</h1>
            <div class="d-inline-flex">
                <p class="m-0"><a href="">Trang chủ</a></p>
                <p class="m-0 px-2">-</p>
                <p class="m-0">Giỏ hàng</p>
            </div>
        </div>
    </div>
    <!-- Page Header End -->


    <!-- Cart Start -->
    <div class="container-fluid pt-5">
        <div class="row px-xl-5">
            <div class="col-lg-8 table-responsive mb-5">
                <table class="table table-bordered mb-0">
                    <thead class="bg-secondary text-dark">
                        <tr>
                            <th>Các sản phẩm</th>
                            <th>Giá</th>
                            <th>Số lượng</th>
                            <th>Tổng tiền</th>
                            <th>Xóa</th>
                        </tr>
                    </thead>
                    <tbody class="align-middle">
                    
                    
                    
                    
                    <!-- for tại đây -->
                    <c:forEach var="sp" items="${cartDetail }">
                        <tr>
                            <td>
                            	<img src="img/${sp.product.image}" alt="" style="width: 50px;">
                            	${sp.product.pr_Name}
                            </td>
                            
                            <td>${sp.product.price}</td>
                            <td style="width: 130px;">
                                <div class="input-group mx-auto">
                                <div class="input-group-btn">
                                        <button onclick="dereFunc('${sp.product.price}','${sp.idDetail}', this)" class="btn btn-sm btn-primary btn-minus" >
                                        <i class="fa fa-minus"></i>
                                        </button>
                                    </div>
                                    
                                    <input id="${sp.idDetail}"  value="${sp.getAmount()}" disabled="disabled" type="text" class="form-control form-control-sm bg-secondary text-center">
                                    
                                    <div class="input-group-btn">
                                        <button onclick="dereFunc('${sp.product.price}','${sp.idDetail}', this)" class="btn btn-sm btn-primary btn-plus">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                
   
                                </div>
                            </td>
                            <td class="align-middle tongGiaSP" id="total${sp.idDetail}">${sp.product.price * sp.getAmount()}</td>
                            <!-- xóa -->
                            <td class="align-middle"><button onclick="deleteBd('${sp.idDetail}')" class="btn btn-sm btn-primary"><i class="fa fa-times"></i></button></td>
                        </tr>
                        </c:forEach>
                       <!-- hết for -->
                       
                    </tbody>
                </table>
            </div>
            <div class="col-lg-4">
                <form class="mb-5" action="">
                    <div class="input-group">
                        <input type="text" class="form-control p-4" placeholder="Nhập mã phiếu">
                        <div class="input-group-append">
                            <button class="btn btn-primary">Phiếu giảm giá</button>
                        </div>
                    </div>
                </form>
                <div class="card border-secondary mb-5">
                    <div class="card-header bg-secondary border-0">
                        <h4 class="font-weight-semi-bold m-0">Hóa đơn</h4>
                    </div>
                  
                    <div class="card-footer border-secondary bg-transparent">
                        <div class="d-flex justify-content-between mt-2">
                            <h5 class="font-weight-bold">Tổng tiền</h5>
                            <h5 id="tong" class="font-weight-bold">${tongTien }</h5>
                        </div>
                        <form action="checkout?">
                        
                        <button class="btn btn-block btn-primary my-3 py-3">Thanh toán</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Cart End -->


    <!-- Footer Start -->
    <div class="container-fluid bg-secondary text-dark mt-5 pt-5">
		<div class="row px-xl-5 pt-5">
			<div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
				<a href="" class="text-decoration-none">
					<h1 class="mb-4 display-5 font-weight-semi-bold">
						<span
							class="text-primary font-weight-bold border border-white px-3 mr-1">E</span>Elec-Pro
					</h1>
				</a>
				<p>Nỗi đau là nỗi đau, chiếc xe là sự thật. Nhưng hãy để nó trở thành một phương tiện tuyệt vời, nó không quan trọng là phương tiện nào, và bản thân nỗi đau mới là điều quan trọng.</p>
				<p class="mb-2">
					<i class="fa fa-map-marker-alt text-primary mr-3"></i>123 Quang Trung Street,
					Cong vien phan mem Quang Trung, 12 Dict, HCM City
				</p>
				<p class="mb-2">
					<i class="fa fa-envelope text-primary mr-3"></i>tmtp_group4@gmail.com
				</p>
				<p class="mb-0">
					<i class="fa fa-phone-alt text-primary mr-3"></i>+84 888888888
				</p>
			</div>
			<div class="col-lg-8 col-md-12">
				<div class="row">
					<div class="col-md-6 mb-5">
						<h5 class="font-weight-bold text-dark mb-4">Quick links</h5>
						<div class="d-flex flex-column justify-content-start">
							<a class="text-dark mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Trang chủ</a> <a
								class="text-dark mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Về chúng tôi</a> <a
								class="text-dark mb-2" href="#"><i
								class="fa fa-angle-right mr-2"></i>Chi tiết cửa hàng</a> 
								<a class="text-dark"
								href="contact.html"><i class="fa fa-angle-right mr-2"></i>Liên hệ</a>
						</div>
					</div>

					<div class="col-md-6 mb-5">
						<h5 class="font-weight-bold text-dark mb-4">Newsletter</h5>
						<form action="">
							<div class="form-group">
								<input type="text" class="form-control border-0 py-4"
									placeholder="Your Name" required="required" />
							</div>
							<div class="form-group">
								<input type="email" class="form-control border-0 py-4"
									placeholder="Your Email" required="required" />
							</div>
							<div>
								<button class="btn btn-primary btn-block border-0 py-3"
									type="submit">Subscribe Now</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="mail/jqBootstrapValidation.min.js"></script>
    <script src="mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
    
    <script type="text/javascript">
   /*  function dereFunc(gia, id){
		var quantity = document.getElementById(id).value;
		var thu = "total" + id;
		var qu =document.getElementById(thu);
		
		qu.innerText = quantity*gia;
		
		tinhTong();
	} */
    
    
    function dereFunc(gia, idBDetail, but){
		var button = $(but);
		var quantity = document.getElementById(idBDetail).value;
		
		if (button.hasClass('btn-plus')){
			quantity ++;
			document.getElementById(idBDetail).value = quantity;
		}else{
			if(quantity > 1){
				quantity --;
				document.getElementById(idBDetail).value = quantity;
			}else{
				return;
			}
			
		}
		
		
		var thu = "total" + idBDetail;
		var qu =document.getElementById(thu);
		
		qu.innerText = quantity*gia;
		
		tinhTong(quantity,idBDetail);
	}
    
    function tinhTong(quantity,idBDetail){
    	var listGia = document.getElementsByClassName("tongGiaSP");
    	var tong = 0;
    	for(let i = 0;i<listGia.length;i++){
    		var gia = Number(listGia[i].innerText);
    		tong += gia;
    	}
    	
    	document.getElementById("tong").innerText = tong;
    	window.location.href = "luuBill?layGt="+quantity+"-"+idBDetail+"-"+tong;
	}
    
    
    
    function deleteBd(maBd){
    	var id = "total" + maBd;
		var gia =document.getElementById(id).innerText;
    	
    	var tong = document.getElementById("tong").innerText;
    	var tongSau = tong - gia;
		
    	document.getElementById("tong").innerText = tongSau;
    	window.location.href = "xoaBd?layGt2="+maBd+"-"+tongSau;
	}
    </script>
</body>

</html>